package mx.com.tot.mx.com.tot.config;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.*;
import mx.com.tot.mx.com.tot.web.MainUI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

/**
 * Created by elver on 26/07/16.
 */

@WebServlet(value = "/*", asyncSupported = true)
@VaadinServletConfiguration(ui = MainUI.class, productionMode = false)
public class ServletConfiguration extends VaadinServlet implements SessionInitListener, SessionDestroyListener {

    @Override
    public void servletInitialized() throws ServletException {
        super.servletInitialized();
        System.out.println("servletInitialized()>>>>>");


        getService().addSessionInitListener(this);
        getService().addSessionDestroyListener(this);
    }

    public void sessionDestroy(SessionDestroyEvent sessionDestroyEvent) {
        System.out.println("sessionDestroy()>>>>>");
    }

    public void sessionInit(SessionInitEvent sessionInitEvent) throws ServiceException {
        System.out.println("sessionInit()>>>>>");
    }
}

