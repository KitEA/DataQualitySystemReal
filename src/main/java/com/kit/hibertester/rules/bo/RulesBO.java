package com.kit.hibertester.rules.bo;

import com.kit.hibertester.rules.entity.Rules;

/**
 * Created by Eldest on 20.03.2016.
 */
public interface RulesBO {
    void save(Rules rules);
    void update(Rules rules);
    void delete(Rules rules);
    Rules findByRuleName(String ruleName);
}
