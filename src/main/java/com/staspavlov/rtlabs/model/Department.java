package com.staspavlov.rtlabs.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Ведомство
 */
@Document(collection = "departments")
public class Department {

    /**
     * Идентификатор ведомства
     */
    @Id
    private String id;

    /**
     * Название
     */
    private String title;

    /**
     * Код ведомства
     */
    private String code;

    /**
     * Возвращает идентификатор ведомства
     *
     * @return Идентификатор ведомства
     */
    public String getId() {
        return id;
    }

    /**
     * Устанавливает идентификатор ведомства
     *
     * @param id Идентификатор ведомства
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Возвращает название
     *
     * @return Название
     */
    public String getTitle() {
        return title;
    }

    /**
     * Устанавливает название
     *
     * @param title Название
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Возвращает код ведомства
     *
     * @return Код ведомства
     */
    public String getCode() {
        return code;
    }

    /**
     * Устанавливает код ведомства
     *
     * @param code Код ведомства
     */
    public void setCode(String code) {
        this.code = code;
    }

}
