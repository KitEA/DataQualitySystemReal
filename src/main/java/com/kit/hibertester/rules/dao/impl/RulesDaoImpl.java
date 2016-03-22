package com.kit.hibertester.rules.dao.impl;

import com.kit.hibertester.rules.dao.RulesDAO;
import com.kit.hibertester.rules.entity.Rules;
import com.kit.hibertester.util.CustomHibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Eldest on 16.03.2016.
 */

@Repository("rulesDAO")
public class RulesDaoImpl extends CustomHibernateDaoSupport implements RulesDAO {

    @Transactional(readOnly = false)
    public void save(Rules rules) {
        getHibernateTemplate().save(rules);
    }

    public void update(Rules rules) {
        getHibernateTemplate().update(rules);
    }

    public void delete(Rules rules) {
        getHibernateTemplate().delete(rules);
    }

    public Rules findRulesByName(String ruleName) {
        List list = getHibernateTemplate().find("from Rules where name=?", ruleName);
        return (Rules) list.get(0);
    }
}
