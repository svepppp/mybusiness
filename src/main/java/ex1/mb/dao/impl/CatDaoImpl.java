package ex1.mb.dao.impl;

import ex1.mb.dao.CatDao;
import ex1.mb.entity.Cat;

public class CatDaoImpl extends BasicDaoImpl<Cat> implements CatDao {
    public CatDaoImpl(Class<Cat> entityClass) {
        super(entityClass);
    }
}