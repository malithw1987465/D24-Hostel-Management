package lk.ijse.D24.config;

import lk.ijse.D24.entity.Reservation;
import lk.ijse.D24.entity.Rooms;
import lk.ijse.D24.entity.Student;
import lk.ijse.D24.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfig {
    private static  SessionFactoryConfig factoryConfig;
    private final SessionFactory sessionFactory;

    private SessionFactoryConfig(){
//         sessionFactory  =new MetadataSources(new StandardServiceRegistryBuilder().
//                 configure().build())
//                 .addAnnotatedClass(Customer.class)
//                 .getMetadataBuilder()
//                 .applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
//                 .build().buildSessionFactory();

        sessionFactory = new Configuration().configure()
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Rooms.class)
                .addAnnotatedClass(Reservation.class)
                .buildSessionFactory();

    }


    public static SessionFactoryConfig getInstance(){
        return (null==factoryConfig)
                ?factoryConfig=new SessionFactoryConfig():factoryConfig;

    }
    public Session getSession(){

        return sessionFactory.openSession();
    }
}
