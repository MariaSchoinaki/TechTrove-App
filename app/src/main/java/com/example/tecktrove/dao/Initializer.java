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
import com.example.tecktrove.util.Pair;
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

    public abstract ItemDAO getItemDAO();

    public void prepareData(){
        eraseData();
        //Customers
        Customer c1 = new Customer(5673, "george", "ok123456", "George", "Johnson", new Email("klap@yahoo.com"), new Telephone("6898909678"), new ArrayList<Synthesis>(), new ArrayList<Pair<ProductType,Integer>>());
        getCustomerDAO().save(c1);

        Customer c2 = new Customer(7859, "maria5", "31m@ria5", "Maria", "Papadaki", new Email("papadaki27@gmail.com"), new Telephone("6984596936"), new ArrayList<Synthesis>(), new ArrayList<Pair<ProductType,Integer>>());
        getCustomerDAO().save(c2);

        Customer c3 = new Customer(2598, "chris", "chr!s598", "Christos", "Papaioanou", new Email("papaio54@gmail.com"), new Telephone("6985369825"), new ArrayList<Synthesis>(), new ArrayList<Pair<ProductType,Integer>>());
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

        Pair<String, Integer> pair2_1 = new Pair<String, Integer>("ATX Power Port",1);
        Pair<String, Integer> pair2_2 = new Pair<String, Integer>("ATX 12V Power Port",1);
        Pair<String, Integer> pair2_3 = new Pair<String, Integer>("SATA Power Port",2);
        Pair<String, Integer> pair2_4 = new Pair<String, Integer>("Molex Connector",1);
        Pair<String, Integer> pair2_5 = new Pair<String, Integer>("PCI Express Connector",1);
        Pair<String, Integer> pair2_6 = new Pair<String, Integer>("PCI Floppy Drive Connector",1);
        Pair<String, Integer> pair2_7 = new Pair<String, Integer>("AC Adapter",1);

        Port port2 = new Port();
        Port port2_1 = new Port();

        port2.add(pair2_1);
        port2.add(pair2_2);
        port2.add(pair2_3);
        port2.add(pair2_4);
        port2.add(pair2_5);
        port2.add(pair2_6);
        port2_1.add(pair2_7);

        Component com2 = new Component(2936, Money.euros(BigDecimal.valueOf(36.90)), "Turbo-X PSU Value III Series 550 W", "Προσιτό αλλά αξιόπιστο τροφοδοτικό, με ισχύ 550W, προηγμένες δικλείδες ασφαλείας και αθόρυβο ανεμιστήρα 120mm.", "Turbo-X",  port2, port2_1, 75);
        getComponentDAO().save(com2);

        Pair<String, Integer> pair3_1 = new Pair<String, Integer>("socket AM4",1);
        Port port3 = new Port();
        port3.add(pair3_1);

        Component com3 = new Component(3260, Money.euros(BigDecimal.valueOf(119.90)), "AMD CPU Ryzen 3 3200G", "Με τέσσερις πυρήνες Zen σε Socket AM4, μέγιστη συχνότητα λειτουργίας 4GHz, μνήμη cache 6MB και Radeon Vega 8 iGPU για αξεπέραστες επιδόσεις γραφικών.", "AMD",port3,port3, 60);
        getComponentDAO().save(com3);

        Pair<String, Integer> pair4_1 = new Pair<String, Integer>("AM4,",1);
        Port port4 = new Port();
        port4.add(pair4_1);
        Component com4 = new Component(3888, Money.euros(BigDecimal.valueOf(32.90)), "Alpenföhn CPU Cooler Ben Nevis", "Ψύκτρα με ανεμιστήρα 130mm συμβατή με τα sockets 2066, 2011, 2011-v3, 1366, 115X, 1200, AM4, 775, AM4, AM3(+), AM3, AM2(+), AM2 και FM1.", "Alpenföhn", new Port(), port4, 20);
        getComponentDAO().save(com4);

        Pair<String, Integer> pair5_1 = new Pair<String, Integer>("socket AM4",1);
        Pair<String, Integer> pair5_2 = new Pair<String, Integer>("DDR4",2);
        Pair<String, Integer> pair5_3 = new Pair<String, Integer>("PCI Express x16 3.0",1);
        Pair<String, Integer> pair5_4 = new Pair<String, Integer>("SATA III",4);

        Port port5 = new Port();

        port5.add(pair5_1);
        port5.add(pair5_2);
        port5.add(pair5_3);
        port5.add(pair5_4);
        Component com5 = new Component(4188, Money.euros(BigDecimal.valueOf(129.90)), "Gigabyte Motherboard A520I AC", "Βασίζεται στο AMD® A520 Chipset και δέχεται επεξεργαστές AMD Ryzen™ 5000 και 3000 Series καθώς και 4000 G-Series. Υποστηρίζει DDR4 RAM ως 64GB, NVMe PCIe 3.0 M.2 και Intel® Dual Band 802.11ac Wi-Fi.", "AMD",port5, new Port(), 57);
        getComponentDAO().save(com5);

        Pair<String, Integer> pair6 = new Pair<String, Integer>("DDR4",1);
        Port port6 = new Port();

        port6.add(pair6);
        Component com6 = new Component(3935, Money.euros(BigDecimal.valueOf(44.90)), "Crucial Desktop RAM Value 16GB 3200MHz DDR4", "Μνήμη DDR4-3200 UDIMM χωρητικότητας 16GB από την Crucial® με συχνότητα λειτουργίας 3.200 MHz και CL22.", "Micron",new Port(),port6, 44);
        getComponentDAO().save(com6);

        Pair<String, Integer> pair7_1 = new Pair<String, Integer>("PCI Express x16 2.0",1);
        Pair<String, Integer> pair7_2 = new Pair<String, Integer>("HDMI",1);
        Pair<String, Integer> pair7_3 = new Pair<String, Integer>("DVI-D",1);

        Port port7 = new Port();
        Port port7_1 = new Port();

        port7.add(pair7_3);
        port7.add(pair7_2);
        port7_1.add(pair7_1);
        Component com7 = new Component(4311, Money.euros(BigDecimal.valueOf(69.90)), "Asus VGA GeForce GT 730 Evo Low Profile BRK 2 GB", "Είναι ιδανική για υπολογιστές γραφείου, Small Form Factor (SFF) ή Home Theater PCs (HTPC). Είναι χαμηλής κατανάλωσης, με παθητική ψύξη και διαθέτει 3x εξόδους εικόνας.", "ASUS",  port7,port7_1, 28);
        getComponentDAO().save(com7);

        Pair<String, Integer> pair8 = new Pair<String, Integer>("SATA III",1);
        Port port8 = new Port();

        port8.add(pair8);
        Component com8 = new Component(2489, Money.euros(BigDecimal.valueOf(26.90)), "SanDisk SSD Plus 240GB", "Η τεχνολογία SSD 2,5” στο φορητό ή το σταθερό σου υπολογιστή, με χωρητικότητα 240GB, γρήγορες ταχύτητες λειτουργίας και σύνδεση SATA III.", "SanDisk",new Port(),port8, 35);
        getComponentDAO().save(com8);

        Component com11 = new Component(3604, Money.euros(BigDecimal.valueOf(69.90)), "Sharkoon Midi ATX Tower VS4-V Midi Tower", "Μινιμαλιστική σχεδίαση, ευρύχωρο εσωτερικό και άφθονες θέσεις για SSDs/HDDs, προεγκατεστημένος ανεμιστήρας και φίλτρο σκόνης, πρακτικό πάνελ και συμβατότητα με συστήματα υδρόψυξης.", "Sharkoon", new Port(), new Port(), 10);
        getComponentDAO().save(com11);
        Pair<String, Integer> pair12_1 = new Pair<String, Integer>("ATX Power Port",1);
        Pair<String, Integer> pair12_2 = new Pair<String, Integer>("ATX 12V Power Port",1);
        Pair<String, Integer> pair12_3 = new Pair<String, Integer>("SATA Power Port",2);
        Pair<String, Integer> pair12_4 = new Pair<String, Integer>("PCI Express Connector",1);

        Port port12 = new Port();

        port12.add(pair12_1);
        port12.add(pair12_2);
        port12.add(pair12_3);
        port12.add(pair12_4);
        Component com12 = new Component(3740, Money.euros(BigDecimal.valueOf(69.90)), "Sharkoon PSU Series 500 W 80+ Bronze", "Τροφοδοτικό υπολογιστή Sharkoon 500W με πιστοποίηση 80+ Bronze, active PFC, αθόρυβη λειτουργεία με ανεμιστήρα 120mm και διακριτική μαύρη εμφάνιση.", "Sharkoon",  port12,port2_1, 17);
        getComponentDAO().save(com12);

        Pair<String, Integer> pair13_1 = new Pair<String, Integer>("socket AM4+",1);
        Port port13 = new Port();
        port13.add(pair13_1);
        Component com13 = new Component(3740, Money.euros(BigDecimal.valueOf(84.90)), "AMD CPU Ryzen 5 4500", "Με πυρήνες αρχιτεκτονικής Zen 2 και υψηλότερους χρονισμούς, περισσότερο bandwidth, υποστήριξη PCIe 3.0 και αποκλειστικές τεχνολογίες AMD, επαναπροσδιορίζουν την απόδοση των Gaming PCs.", "AMD",port13,port13,33);
        getComponentDAO().save(com13);

        Pair<String, Integer> pair14_1 = new Pair<String, Integer>("4-Pin PWM",1);
        Port port14 = new Port();
        port14.add(pair14_1);
        Component com14 = new Component(4188, Money.euros(BigDecimal.valueOf(34.90)), "Be Quiet! Be Quiet Light Wings 140mm PWM", "Ανεμιστήρας 140mm με PWM, 7 ειδικά βελτιστοποιημένα για χαμηλό θόρυβο και υψηλή απόδοση πτερύγια, rifle-bearing και δύο φωτιζόμενους δακτυλίους ARGB.", "Be Quiet!", new Port(),  port14, 54);
        getComponentDAO().save(com14);

        Pair<String, Integer> pair15_1 = new Pair<String, Integer>("socket AM4+",1);
        Pair<String, Integer> pair15_2 = new Pair<String, Integer>("DDR5",2);
        Pair<String, Integer> pair15_3 = new Pair<String, Integer>("PCI Express x16 3.0",1);
        Pair<String, Integer> pair15_4 = new Pair<String, Integer>("SATA III",4);

        Port port15 = new Port();

        port15.add(pair15_1);
        port15.add(pair15_2);
        port15.add(pair15_3);
        port15.add(pair15_4);
        Component com15 = new Component(3639, Money.euros(BigDecimal.valueOf(69.90)), "MSI Motherboard A520M-A PRO", "Βασίζεται στο AMD® A520 Chipset και δέχεται επεξεργαστές AMD Ryzen™ 5000 και 3000 Series καθώς και 4000 G-Series. Υποστηρίζει μνήμη DDR3 ως 64GB και έχει υποδοχές Μ.2 και PCI Express Gen3 x16.", "AMD", port15, new Port(), 85);
        getComponentDAO().save(com15);

        Pair<String, Integer> pair16 = new Pair<String, Integer>("DDR5",1);
        Port port16 = new Port();
        port16.add(pair16);
        Component com16 = new Component(3290, Money.euros(BigDecimal.valueOf(69.90)), "Corsair Desktop RAM Vengeance PRO RGB 16GB Kit 3000MHz DDR5", "16GB μνήμης RAM DDR5 για υψηλές επιδόσεις και χρονισμούς, με built-in heat spreaders και multi-zone RGB φωτισμό που συμπληρώνει το στυλ κάθε gamer.", "Corsair",  port16, new Port(), 29);
        getComponentDAO().save(com16);


        Pair<String, Integer> pair17_2 = new Pair<String, Integer>("HDMI",1);
        Pair<String, Integer> pair17_3 = new Pair<String, Integer>("DVI-D",1);
        Pair<String, Integer> pair17_4 = new Pair<String, Integer>("DisplayPort",1);

        Port port17 = new Port();

        port17.add(pair17_3);
        port17.add(pair17_2);
        port17.add(pair17_4);
        Component com17 = new Component(4311, Money.euros(BigDecimal.valueOf(189.90)), "Asus VGA GeForce GTX 1630 Phoenix EVO 4 GB", "Προσφέρει υψηλές επιδόσεις στα παιχνίδια χάρη στην αρχιτεκτονική NVIDIA Turing™. Διαθέτει 512 πυρήνες CUDA® και 4GB μνήμης GDDR6.", "Asus", port17, port7_1, 45);
        getComponentDAO().save(com17);

        Pair<String, Integer> pair18 = new Pair<String, Integer>("M.2",1);
        Port port18 = new Port();

        port18.add(pair18);
        Component com18 = new Component(3748, Money.euros(BigDecimal.valueOf(94.90)), "Samsung SSD 980 NVMe M.2 1TB", "Το Samsung NVMe SSD χρησιμοποιεί τεχνολογία μνήμης V-NAND και υποστηρίζει ταχύτητες ανάγνωσης και εγγραφής (sequential) έως 3.500MB/s και 3.000MB/s αντίστοιχα. Έχει χωρητικότητα 1TB", "Samsung", new Port() , port18, 66);
        getComponentDAO().save(com18);

        //Synthesis
        Synthesis s1 = new Synthesis(9787, Money.euros(BigDecimal.valueOf(0)), "Synthesis1");
        s1.add(com1);
        s1.add(com2);
        s1.add(com3);
        s1.add(com4);
        s1.add(com5);
        s1.add(com6);
        s1.add(com7);
        s1.add(com8);
        getSynthesisDAO().save(s1);


        Synthesis s2 = new Synthesis(9485, Money.euros(BigDecimal.valueOf(0)), "Synthesis2");
        s2.add(com11);
        s2.add(com12);
        s2.add(com13);
        s2.add(com14);
        s2.add(com15);
        s2.add(com16);
        s2.add(com17);
        s2.add(com18);
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