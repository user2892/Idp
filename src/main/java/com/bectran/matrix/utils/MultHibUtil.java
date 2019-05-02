package com.bectran.matrix.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public class MultHibUtil extends HibernateSessionFactory {
    public static Session currentSession(String key) throws HibernateException {
        return getSession();
    }

    public static void closeSession(Session session) {
        try {
            // if (session != null && session.isOpen()){
            if (session != null) {
                session.close();
            }
        }
        catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("--start---");
        // getDataToProcess(1,"");
        // currentSession("HSHS");
        System.out.println("--end---");
    }
} // end of the class
