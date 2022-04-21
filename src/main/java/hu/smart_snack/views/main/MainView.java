package hu.smart_snack.views.main;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import hu.smart_snack.Controller.SnackMachineController;
import hu.smart_snack.model.SnackMachine;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@PageTitle("Main")
@Route(value = "gfh")
@Slf4j
public class MainView extends HorizontalLayout {


    public MainView() throws InterruptedException {
        H1 h1 = new H1("Welcome to my SnackMachine management services");
        H2 h2 = new H2("test33");
        Button btn = new Button("create SnackMachine");

        add(h1 ,h2, btn);




    }


}
