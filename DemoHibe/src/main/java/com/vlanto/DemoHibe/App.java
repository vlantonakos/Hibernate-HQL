package com.vlanto.DemoHibe;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class App 
{
    public static void main( String[] args )
    {
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
         
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
         
        SessionFactory sf = con.buildSessionFactory(reg);
         
        Session session = sf.openSession();
         
        session.beginTransaction();
        
        Query q = session.createQuery("from Student where rollno=7");
        Student student = (Student)q.uniqueResult();
        System.out.println(student);
        
        
        session.getTransaction().commit();
        
        
    }
}