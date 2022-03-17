package com;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainApp {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter name,instrument");
        String name=br.readLine();
        String instrument=br.readLine();
        Musicians musicians = new Musicians();
        musicians.setName(name);
        musicians.setInst(instrument);
        Configuration configuration=new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sf=configuration.buildSessionFactory();
        Session session=sf.openSession();
        Transaction transaction= session.beginTransaction();
        int i= (int) session.save(musicians);
        if(i>0){
            transaction.commit();
            System.out.println("Success");
        }
        else
            System.out.println("try again");
    }
}
