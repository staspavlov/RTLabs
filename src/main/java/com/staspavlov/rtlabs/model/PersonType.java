package com.staspavlov.rtlabs.model;

/**
 * Тип заявителя
 */
public enum PersonType {

    IP("ИП"),
    UL("ЮЛ"),
    FL("ФЛ");

    private final String title;

    private PersonType(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }

}
