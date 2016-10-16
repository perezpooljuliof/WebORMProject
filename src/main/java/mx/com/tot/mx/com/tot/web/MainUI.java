package mx.com.tot.mx.com.tot.web;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import mx.com.tot.mx.com.tot.config.SpringContextProvider;
import mx.com.tot.mx.com.tot.dao.EmpleadoRepository;
import mx.com.tot.mx.com.tot.dto.Empleado;

import java.util.List;

/**
 * Created by elver on 27/07/16.
 */
@Title("UI")
@Theme("valo")
public class MainUI extends UI {
    public void init(VaadinRequest request) {
        setContent(new Label("Hola"));
        Object bean = SpringContextProvider.getBean("firstBean");
        System.out.println("bean:" + bean);
        EmpleadoRepository dao = (EmpleadoRepository) SpringContextProvider.getBean("empleadoRepository");
        List<Empleado> empleados = dao.getAll();
        System.out.println(empleados);
    }
}
