package com.example.tecktrove.dao;

import com.example.tecktrove.contacts.Email;
import com.example.tecktrove.contacts.Telephone;
import com.example.tecktrove.domain.Customer;
import com.example.tecktrove.domain.Employer;
import com.example.tecktrove.domain.Order;
import com.example.tecktrove.domain.OrderLine;
import com.example.tecktrove.domain.ProductType;
import com.example.tecktrove.domain.Synthesis;
import com.example.tecktrove.domain.Component;
import com.example.tecktrove.domain.Item;
import com.example.tecktrove.util.Port;
import com.example.tecktrove.util.Money;
import com.example.tecktrove.util.SimpleCalendar;

import java.math.BigDecimal;
import java.util.ArrayList;

public abstract class Initializer {

    /**
     * Erases all the data from the database
     */
    protected abstract void eraseData();

    public abstract CustomerDAO getCustomerDAO();

    public abstract EmployerDAO getEmployerDAO();

    public abstract ComponentDAO getComponentDAO();

    public abstract SynthesisDAO getSynthesisDAO();

    public abstract OrderDAO getOrderDAO();

    public abstract OrderLineDAO getOrderLineDAO();

    public abstract ItemDAO getItemDAO();

    public void prepareData(){
        eraseData();
        //Customers
        Customer c1 = new Customer(5673, "george", "ok123456", "George", "Johnson", new Email("klap@yahoo.com"), new Telephone("6898909678"), new ArrayList<Synthesis>(), new ArrayList<ProductType>());
        getCustomerDAO().save(c1);

        Customer c2 = new Customer(7859, "maria5", "31m@ria5", "Maria", "Papadaki", new Email("papadaki27@gmail.com"), new Telephone("6984596936"), new ArrayList<Synthesis>(), new ArrayList<ProductType>());
        getCustomerDAO().save(c2);

        Customer c3 = new Customer(2598, "chris", "chr!s598", "Christos", "Papaioanou", new Email("papaio54@gmail.com"), new Telephone("6985369825"), new ArrayList<Synthesis>(), new ArrayList<ProductType>());
        getCustomerDAO().save(c3);

        //Employers
        Employer em1 = new Employer(1252, "eleni3", "elen!562", "Eleni", "Georgali", new Email("eleniii2@gmail.com"), new Telephone("6988745961"));
        getEmployerDAO().save(em1);

        Employer em2 = new Employer(5698, "faihh1", "faihskoni1", "Foteini", "Soultatou", new Email("apple3r@yahoo.com"), new Telephone("6978451236"));
        getEmployerDAO().save(em2);

        Employer em3 = new Employer(8596, "kostas34", "13k023m32", "Konstantinos", "Glitsas", new Email("glitsas13@gmail.com"), new Telephone("6945259875"));
        getEmployerDAO().save(em3);

        //Components
        Component com1 = new Component(4191, Money.euros(BigDecimal.valueOf(59.99)), "Case Kolink VOID RGB Midi Tower", "Το VOID Midi-Tower Case αντιπροσωπεύει ένα συναρπαστικό νέο κεφάλαιο στην ιστορία της Kolink, με εντυπωσιακό εφέ «απείρου» καθρεπτισμού σε σχήμα V, ανεμιστήρα 120mm ARGB και πληθώρα χαρακτηριστικών.","Kolink" , new Port(), new Port(), 80);
        getComponentDAO().save(com1);

        Component com2 = new Component(2936, Money.euros(BigDecimal.valueOf(36.90)), "Turbo-X PSU Value III Series 550 W", "Προσιτό αλλά αξιόπιστο τροφοδοτικό, με ισχύ 550W, προηγμένες δικλείδες ασφαλείας και αθόρυβο ανεμιστήρα 120mm.", "Turbo-X", new Port(), new Port(), 75);
        getComponentDAO().save(com2);
        Money total_cost1 = com1.getPrice().plus(com2.getPrice());

        Component com3 = new Component(3260, Money.euros(BigDecimal.valueOf(119.90)), "AMD CPU Ryzen 3 3200G", "Με τέσσερις πυρήνες Zen σε Socket AM4, μέγιστη συχνότητα λειτουργίας 4GHz, μνήμη cache 6MB και Radeon Vega 8 iGPU για αξεπέραστες επιδόσεις γραφικών.", "Turbo-X", new Port(), new Port(), 60);
        getComponentDAO().save(com3);
        total_cost1 = total_cost1.plus(com3.getPrice());

        Component com4 = new Component(3888, Money.euros(BigDecimal.valueOf(32.90)), "Alpenföhn CPU Cooler Ben Nevis", "Ψύκτρα με ανεμιστήρα 130mm συμβατή με τα sockets 2066, 2011, 2011-v3, 1366, 115X, 1200, AM4, 775, AM4, AM3(+), AM3, AM2(+), AM2 και FM1.", "Alpenföhn", new Port(), new Port(), 20);
        getComponentDAO().save(com4);
        total_cost1 = total_cost1.plus(com4.getPrice());

        Component com5 = new Component(4188, Money.euros(BigDecimal.valueOf(129.90)), "Gigabyte Motherboard A520I AC", "Βασίζεται στο AMD® A520 Chipset και δέχεται επεξεργαστές AMD Ryzen™ 5000 και 3000 Series καθώς και 4000 G-Series. Υποστηρίζει DDR4 RAM ως 64GB, NVMe PCIe 3.0 M.2 και Intel® Dual Band 802.11ac Wi-Fi.", "AMD", new Port(), new Port(), 57);
        getComponentDAO().save(com5);
        total_cost1 = total_cost1.plus(com5.getPrice());

        Component com6 = new Component(3935, Money.euros(BigDecimal.valueOf(44.90)), "Crucial Desktop RAM Value 16GB 3200MHz DDR4", "Μνήμη DDR4-3200 UDIMM χωρητικότητας 16GB από την Crucial® με συχνότητα λειτουργίας 3.200 MHz και CL22.", "Micron", new Port(), new Port(), 44);
        getComponentDAO().save(com6);
        total_cost1 = total_cost1.plus(com6.getPrice());

        Component com7 = new Component(4311, Money.euros(BigDecimal.valueOf(69.90)), "Asus VGA GeForce GT 730 Evo Low Profile BRK 2 GB", "Είναι ιδανική για υπολογιστές γραφείου, Small Form Factor (SFF) ή Home Theater PCs (HTPC). Είναι χαμηλής κατανάλωσης, με παθητική ψύξη και διαθέτει 3x εξόδους εικόνας.", "ASUS", new Port(), new Port(), 28);
        getComponentDAO().save(com7);
        total_cost1 = total_cost1.plus(com7.getPrice());

        Component com8 = new Component(2489, Money.euros(BigDecimal.valueOf(26.90)), "SanDisk SSD Plus 240GB", "Η τεχνολογία SSD 2,5” στο φορητό ή το σταθερό σου υπολογιστή, με χωρητικότητα 240GB, γρήγορες ταχύτητες λειτουργίας και σύνδεση SATA III.", "SanDisk", new Port(), new Port(), 35);
        getComponentDAO().save(com8);
        total_cost1 = total_cost1.plus(com8.getPrice());


        Component com11 = new Component(3604, Money.euros(BigDecimal.valueOf(69.90)), "Sharkoon Midi ATX Tower VS4-V Midi Tower", "Μινιμαλιστική σχεδίαση, ευρύχωρο εσωτερικό και άφθονες θέσεις για SSDs/HDDs, προεγκατεστημένος ανεμιστήρας και φίλτρο σκόνης, πρακτικό πάνελ και συμβατότητα με συστήματα υδρόψυξης.", "Sharkoon", new Port(), new Port(), 10);
        getComponentDAO().save(com11);

        Component com12 = new Component(3740, Money.euros(BigDecimal.valueOf(69.90)), "Sharkoon PSU Series 500 W 80+ Bronze", "Τροφοδοτικό υπολογιστή Sharkoon 500W με πιστοποίηση 80+ Bronze, active PFC, αθόρυβη λειτουργεία με ανεμιστήρα 120mm και διακριτική μαύρη εμφάνιση.", "Sharkoon", new Port(), new Port(), 17);
        getComponentDAO().save(com12);
        Money total_cost2 = com11.getPrice().plus(com12.getPrice());

        Component com13 = new Component(3740, Money.euros(BigDecimal.valueOf(84.90)), "AMD CPU Ryzen 5 4500", "Με πυρήνες αρχιτεκτονικής Zen 2 και υψηλότερους χρονισμούς, περισσότερο bandwidth, υποστήριξη PCIe 3.0 και αποκλειστικές τεχνολογίες AMD, επαναπροσδιορίζουν την απόδοση των Gaming PCs.", "AMD", new Port(), new Port(), 33);
        getComponentDAO().save(com13);
        total_cost2 = total_cost2.plus(com13.getPrice());

        Component com14 = new Component(4188, Money.euros(BigDecimal.valueOf(34.90)), "Be Quiet! Be Quiet Light Wings 140mm PWM", "Ανεμιστήρας 140mm με PWM, 7 ειδικά βελτιστοποιημένα για χαμηλό θόρυβο και υψηλή απόδοση πτερύγια, rifle-bearing και δύο φωτιζόμενους δακτυλίους ARGB.", "Be Quiet!", new Port(), new Port(), 54);
        getComponentDAO().save(com14);
        total_cost2 = total_cost2.plus(com14.getPrice());

        Component com15 = new Component(3639, Money.euros(BigDecimal.valueOf(69.90)), "MSI Motherboard A520M-A PRO", "Βασίζεται στο AMD® A520 Chipset και δέχεται επεξεργαστές AMD Ryzen™ 5000 και 3000 Series καθώς και 4000 G-Series. Υποστηρίζει μνήμη DDR4 ως 64GB και έχει υποδοχές Μ.2 και PCI Express Gen3 x16.", "AMD", new Port(), new Port(), 85);
        getComponentDAO().save(com15);
        total_cost2 = total_cost2.plus(com15.getPrice());

        Component com16 = new Component(3290, Money.euros(BigDecimal.valueOf(69.90)), "Corsair Desktop RAM Vengeance PRO RGB 16GB Kit 3000MHz DDR4", "16GB μνήμης RAM DDR4 για υψηλές επιδόσεις και χρονισμούς, με built-in heat spreaders και multi-zone RGB φωτισμό που συμπληρώνει το στυλ κάθε gamer.", "Corsair", new Port(), new Port(), 29);
        getComponentDAO().save(com16);
        total_cost2 = total_cost2.plus(com16.getPrice());

        Component com17 = new Component(4311, Money.euros(BigDecimal.valueOf(189.90)), "Asus VGA GeForce GTX 1630 Phoenix EVO 4 GB", "Προσφέρει υψηλές επιδόσεις στα παιχνίδια χάρη στην αρχιτεκτονική NVIDIA Turing™. Διαθέτει 512 πυρήνες CUDA® και 4GB μνήμης GDDR6.", "Asus", new Port(), new Port(), 45);
        getComponentDAO().save(com17);
        total_cost2 = total_cost2.plus(com17.getPrice());

        Component com18 = new Component(3748, Money.euros(BigDecimal.valueOf(94.90)), "Samsung SSD 980 NVMe M.2 1TB", "Το Samsung NVMe SSD χρησιμοποιεί τεχνολογία μνήμης V-NAND και υποστηρίζει ταχύτητες ανάγνωσης και εγγραφής (sequential) έως 3.500MB/s και 3.000MB/s αντίστοιχα. Έχει χωρητικότητα 1TB", "Samsung", new Port(), new Port(), 66);
        getComponentDAO().save(com18);
        total_cost2 = total_cost2.plus(com18.getPrice());

        //Synthesis
        ArrayList<Component> components1 = new ArrayList<Component>();
        components1.add(com1);
        components1.add(com2);
        components1.add(com3);
        components1.add(com4);
        components1.add(com5);
        components1.add(com6);
        components1.add(com7);
        components1.add(com8);
        Synthesis s1 = new Synthesis(9787, total_cost1, "Synthesis1", components1);
        getSynthesisDAO().save(s1);

        ArrayList<Component> components2 = new ArrayList<Component>();
        components2.add(com11);
        components2.add(com12);
        components2.add(com13);
        components2.add(com14);
        components2.add(com15);
        components2.add(com16);
        components2.add(com17);
        components2.add(com18);
        Synthesis s2 = new Synthesis(9485, total_cost2, "Synthesis2", components2);
        getSynthesisDAO().save(s2);

        //OrderLines-Orders
        OrderLine ol1 = new OrderLine(5, com1);
        OrderLine ol2 = new OrderLine(2, com2);
        OrderLine ol3 = new OrderLine(4, com3);
        OrderLine ol4 = new OrderLine(2, com8);
        OrderLine ol5 = new OrderLine(1, s1);

        ArrayList<OrderLine> orderLines1 = new ArrayList<OrderLine>();
        orderLines1.add(ol1);
        orderLines1.add(ol2);
        orderLines1.add(ol3);
        orderLines1.add(ol4);
        orderLines1.add(ol5);
        Order o1 = new Order(new SimpleCalendar(2023, 11, 24), 9999999999999999L, new Telephone("6977584156"), new Email("vasia43@gmail.com"), orderLines1);
        o1.setId(1324);
        o1.setCustomer(c1);
        getOrderDAO().save(o1);

        //-----------------------------------------------//
        OrderLine ol11 = new OrderLine(5, com15);
        OrderLine ol12 = new OrderLine(2, com12);
        OrderLine ol13 = new OrderLine(4, com17);
        OrderLine ol14 = new OrderLine(1, com14);
        OrderLine ol15 = new OrderLine(1, s2);

        ArrayList<OrderLine> orderLines2 = new ArrayList<OrderLine>();
        orderLines2.add(ol11);
        orderLines2.add(ol12);
        orderLines2.add(ol13);
        orderLines2.add(ol14);
        orderLines2.add(ol15);
        Order o2 = new Order(new SimpleCalendar(2023, 12, 12), 1111111111111111L, new Telephone("6947512635"), new Email("snoopy15@gmail.com"), orderLines2);
        o2.setId(1144);
        o2.setCustomer(c3);
        getOrderDAO().save(o2);

        //-----------------------------------------------//
        OrderLine ol21 = new OrderLine(5, com11);
        OrderLine ol22 = new OrderLine(2, com15);
        OrderLine ol23 = new OrderLine(4, com18);
        OrderLine ol24 = new OrderLine(1, s1);
        OrderLine ol25 = new OrderLine(1, s2);

        ArrayList<OrderLine> orderLines3 = new ArrayList<OrderLine>();
        orderLines3.add(ol21);
        orderLines3.add(ol22);
        orderLines3.add(ol23);
        orderLines3.add(ol24);
        orderLines3.add(ol25);
        Order o3 = new Order(new SimpleCalendar(2023, 12, 25), 1234567891234567L, new Telephone("6955352569"), new Email("legolas7@gmail.com"), orderLines3);
        o3.setId(1225);
        o3.setCustomer(c3);
        getOrderDAO().save(o3);

        //Items
        Item i1 = new Item(16245798);
        getItemDAO().save(i1);

        Item i2 = new Item(14247895);
        getItemDAO().save(i2);

        Item i3 = new Item(24178411);
        getItemDAO().save(i3);
    }
}