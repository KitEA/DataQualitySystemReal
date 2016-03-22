package com.kit.hibertester.util;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

/**
 * Created by Eldest on 22.03.2016.
 */
public abstract class CustomHibernateDaoSupport extends HibernateDaoSupport{
    @Autowired
    public void anyMethodName(SessionFactory sessionFactory){
        setSessionFactory(sessionFactory);
    }
}
