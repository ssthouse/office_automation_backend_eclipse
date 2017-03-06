package com.ssthouse.officeautomation.utils;


import com.google.gson.Gson;
import com.ssthouse.officeautomation.entity.UserInfoEntity;
import com.ssthouse.officeautomation.entity.UserIno;
import org.hibernate.Session;

/**
 * Created by ssthouse on 20/01/2017.
 */
public class Main {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        UserInfoEntity userInfoEntity = session.get(UserInfoEntity.class, 1);
        Log.error(userInfoEntity.getUsername() + "  " + userInfoEntity.getDescription());
    }
}
