package ex1.mb.dao.impl;

import ex1.mb.dao.UserDao;
import ex1.mb.entity.User;

public class UserDaoImpl extends BasicDaoImpl<User> implements UserDao {
    public UserDaoImpl(Class<User> entityClass) {
        super(entityClass);
    }
}

