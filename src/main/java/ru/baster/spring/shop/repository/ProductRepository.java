package ru.baster.spring.shop.repository;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import ru.baster.spring.shop.models.Product;
import ru.baster.spring.shop.utils.SessionFactory;
import java.util.List;

@Component
public class ProductRepository implements ProductInterface {
    SessionFactory sessionFactory;

    public ProductRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Product findById(Long id) {
        try (Session session = (Session) sessionFactory.getSession()){
            session.beginTransaction();
            Product product =session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public List<Product> findAll() {
        try (Session session = (Session) sessionFactory.getSession()){
            session.beginTransaction();
            List<Product> products = session.createQuery("from Product").getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public void deleteProductById(Long id) {
        try (Session session = (Session) sessionFactory.getSession()){
            session.beginTransaction();
            session.createQuery("delete from Product where id = :id")
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public Product saveOrUpdate(String title, String price) {
        try (Session session = (Session) sessionFactory.getSession()){
            session.beginTransaction();
            session.saveOrUpdate(title, price);
            session.getTransaction().commit();

            return null;
        }

    }

}


