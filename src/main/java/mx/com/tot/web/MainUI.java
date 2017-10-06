package mx.com.tot.web;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import mx.com.tot.config.SpringContextProvider;
import mx.com.tot.dao.EmpleadoRepository;
import mx.com.tot.dto.Empleado;
import mx.com.tot.service.EmpleadoService;

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
        EmpleadoService service = SpringContextProvider.getApplicationContext().getBean(EmpleadoService.class);
        List<Empleado> empleados = service.getAll();
        System.out.println(empleados);
    }
}
