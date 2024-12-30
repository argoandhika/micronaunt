package com.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final String SCHEMA_NAME = "monitoring";
    private static SessionFactory sessionFactory;

    // Mengambil SessionFactory
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.configure(); // Membaca dari hibernate.cfg.xml
                sessionFactory = configuration.buildSessionFactory();
            } catch (Throwable ex) {
                throw new ExceptionInInitializerError(ex);
            }
        }
        return sessionFactory;
    }

    // Membuka sesi baru
    public static Session openSession() {
        return getSessionFactory().openSession();
    }

    // Menutup SessionFactory
    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    public static String getSchemaName() {
        return SCHEMA_NAME;
    }
    
    
}
