package hu.smart_snack.views.main;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import lombok.extern.slf4j.Slf4j;

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
