package com.staspavlov.rtlabs.dao;

import com.staspavlov.rtlabs.model.Claim;
import java.util.List;

/**
 * Доступ к заявкам
 */
public interface ClaimDao {

    /**
     * Получить список всех заявок
     *
     * @return Список всех заявок
     */
    public List<Claim> findAll();

}
