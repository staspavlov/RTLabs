package com.staspavlov.rtlabs.dao;

import com.staspavlov.rtlabs.model.Claim;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

/**
 * Доступ к заявкам
 */
@Repository
public class ClaimDaoImpl implements ClaimDao {

    /**
     * Доступ к MongoDb
     */
    @Autowired
    MongoOperations mongoOperations;

    /**
     * Получить список всех заявок
     *
     * @return Список всех заявок
     */
    @Override
    public List<Claim> findAll() {
        return mongoOperations.findAll(Claim.class);
    }

}
