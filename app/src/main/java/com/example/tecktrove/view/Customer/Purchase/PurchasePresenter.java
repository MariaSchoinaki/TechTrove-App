package com.example.tecktrove.view.Customer.Purchase;

import com.example.tecktrove.contacts.Email;
import com.example.tecktrove.contacts.Telephone;
import com.example.tecktrove.dao.OrderDAO;
import com.example.tecktrove.dao.CustomerDAO;
import com.example.tecktrove.domain.Order;
import com.example.tecktrove.domain.Customer;
import com.example.tecktrove.domain.Employer;
import com.example.tecktrove.domain.OrderLine;
import com.example.tecktrove.domain.ProductType;
import com.example.tecktrove.domain.Synthesis;
import com.example.tecktrove.domain.Component;
import com.example.tecktrove.util.Pair;
import com.example.tecktrove.util.SimpleCalendar;
import com.example.tecktrove.util.SystemDate;
import com.example.tecktrove.view.SharedViewModel;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PurchasePresenter {

    private PurchaseView view;

    private OrderDAO orders;

    private Customer customer;

    /**
     * Constructor of the presenter
     * @param view          purchase view
     * @param orders        order dao
     * @param customer      customer
     */
    public PurchasePresenter(PurchaseView view, OrderDAO orders, Customer customer){
        this.view = view;
        this.orders = orders;
        this.customer = customer;
    }

    /**
     * Checks if the given from the user values, are following
     * some of the basic rules, such as the card number must be 16 digits
     * and completes the order
     */
    public void placeOrder(){
        boolean checked = true;
        String fullname = view.getFullName();
        String email = view.getEmail();
        String telephone = view.getTelephone();
        String address = view.getAddress();
        String cardNumber = view.getCardNumber();
        String cardMonth = view.getCardMonth();
        String cardYear = view.getCardYear();
        String cardCvv = view.getCardCvv();

        if(fullname.equals("") || email.equals("") || telephone.equals("") || address.equals("") || cardNumber.equals("") || cardMonth.equals("") || cardYear.equals("") || cardCvv.equals("")) {
            view.showMessage("Προβλήμα", "Συμπληρώσε όλα τα πεδία");
        }
        else if(!(email.contains("@") && (email.contains(".com") || email.contains(".gr")))){
            view.showMessage("Προβλήμα", "Γράψε ένα έγκυρο email");
        }
        else if(telephone.length() != 10){
            view.showMessage("Προβλήμα", "Γράψε ένα έγκυρο αριθμό τηλεφώνου");
        }
        else{
            boolean is_digit = true;
            for (int i = 0; i < cardNumber.length(); i++)
                if (!Character.isDigit(cardNumber.charAt(i))) is_digit = false;

            if(cardNumber.length() != 16 || !is_digit){
                checked = false;
                view.showMessage("Προβλήμα", "Γράψε ένα έγκυρο αριθμό κάρτας.");
            }

            for (int i = 0; i < cardMonth.length(); i++)
                if (!Character.isDigit(cardMonth.charAt(i))) is_digit = false;

            if(cardMonth.length() != 2 || !is_digit){
                checked = false;
                view.showMessage("Προβλήμα", "Γράψε ένα έγκυρο αριθμό μήνα");
            }

            for (int i = 0; i < cardYear.length(); i++)
                if (!Character.isDigit(cardYear.charAt(i))) is_digit = false;

            if(cardYear.length() != 2 || !is_digit){
                checked = false;
                view.showMessage("Προβλήμα", "Γράψε ένα έγκυρο αριθμό χρόνου");
            }

            for (int i = 0; i < cardCvv.length(); i++)
                if (!Character.isDigit(cardCvv.charAt(i))) is_digit = false;

            if(cardCvv.length() != 3 || !is_digit){
                checked = false;
                view.showMessage("Προβλήμα", "Γράψε ένα έγκυρο cvv");
            }

            if(checked) {
                boolean ready_cart = true;
                for(OrderLine ol: customer.getCart()){
                    ProductType c = ol.getProductType();
                    if(c instanceof Synthesis){
                        boolean ready_synthesis = true;
                        ArrayList<Component> componen = ((Synthesis) c).getComponentList();
                        for(Component comp: componen){
                            if(comp.getQuantity() == 0){
                                ready_synthesis = false;
                            }
                        }
                        if(!ready_synthesis){
                            ready_cart = false;
                            view.showMessage("Πρόβλημα!", "Η σύνθεση είναι εκτός διαθεσιμότητας.");
                        }
                    }
                    else{
                        if(ol.getQuantity() > ((Component) c).getQuantity()){
                            ready_cart = false;
                        }
                    }
                }
                if(ready_cart) {
                    Order order = new Order();
                    order.setOrderLines(customer.getCart());
                    order.setCustomer(customer);
                    order.setTelephone(new Telephone(telephone));
                    order.setEmail(new Email(email));
                    order.setCardNumber(Long.parseLong(cardNumber));
                    order.setDate(SystemDate.now());
                    customer.addOrderList(order);
                    order.setId(orders.nextId());
                    orders.save(order);
                    for(OrderLine ol: customer.getCart()) {
                        ProductType c = ol.getProductType();
                        if(c instanceof Synthesis){
                            ArrayList<Component> componen = ((Synthesis) c).getComponentList();
                            for(Component comp: componen) {
                                comp.removeQuantity(1);
                            }
                        }else{
                            c.setQuantity(c.getQuantity()-ol.getQuantity());
                        }
                    }
                    view.order();
                }
                else{view.showMessage("Πρόβλημα", "Εκτός διαθεσιμότητας");}
            }
        }
    }
}
