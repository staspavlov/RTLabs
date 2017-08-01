package com.staspavlov.rtlabs.model;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Заявка
 */
@Document(collection = "claims")
public class Claim {

    /**
     * Идентификатор заявки
     */
    @Id
    private String id;

    /**
     * Номер заявки
     */
    private int number;

    /**
     * Дата создания
     */
    private Date createdAt;

    /**
     * Статус заявки
     */
    private String status;

    /**
     * Услуга
     */
    private Service service;

    /**
     * Заявитель
     */
    private Person person;

    /**
     * Ведомство
     */
    private Department department;

    /**
     * Возвращает идентификатор заявки
     *
     * @return Идентификатор заявки
     */
    public String getId() {
        return id;
    }

    /**
     * Устанавливает идентификатор заявки
     *
     * @param id Идентификатор заявки
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Возвращает номер заявки
     *
     * @return Номер заявки
     */
    public int getNumber() {
        return number;
    }

    /**
     * Устанавливает номер заявки
     *
     * @param number Номер заявки
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Возвращает дату создания
     *
     * @return Дата создания
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Устанавливает дату создания
     *
     * @param createdAt Дата создания
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Возвращает статус заявки
     *
     * @return Статус заявки
     */
    public String getStatus() {
        return status;
    }

    /**
     * Устанавливает статус заявки
     *
     * @param status Статус заявки
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Возвращает услугу
     *
     * @return Услуга
     */
    public Service getService() {
        return service;
    }

    /**
     * Устанавливает услугу
     *
     * @param service Услуга
     */
    public void setService(Service service) {
        this.service = service;
    }

    /**
     * Возвращает заявителя
     *
     * @return Заявитель
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Устанавливает заявителя
     *
     * @param person Заявитель
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * Возвращает ведомство
     *
     * @return Ведомство
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Устанавливает ведомство
     *
     * @param department Ведомство
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

}
