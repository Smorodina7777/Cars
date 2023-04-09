package org.example.dao;

import org.example.antity.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class InstanceDaoHibernate implements InstanceDao {
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public List<Car> getAllCars() {
        TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("from Car");
        return query.getResultList();
    }

}
