package com.example.tecktrove.view.MyAccount;


import com.example.tecktrove.contacts.Email;
import com.example.tecktrove.contacts.Telephone;
import com.example.tecktrove.dao.CustomerDAO;
import com.example.tecktrove.dao.EmployerDAO;
import com.example.tecktrove.domain.Customer;
import com.example.tecktrove.domain.Employer;
import com.example.tecktrove.domain.ProductType;
import com.example.tecktrove.domain.Synthesis;
import com.example.tecktrove.domain.User;

import java.util.ArrayList;

public class MyAccountPresenter {

    private MyAccountView view;
    private String fullname, email, phone, username, password, confirm_password;
    private boolean isEmployer;
    private EmployerDAO employerDAO;
    private CustomerDAO customerDAO;
    private int userID;


    public MyAccountPresenter(MyAccountView view, CustomerDAO customerDAO, EmployerDAO employerDAO){
        this.view = view;
        this.customerDAO = customerDAO;
        this.employerDAO = employerDAO;
    }

    public void onLogout(){
        view.logout();
    }

    public void onSaveChanges(User user, int userID) {
        boolean allgood = false;

        if (username.equals("") || password.equals("") || email.equals("") || phone.equals("") || confirm_password.equals("") || fullname.equals("")) {
            view.showMessage("Λάθος!", "Συμπλήρωσε όλα τα πεδία.");
        } else if (username.length() < 4 || username.length() > 20) {
            view.showMessage("Λάθος!", "Το όνομα χρήστη πρέπει να είναι μεταξύ 4 και 20 χαρακτήρων.");
        } else if (username.contains(" ")) {
            view.showMessage("Λάθος!", "Το όνομα χρήστη δεν πρέπει να περιέχει κενά.");
        } else if (phone.length() != 10) {
            view.showMessage("Λάθος!", "Γράψε έναν έγκυρο αριθμό τηλεφώνου.");
        } else if (password.length() < 8 || password.contains(" ")) {
            view.showMessage("Λάθος!", "Ο κωδικός πρέπει να είναι πάνω από 8 χαρακτήρες και να μην περιέχει κενά.");
        } else if (!(email.contains("@") && (email.contains(".com") || email.contains(".gr")))) {
            view.showMessage("Λάθος!", "Γράψε ένα έγκυρο mail.");
        } else if (!password.equals(confirm_password)) {
            view.showMessage("Λάθος!", "Ο κωδικός και ο κωδικός επιβεβαίωσης δεν ταιριάζουν.");
        } else {
            String[] name = fullname.split(" ", 2);
            if (user instanceof Employer) {
                Employer employer = employerDAO.findEmployerByUsername(username);
                if ( employer!= null && !employer.equals(user)) {
                    view.showMessage("Λάθος!", "Το όνομα χρήστη υπάρχει ήδη.");
                } else {
                    Employer e = employerDAO.findEmployerByID(userID);
                    e.setName(name[0]); e.setLastName(name[1]); e.setEmail(new Email(email)); e.setUsername(username);
                    e.setPassword(password); e.setTelephone(new Telephone(phone));
                    allgood = true;
                }
            } else {
                Customer customer = customerDAO.findCustomerByUsername(username);
                if (customer != null && !customer.equals(user)) {
                    view.showMessage("Λάθος!", "Το όνομα χρήστη υπάρχει ήδη.");
                } else {
                    Customer c = customerDAO.findCustomerByID(userID);
                    c.setName(name[0]); c.setLastName(name[1]); c.setEmail(new Email(email)); c.setUsername(username);
                    c.setPassword(password); c.setTelephone(new Telephone(phone));
                    allgood = true;
                }
            }
            if (allgood) {
                view.showMessage("Επιτυχία:", "Τα στοιχεία σου άλλαξαν επιτυχώς!");
            }
        }
    }

    public void setInfo(String fullname, String email, String phoneNumber, String username, String password, String confirm_password, boolean isemployer){
        this.fullname = fullname;
        this.email = email;
        this.phone = phoneNumber;
        this.username = username;
        this.password = password;
        this.confirm_password = confirm_password;
        this.isEmployer = isemployer;
    }

    public void onDeleteAccount(){
        /*
        if(isEmployer){
            employerDAO.delete(employerDAO.findEmployerByUsernameAndPassword(username, password));
        }else{
            customerDAO.delete(customerDAO.findCustomerByUsernameAndPassword(username, password));
        }*/
        view.logout();
    }

}
