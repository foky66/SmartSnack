package hu.smart_snack.views.main;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


@Route(value="", layout = MainView.class)
public class HomeView  extends VerticalLayout {
    public HomeView() {
      getTitle();
    }

    private void getTitle(){
        H1 title = new H1("Welcome my SnackMachine management application");
        H2 message = new H2("Use this application to manage vending machines located in your country.\n" +
                "You can create new ones and upload depleted vending machines");
        title.setSizeFull();
        setAlignItems(Alignment.CENTER);
        add(title,message);
    }
}
