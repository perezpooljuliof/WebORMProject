package mx.com.tot.mx.com.tot.dao;

import mx.com.tot.mx.com.tot.dto.Empleado;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by elver on 10/10/16.
 */
@Repository("empleadoRepository")
public class EmpleadoRepository {
    private SessionFactory sessionFactory;

    public EmpleadoRepository() {
        System.out.println("EmpleadoRepository()>>>>>");
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Empleado> getAll() {
        String sql = "select e from Empleado e";
        Query query = sessionFactory.getCurrentSession().createQuery(sql);
        return query.list();
    }
}
