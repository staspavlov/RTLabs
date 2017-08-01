package com.staspavlov.rtlabs.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Подуслуга
 */
@Document(collection = "subservices")
public class Subservice {

    /**
     * Идентификатор подуслуги
     */
    @Id
    private String id;

    /**
     * Код цели
     */
    private String targetCode;

    /**
     * Название
     */
    private String title;

    /**
     * Возвращает идентификатор подуслуги
     *
     * @return Идентификатор подуслуги
     */
    public String getId() {
        return id;
    }

    /**
     * Устанавливает идентификатор подуслуги
     *
     * @param id Идентификатор подуслуги
     */
    public void setId(String id) {
        this.id = id;
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

}
