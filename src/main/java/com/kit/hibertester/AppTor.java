package com.kit.hibertester;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.kit.hibertester.entity.Employee;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AppTor {
    private static SessionFactory factory;
    public static void main(String[] args) {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        AppTor appTor = new AppTor();

        appTor.addEmployee("John", "Brown", 1000);
        appTor.addEmployee("Clark", "Kent", 500);
        appTor.addEmployee("Alicea", "Wildwom", 1);

        //appTor.listEmployees();

        Scanner user_input = new Scanner(System.in);
        String userValue = user_input.next();

        UserInputStr userInputStr = new UserInputStr(userValue);

        List<Employee> badEmployees = appTor.listBadEmployee(0, 2, userInputStr);
        for (Iterator iterator =
             badEmployees.iterator(); iterator.hasNext(); ) {
            Employee employee = (Employee) iterator.next();
            System.out.print("First Name: " + employee.getFirstName());
            System.out.print("  Last Name: " + employee.getLastName());
            System.out.println("  Salary: " + employee.getSalary());
        }

        /*String hql = "From Employee E WHERE E.salary < :employee_salary";
        Query query = session.createQuery(hql);
        query.setParameter("employee_salary", 500);*/
    }

    public void addEmployee(String fname, String lname, int salary) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Employee employee = new Employee();
            employee.setFirstName(fname);
            employee.setLastName(lname);
            employee.setSalary(salary);
            session.save(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void listEmployees() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List employees = session.createQuery("FROM Employee").list();
            for (Iterator iterator =
                 employees.iterator(); iterator.hasNext(); ) {
                Employee employee = (Employee) iterator.next();
                System.out.print("First Name: " + employee.getFirstName());
                System.out.print("  Last Name: " + employee.getLastName());
                System.out.println("  Salary: " + employee.getSalary());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List listBadEmployee(int firstRes, int maxRes, UserInputStr userQuery) {
        Session session = factory.openSession();
        Transaction tx = null;
        List badEmployees = new ArrayList<Employee>();
        try {
            tx = session.beginTransaction();
            String hql = "FROM Employee E WHERE salary < :userInputTo";
            Query query = session.createQuery(hql);
            query.setFirstResult(firstRes);
            query.setMaxResults(maxRes);
            ExpressionParser parser = new SpelExpressionParser();
            Expression exp = parser.parseExpression("userInputTo");
            EvaluationContext context = new StandardEvaluationContext(userQuery);
            //int maxi = (Integer) exp.getValue(context);
            String maxi = (String) exp.getValue(context);
            query.setParameter("userInputTo", Integer.parseInt(maxi));
            badEmployees = query.list();
            //List employees = query.list();
            /*for (Iterator iterator = employees.iterator(); iterator.hasNext(); ) {
                Employee employee = (Employee) iterator.next();
                ExpressionParser parser = new SpelExpressionParser();
                Expression exp = parser.parseExpression("salary < userInputTo");
                EvaluationContext context = new StandardEvaluationContext(employee);
                boolean wrongObject = exp.getValue(context, Boolean.class);
                if (wrongObject) {
                    badEmployees.add(employee);
                }
            }*/
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return badEmployees;
    }
}
