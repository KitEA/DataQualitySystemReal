package com.kit.hibertester.common;

import com.kit.hibertester.rules.bo.RulesBO;
import com.kit.hibertester.rules.entity.Rules;
import com.kit.hibertester.pathExtractor.PathExtractor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class AppTor {
    public static void main(String[] args) {
        PathExtractor pE = new PathExtractor();
        Path fileLocation = pE.getPathToFile("rules.txt");
        File source = new File(fileLocation.toString());
        String line = null;

        List<String> list = new ArrayList<String>();
        try {
            FileReader fileReader = new FileReader(source);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }

            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file ");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");

        RulesBO rulesBO = (RulesBO) applicationContext.getBean("rulesBO");

        Rules rules = new Rules();
        rules.setRule_Name(list.get(0));
        rules.setDescription(list.get(1));
        rules.setEntity_id(Integer.parseInt(list.get(2)));
        rules.setQuery_text(list.get(3));
        rules.setSection_id(Integer.parseInt(list.get(4)));

        rulesBO.save(rules);
    }
}
