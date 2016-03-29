package com.kit.hibertester.rules.bo.impl;

import com.kit.hibertester.rules.bo.RulesBO;
import com.kit.hibertester.rules.dao.RulesDAO;
import com.kit.hibertester.rules.entity.Rules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Eldest on 20.03.2016.
 */
@Service("rulesBO")
public class RulesBoImpl implements RulesBO {
    @Autowired
    private RulesDAO rulesDAO;

    public void setRulesDAO(RulesDAO rulesDAO){
        this.rulesDAO = rulesDAO;
    }

    @Transactional
    public void save(Rules rules) {
        rulesDAO.save(rules);
    }

    public void update(Rules rules) {
        rulesDAO.update(rules);
    }

    public void delete(Rules rules) {
        rulesDAO.delete(rules);
    }

    public Rules findByRuleName(String ruleName) {
        return rulesDAO.findRulesByName(ruleName);
    }
}
