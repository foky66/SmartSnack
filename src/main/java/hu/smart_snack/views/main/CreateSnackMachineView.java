package hu.smart_snack.views.main;

import com.vaadin.flow.component.button.Button;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import hu.smart_snack.model.CountiesAndCities;
import hu.smart_snack.model.SnackMachine;
import hu.smart_snack.services.Impl.SnackMachineServiceImpl;
import hu.smart_snack.validation.AmountValidation;

import java.util.HashMap;
import java.util.List;


@PageTitle("Create SnackMachine")
@Route(value ="create", layout = MainView.class)
public class CreateSnackMachineView extends VerticalLayout {

    private ComboBox<String> county;
    private ComboBox<String> city;
    private ComboBox<String> product;
    private NumberField amount;
    private Button createSnackMachine;
    private Button addFields;
    private TextArea showProducts;

    private final HashMap<String, Integer> products = new HashMap<>();
    private  final CountiesAndCities countiesAndCities = new CountiesAndCities();
    private final List<String> optionalProducts =
            List.of("CocaCola","Szentkirályi ásv.","Fanta","ChioChips","Snickers","Bounty","Mentos","Croissant");
    private final SnackMachineServiceImpl service;
    private final AmountValidation validation = new AmountValidation();


    public CreateSnackMachineView(SnackMachineServiceImpl service){
        this.service = service;
        configureLayouts();
        setCountyAndCityComboBox();
        setProductAndAmount();

        configureListeners();
    }

    private void configureListeners() {
        createSnackMachine.addClickListener(e -> saveMachine());
        addFields.addClickListener(event->{
            addProductsToMachine();
            showProducts.setValue(printProducts());

        });
    }

    private void configureLayouts(){
        county = new ComboBox<>("County");
        city = new ComboBox<>("City");
        product = new ComboBox<>("Product");
        amount = new NumberField("Amount");
        createSnackMachine = new Button("Create SnackMachine");
        addFields= new Button("+");
        showProducts = new TextArea();
        county.setWidth("300px");
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setAlignItems(Alignment.END);
        horizontalLayout.add(product, amount, addFields);

        showProducts.setReadOnly(true);
        showProducts.setWidth("300px");
        setAlignItems(Alignment.BASELINE);
        add(county, city, horizontalLayout, showProducts, createSnackMachine);
        setMargin(true);
    }

    private void addProductsToMachine() {
        try{
            validation.validate(amount.getValue().intValue());
        }catch (IllegalArgumentException e){
            Notification.show(e.getMessage());
            resetProductAndAmount();
            return;
        }
        products.put(product.getValue(),amount.getValue().intValue());
        Notification.show("Product and amount added to Machine");
        resetProductAndAmount();
    }

    private void saveMachine() {
        Notification.show("SnackMachine added to database");
        service.create(SnackMachine.builder()
                .county(county.getValue())
                .city(city.getValue())
                .products(products)
                .isAnyProductEmpty(false)    //default : false
                .isWorking(true)            //default : true
                .build());
        resetProductAndAmount();
        showProducts.clear();
    }

    private void setCountyAndCityComboBox(){

        county.setItems(countiesAndCities.getCounties());
        city.setEnabled(false);
        county.addValueChangeListener(event->{
           city.setEnabled(event.getValue() != null);
           city.setItems(countiesAndCities.getCities(county.getValue()));

       });
    }

    private void setProductAndAmount(){

        amount.setEnabled(false);
        product.setEnabled(false);

        city.addValueChangeListener(event->{
            product.setEnabled(event.getValue() != null);
            product.setItems(optionalProducts);
        });
        product.addValueChangeListener(event-> amount.setEnabled(event.getValue() != null));
    }
    private void resetProductAndAmount(){
        product.clear();
        amount.clear();
    }


    private String printProducts(){
        StringBuilder out = new StringBuilder();
         products.forEach((key,value) ->{
            out.append(key).append(":").append(value.toString()).append(" db");
            out.append("\n");
        });
         return out.toString();
    }
}
