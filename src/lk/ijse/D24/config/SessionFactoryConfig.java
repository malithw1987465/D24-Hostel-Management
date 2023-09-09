package lk.ijse.D24.config;

import lk.ijse.D24.entity.Reservation;
import lk.ijse.D24.entity.Rooms;
import lk.ijse.D24.entity.Student;
import lk.ijse.D24.entity.User;
import lk.ijse.D24.util.Utility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfig {

    private final SessionFactory sessionFactory;

    private static SessionFactoryConfig factoryConfig;

    private SessionFactoryConfig(){


        sessionFactory=new Configuration().mergeProperties(Utility.getProperties())
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Rooms.class)
                .addAnnotatedClass(Reservation.class)
                .buildSessionFactory();
    }

    public static SessionFactoryConfig getInstance(){
        return(null==factoryConfig)
                ?factoryConfig=new SessionFactoryConfig()
                :factoryConfig;
    }

    public Session getSession(){


        return sessionFactory.openSession();
    }
}