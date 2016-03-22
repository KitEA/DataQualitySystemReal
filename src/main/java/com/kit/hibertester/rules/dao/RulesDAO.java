package com.kit.hibertester.rules.dao;

import com.kit.hibertester.rules.entity.Rules;

/**
 * Created by Eldest on 16.03.2016.
 */
public interface RulesDAO {
    void save(Rules rules);
    void update(Rules rules);
    void delete(Rules rules);
    Rules findRulesByName(String ruleName);
}
