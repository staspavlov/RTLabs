package com.staspavlov.rtlabs.controller;

import com.staspavlov.rtlabs.dao.ClaimDao;
import com.staspavlov.rtlabs.model.Claim;
import com.staspavlov.rtlabs.model.PersonType;
import com.staspavlov.rtlabs.model.Subservice;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.Axis;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * FXML контроллер
 */
public class AppController implements Initializable {

    /**
     * Свойство для хранения списка заявок
     */
    private final ObservableList<Claim> claimsData = FXCollections.observableArrayList();

    /**
     * Достут к заявкам в БД
     */
    @Autowired
    private ClaimDao claimDao;

    /**
     * Таблица отчета
     */
    @FXML
    private TableView<Claim> tableClaims;

    /**
     * Колонка таблицы "Номер заявки"
     */
    @FXML
    private TableColumn<Claim, Integer> columnNumber;

    /**
     * Колонка таблицы "Дата"
     */
    @FXML
    private TableColumn<Claim, String> columnDate;

    /**
     * Колонка таблицы "Код формы"
     */
    @FXML
    private TableColumn<Claim, String> columnForm;

    /**
     * Колонка таблицы "Статус"
     */
    @FXML
    private TableColumn<Claim, String> columnStatus;

    /**
     * Колонка таблицы "ФИО заявителя"
     */
    @FXML
    private TableColumn<Claim, String> columnName;

    /**
     * Колонка таблицы "Тип заявителя"
     */
    @FXML
    private TableColumn<Claim, String> columnType;

    /**
     * Колонка таблицы "Название услуги"
     */
    @FXML
    private TableColumn<Claim, String> columnService;

    /**
     * Колонка таблицы "Название подуслуги"
     */
    @FXML
    private TableColumn<Claim, String> columnSubservices;

    /**
     * Колонка таблицы "Название ведомства"
     */
    @FXML
    private TableColumn<Claim, String> columnDepartment;

    /**
     * Выпадающий список для фильтрации данных для гистограммы
     */
    @FXML
    private ChoiceBox<PersonType> choiceType;

    /**
     * Гистограммы
     */
    @FXML
    private BarChart<Date, Integer> chartHistogram;

    /**
     * Инициализация контроллера
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initData();
        initTableClaims();
        initChoiceType();
        initChartHistogram();
        refreshChartHistogram();
    }

    /**
     * Подготовить данные
     */
    private void initData() {
        claimsData.addAll(claimDao.findAll());
    }

    /**
     * Подготовить таблицу отчета
     */
    private void initTableClaims() {
        columnNumber.setCellValueFactory(new PropertyValueFactory<>("number"));

        columnStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        columnDate.setCellValueFactory((param) -> {
            DateFormat df = new SimpleDateFormat("dd.MM");
            String date = df.format(param.getValue().getCreatedAt());
            return new SimpleStringProperty(date);
        });

        columnForm.setCellValueFactory((param) -> {
            return new SimpleStringProperty(param.getValue().getService().getFormCode());
        });

        columnName.setCellValueFactory((param) -> {
            return new SimpleStringProperty(param.getValue().getPerson().getName());
        });

        columnType.setCellValueFactory((param) -> {
            return new SimpleStringProperty(param.getValue().getPerson().getType().toString());
        });

        columnService.setCellValueFactory((param) -> {
            return new SimpleStringProperty(param.getValue().getService().getTitle());
        });

        columnSubservices.setCellValueFactory((param) -> {
            List<Subservice> subservices = param.getValue().getService().getSubservices();
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < subservices.size(); i++) {
                builder.append(subservices.get(i).getTitle());
                if (i != subservices.size() - 1) {
                    builder.append("\n");
                }
            }
            return new SimpleStringProperty(builder.toString());
        });

        columnDepartment.setCellValueFactory((param) -> {
            return new SimpleStringProperty(param.getValue().getDepartment().getTitle());
        });

        tableClaims.setItems(claimsData);
    }

    /**
     * Подготовить выпадающий список типов заявителей
     */
    private void initChoiceType() {
        choiceType.getItems().addAll(PersonType.values());
        choiceType.setValue(PersonType.UL);

        // При смене значения обновить гистограмму
        choiceType.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue ov, Object oldValue, Object newValue) {
                refreshChartHistogram();
            }
        });
    }

    /**
     * Подготовить гистограмму
     */
    private void initChartHistogram() {
        Axis<Date> xAxis = chartHistogram.getXAxis();
        xAxis.setLabel("Дата");

        Axis<Integer> yAxis = chartHistogram.getYAxis();
        yAxis.setLabel("Количество заявок");
    }

    /**
     * Обновить данные гистограммы
     */
    private void refreshChartHistogram() {
        // Текущий выбранный тип заявителя
        PersonType personType = choiceType.getValue();

        // Вычисляем количество заявок в день
        Map<Date, Integer> data = new HashMap<>();
        for (Claim claim : claimsData) {
            if (claim.getPerson().getType() == personType) {
                Date key = claim.getCreatedAt();
                Integer value = data.containsKey(key) ? data.get(key) + 1 : 1;
                data.put(key, value);
            }
        }

        // Упорядочиваем по дате и заносим данные в график
        List<Date> dates = new ArrayList<>(data.keySet());
        Collections.sort(dates);
        XYChart.Series dataSeries = new XYChart.Series();
        dataSeries.setName("Количество заявок в день");
        DateFormat df = new SimpleDateFormat("dd.MM");

        for (Date date : dates) {
            String key = df.format(date);
            Integer val = data.get(date);
            dataSeries.getData().add(new XYChart.Data(key, val));
        }

        chartHistogram.getData().setAll(dataSeries);
    }

}
