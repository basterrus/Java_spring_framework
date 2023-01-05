package ru.baster.spring.shop.utils;

import jakarta.annotation.PostConstruct;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import ru.baster.spring.shop.models.Product;

@Component
public class SessionFactory {
    private static org.hibernate.SessionFactory sessionFactory;

    @PostConstruct
    public static void init(){
        sessionFactory= new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
    }

    public static SessionFactory getSession(){
        return (SessionFactory) sessionFactory.getCurrentSession();
    }

    public static void close(){
        if(sessionFactory!=null){
            sessionFactory.close();
        }
    }

}
