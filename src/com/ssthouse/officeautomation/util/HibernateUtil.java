package com.ssthouse.officeautomation.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * hibernate工具类
 * Created by ssthouse on 20/01/2017.
 */
public class HibernateUtil {

    private static SessionFactory mSessionFactory;

    private static ThreadLocal<Session> mThreadLocalSession = new ThreadLocal<>();

    static {
        Configuration configuration = new Configuration().configure();
        mSessionFactory = configuration.buildSessionFactory();
    }

    public static SessionFactory getmSessionFactory() {
        return mSessionFactory;
    }

    public static Session getSession() {
        Session session = mThreadLocalSession.get();
        if (session == null || !session.isOpen()) {
            if (mSessionFactory == null)
                rebuildSessionFactory();
            session = mSessionFactory == null ? null : mSessionFactory.openSession();
            mThreadLocalSession.set(session);
        }
        return session;
    }

    public static void closeSession() {
        Session session = mThreadLocalSession.get();
        mThreadLocalSession.set(null);
        if (session != null) {
            session.close();
        }
    }

    public static void rebuildSessionFactory() {
        Configuration configuration = new Configuration().configure("/hibernate.cfg.xml");
        mSessionFactory = configuration.buildSessionFactory();
    }
}
