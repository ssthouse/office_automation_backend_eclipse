package com.ssthouse.officeautomation.util;


import com.google.gson.Gson;
import com.ssthouse.officeautomation.entity.UserEntity;
import org.hibernate.Session;

/**
 * Created by ssthouse on 20/01/2017.
 */
public class Main {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        UserEntity userEntity = session.get(UserEntity.class, 1);
        Log.error(userEntity.getUsername() + "  " + userEntity.getDescription());
    }
}
