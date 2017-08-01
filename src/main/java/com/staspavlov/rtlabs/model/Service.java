package com.staspavlov.rtlabs.model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Услуга
 */
@Document(collection = "services")
public class Service {

    /**
     * Идентификатор услуги
     */
    @Id
    private String id;

    /**
     * Название
     */
    private String title;

    /**
     * Код цели
     */
    private String targetCode;

    /**
     * Код формы
     */
    private String formCode;

    /**
     * Категория пользователей
     */
    private PersonType recipientType;

    /**
     * Подуслуги
     */
    private List<Subservice> subservices;

    /**
     * Возвращает идентификатор услуги
     *
     * @return Идентификатор услуги
     */
    public String getId() {
        return id;
    }

    /**
     * Устанавливает идентификатор услуги
     *
     * @param id Идентификатор услуги
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
     * Возвращает код цели
     *
     * @return Код цели
     */
    public String getTargetCode() {
        return targetCode;
    }

    /**
     * Устанавливает код цели
     *
     * @param targetCode Код цели
     */
    public void setTargetCode(String targetCode) {
        this.targetCode = targetCode;
    }

    /**
     * Возвращает код формы
     *
     * @return Код формы
     */
    public String getFormCode() {
        return formCode;
    }

    /**
     * Устанавливает код формы
     *
     * @param formCode Код формы
     */
    public void setFormCode(String formCode) {
        this.formCode = formCode;
    }

    /**
     * Возвращает категорию пользователей
     *
     * @return Категория пользователей
     */
    public PersonType getRecipientType() {
        return recipientType;
    }

    /**
     * Устанавливает категорию пользователей
     *
     * @param recipientType Категория пользователей
     */
    public void setRecipientType(PersonType recipientType) {
        this.recipientType = recipientType;
    }

    /**
     * Возвращает список подуслуг
     *
     * @return Список подуслуг
     */
    public List<Subservice> getSubservices() {
        return subservices;
    }

    /**
     * Устанавливает список подуслуг
     *
     * @param subservices Список подуслуг
     */
    public void setSubservices(List<Subservice> subservices) {
        this.subservices = subservices;
    }

}
