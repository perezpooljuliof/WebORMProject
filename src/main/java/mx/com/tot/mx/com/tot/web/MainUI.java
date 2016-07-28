package mx.com.tot.mx.com.tot.web;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

/**
 * Created by elver on 27/07/16.
 */
@Title("UI")
@Theme("valo")
public class MainUI extends UI {
    public void init(VaadinRequest request) {
        setContent(new Label("Hola"));
    }
}
