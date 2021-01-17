import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class demo  {
    private int count=1;
    demo() {

        JFrame f=new JFrame("Blood Bank Management System");
        JLabel lname,laddress,lbloodgroup,lage,lcontact,lemail,lamount,lcampus;

        lname=new JLabel("Full Name :");
        laddress=new JLabel("Address :");
        lbloodgroup=new JLabel("Blood Group :");
        lage=new JLabel("Age :");
        lcontact=new JLabel("Contact No. :");
        lemail=new JLabel("E-mail Id :");
        lamount=new JLabel("Amount :");
        lcampus=new JLabel("Campus :");

        JTextField name=new JTextField();
        JTextArea address= new JTextArea();
        JTextField bloodgroup=new JTextField();
        JTextField age=new JTextField();
        JTextField contact=new JTextField();
        JTextField mailid=new JTextField();
        JTextField amount=new JTextField();
        JTextField campus=new JTextField();
        JTextField search = new JTextField();

        JPanel panel=new JPanel();
        JPanel panel1=new JPanel();

        Button b=new Button("Add+");
        Button clear=new Button("Clear");
        Button B_button = new Button(("B+"));
        Button A_button = new Button("A+");
        Button AB_button = new Button("AB+");
        Button O_button = new Button("O+");
        Button searchButton = new Button("Search");

        String[] bloodTitles = new String[] {"A+","A-","B+","B-","AB+","AB-","O+","O-"};
        JComboBox<String> bloodList = new JComboBox<>(bloodTitles);
        f.add(bloodList);

        bloodList.setBounds(515,55, 50,20);

        lname.setBounds(20,50, 100,30);
        laddress.setBounds(20,85, 100,30);
        lbloodgroup.setBounds(430,50, 100,30);
        lage.setBounds(310,50, 100,30);
        lcontact.setBounds(20,145, 100,30);
        lemail.setBounds(20,180, 100,30);
        lamount.setBounds(310,105, 100,30);
        lcampus.setBounds(310,145, 100,30);

        name.setBounds(90,50,200,25);
        address.setBounds(90,85, 200,50);
        age.setBounds(360,50, 50,25);
        contact.setBounds(90,145, 200,25);
        mailid.setBounds(90,180, 200,25);
        amount.setBounds(360,105, 200,25);
        campus.setBounds(360,145, 200,25);

        b.setBounds(270,225,80,40);
        b.setBackground(Color.lightGray);
        b.setFont(new Font("Serif", Font.BOLD, 20));
        clear.setBounds(360,225,80,40);
        clear.setBackground(Color.lightGray);
        clear.setFont(new Font("Serif", Font.BOLD, 20));
        B_button.setBounds(1095,20,80,40);
        A_button.setBounds(1010,20,80,40);
        AB_button.setBounds(1010,65,80,40);
        O_button.setBounds(1095,65,80,40);
        searchButton.setBounds(1010,105,80,40);
        search.setBounds(1095,105,80,40);

        Border black = BorderFactory.createLineBorder(Color.black);
        LayoutManager layout = new FlowLayout();

        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table=new JTable(tableModel);
        tableModel.addColumn("Sr no.");
        tableModel.addColumn("NAME");
        tableModel.addColumn("Blood group");
        tableModel.addColumn("Campus");

        table.setBounds(10,800,1000,700);
        JScrollPane scrollPane =new JScrollPane(table);
        scrollPane.setSize(1000, 700);
        table.setFillsViewportHeight(true);

        panel.setBounds(10,3,1350,350);
        panel1.setBounds(10,360,1350,350);

        f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));

                clear.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                      name.setText("");
                      address.setText("");
                      contact.setText("");
                      mailid.setText("");
                      age.setText("");
                      amount.setText("");
                      campus.setText("");
                      bloodList.getModel().setSelectedItem("A+");
                    }
                    } );

        ArrayList<Object[]> listTable  = new ArrayList<>();
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String blood = (String) bloodList.getSelectedItem();

                String n = name.getText();
                System.out.println(n);
                String a = address.getText();
                System.out.println(a);
                String bl = bloodgroup.getText();
                System.out.println(bl);
                String ag = age.getText();
                System.out.println(ag);
                String c = contact.getText();
                System.out.println(c);
                String m = mailid.getText();
                System.out.println(m);
                String amt = amount.getText();
                System.out.println(amt);
                String camp = campus.getText();
                System.out.println(camp);

                //input validation
                if(n.isEmpty() || n.equals("")){
                    System.out.println("please enter your name.....");
                }else if(a.isEmpty() || a.equals("")){
                    System.out.println("please enter address.....");
                }else if(blood.isEmpty() || blood.equals("")){
                    System.out.println("cannot be empty.....");
                }else if(ag.isEmpty() || ag.equals("") || Integer.parseInt(ag)<18){
                    System.out.println("please enter your valid age.....");
                }else if(c.isEmpty() || c.equals("")){
                    System.out.println("Enter a number.....");
                }else if(m.isEmpty() || m.equals("")) {
                    System.out.println("Enter a valid email.....");
                }else{

                    int size = tableModel.getRowCount();
                    for (int i=0; i< size; i++){
                        tableModel.removeRow(0);
                    }
                    listTable.add(new Object[]{count++, n, blood, camp});
                    for(Object[] s : listTable){
                            tableModel.addRow(s);
                    }
                }
            }

        });

        B_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tableModel.getRowCount()== listTable.size()) {
                    for (int i = 0; i < listTable.size(); i++) {
                        tableModel.removeRow(0);
                    }
                    for (Object[] a : listTable) {
                        if (a[2].equals("B+")) {
                            tableModel.addRow(a);
                        }
                    }
                }

            }
        });

        A_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tableModel.getRowCount()== listTable.size()) {
                    for (int i = 0; i < listTable.size(); i++) {
                        tableModel.removeRow(0);
                    }
                    for (Object[] a : listTable) {
                        if (a[2].equals("A+")) {
                            tableModel.addRow(a);
                        }
                    }
                }

            }
        });

        AB_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tableModel.getRowCount()== listTable.size()) {
                    for (int i = 0; i < listTable.size(); i++) {
                        tableModel.removeRow(0);
                    }
                    for (Object[] a : listTable) {
                        if (a[2].equals("AB+")) {
                            tableModel.addRow(a);
                        }
                    }
                }

            }
        });

        O_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tableModel.getRowCount()== listTable.size()) {
                    for (int i = 0; i < listTable.size(); i++) {
                        tableModel.removeRow(0);
                    }
                    for (Object[] a : listTable) {
                        if (a[2].equals("O+")) {
                            tableModel.addRow(a);
                        }
                    }
                }

            }
        });

        searchButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String searchText = search.getText();
                        if(!searchText.equals("") || !searchText.isEmpty()){
                            for (Object[] s : listTable){
                                if(s[1].toString().contains(searchText)){
                                    int size = tableModel.getRowCount();
                                    for (int i=0; i< size; i++){
                                        tableModel.removeRow(0);
                                    }
                                    break;
                                }
                            }
                    for(Object[] s : listTable){
                        if(s[1].toString().contains(searchText)){
                            tableModel.addRow(s);
                        }
                    }
                } else {
                    int size = tableModel.getRowCount();
                    for (int i=0; i< size; i++){
                        tableModel.removeRow(0);
                    }
                    for( Object[] s : listTable){
                        tableModel.addRow(s);
                    }
                }
            }
        });

        panel.setLayout(layout);
        panel.setLayout(null);
        panel.setBorder(black);
        panel.add(b);
        panel.add(clear);
        panel.add(name);
        panel.add(address);
        panel.add(bloodgroup);
        panel.add(age);
        panel.add(contact);
        panel.add(mailid);
        panel.add(amount);
        panel.add(campus);
        panel.setBackground(Color.white);
        panel1.add(B_button);
        panel1.add(A_button);
        panel1.add(AB_button);
        panel1.add(O_button);
        panel1.add(search);
        panel1.add(searchButton);
        panel1.setLayout(layout);
        panel1.setLayout(null);
        panel1.setBorder(black);
        panel1.setBackground(Color.white);
        panel1.setVisible(true);
        panel1.add(scrollPane);

        f.add(lname);
        f.add(laddress);
        f.add(lbloodgroup);
        f.add(lage);
        f.add(lcontact);
        f.add(lemail);
        f.add(lamount);
        f.add(lcampus);
        f.add(panel);
        f.add(panel1);
        f.setSize(1000,700);
        f.setLayout(null);
        f.setVisible(true);

    }

    public static void main(String[] args) {
        demo ta = new demo();
    }
}
