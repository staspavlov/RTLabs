package com.staspavlov.rtlabs.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Заявитель
 */
@Document(collection = "persons")
public class Person {

    /**
     * Идентификатор заявителя
     */
    @Id
    private String id;

    /**
     * Ф.И.О.
     */
    private String name;

    /**
     * Тип заявителя
     */
    private PersonType type;

    /**
     * Возвращает идентификатор заявителя
     *
     * @return Идентификатор заявителя
     */
    public String getId() {
        return id;
    }

    /**
     * Устанавливает идентификатор заявителя
     *
     * @param id Идентификатор заявителя
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Возвращает Ф.И.О.
     *
     * @return Ф.И.О.
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает Ф.И.О.
     *
     * @param name Ф.И.О.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Возвращает тип заявителя
     *
     * @return Тип заявителя
     */
    public PersonType getType() {
        return type;
    }

    /**
     * Устанавливает тип заявителя
     *
     * @param type Тип заявителя
     */
    public void setType(PersonType type) {
        this.type = type;
    }

}
