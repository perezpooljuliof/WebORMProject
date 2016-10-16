package mx.com.tot.dao;

import mx.com.tot.dto.Empleado;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by elver on 10/10/16.
 */
@Repository
public class EmpleadoRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public EmpleadoRepository() {
        System.out.println("EmpleadoRepository()>>>>>");
    }


    public List<Empleado> getAll() {

        String sql = "select e from Empleado e";
        Query query = sessionFactory.openSession().createQuery(sql);
        return query.list();
    }
}
