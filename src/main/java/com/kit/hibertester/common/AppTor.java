package com.kit.hibertester.common;

import com.kit.hibertester.pathExtractor.PathExtractor;
import com.kit.hibertester.rules.bo.RulesBO;
import com.kit.hibertester.rules.entity.EntityT;
import com.kit.hibertester.rules.entity.Rules;

import org.hibernate.Query;
import org.ini4j.Ini;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class AppTor {
    public static void main(String[] args) {
        PathExtractor pE = new PathExtractor();
        Path fileLocation = pE.getPathToFile("config/config.ini");
        File source = new File(fileLocation.toString());

        String name = null;
        String description = null;
        String entityName = null;
        String queryText= null;
        String sectionName = null;
        String scenarioName = null;

        try {
            Ini ini = new Ini(source);
            Ini.Section section = ini.get("rule")
            name  = section.get("name");
            description = section.get("description");
            entityName = section.get("entity_name");
            queryText = section.get("query_text");
            sectionName = section.get("section_name");
            scenarioName = section.get("scenario_name");
        } catch (IOException e) {
            e.printStackTrace();
        }


        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");

        RulesBO rulesBO = (RulesBO) applicationContext.getBean("rulesBO");

        Rules rules = new Rules();
        rules.setRule_Name(name);
        rules.setDescription(description);



        rules.setEntity_id();
        rules.setQuery_text(list.get(3));
        rules.setSection_id(Integer.parseInt(list.get(4)));

        rulesBO.save(rules);
    }
}
