import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class databaseapp{

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/nayab";//database name nayab
    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";


    public  static void main(String args[]) {
        //new Main();
        new Main();
        Connection conn = null;
        Statement stmt = null;
        try{

            //STEP 2: Register load JDBC driver

            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            System.out.println("Creating SQL statement...");
            stmt = conn.createStatement();

            //         sql="INSERT INTO Serena_Hotel(FIRST_NAME,LAST_NAME,CNIC,STATE,ZIP_CODE,PHONE_NO)"+
            //         "VALUES('Sabeen','Nisar',4130191543124,'Pakistan',5145,0302827822)";

            //books
            String  sql = "SELECT * FROM Serena_Hotel";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            System.out.println("Retrieveing and Displaying data from table books of nayab Database");
            System.out.println("****************************************************************************************************************************************");
            System.out.println("F_Name"+" "+"  L_Name"+"    "+"CNIC"+"          "+"Email_Add"+"    "+"\tPhone_no"+"   "
                    +"Region"+"   "+"State"+" "+"Zip_Code"+"  "+"Check_In  "+"  Check_Out"+" "+" Packages"+" "+"  Room_Pref"+" Card_Num");

            System.out.println("****************************************************************************************************************************************");

            while(rs.next()){

                //Retrieve by column name

                String name=rs.getString("First_Name");

                String l_name=rs.getString("Last_Name");

                int CNIC = rs.getInt("CNIC");
                String email=rs.getString("Email_Address");
                int Phone_no = rs.getInt("Phone_no");
                String region=rs.getString("Region");
                String state=rs.getString("State");
                int Zip_Code = rs.getInt("ZipCode");
                String Check_In=rs.getString("Check_in");
                String Check_Out=rs.getString("Check_out");
                String packages=rs.getString("Packages");
                String room_pref=rs.getString("Room_Pref");
                String Payment=rs.getString("Payment_Method");
                //Display values

                System.out.println(name+"   "+l_name+" "+CNIC+" "+email+" "+" "+Phone_no+" "+region+"   "+
                        state+"   "+Zip_Code+"   "+Check_In+"  "+Check_Out+"   "+packages
                        +"       "+room_pref+"  "+Payment);//

            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();//connection closed

        } catch (Exception e) {

            System.out.print("DBTest");
        }//Catch block ends here

    }
}
class Main extends JFrame implements ActionListener {

    JFrame frame;
    JRadioButton next;
    JLabel lbl;
    Font myfont;
    Font myfont1;
    JRadioButton b1;
    JRadioButton b2;
    JRadioButton b3;
    JRadioButton b4;
    JRadioButton b5;
    JRadioButton b6;
    JRadioButton b7;
    JRadioButton b8;
    JRadioButton b9;
    JRadioButton b10;


    public Main() {

        setTitle("Hotel Booking");
        //Background Image
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("C:\\Users\\hp\\Desktop\\Image.jpg")));
        setLayout(new FlowLayout());
        setSize(599, 899);
        setSize(600, 900);

        //Intro

        lbl = new JLabel("ISLAMABAD THE SMART CITY");
        myfont = new Font("Serief", Font.BOLD, 60);
        lbl.setFont(myfont);

        //Sign_in Button
        next = new JRadioButton("");

//Adding in Frame
        next.addActionListener(this);
        add(next);
        add(lbl);

        //Frame Setting

        setVisible(true);
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {

        new Main();
//Conecting to the database
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {

            JFrame frame1 = new JFrame(" Top 10 Hotel's Of Islamabad ");

            //Background Image
            frame1.setSize(900, 900);
            frame1.setLocationRelativeTo(null);
            frame1.setDefaultCloseOperation(EXIT_ON_CLOSE);
            frame1.setVisible(true);
            frame1.setLayout(new BorderLayout());
            frame1.setContentPane(new JLabel(new ImageIcon("C:\\Users\\hp\\Desktop\\Hotel_Image.jpg")));
            frame1.setLayout(new FlowLayout());
            frame1.getContentPane().setBackground(Color.GRAY);
//Buttons
            b1 = new JRadioButton("Sarena Hotel");
            b1.setBounds(300, 250, 200, 50);
            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    JFrame frame=new JFrame("Form");

                    frame.setSize(800, 900);
                    frame.setLocationRelativeTo(null);
                    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    frame.setVisible(true);
                    frame.setLayout(new BorderLayout());
                    frame.setContentPane(new JLabel(new ImageIcon("C:\\Users\\hp\\Desktop\\image1.jpg")));
                    frame.setLayout(new FlowLayout());
                    frame.getContentPane().setBackground(Color.RED);

                    JLabel title = new JLabel("SERENA HOTEL");


                    title.setBounds(150,10,300,50);
                    title.setFont(new Font("Serif", Font.BOLD, 30));
                    title.setForeground(Color.BLACK);
                    frame.add(title);
                    JLabel reservation=new JLabel("Reservation Details");
                    reservation.setBounds(40,20,180,100);
                    // First Name

                    JLabel f_name = new JLabel(" First Name");
                    f_name.setBounds(40, 60, 80, 100);

                    JTextField name = new JTextField();
                    name.setBounds(40, 120, 160, 30);
                    //Last_Name
                    JLabel l_name = new JLabel("Last Name");
                    l_name.setBounds(250, 60, 100, 100);

                    JTextField last_name= new JTextField();
                    last_name.setBounds(250, 120, 160, 30);

                    //CNIC
                    JLabel cnic=new JLabel("CNIC");
                    cnic.setBounds(40,130,280,100);
                    JTextField cnic_no=new JTextField();
                    cnic_no.setBounds(40, 195, 250, 30);
                    //Email

                    JLabel email = new JLabel("Email Address");
                    email.setBounds(40, 205, 100, 100);
                    JTextField email_text = new JTextField();
                    email_text.setBounds(40, 270, 160, 30);

                    //Phone no

                    JLabel phone_no = new JLabel("Phone_no");
                    phone_no.setBounds(250, 205, 100, 100);
                    JTextField phone_text = new JTextField();
                    phone_text.setBounds(250, 270, 160, 30);
                    phone_text.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyPressed(KeyEvent e) {
                            String value = phone_text.getText();
                            int l = value.length();
                            if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
                                phone_text.setEditable(true);
                            } else {
                                phone_text.setEditable(false);
                                JOptionPane.showMessageDialog(null, "Enter only numeric digits(0-9)");
                            }
                        }
                    });


                    //Region of residence

                    JLabel residence=new JLabel("Region of Residence");
                    residence.setBounds(40,285,140,100);
                    JTextField residence_text=new JTextField();
                    residence_text.setBounds(40,350,140,30);
                    //State
                    JLabel state=new JLabel("State");
                    state.setBounds(200,285,100,100);
                    JTextField state_text=new JTextField();
                    state_text.setBounds(200,350,100,30);

                    //Zipcode

                    JLabel zipcode=new JLabel("Zip Code");
                    zipcode.setBounds(310,285,100,100);
                    JTextField zipcode_text=new JTextField();
                    zipcode_text.setBounds(310,350,100,30);

                    //Check in:
                    JLabel Check_in=new JLabel("Check_in_Date:");
                    Check_in.setBounds(40,370,130,100);

                    String date[] = {"1","2","3","4","5","6","7","8","9",
                            "10","11","12","13","14","15","16","17","18","19","20","21",
                            "22","23","24","25","26","27","28","29","30","31"};
                    JComboBox dates = new JComboBox(date);
                    dates.setBounds(170, 400, 40, 30);

                    String mon[]={"Jan","Feb","March","April","May","June","July","Aug","Sep","Oct","Nov","Dec"};
                    JComboBox months=new JComboBox(mon);
                    months.setBounds(220,400,60,30);

                    String Year[]={"2022","2023","2024"};
                    JComboBox year=new JComboBox(Year);
                    year.setBounds(290,400,60,30);

                    //Check_out

                    JLabel Check_out=new JLabel("Check_Out_Date:");
                    Check_out.setBounds(40,410,130,100);

                    String date_exit[] = {"1","2","3","4","5","6","7","8","9",
                            "10","11","12","13","14","15","16","17","18","19","20","21",
                            "22","23","24","25","26","27","28","29","30","31"};
                    JComboBox dates_exit = new JComboBox(date_exit);
                    dates_exit.setBounds(170, 450, 40, 30);

                    String mon_exit[]={"Jan","Feb","March","April","May","June","July","Aug","Sep","Oct","Nov","Dec"};
                    JComboBox months_exit=new JComboBox(mon_exit);
                    months_exit.setBounds(220,450,60,30);

                    String Year_exit[]={"2022","2023","2024"};
                    JComboBox year_exit=new JComboBox(Year_exit);
                    year_exit.setBounds(290,450,60,30);

                    ButtonGroup bg;


                    //Room Preference
                    JLabel R_Prefernce=new JLabel("Room Prefernce");
                    R_Prefernce.setBounds(40,500,100,100);


                    JTextField r_pref=new JTextField();
                    r_pref.setBounds(170,530,150,30);

//Packages
                    JLabel packages=new JLabel("Packages:");
                    packages.setBounds(40,500,70,20);

                    JRadioButton Packages = new JRadioButton("Avail the Packages");
                    Packages.setBounds(160,500,150,20);
                    frame.add(Packages);

                    JLabel optional=new JLabel("(Optional)");
                    optional.setBounds(320,500,70,20);

                    Packages.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            JFrame f5=new JFrame("Available Packages");


                            f5.setSize(350, 350);
                            f5.setLocationRelativeTo(null);
                            f5.setDefaultCloseOperation(EXIT_ON_CLOSE);
                            f5.setVisible(true);
                            //f5.setContentPane(new JLabel(new ImageIcon("C:\\Users\\hp\\Desktop\\Islamabad_collage_1.jpg")));
                            f5.getContentPane().setBackground(Color.lightGray);
                            // frame.getContentPane().setBackground(Color.PINK);
                            f5.setLayout(new FlowLayout());

                            //Adding
                            JLabel packages0=new JLabel("> Pick and Drop services from Airport/Station");
                            packages0.setBounds(40,60,270,20);
                            packages0.setFont(new Font("Serief",Font.BOLD,15));
                            JLabel packages1=new JLabel("> Buffet Breakfast in Restaurant");
                            packages1.setBounds(40,90,210,20);
                            packages1.setFont(new Font("Serief",Font.BOLD,15));

                            JLabel packages2=new JLabel("> Under the age of 12 Years Free with Parents");
                            packages2.setBounds(40,120,270,20);
                            packages2.setFont(new Font("Serief",Font.BOLD,15));

                            JLabel packages3=new JLabel("> 5% Discount on Laundry Service");
                            packages3.setBounds(40,150,210,20);
                            packages3.setFont(new Font("Serief",Font.BOLD,15));

                            JLabel packages4=new JLabel("> 10% Discount on Food Items");
                            packages4.setBounds(40,180,170,20);
                            packages4.setFont(new Font("Serief",Font.BOLD,15));

                            JLabel packages5=new JLabel("> 10% Discount on Room Service");
                            packages5.setBounds(40,210,210,20);
                            packages5.setFont(new Font("Serief",Font.BOLD,18));
//
//                            JLabel packages6=new JLabel("> 5% Discount on  10 days Stay");
//                            packages6.setBounds(40,210,210,20);
//                            packages6.setFont(new Font("Serief",Font.BOLD,15));

                            //Confirm

                            JButton button1 = new JButton("Yes");
                            button1.setBounds(20, 20, 50, 30);

                            JButton button2 = new JButton("No");
                            button2.setBounds(100, 270, 70, 30);
                            button2.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {

                                    f5.setDefaultCloseOperation(EXIT_ON_CLOSE);
                                    //System.exit(0);
                                }
                            });

                            //Addding to the Panel
                            f5.getContentPane().add(packages0);
                            f5.getContentPane().add(packages1);
                            f5.getContentPane().add(packages2);
                            f5.getContentPane().add(packages3);
                            f5.getContentPane().add(packages4);
                            f5.getContentPane().add(packages5);
//                            f5.getContentPane().add(packages6);
                            f5.add(button1);
                            f5.add(button2);

                        }
                    });


//Payment Method
                    JLabel payment=new JLabel("Payment Method");
                    payment.setBounds(40,535,130,100);

                    JRadioButton r1 = new JRadioButton("Credit Card");
                    r1.setBounds(170, 570, 100, 20);
                    frame.add(r1);
                    bg = new ButtonGroup();
                    bg.add(r1);
                    JRadioButton r2=new JRadioButton("Pay through Cash");
                    r2.setBounds(270, 570, 140, 20);
                    frame.add(r2);
                    bg = new ButtonGroup();
                    bg.add(r2);

                    r1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JFrame f4=new JFrame("Card Details");
                            String name=JOptionPane.showInputDialog(f4,"Enter Credit_Card num:");


                        }
                    });
//Clear Button

                    JButton button1 = new JButton("Confirm");
                    button1.setBounds(120, 620, 100, 30);
                    button1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JFrame f5=new JFrame("Confirm Message");

                            f5.setSize(500,350);
                            f5.setLocationRelativeTo(null);
                            f5.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
                            f5.setVisible(true);
                            f5.setLayout(new BorderLayout());
                            f5.setBackground(Color.WHITE);
                            f5.setLayout(new FlowLayout());
                            f5.setVisible(true);

                            JLabel l1=new JLabel("Dear Guest \nYour Reservation is Confirmed..");
                            JLabel l2=new JLabel("This is Confirmation message of your Stay");
                            JLabel l3=new JLabel("If you have any queries please don't hesitate to call us directly");
                            JLabel l4=new JLabel("We are looking forward for your visit and hope that you enjoy your visit");
                            JLabel l5=new JLabel("Best Regards: SERENA HOTEL ISLAMABAD");

                            l1.setFont(new Font("Serief",Font.ITALIC,14));
                            l2.setFont(new Font("Serief",Font.ITALIC,14));
                            l3.setFont(new Font("Serief",Font.ITALIC,14));
                            l4.setFont(new Font("Serief",Font.ITALIC,14));
                            l5.setFont(new Font("Serif", Font.BOLD, 20));

                            f5.add(l1);
                            f5.add(l2);
                            f5.add(l3);
                            f5.add(l4);
                            f5.add(l5);

                        }
                    });

                    JButton button2 = new JButton("Cancel");
                    button2.setBounds(240, 620, 110, 30);
                    button2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.exit(0);
                        }
                    });
                    frame.add(button1);
                    frame.add(button2);
//Frame Setting
                    frame.setLayout(null);
                    frame.setSize(600, 800);
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setResizable(false);
                    //Addding to the Panel
                    frame.getContentPane().add(title);
                    frame.getContentPane().add(reservation);
                    frame.getContentPane().add(f_name);
                    frame.getContentPane().add(name);
                    frame.getContentPane().add(l_name);
                    frame.getContentPane().add(last_name);
                    frame.getContentPane().add(cnic);
                    frame.getContentPane().add(cnic_no);
                    frame.getContentPane().add(email);
                    frame.getContentPane().add(email_text);
                    frame.getContentPane().add(phone_no);
                    frame.getContentPane().add(phone_text);
                    frame.getContentPane().add(residence);
                    frame.getContentPane().add(residence_text);
                    frame.getContentPane().add(state);
                    frame.getContentPane().add(state_text);
                    frame.getContentPane().add(zipcode);
                    frame.getContentPane().add(zipcode_text);

                    //check_iN
                    frame.getContentPane().add(Check_in);
                    frame.getContentPane().add(dates);
                    frame.getContentPane().add(year);
                    frame.getContentPane().add(months);
                    //Check out
                    frame.getContentPane().add(Check_out);
                    frame.getContentPane().add(dates_exit);
                    frame.getContentPane().add(months_exit);
                    frame.getContentPane().add(year_exit);
                    frame.getContentPane().add(payment);
                    frame.getContentPane().add(R_Prefernce);
                    frame.getContentPane().add(r_pref);
                    frame.getContentPane().add(packages);
                    frame.getContentPane().add(optional);

                }});
//***********************************
    // Second Hotel Marriott
            //*******************************
            b2 = new JRadioButton("Marriott Hotel");

            b2.setBounds(500, 250, 150, 50);
            b2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    JFrame frame=new JFrame("Form");

                    frame.setSize(800, 900);
                    frame.setLocationRelativeTo(null);
                    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    frame.setVisible(true);
                    frame.setLayout(new BorderLayout());
                    frame.setContentPane(new JLabel(new ImageIcon("C:\\Users\\hp\\Desktop\\image1.jpg")));
                    frame.setLayout(new FlowLayout());
                    frame.getContentPane().setBackground(Color.RED);

                    JLabel title = new JLabel("MARRIOTT  HOTEL");

                    title.setBounds(150,10,300,50);
                    title.setFont(new Font("Serif", Font.BOLD, 30));
                    title.setForeground(Color.BLACK);
                    frame.add(title);
                    JLabel reservation=new JLabel("Reservation Details");
                    reservation.setBounds(40,20,180,100);
                    // First Name

                    JLabel f_name = new JLabel(" First Name");
                    f_name.setBounds(40, 60, 80, 100);

                    JTextField name = new JTextField();
                    name.setBounds(40, 120, 160, 30);
                    //Last_Name
                    JLabel l_name = new JLabel("Last Name");
                    l_name.setBounds(250, 60, 100, 100);

                    JTextField last_name= new JTextField();
                    last_name.setBounds(250, 120, 160, 30);

                    //CNIC
                    JLabel cnic=new JLabel("CNIC");
                    cnic.setBounds(40,130,280,100);
                    JTextField cnic_no=new JTextField();
                    cnic_no.setBounds(40, 195, 250, 30);
                    //Email

                    JLabel email = new JLabel("Email Address");
                    email.setBounds(40, 205, 100, 100);
                    JTextField email_text = new JTextField();
                    email_text.setBounds(40, 270, 160, 30);

                    //Phone no

                    JLabel phone_no = new JLabel("Phone_no");
                    phone_no.setBounds(250, 205, 100, 100);
                    JTextField phone_text = new JTextField();
                    phone_text.setBounds(250, 270, 160, 30);
                    phone_text.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyPressed(KeyEvent e) {
                            String value = phone_text.getText();
                            int l = value.length();
                            if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
                                phone_text.setEditable(true);
                            } else {
                                phone_text.setEditable(false);
                                JOptionPane.showMessageDialog(null, "Enter only numeric digits(0-9)");
                            }
                        }
                    });


                    //Region of residence

                    JLabel residence=new JLabel("Region of Residence");
                    residence.setBounds(40,285,140,100);
                    JTextField residence_text=new JTextField();
                    residence_text.setBounds(40,350,140,30);
                    //State
                    JLabel state=new JLabel("State");
                    state.setBounds(200,285,100,100);
                    JTextField state_text=new JTextField();
                    state_text.setBounds(200,350,100,30);

                    //Zipcode

                    JLabel zipcode=new JLabel("Zip Code");
                    zipcode.setBounds(310,285,100,100);
                    JTextField zipcode_text=new JTextField();
                    zipcode_text.setBounds(310,350,100,30);

                    //Check in:
                    JLabel Check_in=new JLabel("Check_in_Date:");
                    Check_in.setBounds(40,370,130,100);

                    String date[] = {"1","2","3","4","5","6","7","8","9",
                            "10","11","12","13","14","15","16","17","18","19","20","21",
                            "22","23","24","25","26","27","28","29","30","31"};
                    JComboBox dates = new JComboBox(date);
                    dates.setBounds(170, 400, 40, 30);

                    String mon[]={"Jan","Feb","March","April","May","June","July","Aug","Sep","Oct","Nov","Dec"};
                    JComboBox months=new JComboBox(mon);
                    months.setBounds(220,400,60,30);

                    String Year[]={"2022","2023","2024"};
                    JComboBox year=new JComboBox(Year);
                    year.setBounds(290,400,60,30);

                    //Check_out

                    JLabel Check_out=new JLabel("Check_Out_Date:");
                    Check_out.setBounds(40,410,130,100);

                    String date_exit[] = {"1","2","3","4","5","6","7","8","9",
                            "10","11","12","13","14","15","16","17","18","19","20","21",
                            "22","23","24","25","26","27","28","29","30","31"};
                    JComboBox dates_exit = new JComboBox(date_exit);
                    dates_exit.setBounds(170, 450, 40, 30);

                    String mon_exit[]={"Jan","Feb","March","April","May","June","July","Aug","Sep","Oct","Nov","Dec"};
                    JComboBox months_exit=new JComboBox(mon_exit);
                    months_exit.setBounds(220,450,60,30);

                    String Year_exit[]={"2022","2023","2024"};
                    JComboBox year_exit=new JComboBox(Year_exit);
                    year_exit.setBounds(290,450,60,30);

                    ButtonGroup bg;


                    //Room Preference
                    JLabel R_Prefernce=new JLabel("Room Prefernce");
                    R_Prefernce.setBounds(40,500,100,100);
                    JTextField r_pref=new JTextField();
                    r_pref.setBounds(170,530,150,30);


                    //Packages

                    JLabel packages=new JLabel("Packages:");
                    packages.setBounds(40,500,70,20);

                    JRadioButton Packages = new JRadioButton("Avail the Packages");
                    Packages.setBounds(160,500,150,20);
                    frame.add(Packages);

                    JLabel optional=new JLabel("(Optional)");
                    optional.setBounds(320,500,70,20);

                    Packages.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {



                            JFrame f5=new JFrame("Available Packages");


                            f5.setSize(350, 350);
                            f5.setLocationRelativeTo(null);
                            f5.setDefaultCloseOperation(EXIT_ON_CLOSE);
                            f5.setVisible(true);
                            //f5.setContentPane(new JLabel(new ImageIcon("C:\\Users\\hp\\Desktop\\Islamabad_collage_1.jpg")));
                            f5.getContentPane().setBackground(Color.lightGray);
                            // frame.getContentPane().setBackground(Color.PINK);
                            f5.setLayout(new FlowLayout());

                            //Adding
                            JLabel packages0=new JLabel("> Pick and Drop services from Airport/Station");
                            packages0.setBounds(40,60,270,20);
                            packages0.setFont(new Font("Serief",Font.BOLD,15));
                            JLabel packages1=new JLabel("> Buffet Breakfast in Restaurant");
                            packages1.setBounds(40,90,210,20);
                            packages1.setFont(new Font("Serief",Font.BOLD,15));

                            JLabel packages2=new JLabel("> Under the age of 12 Years Free with Parents");
                            packages2.setBounds(40,120,270,20);
                            packages2.setFont(new Font("Serief",Font.BOLD,15));

                            JLabel packages3=new JLabel("> 5% Discount on Laundry Service");
                            packages3.setBounds(40,150,210,20);
                            packages3.setFont(new Font("Serief",Font.BOLD,15));

                            JLabel packages4=new JLabel("> 10% Discount on Food Items");
                            packages4.setBounds(40,180,170,20);
                            packages4.setFont(new Font("Serief",Font.BOLD,15));

                            JLabel packages5=new JLabel("> 10% Discount on Room Service");
                            packages5.setBounds(40,210,210,20);
                            packages5.setFont(new Font("Serief",Font.BOLD,18));

                            //Confirm

                            JButton button1 = new JButton("Yes");
                            button1.setBounds(20, 20, 50, 30);

                            JButton button2 = new JButton("No");
                            button2.setBounds(100, 270, 70, 30);
                            button2.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {

                                    f5.setDefaultCloseOperation(EXIT_ON_CLOSE);
                                    //System.exit(0);
                                }
                            });


                            //Addding to the Panel
                            f5.getContentPane().add(packages0);
                            f5.getContentPane().add(packages1);
                            f5.getContentPane().add(packages2);
                            f5.getContentPane().add(packages3);
                            f5.getContentPane().add(packages4);
                            f5.getContentPane().add(packages5);

                            f5.add(button1);
                            f5.add(button2);

                        }
                    });


//Payment Method

                    JLabel payment=new JLabel("Payment Method");
                    payment.setBounds(40,535,130,100);

                    JRadioButton r1 = new JRadioButton("Credit Card");
                    r1.setBounds(170, 570, 100, 20);
                    frame.add(r1);
                    bg = new ButtonGroup();
                    bg.add(r1);
                    JRadioButton r2=new JRadioButton("Pay through Cash");
                    r2.setBounds(270, 570, 140, 20);
                    frame.add(r2);
                    bg = new ButtonGroup();
                    bg.add(r2);

                    r1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JFrame f4=new JFrame("Card Details");
                            String name=JOptionPane.showInputDialog(f4,"Enter Credit_Card num:");


                        }
                    });
//Clear Button

                    JButton button1 = new JButton("Confirm");
                    button1.setBounds(120, 620, 100, 30);
                    button1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JFrame f5=new JFrame("Confirm Message");





                            f5.setSize(500,350);
                            f5.setLocationRelativeTo(null);
                            f5.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
                            f5.setVisible(true);
                            f5.setLayout(new BorderLayout());
                            f5.setBackground(Color.WHITE);
                            f5.setLayout(new FlowLayout());
                            f5.setVisible(true);

                            JLabel l1=new JLabel("Dear Guest \nYour Reservation is Confirmed..");
                            JLabel l2=new JLabel("This is Confirmation message of your Stay");
                            JLabel l3=new JLabel("If you have any queries please don't hesitate to call us directly");
                            JLabel l4=new JLabel("We are looking forward for your visit and hope that you enjoy your visit");
                            JLabel l5=new JLabel("Best Regards: MARIOTT HOTEL ISLAMABAD");

                            l1.setFont(new Font("Serief",Font.ITALIC,14));
                            l2.setFont(new Font("Serief",Font.ITALIC,14));
                            l3.setFont(new Font("Serief",Font.ITALIC,14));
                            l4.setFont(new Font("Serief",Font.ITALIC,14));
                            l5.setFont(new Font("Serif", Font.BOLD, 20));

                            f5.add(l1);
                            f5.add(l2);
                            f5.add(l3);
                            f5.add(l4);
                            f5.add(l5);

                        }
                    });

                    JButton button2 = new JButton("Cancel");
                    button2.setBounds(240, 620, 110, 30);
                    button2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.exit(0);
                        }
                    });
                    frame.add(button1);
                    frame.add(button2);
//Frame Setting
                    frame.setLayout(null);
                    frame.setSize(600, 800);
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setResizable(false);
                    //Addding to the Panel
                    frame.getContentPane().add(title);
                    frame.getContentPane().add(reservation);
                    frame.getContentPane().add(f_name);
                    frame.getContentPane().add(name);
                    frame.getContentPane().add(l_name);
                    frame.getContentPane().add(last_name);
                    frame.getContentPane().add(cnic);
                    frame.getContentPane().add(cnic_no);
                    frame.getContentPane().add(email);
                    frame.getContentPane().add(email_text);
                    frame.getContentPane().add(phone_no);
                    frame.getContentPane().add(phone_text);
                    frame.getContentPane().add(residence);
                    frame.getContentPane().add(residence_text);
                    frame.getContentPane().add(state);
                    frame.getContentPane().add(state_text);
                    frame.getContentPane().add(zipcode);
                    frame.getContentPane().add(zipcode_text);

                    //check_iN
                    frame.getContentPane().add(Check_in);
                    frame.getContentPane().add(dates);
                    frame.getContentPane().add(year);
                    frame.getContentPane().add(months);
                    //Check out
                    frame.getContentPane().add(Check_out);
                    frame.getContentPane().add(dates_exit);
                    frame.getContentPane().add(months_exit);
                    frame.getContentPane().add(year_exit);
                    frame.getContentPane().add(payment);
                    frame.getContentPane().add(R_Prefernce);
                    frame.getContentPane().add(r_pref);
                    frame.getContentPane().add(packages);
                    frame.getContentPane().add(optional);

                }});


//3rd hotel


            b3 = new JRadioButton("Jasmine Hotel ");
            b3.setBounds(300, 300, 200, 50);

            b3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    JFrame frame=new JFrame("Form");

                    frame.setSize(800, 900);
                    frame.setLocationRelativeTo(null);
                    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    frame.setVisible(true);
                    frame.setLayout(new BorderLayout());
                    frame.setContentPane(new JLabel(new ImageIcon("C:\\Users\\hp\\Desktop\\image1.jpg")));
                    frame.setLayout(new FlowLayout());
                    frame.getContentPane().setBackground(Color.RED);

                    JLabel title = new JLabel("JASMINE  HOTEL");

                    title.setBounds(150,10,300,50);
                    title.setFont(new Font("Serif", Font.BOLD, 30));
                    title.setForeground(Color.BLACK);
                    frame.add(title);
                    JLabel reservation=new JLabel("Reservation Details");
                    reservation.setBounds(40,20,180,100);
                    // First Name

                    JLabel f_name = new JLabel(" First Name");
                    f_name.setBounds(40, 60, 80, 100);

                    JTextField name = new JTextField();
                    name.setBounds(40, 120, 160, 30);
                    //Last_Name
                    JLabel l_name = new JLabel("Last Name");
                    l_name.setBounds(250, 60, 100, 100);

                    JTextField last_name= new JTextField();
                    last_name.setBounds(250, 120, 160, 30);

                    //CNIC
                    JLabel cnic=new JLabel("CNIC");
                    cnic.setBounds(40,130,280,100);
                    JTextField cnic_no=new JTextField();
                    cnic_no.setBounds(40, 195, 250, 30);
                    //Email

                    JLabel email = new JLabel("Email Address");
                    email.setBounds(40, 205, 100, 100);
                    JTextField email_text = new JTextField();
                    email_text.setBounds(40, 270, 160, 30);

                    //Phone no

                    JLabel phone_no = new JLabel("Phone_no");
                    phone_no.setBounds(250, 205, 100, 100);
                    JTextField phone_text = new JTextField();
                    phone_text.setBounds(250, 270, 160, 30);
                    phone_text.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyPressed(KeyEvent e) {
                            String value = phone_text.getText();
                            int l = value.length();
                            if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
                                phone_text.setEditable(true);
                            } else {
                                phone_text.setEditable(false);
                                JOptionPane.showMessageDialog(null, "Enter only numeric digits(0-9)");
                            }
                        }
                    });


                    //Region of residence

                    JLabel residence=new JLabel("Region of Residence");
                    residence.setBounds(40,285,140,100);
                    JTextField residence_text=new JTextField();
                    residence_text.setBounds(40,350,140,30);
                    //State
                    JLabel state=new JLabel("State");
                    state.setBounds(200,285,100,100);
                    JTextField state_text=new JTextField();
                    state_text.setBounds(200,350,100,30);

                    //Zipcode

                    JLabel zipcode=new JLabel("Zip Code");
                    zipcode.setBounds(310,285,100,100);
                    JTextField zipcode_text=new JTextField();
                    zipcode_text.setBounds(310,350,100,30);

                    //Check in:
                    JLabel Check_in=new JLabel("Check_in_Date:");
                    Check_in.setBounds(40,370,130,100);

                    String date[] = {"1","2","3","4","5","6","7","8","9",
                            "10","11","12","13","14","15","16","17","18","19","20","21",
                            "22","23","24","25","26","27","28","29","30","31"};
                    JComboBox dates = new JComboBox(date);
                    dates.setBounds(170, 400, 40, 30);

                    String mon[]={"Jan","Feb","March","April","May","June","July","Aug","Sep","Oct","Nov","Dec"};
                    JComboBox months=new JComboBox(mon);
                    months.setBounds(220,400,60,30);

                    String Year[]={"2022","2023","2024"};
                    JComboBox year=new JComboBox(Year);
                    year.setBounds(290,400,60,30);

                    //Check_out

                    JLabel Check_out=new JLabel("Check_Out_Date:");
                    Check_out.setBounds(40,410,130,100);

                    String date_exit[] = {"1","2","3","4","5","6","7","8","9",
                            "10","11","12","13","14","15","16","17","18","19","20","21",
                            "22","23","24","25","26","27","28","29","30","31"};
                    JComboBox dates_exit = new JComboBox(date_exit);
                    dates_exit.setBounds(170, 450, 40, 30);

                    String mon_exit[]={"Jan","Feb","March","April","May","June","July","Aug","Sep","Oct","Nov","Dec"};
                    JComboBox months_exit=new JComboBox(mon_exit);
                    months_exit.setBounds(220,450,60,30);

                    String Year_exit[]={"2022","2023","2024"};
                    JComboBox year_exit=new JComboBox(Year_exit);
                    year_exit.setBounds(290,450,60,30);

                    ButtonGroup bg;


                    //Room Preference
                    JLabel R_Prefernce=new JLabel("Room Prefernce");
                    R_Prefernce.setBounds(40,500,100,100);
                    JTextField r_pref=new JTextField();
                    r_pref.setBounds(170,530,150,30);

//Packages
                    JLabel packages=new JLabel("Packages:");
                    packages.setBounds(40,500,70,20);

                    JRadioButton Packages = new JRadioButton("Avail the Packages");
                    Packages.setBounds(160,500,150,20);
                    frame.add(Packages);

                    JLabel optional=new JLabel("(Optional)");
                    optional.setBounds(320,500,70,20);

                    Packages.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {



                            JFrame f5=new JFrame("Available Packages");


                            f5.setSize(350, 350);
                            f5.setLocationRelativeTo(null);
                            f5.setDefaultCloseOperation(EXIT_ON_CLOSE);
                            f5.setVisible(true);
                            //f5.setContentPane(new JLabel(new ImageIcon("C:\\Users\\hp\\Desktop\\Islamabad_collage_1.jpg")));
                            f5.getContentPane().setBackground(Color.lightGray);
                            // frame.getContentPane().setBackground(Color.PINK);
                            f5.setLayout(new FlowLayout());

                            //Adding
                            JLabel packages0=new JLabel("> Pick and Drop services from Airport/Station");
                            packages0.setBounds(40,60,270,20);
                            packages0.setFont(new Font("Serief",Font.BOLD,15));
                            JLabel packages1=new JLabel("> Buffet Breakfast in Restaurant");
                            packages1.setBounds(40,90,210,20);
                            packages1.setFont(new Font("Serief",Font.BOLD,15));

                            JLabel packages2=new JLabel("> Under the age of 12 Years Free with Parents");
                            packages2.setBounds(40,120,270,20);
                            packages2.setFont(new Font("Serief",Font.BOLD,15));

                            JLabel packages3=new JLabel("> 5% Discount on Laundry Service");
                            packages3.setBounds(40,150,210,20);
                            packages3.setFont(new Font("Serief",Font.BOLD,15));

                            JLabel packages4=new JLabel("> 10% Discount on Food Items");
                            packages4.setBounds(40,180,170,20);
                            packages4.setFont(new Font("Serief",Font.BOLD,15));

                            JLabel packages5=new JLabel("> 10% Discount on Room Service");
                            packages5.setBounds(40,210,210,20);
                            packages5.setFont(new Font("Serief",Font.BOLD,18));
//
//                            JLabel packages6=new JLabel("> 5% Discount on  10 days Stay");
//                            packages6.setBounds(40,210,210,20);
//                            packages6.setFont(new Font("Serief",Font.BOLD,15));

                            //Confirm

                            JButton button1 = new JButton("Yes");
                            button1.setBounds(20, 20, 50, 30);

                            JButton button2 = new JButton("No");
                            button2.setBounds(100, 270, 70, 30);
                            button2.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {

                                    f5.setDefaultCloseOperation(EXIT_ON_CLOSE);
                                    //System.exit(0);
                                }
                            });

                            //Addding to the Panel
                            f5.getContentPane().add(packages0);
                            f5.getContentPane().add(packages1);
                            f5.getContentPane().add(packages2);
                            f5.getContentPane().add(packages3);
                            f5.getContentPane().add(packages4);
                            f5.getContentPane().add(packages5);

                            f5.add(button1);
                            f5.add(button2);

                        }
                    });


//Payment Method
                    JLabel payment=new JLabel("Payment Method");
                    payment.setBounds(40,535,130,100);

                    JRadioButton r1 = new JRadioButton("Credit Card");
                    r1.setBounds(170, 570, 100, 20);
                    frame.add(r1);
                    bg = new ButtonGroup();
                    bg.add(r1);
                    JRadioButton r2=new JRadioButton("Pay through Cash");
                    r2.setBounds(270, 570, 140, 20);
                    frame.add(r2);
                    bg = new ButtonGroup();
                    bg.add(r2);

                    r1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JFrame f4=new JFrame("Card Details");
                            String name=JOptionPane.showInputDialog(f4,"Enter Credit_Card num:");


                        }
                    });
//Clear Button

                    JButton button1 = new JButton("Confirm");
                    button1.setBounds(120, 620, 100, 30);
                    button1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JFrame f5=new JFrame("Confirm Message");





                            f5.setSize(500,350);
                            f5.setLocationRelativeTo(null);
                            f5.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
                            f5.setVisible(true);
                            f5.setLayout(new BorderLayout());
                            f5.setBackground(Color.WHITE);
                            f5.setLayout(new FlowLayout());
                            f5.setVisible(true);

                            JLabel l1=new JLabel("Dear Guest \nYour Reservation is Confirmed..");
                            JLabel l2=new JLabel("This is Confirmation message of your Stay");
                            JLabel l3=new JLabel("If you have any queries please don't hesitate to call us directly");
                            JLabel l4=new JLabel("We are looking forward for your visit and hope that you enjoy your visit");
                            JLabel l5=new JLabel("Best Regards: JASMINE HOTEL ISLAMABAD");

                            l1.setFont(new Font("Serief",Font.ITALIC,14));
                            l2.setFont(new Font("Serief",Font.ITALIC,14));
                            l3.setFont(new Font("Serief",Font.ITALIC,14));
                            l4.setFont(new Font("Serief",Font.ITALIC,14));
                            l5.setFont(new Font("Serif", Font.BOLD, 20));

                            f5.add(l1);
                            f5.add(l2);
                            f5.add(l3);
                            f5.add(l4);
                            f5.add(l5);

                        }
                    });

                    JButton button2 = new JButton("Cancel");
                    button2.setBounds(240, 620, 110, 30);
                    button2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.exit(0);
                        }
                    });
                    frame.add(button1);
                    frame.add(button2);
//Frame Setting
                    frame.setLayout(null);
                    frame.setSize(600, 800);
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setResizable(false);
                    //Addding to the Panel
                    frame.getContentPane().add(title);
                    frame.getContentPane().add(reservation);
                    frame.getContentPane().add(f_name);
                    frame.getContentPane().add(name);
                    frame.getContentPane().add(l_name);
                    frame.getContentPane().add(last_name);
                    frame.getContentPane().add(cnic);
                    frame.getContentPane().add(cnic_no);
                    frame.getContentPane().add(email);
                    frame.getContentPane().add(email_text);
                    frame.getContentPane().add(phone_no);
                    frame.getContentPane().add(phone_text);
                    frame.getContentPane().add(residence);
                    frame.getContentPane().add(residence_text);
                    frame.getContentPane().add(state);
                    frame.getContentPane().add(state_text);
                    frame.getContentPane().add(zipcode);
                    frame.getContentPane().add(zipcode_text);

                    //check_iN
                    frame.getContentPane().add(Check_in);
                    frame.getContentPane().add(dates);
                    frame.getContentPane().add(year);
                    frame.getContentPane().add(months);
                    //Check out
                    frame.getContentPane().add(Check_out);
                    frame.getContentPane().add(dates_exit);
                    frame.getContentPane().add(months_exit);
                    frame.getContentPane().add(year_exit);
                    frame.getContentPane().add(payment);
                    frame.getContentPane().add(R_Prefernce);
                    frame.getContentPane().add(r_pref);
                    frame.getContentPane().add(packages);
                    frame.getContentPane().add(optional);

                }});

//4th hotel

            b4 = new JRadioButton("Margala Hotel");
            b4.setBounds(500, 300, 150, 50);

            b4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    JFrame frame=new JFrame("Form");

                    frame.setSize(800, 900);
                    frame.setLocationRelativeTo(null);
                    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    frame.setVisible(true);
                    frame.setLayout(new BorderLayout());
                    frame.setContentPane(new JLabel(new ImageIcon("C:\\Users\\hp\\Desktop\\image1.jpg")));
                    frame.setLayout(new FlowLayout());
                    frame.getContentPane().setBackground(Color.RED);

                    JLabel title = new JLabel("MARGALLA  HOTEL");

                    title.setBounds(150,10,300,50);
                    title.setFont(new Font("Serif", Font.BOLD, 30));
                    title.setForeground(Color.BLACK);
                    frame.add(title);
                    JLabel reservation=new JLabel("Reservation Details");
                    reservation.setBounds(40,20,180,100);
                    // First Name

                    JLabel f_name = new JLabel(" First Name");
                    f_name.setBounds(40, 60, 80, 100);

                    JTextField name = new JTextField();
                    name.setBounds(40, 120, 160, 30);
                    //Last_Name
                    JLabel l_name = new JLabel("Last Name");
                    l_name.setBounds(250, 60, 100, 100);

                    JTextField last_name= new JTextField();
                    last_name.setBounds(250, 120, 160, 30);

                    //CNIC
                    JLabel cnic=new JLabel("CNIC");
                    cnic.setBounds(40,130,280,100);
                    JTextField cnic_no=new JTextField();
                    cnic_no.setBounds(40, 195, 250, 30);
                    //Email

                    JLabel email = new JLabel("Email Address");
                    email.setBounds(40, 205, 100, 100);
                    JTextField email_text = new JTextField();
                    email_text.setBounds(40, 270, 160, 30);

                    //Phone no

                    JLabel phone_no = new JLabel("Phone_no");
                    phone_no.setBounds(250, 205, 100, 100);
                    JTextField phone_text = new JTextField();
                    phone_text.setBounds(250, 270, 160, 30);
                    phone_text.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyPressed(KeyEvent e) {
                            String value = phone_text.getText();
                            int l = value.length();
                            if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
                                phone_text.setEditable(true);
                            } else {
                                phone_text.setEditable(false);
                                JOptionPane.showMessageDialog(null, "Enter only numeric digits(0-9)");
                            }
                        }
                    });


                    //Region of residence

                    JLabel residence=new JLabel("Region of Residence");
                    residence.setBounds(40,285,140,100);
                    JTextField residence_text=new JTextField();
                    residence_text.setBounds(40,350,140,30);
                    //State
                    JLabel state=new JLabel("State");
                    state.setBounds(200,285,100,100);
                    JTextField state_text=new JTextField();
                    state_text.setBounds(200,350,100,30);

                    //Zipcode

                    JLabel zipcode=new JLabel("Zip Code");
                    zipcode.setBounds(310,285,100,100);
                    JTextField zipcode_text=new JTextField();
                    zipcode_text.setBounds(310,350,100,30);

                    //Check in:
                    JLabel Check_in=new JLabel("Check_in_Date:");
                    Check_in.setBounds(40,370,130,100);

                    String date[] = {"1","2","3","4","5","6","7","8","9",
                            "10","11","12","13","14","15","16","17","18","19","20","21",
                            "22","23","24","25","26","27","28","29","30","31"};
                    JComboBox dates = new JComboBox(date);
                    dates.setBounds(170, 400, 40, 30);

                    String mon[]={"Jan","Feb","March","April","May","June","July","Aug","Sep","Oct","Nov","Dec"};
                    JComboBox months=new JComboBox(mon);
                    months.setBounds(220,400,60,30);

                    String Year[]={"2022","2023","2024"};
                    JComboBox year=new JComboBox(Year);
                    year.setBounds(290,400,60,30);

                    //Check_out

                    JLabel Check_out=new JLabel("Check_Out_Date:");
                    Check_out.setBounds(40,410,130,100);

                    String date_exit[] = {"1","2","3","4","5","6","7","8","9",
                            "10","11","12","13","14","15","16","17","18","19","20","21",
                            "22","23","24","25","26","27","28","29","30","31"};
                    JComboBox dates_exit = new JComboBox(date_exit);
                    dates_exit.setBounds(170, 450, 40, 30);

                    String mon_exit[]={"Jan","Feb","March","April","May","June","July","Aug","Sep","Oct","Nov","Dec"};
                    JComboBox months_exit=new JComboBox(mon_exit);
                    months_exit.setBounds(220,450,60,30);

                    String Year_exit[]={"2022","2023","2024"};
                    JComboBox year_exit=new JComboBox(Year_exit);
                    year_exit.setBounds(290,450,60,30);

                    ButtonGroup bg;


                    //Room Preference
                    JLabel R_Prefernce=new JLabel("Room Prefernce");
                    R_Prefernce.setBounds(40,500,100,100);

                    JTextField r_pref=new JTextField();
                    r_pref.setBounds(170,530,150,30);

//Packages
                    JLabel packages=new JLabel("Packages:");
                    packages.setBounds(40,500,70,20);

                    JRadioButton Packages = new JRadioButton("Avail the Packages");
                    Packages.setBounds(160,500,150,20);
                    frame.add(Packages);

                    JLabel optional=new JLabel("(Optional)");
                    optional.setBounds(320,500,70,20);

                    Packages.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {




                            JFrame f5=new JFrame("Available Packages");


                            f5.setSize(350, 350);
                            f5.setLocationRelativeTo(null);
                            f5.setDefaultCloseOperation(EXIT_ON_CLOSE);
                            f5.setVisible(true);
                            //f5.setContentPane(new JLabel(new ImageIcon("C:\\Users\\hp\\Desktop\\Islamabad_collage_1.jpg")));
                            f5.getContentPane().setBackground(Color.lightGray);
                            // frame.getContentPane().setBackground(Color.PINK);
                            f5.setLayout(new FlowLayout());

                            //Adding
                            JLabel packages0=new JLabel("> Pick and Drop services from Airport/Station");
                            packages0.setBounds(40,60,270,20);
                            packages0.setFont(new Font("Serief",Font.BOLD,15));
                            JLabel packages1=new JLabel("> Buffet Breakfast in Restaurant");
                            packages1.setBounds(40,90,210,20);
                            packages1.setFont(new Font("Serief",Font.BOLD,15));

                            JLabel packages2=new JLabel("> Under the age of 12 Years Free with Parents");
                            packages2.setBounds(40,120,270,20);
                            packages2.setFont(new Font("Serief",Font.BOLD,15));

                            JLabel packages3=new JLabel("> 5% Discount on Laundry Service");
                            packages3.setBounds(40,150,210,20);
                            packages3.setFont(new Font("Serief",Font.BOLD,15));

                            JLabel packages4=new JLabel("> 10% Discount on Food Items");
                            packages4.setBounds(40,180,170,20);
                            packages4.setFont(new Font("Serief",Font.BOLD,15));

                            JLabel packages5=new JLabel("> 10% Discount on Room Service");
                            packages5.setBounds(40,210,210,20);
                            packages5.setFont(new Font("Serief",Font.BOLD,18));
//
//                            JLabel packages6=new JLabel("> 5% Discount on  10 days Stay");
//                            packages6.setBounds(40,210,210,20);
//                            packages6.setFont(new Font("Serief",Font.BOLD,15));

                            //Confirm

                            JButton button1 = new JButton("Yes");
                            button1.setBounds(20, 20, 50, 30);

                            JButton button2 = new JButton("No");
                            button2.setBounds(100, 270, 70, 30);
                            button2.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {

                                    f5.setDefaultCloseOperation(EXIT_ON_CLOSE);
                                    //System.exit(0);
                                }
                            });

                            //Addding to the Panel
                            f5.getContentPane().add(packages0);
                            f5.getContentPane().add(packages1);
                            f5.getContentPane().add(packages2);
                            f5.getContentPane().add(packages3);
                            f5.getContentPane().add(packages4);
                            f5.getContentPane().add(packages5);

                            f5.add(button1);
                            f5.add(button2);

                        }
                    });


//Payment Method
                    JLabel payment=new JLabel("Payment Method");
                    payment.setBounds(40,535,130,100);

                    JRadioButton r1 = new JRadioButton("Credit Card");
                    r1.setBounds(170, 570, 100, 20);
                    frame.add(r1);
                    bg = new ButtonGroup();
                    bg.add(r1);
                    JRadioButton r2=new JRadioButton("Pay through Cash");
                    r2.setBounds(270, 570, 140, 20);
                    frame.add(r2);
                    bg = new ButtonGroup();
                    bg.add(r2);

                    r1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JFrame f4=new JFrame("Card Details");
                            String name=JOptionPane.showInputDialog(f4,"Enter Credit_Card num:");


                        }
                    });
//Clear Button

                    JButton button1 = new JButton("Confirm");
                    button1.setBounds(120, 620, 100, 30);
                    button1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JFrame f5=new JFrame("Confirm Message");





                            f5.setSize(500,350);
                            f5.setLocationRelativeTo(null);
                            f5.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
                            f5.setVisible(true);
                            f5.setLayout(new BorderLayout());
                            f5.setBackground(Color.WHITE);
                            f5.setLayout(new FlowLayout());
                            f5.setVisible(true);

                            JLabel l1=new JLabel("Dear Guest \nYour Reservation is Confirmed..");
                            JLabel l2=new JLabel("This is Confirmation message of your Stay");
                            JLabel l3=new JLabel("If you have any queries please don't hesitate to call us directly");
                            JLabel l4=new JLabel("We are looking forward for your visit and hope that you enjoy your visit");
                            JLabel l5=new JLabel("Best Regards: MARGALLA HOTEL ISLAMABAD");

                            l1.setFont(new Font("Serief",Font.ITALIC,14));
                            l2.setFont(new Font("Serief",Font.ITALIC,14));
                            l3.setFont(new Font("Serief",Font.ITALIC,14));
                            l4.setFont(new Font("Serief",Font.ITALIC,14));
                            l5.setFont(new Font("Serif", Font.BOLD, 20));

                            f5.add(l1);
                            f5.add(l2);
                            f5.add(l3);
                            f5.add(l4);
                            f5.add(l5);

                        }
                    });

                    JButton button2 = new JButton("Cancel");
                    button2.setBounds(240, 620, 110, 30);
                    button2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.exit(0);
                        }
                    });
                    frame.add(button1);
                    frame.add(button2);
//Frame Setting
                    frame.setLayout(null);
                    frame.setSize(600, 800);
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setResizable(false);
                    //Addding to the Panel
                    frame.getContentPane().add(title);
                    frame.getContentPane().add(reservation);
                    frame.getContentPane().add(f_name);
                    frame.getContentPane().add(name);
                    frame.getContentPane().add(l_name);
                    frame.getContentPane().add(last_name);
                    frame.getContentPane().add(cnic);
                    frame.getContentPane().add(cnic_no);
                    frame.getContentPane().add(email);
                    frame.getContentPane().add(email_text);
                    frame.getContentPane().add(phone_no);
                    frame.getContentPane().add(phone_text);
                    frame.getContentPane().add(residence);
                    frame.getContentPane().add(residence_text);
                    frame.getContentPane().add(state);
                    frame.getContentPane().add(state_text);
                    frame.getContentPane().add(zipcode);
                    frame.getContentPane().add(zipcode_text);

                    //check_iN
                    frame.getContentPane().add(Check_in);
                    frame.getContentPane().add(dates);
                    frame.getContentPane().add(year);
                    frame.getContentPane().add(months);
                    //Check out
                    frame.getContentPane().add(Check_out);
                    frame.getContentPane().add(dates_exit);
                    frame.getContentPane().add(months_exit);
                    frame.getContentPane().add(year_exit);
                    frame.getContentPane().add(payment);
                    frame.getContentPane().add(R_Prefernce);
                    frame.getContentPane().add(r_pref);
                    frame.getContentPane().add(packages);
                    frame.getContentPane().add(optional);

                }});


//5th hotel
            //DELANO INN
            b5 = new JRadioButton("Delano Inn");
            b5.setBounds(300, 350, 200, 50);

            b5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    JFrame frame=new JFrame("Form");

                    frame.setSize(800, 900);
                    frame.setLocationRelativeTo(null);
                    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    frame.setVisible(true);
                    frame.setLayout(new BorderLayout());
                    frame.setContentPane(new JLabel(new ImageIcon("C:\\Users\\hp\\Desktop\\image1.jpg")));
                    frame.setLayout(new FlowLayout());
                    frame.getContentPane().setBackground(Color.RED);

                    JLabel title = new JLabel("DELANO INN  HOTEL");

                    title.setBounds(150,10,300,50);
                    title.setFont(new Font("Serif", Font.BOLD, 20));
                    title.setForeground(Color.BLACK);
                    frame.add(title);
                    JLabel reservation=new JLabel("Reservation Details");
                    reservation.setBounds(40,20,180,100);
                    // First Name

                    JLabel f_name = new JLabel(" First Name");
                    f_name.setBounds(40, 60, 80, 100);

                    JTextField name = new JTextField();
                    name.setBounds(40, 120, 160, 30);
                    //Last_Name
                    JLabel l_name = new JLabel("Last Name");
                    l_name.setBounds(250, 60, 100, 100);

                    JTextField last_name= new JTextField();
                    last_name.setBounds(250, 120, 160, 30);

                    //CNIC
                    JLabel cnic=new JLabel("CNIC");
                    cnic.setBounds(40,130,280,100);
                    JTextField cnic_no=new JTextField();
                    cnic_no.setBounds(40, 195, 250, 30);
                    //Email

                    JLabel email = new JLabel("Email Address");
                    email.setBounds(40, 205, 100, 100);
                    JTextField email_text = new JTextField();
                    email_text.setBounds(40, 270, 160, 30);

                    //Phone no

                    JLabel phone_no = new JLabel("Phone_no");
                    phone_no.setBounds(250, 205, 100, 100);
                    JTextField phone_text = new JTextField();
                    phone_text.setBounds(250, 270, 160, 30);
                    phone_text.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyPressed(KeyEvent e) {
                            String value = phone_text.getText();
                            int l = value.length();
                            if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
                                phone_text.setEditable(true);
                            } else {
                                phone_text.setEditable(false);
                                JOptionPane.showMessageDialog(null, "Enter only numeric digits(0-9)");
                            }
                        }
                    });


                    //Region of residence

                    JLabel residence=new JLabel("Region of Residence");
                    residence.setBounds(40,285,140,100);
                    JTextField residence_text=new JTextField();
                    residence_text.setBounds(40,350,140,30);
                    //State
                    JLabel state=new JLabel("State");
                    state.setBounds(200,285,100,100);
                    JTextField state_text=new JTextField();
                    state_text.setBounds(200,350,100,30);

                    //Zipcode

                    JLabel zipcode=new JLabel("Zip Code");
                    zipcode.setBounds(310,285,100,100);
                    JTextField zipcode_text=new JTextField();
                    zipcode_text.setBounds(310,350,100,30);

                    //Check in:
                    JLabel Check_in=new JLabel("Check_in_Date:");
                    Check_in.setBounds(40,370,130,100);

                    String date[] = {"1","2","3","4","5","6","7","8","9",
                            "10","11","12","13","14","15","16","17","18","19","20","21",
                            "22","23","24","25","26","27","28","29","30","31"};
                    JComboBox dates = new JComboBox(date);
                    dates.setBounds(170, 400, 40, 30);

                    String mon[]={"Jan","Feb","March","April","May","June","July","Aug","Sep","Oct","Nov","Dec"};
                    JComboBox months=new JComboBox(mon);
                    months.setBounds(220,400,60,30);

                    String Year[]={"2022","2023","2024"};
                    JComboBox year=new JComboBox(Year);
                    year.setBounds(290,400,60,30);

                    //Check_out

                    JLabel Check_out=new JLabel("Check_Out_Date:");
                    Check_out.setBounds(40,410,130,100);

                    String date_exit[] = {"1","2","3","4","5","6","7","8","9",
                            "10","11","12","13","14","15","16","17","18","19","20","21",
                            "22","23","24","25","26","27","28","29","30","31"};
                    JComboBox dates_exit = new JComboBox(date_exit);
                    dates_exit.setBounds(170, 450, 40, 30);

                    String mon_exit[]={"Jan","Feb","March","April","May","June","July","Aug","Sep","Oct","Nov","Dec"};
                    JComboBox months_exit=new JComboBox(mon_exit);
                    months_exit.setBounds(220,450,60,30);

                    String Year_exit[]={"2022","2023","2024"};
                    JComboBox year_exit=new JComboBox(Year_exit);
                    year_exit.setBounds(290,450,60,30);

                    ButtonGroup bg;


                    //Room Preference
                    JLabel R_Prefernce=new JLabel("Room Prefernce");
                    R_Prefernce.setBounds(40,500,100,100);
                    JTextField r_pref=new JTextField();
                    r_pref.setBounds(170,530,150,30);

//Packages
                    JLabel packages=new JLabel("Packages:");
                    packages.setBounds(40,500,70,20);

                    JRadioButton Packages = new JRadioButton("Avail the Packages");
                    Packages.setBounds(160,500,150,20);
                    frame.add(Packages);

                    JLabel optional=new JLabel("(Optional)");
                    optional.setBounds(320,500,70,20);

                    Packages.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {




                            JFrame f5=new JFrame("Available Packages");


                            f5.setSize(350, 350);
                            f5.setLocationRelativeTo(null);
                            f5.setDefaultCloseOperation(EXIT_ON_CLOSE);
                            f5.setVisible(true);
                            //f5.setContentPane(new JLabel(new ImageIcon("C:\\Users\\hp\\Desktop\\Islamabad_collage_1.jpg")));
                            f5.getContentPane().setBackground(Color.lightGray);
                            // frame.getContentPane().setBackground(Color.PINK);
                            f5.setLayout(new FlowLayout());

                            //Adding
                            JLabel packages0=new JLabel("> Pick and Drop services from Airport/Station");
                            packages0.setBounds(40,60,270,20);
                            packages0.setFont(new Font("Serief",Font.BOLD,15));
                            JLabel packages1=new JLabel("> Buffet Breakfast in Restaurant");
                            packages1.setBounds(40,90,210,20);
                            packages1.setFont(new Font("Serief",Font.BOLD,15));

                            JLabel packages2=new JLabel("> Under the age of 12 Years Free with Parents");
                            packages2.setBounds(40,120,270,20);
                            packages2.setFont(new Font("Serief",Font.BOLD,15));

                            JLabel packages3=new JLabel("> 5% Discount on Laundry Service");
                            packages3.setBounds(40,150,210,20);
                            packages3.setFont(new Font("Serief",Font.BOLD,15));

                            JLabel packages4=new JLabel("> 10% Discount on Food Items");
                            packages4.setBounds(40,180,170,20);
                            packages4.setFont(new Font("Serief",Font.BOLD,15));

                            JLabel packages5=new JLabel("> 10% Discount on Room Service");
                            packages5.setBounds(40,210,210,20);
                            packages5.setFont(new Font("Serief",Font.BOLD,18));
//
//                            JLabel packages6=new JLabel("> 5% Discount on  10 days Stay");
//                            packages6.setBounds(40,210,210,20);
//                            packages6.setFont(new Font("Serief",Font.BOLD,15));

                            //Confirm

                            JButton button1 = new JButton("Yes");
                            button1.setBounds(20, 20, 50, 30);

                            JButton button2 = new JButton("No");
                            button2.setBounds(100, 270, 70, 30);
                            button2.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {

                                    f5.setDefaultCloseOperation(EXIT_ON_CLOSE);
                                    //System.exit(0);
                                }
                            });


                            //Addding to the Panel
                            f5.getContentPane().add(packages0);
                            f5.getContentPane().add(packages1);
                            f5.getContentPane().add(packages2);
                            f5.getContentPane().add(packages3);
                            f5.getContentPane().add(packages4);
                            f5.getContentPane().add(packages5);

                            f5.add(button1);
                            f5.add(button2);

                        }
                    });


//Payment Method

                    JLabel payment=new JLabel("Payment Method");
                    payment.setBounds(40,535,130,100);

                    JRadioButton r1 = new JRadioButton("Credit Card");
                    r1.setBounds(170, 570, 100, 20);
                    frame.add(r1);
                    bg = new ButtonGroup();
                    bg.add(r1);
                    JRadioButton r2=new JRadioButton("Pay through Cash");
                    r2.setBounds(270, 570, 140, 20);
                    frame.add(r2);
                    bg = new ButtonGroup();
                    bg.add(r2);

                    r1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JFrame f4=new JFrame("Card Details");
                            String name=JOptionPane.showInputDialog(f4,"Enter Credit_Card num:");


                        }
                    });
//Clear Button

                    JButton button1 = new JButton("Confirm");
                    button1.setBounds(120, 620, 100, 30);
                    button1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JFrame f5=new JFrame("Confirm Message");





                            f5.setSize(500,350);
                            f5.setLocationRelativeTo(null);
                            f5.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
                            f5.setVisible(true);
                            f5.setLayout(new BorderLayout());
                            f5.setBackground(Color.WHITE);
                            f5.setLayout(new FlowLayout());
                            f5.setVisible(true);

                            JLabel l1=new JLabel("Dear Guest \nYour Reservation is Confirmed..");
                            JLabel l2=new JLabel("This is Confirmation message of your Stay");
                            JLabel l3=new JLabel("If you have any queries please don't hesitate to call us directly");
                            JLabel l4=new JLabel("We are looking forward for your visit and hope that you enjoy your visit");
                            JLabel l5=new JLabel("Best Regards: DELANO INN HOTEL ISLAMABAD");

                            l1.setFont(new Font("Serief",Font.ITALIC,14));
                            l2.setFont(new Font("Serief",Font.ITALIC,14));
                            l3.setFont(new Font("Serief",Font.ITALIC,14));
                            l4.setFont(new Font("Serief",Font.ITALIC,14));
                            l5.setFont(new Font("Serif", Font.BOLD, 20));

                            f5.add(l1);
                            f5.add(l2);
                            f5.add(l3);
                            f5.add(l4);
                            f5.add(l5);

                        }
                    });

                    JButton button2 = new JButton("Cancel");
                    button2.setBounds(240, 620, 110, 30);
                    button2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.exit(0);
                        }
                    });
                    frame.add(button1);
                    frame.add(button2);
//Frame Setting
                    frame.setLayout(null);
                    frame.setSize(600, 800);
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setResizable(false);
                    //Addding to the Panel
                    frame.getContentPane().add(title);
                    frame.getContentPane().add(reservation);
                    frame.getContentPane().add(f_name);
                    frame.getContentPane().add(name);
                    frame.getContentPane().add(l_name);
                    frame.getContentPane().add(last_name);
                    frame.getContentPane().add(cnic);
                    frame.getContentPane().add(cnic_no);
                    frame.getContentPane().add(email);
                    frame.getContentPane().add(email_text);
                    frame.getContentPane().add(phone_no);
                    frame.getContentPane().add(phone_text);
                    frame.getContentPane().add(residence);
                    frame.getContentPane().add(residence_text);
                    frame.getContentPane().add(state);
                    frame.getContentPane().add(state_text);
                    frame.getContentPane().add(zipcode);
                    frame.getContentPane().add(zipcode_text);

                    //check_iN
                    frame.getContentPane().add(Check_in);
                    frame.getContentPane().add(dates);
                    frame.getContentPane().add(year);
                    frame.getContentPane().add(months);
                    //Check out
                    frame.getContentPane().add(Check_out);
                    frame.getContentPane().add(dates_exit);
                    frame.getContentPane().add(months_exit);
                    frame.getContentPane().add(year_exit);
                    frame.getContentPane().add(payment);
                    frame.getContentPane().add(R_Prefernce);
                    frame.getContentPane().add(r_pref);
                    frame.getContentPane().add(packages);
                    frame.getContentPane().add(optional);

                }});

//6TH HOTEL
            //SERENE RESIDENCE
            b6 = new JRadioButton("Serene Residence");
            b6.setBounds(500, 350, 150, 50);
            b6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    JFrame frame=new JFrame("Form");

                    frame.setSize(900, 900);
                    frame.setLocationRelativeTo(null);
                    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    frame.setVisible(true);
                    frame.setLayout(new BorderLayout());
                    frame.setContentPane(new JLabel(new ImageIcon("C:\\Users\\hp\\Desktop\\image1.jpg")));
                    frame.setLayout(new FlowLayout());
                    frame.getContentPane().setBackground(Color.RED);

                    Font myfont;
                    JLabel title = new JLabel("SERENE RESIDENCE");

                        title.setBounds(150,10,300,50);
                        title.setFont(new Font("Serif", Font.BOLD, 25));
                        title.setForeground(Color.BLACK);
                        frame.add(title);
                        JLabel reservation=new JLabel("Reservation Details");
                        reservation.setBounds(40,20,180,100);
                        // First Name

                        JLabel f_name = new JLabel(" First Name");
                        f_name.setBounds(40, 60, 80, 100);

                        JTextField name = new JTextField();
                        name.setBounds(40, 120, 160, 30);
                        //Last_Name
                        JLabel l_name = new JLabel("Last Name");
                        l_name.setBounds(250, 60, 100, 100);

                        JTextField last_name= new JTextField();
                        last_name.setBounds(250, 120, 160, 30);

                        //CNIC
                        JLabel cnic=new JLabel("CNIC");
                        cnic.setBounds(40,130,280,100);
                        JTextField cnic_no=new JTextField();
                        cnic_no.setBounds(40, 195, 250, 30);
                        //Email

                        JLabel email = new JLabel("Email Address");
                        email.setBounds(40, 205, 100, 100);
                        JTextField email_text = new JTextField();
                        email_text.setBounds(40, 270, 160, 30);

                        //Phone no

                        JLabel phone_no = new JLabel("Phone_no");
                        phone_no.setBounds(250, 205, 100, 100);
                        JTextField phone_text = new JTextField();
                        phone_text.setBounds(250, 270, 160, 30);
                        phone_text.addKeyListener(new KeyAdapter() {
                            @Override
                            public void keyPressed(KeyEvent e) {
                                String value = phone_text.getText();
                                int l = value.length();
                                if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
                                    phone_text.setEditable(true);
                                } else {
                                    phone_text.setEditable(false);
                                    JOptionPane.showMessageDialog(null, "Enter only numeric digits(0-9)");
                                }
                            }
                        });


                        //Region of residence

                        JLabel residence=new JLabel("Region of Residence");
                        residence.setBounds(40,285,140,100);
                        JTextField residence_text=new JTextField();
                        residence_text.setBounds(40,350,140,30);
                        //State
                        JLabel state=new JLabel("State");
                        state.setBounds(200,285,100,100);
                        JTextField state_text=new JTextField();
                        state_text.setBounds(200,350,100,30);

                        //Zipcode

                        JLabel zipcode=new JLabel("Zip Code");
                        zipcode.setBounds(310,285,100,100);
                        JTextField zipcode_text=new JTextField();
                        zipcode_text.setBounds(310,350,100,30);

                        //Check in:
                        JLabel Check_in=new JLabel("Check_in_Date:");
                        Check_in.setBounds(40,370,130,100);

                        String date[] = {"1","2","3","4","5","6","7","8","9",
                                "10","11","12","13","14","15","16","17","18","19","20","21",
                                "22","23","24","25","26","27","28","29","30","31"};
                        JComboBox dates = new JComboBox(date);
                        dates.setBounds(170, 400, 40, 30);

                        String mon[]={"Jan","Feb","March","April","May","June","July","Aug","Sep","Oct","Nov","Dec"};
                        JComboBox months=new JComboBox(mon);
                        months.setBounds(220,400,60,30);

                        String Year[]={"2022","2023","2024"};
                        JComboBox year=new JComboBox(Year);
                        year.setBounds(290,400,60,30);

                        //Check_out

                        JLabel Check_out=new JLabel("Check_Out_Date:");
                        Check_out.setBounds(40,410,130,100);

                        String date_exit[] = {"1","2","3","4","5","6","7","8","9",
                                "10","11","12","13","14","15","16","17","18","19","20","21",
                                "22","23","24","25","26","27","28","29","30","31"};
                        JComboBox dates_exit = new JComboBox(date_exit);
                        dates_exit.setBounds(170, 450, 40, 30);

                        String mon_exit[]={"Jan","Feb","March","April","May","June","July","Aug","Sep","Oct","Nov","Dec"};
                        JComboBox months_exit=new JComboBox(mon_exit);
                        months_exit.setBounds(220,450,60,30);

                        String Year_exit[]={"2022","2023","2024"};
                        JComboBox year_exit=new JComboBox(Year_exit);
                        year_exit.setBounds(290,450,60,30);

                        ButtonGroup bg;


                        //Room Preference
                        JLabel R_Prefernce=new JLabel("Room Prefernce");
                        R_Prefernce.setBounds(40,500,100,100);
                        JTextField r_pref=new JTextField();
                        r_pref.setBounds(170,530,150,30);

//Packages
                        JLabel packages=new JLabel("Packages:");
                        packages.setBounds(40,500,70,20);

                        JRadioButton Packages = new JRadioButton("Avail the Packages");
                        Packages.setBounds(160,500,150,20);
                        frame.add(Packages);

                        JLabel optional=new JLabel("(Optional)");
                        optional.setBounds(320,500,70,20);

                        Packages.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {


                                JFrame f5=new JFrame("Available Packages");


                                f5.setSize(350, 350);
                                f5.setLocationRelativeTo(null);
                                f5.setDefaultCloseOperation(EXIT_ON_CLOSE);
                                f5.setVisible(true);
                                //f5.setContentPane(new JLabel(new ImageIcon("C:\\Users\\hp\\Desktop\\Islamabad_collage_1.jpg")));
                                f5.getContentPane().setBackground(Color.lightGray);
                                // frame.getContentPane().setBackground(Color.PINK);
                                f5.setLayout(new FlowLayout());

                                //Adding
                                JLabel packages0=new JLabel("> Pick and Drop services from Airport/Station");
                                packages0.setBounds(40,60,270,20);
                                packages0.setFont(new Font("Serief",Font.BOLD,15));
                                JLabel packages1=new JLabel("> Buffet Breakfast in Restaurant");
                                packages1.setBounds(40,90,210,20);
                                packages1.setFont(new Font("Serief",Font.BOLD,15));

                                JLabel packages2=new JLabel("> Under the age of 12 Years Free with Parents");
                                packages2.setBounds(40,120,270,20);
                                packages2.setFont(new Font("Serief",Font.BOLD,15));

                                JLabel packages3=new JLabel("> 5% Discount on Laundry Service");
                                packages3.setBounds(40,150,210,20);
                                packages3.setFont(new Font("Serief",Font.BOLD,15));

                                JLabel packages4=new JLabel("> 10% Discount on Food Items");
                                packages4.setBounds(40,180,170,20);
                                packages4.setFont(new Font("Serief",Font.BOLD,15));

                                JLabel packages5=new JLabel("> 10% Discount on Room Service");
                                packages5.setBounds(40,210,210,20);
                                packages5.setFont(new Font("Serief",Font.BOLD,18));
//
//                            JLabel packages6=new JLabel("> 5% Discount on  10 days Stay");
//                            packages6.setBounds(40,210,210,20);
//                            packages6.setFont(new Font("Serief",Font.BOLD,15));

                                //Confirm

                                JButton button1 = new JButton("Yes");
                                button1.setBounds(20, 20, 50, 30);

                                JButton button2 = new JButton("No");
                                button2.setBounds(100, 270, 70, 30);
                                button2.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        f5.setDefaultCloseOperation(EXIT_ON_CLOSE);
                                        //System.exit(0);
                                    }
                                });


                                //Addding to the Panel
                                f5.getContentPane().add(packages0);
                                f5.getContentPane().add(packages1);
                                f5.getContentPane().add(packages2);
                                f5.getContentPane().add(packages3);
                                f5.getContentPane().add(packages4);
                                f5.getContentPane().add(packages5);

                                f5.add(button1);
                                f5.add(button2);

                            }
                        });


//Payment Method
                        JLabel payment=new JLabel("Payment Method");
                        payment.setBounds(40,535,130,100);

                        JRadioButton r1 = new JRadioButton("Credit Card");
                        r1.setBounds(170, 570, 100, 20);
                        frame.add(r1);
                        bg = new ButtonGroup();
                        bg.add(r1);
                        JRadioButton r2=new JRadioButton("Pay through Cash");
                        r2.setBounds(270, 570, 140, 20);
                        frame.add(r2);
                        bg = new ButtonGroup();
                        bg.add(r2);

                        r1.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JFrame f4=new JFrame("Card Details");
                                String name=JOptionPane.showInputDialog(f4,"Enter Credit_Card num:");


                            }
                        });
//Clear Button

                        JButton button1 = new JButton("Confirm");
                        button1.setBounds(120, 620, 100, 30);
                        button1.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JFrame f5=new JFrame("Confirm Message");





                                f5.setSize(500,350);
                                f5.setLocationRelativeTo(null);
                                f5.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
                                f5.setVisible(true);
                                f5.setLayout(new BorderLayout());
                                f5.setBackground(Color.WHITE);
                                f5.setLayout(new FlowLayout());
                                f5.setVisible(true);

                                JLabel l1=new JLabel("Dear Guest \nYour Reservation is Confirmed..");
                                JLabel l2=new JLabel("This is Confirmation message of your Stay");
                                JLabel l3=new JLabel("If you have any queries please don't hesitate to call us directly");
                                JLabel l4=new JLabel("We are looking forward for your visit and hope that you enjoy your visit");
                                JLabel l5=new JLabel("Best Regards: SERENE RESIDENCE   ISLAMABAD");

                                l1.setFont(new Font("Serief",Font.ITALIC,14));
                                l2.setFont(new Font("Serief",Font.ITALIC,14));
                                l3.setFont(new Font("Serief",Font.ITALIC,14));
                                l4.setFont(new Font("Serief",Font.ITALIC,14));
                                l5.setFont(new Font("Serif", Font.BOLD, 20));

                                f5.add(l1);
                                f5.add(l2);
                                f5.add(l3);
                                f5.add(l4);
                                f5.add(l5);

                            }
                        });

                        JButton button2 = new JButton("Cancel");
                        button2.setBounds(240, 620, 110, 30);
                        button2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                System.exit(0);
                            }
                        });
                        frame.add(button1);
                        frame.add(button2);
//Frame Setting
                        frame.setLayout(null);
                        frame.setSize(600, 800);
                        frame.setVisible(true);
                        frame.setLocationRelativeTo(null);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setResizable(false);
                        //Addding to the Panel
                        frame.getContentPane().add(title);
                        frame.getContentPane().add(reservation);
                        frame.getContentPane().add(f_name);
                        frame.getContentPane().add(name);
                        frame.getContentPane().add(l_name);
                        frame.getContentPane().add(last_name);
                        frame.getContentPane().add(cnic);
                        frame.getContentPane().add(cnic_no);
                        frame.getContentPane().add(email);
                        frame.getContentPane().add(email_text);
                        frame.getContentPane().add(phone_no);
                        frame.getContentPane().add(phone_text);
                        frame.getContentPane().add(residence);
                        frame.getContentPane().add(residence_text);
                        frame.getContentPane().add(state);
                        frame.getContentPane().add(state_text);
                        frame.getContentPane().add(zipcode);
                        frame.getContentPane().add(zipcode_text);

                        //check_iN
                        frame.getContentPane().add(Check_in);
                        frame.getContentPane().add(dates);
                        frame.getContentPane().add(year);
                        frame.getContentPane().add(months);
                        //Check out
                        frame.getContentPane().add(Check_out);
                        frame.getContentPane().add(dates_exit);
                        frame.getContentPane().add(months_exit);
                        frame.getContentPane().add(year_exit);
                        frame.getContentPane().add(payment);
                        frame.getContentPane().add(R_Prefernce);
                        frame.getContentPane().add(r_pref);
                        frame.getContentPane().add(packages);
                        frame.getContentPane().add(optional);

                    }});


            b7 = new JRadioButton("Hotel Crown Plaza");
            b7.setBounds(300, 400, 200, 50);

            b7.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {


                    JFrame frame = new JFrame("Form");

                    frame.setSize(900, 900);
                    frame.setLocationRelativeTo(null);
                    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    frame.setVisible(true);
                    frame.setLayout(new BorderLayout());
                    frame.setContentPane(new JLabel(new ImageIcon("C:\\Users\\hp\\Desktop\\image1.jpg")));
                    frame.setLayout(new FlowLayout());
                    frame.getContentPane().setBackground(Color.RED);

                    Font myfont;
                    JLabel title = new JLabel("HOTEL CROWN PLAZA");


                    title.setBounds(150,10,300,50);
                    title.setFont(new Font("Serif", Font.BOLD, 25));
                    title.setForeground(Color.BLACK);
                    frame.add(title);
                    JLabel reservation=new JLabel("Reservation Details");
                    reservation.setBounds(40,20,180,100);
                    // First Name

                    JLabel f_name = new JLabel(" First Name");
                    f_name.setBounds(40, 60, 80, 100);

                    JTextField name = new JTextField();
                    name.setBounds(40, 120, 160, 30);
                    //Last_Name
                    JLabel l_name = new JLabel("Last Name");
                    l_name.setBounds(250, 60, 100, 100);

                    JTextField last_name= new JTextField();
                    last_name.setBounds(250, 120, 160, 30);

                    //CNIC
                    JLabel cnic=new JLabel("CNIC");
                    cnic.setBounds(40,130,280,100);
                    JTextField cnic_no=new JTextField();
                    cnic_no.setBounds(40, 195, 250, 30);
                    //Email

                    JLabel email = new JLabel("Email Address");
                    email.setBounds(40, 205, 100, 100);
                    JTextField email_text = new JTextField();
                    email_text.setBounds(40, 270, 160, 30);

                    //Phone no

                    JLabel phone_no = new JLabel("Phone_no");
                    phone_no.setBounds(250, 205, 100, 100);
                    JTextField phone_text = new JTextField();
                    phone_text.setBounds(250, 270, 160, 30);
                    phone_text.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyPressed(KeyEvent e) {
                            String value = phone_text.getText();
                            int l = value.length();
                            if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
                                phone_text.setEditable(true);
                            } else {
                                phone_text.setEditable(false);
                                JOptionPane.showMessageDialog(null, "Enter only numeric digits(0-9)");
                            }
                        }
                    });


                    //Region of residence

                    JLabel residence=new JLabel("Region of Residence");
                    residence.setBounds(40,285,140,100);
                    JTextField residence_text=new JTextField();
                    residence_text.setBounds(40,350,140,30);
                    //State
                    JLabel state=new JLabel("State");
                    state.setBounds(200,285,100,100);
                    JTextField state_text=new JTextField();
                    state_text.setBounds(200,350,100,30);

                    //Zipcode

                    JLabel zipcode=new JLabel("Zip Code");
                    zipcode.setBounds(310,285,100,100);
                    JTextField zipcode_text=new JTextField();
                    zipcode_text.setBounds(310,350,100,30);

                    //Check in:
                    JLabel Check_in=new JLabel("Check_in_Date:");
                    Check_in.setBounds(40,370,130,100);

                    String date[] = {"1","2","3","4","5","6","7","8","9",
                            "10","11","12","13","14","15","16","17","18","19","20","21",
                            "22","23","24","25","26","27","28","29","30","31"};
                    JComboBox dates = new JComboBox(date);
                    dates.setBounds(170, 400, 40, 30);

                    String mon[]={"Jan","Feb","March","April","May","June","July","Aug","Sep","Oct","Nov","Dec"};
                    JComboBox months=new JComboBox(mon);
                    months.setBounds(220,400,60,30);

                    String Year[]={"2022","2023","2024"};
                    JComboBox year=new JComboBox(Year);
                    year.setBounds(290,400,60,30);

                    //Check_out

                    JLabel Check_out=new JLabel("Check_Out_Date:");
                    Check_out.setBounds(40,410,130,100);

                    String date_exit[] = {"1","2","3","4","5","6","7","8","9",
                            "10","11","12","13","14","15","16","17","18","19","20","21",
                            "22","23","24","25","26","27","28","29","30","31"};
                    JComboBox dates_exit = new JComboBox(date_exit);
                    dates_exit.setBounds(170, 450, 40, 30);

                    String mon_exit[]={"Jan","Feb","March","April","May","June","July","Aug","Sep","Oct","Nov","Dec"};
                    JComboBox months_exit=new JComboBox(mon_exit);
                    months_exit.setBounds(220,450,60,30);

                    String Year_exit[]={"2022","2023","2024"};
                    JComboBox year_exit=new JComboBox(Year_exit);
                    year_exit.setBounds(290,450,60,30);

                    ButtonGroup bg;


                    //Room Preference
                    JLabel R_Prefernce=new JLabel("Room Prefernce");
                    R_Prefernce.setBounds(40,500,100,100);
                    JTextField r_pref=new JTextField();
                    r_pref.setBounds(170,530,150,30);

                    //Packages
                    JLabel packages=new JLabel("Packages:");
                    packages.setBounds(40,500,70,20);

                    JRadioButton Packages = new JRadioButton("Avail the Packages");
                    Packages.setBounds(160,500,150,20);
                    frame.add(Packages);

                    JLabel optional=new JLabel("(Optional)");
                    optional.setBounds(320,500,70,20);

                    Packages.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {


                            JFrame f5=new JFrame("Available Packages");


                            f5.setSize(350, 350);
                            f5.setLocationRelativeTo(null);
                            f5.setDefaultCloseOperation(EXIT_ON_CLOSE);
                            f5.setVisible(true);
                            //f5.setContentPane(new JLabel(new ImageIcon("C:\\Users\\hp\\Desktop\\Islamabad_collage_1.jpg")));
                            f5.getContentPane().setBackground(Color.lightGray);
                            // frame.getContentPane().setBackground(Color.PINK);
                            f5.setLayout(new FlowLayout());

                            //Adding
                            JLabel packages0=new JLabel("> Pick and Drop services from Airport/Station");
                            packages0.setBounds(40,60,270,20);
                            packages0.setFont(new Font("Serief",Font.BOLD,15));
                            JLabel packages1=new JLabel("> Buffet Breakfast in Restaurant");
                            packages1.setBounds(40,90,210,20);
                            packages1.setFont(new Font("Serief",Font.BOLD,15));

                            JLabel packages2=new JLabel("> Under the age of 12 Years Free with Parents");
                            packages2.setBounds(40,120,270,20);
                            packages2.setFont(new Font("Serief",Font.BOLD,15));

                            JLabel packages3=new JLabel("> 5% Discount on Laundry Service");
                            packages3.setBounds(40,150,210,20);
                            packages3.setFont(new Font("Serief",Font.BOLD,15));

                            JLabel packages4=new JLabel("> 10% Discount on Food Items");
                            packages4.setBounds(40,180,170,20);
                            packages4.setFont(new Font("Serief",Font.BOLD,15));

                            JLabel packages5=new JLabel("> 10% Discount on Room Service");
                            packages5.setBounds(40,210,210,20);
                            packages5.setFont(new Font("Serief",Font.BOLD,18));
//
//                            JLabel packages6=new JLabel("> 5% Discount on  10 days Stay");
//                            packages6.setBounds(40,210,210,20);
//                            packages6.setFont(new Font("Serief",Font.BOLD,15));

                            //Confirm

                            JButton button1 = new JButton("Yes");
                            button1.setBounds(20, 20, 50, 30);

                            JButton button2 = new JButton("No");
                            button2.setBounds(100, 270, 70, 30);
                            button2.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {

                                    f5.setDefaultCloseOperation(EXIT_ON_CLOSE);
                                    //System.exit(0);
                                }
                            });

                            //Addding to the Panel
                            f5.getContentPane().add(packages0);
                            f5.getContentPane().add(packages1);
                            f5.getContentPane().add(packages2);
                            f5.getContentPane().add(packages3);
                            f5.getContentPane().add(packages4);
                            f5.getContentPane().add(packages5);

                            f5.add(button1);
                            f5.add(button2);

                        }
                    });


//Payment Method
                    JLabel payment=new JLabel("Payment Method");
                    payment.setBounds(40,535,130,100);

                    JRadioButton r1 = new JRadioButton("Credit Card");
                    r1.setBounds(170, 570, 100, 20);
                    frame.add(r1);
                    bg = new ButtonGroup();
                    bg.add(r1);
                    JRadioButton r2=new JRadioButton("Pay through Cash");
                    r2.setBounds(270, 570, 140, 20);
                    frame.add(r2);
                    bg = new ButtonGroup();
                    bg.add(r2);

                    r1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JFrame f4=new JFrame("Card Details");
                            String name=JOptionPane.showInputDialog(f4,"Enter Credit_Card num:");


                        }
                    });
//Clear Button

                    JButton button1 = new JButton("Confirm");
                    button1.setBounds(120, 620, 100, 30);
                    button1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JFrame f5=new JFrame("Confirm Message");





                            f5.setSize(500,350);
                            f5.setLocationRelativeTo(null);
                            f5.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
                            f5.setVisible(true);
                            f5.setLayout(new BorderLayout());
                            f5.setBackground(Color.WHITE);
                            f5.setLayout(new FlowLayout());
                            f5.setVisible(true);

                            JLabel l1=new JLabel("Dear Guest \nYour Reservation is Confirmed..");
                            JLabel l2=new JLabel("This is Confirmation message of your Stay");
                            JLabel l3=new JLabel("If you have any queries please don't hesitate to call us directly");
                            JLabel l4=new JLabel("We are looking forward for your visit and hope that you enjoy your visit");
                            JLabel l5=new JLabel("Best Regards:  HOTEL CROWN PLAZA ");

                            l1.setFont(new Font("Serief",Font.ITALIC,14));
                            l2.setFont(new Font("Serief",Font.ITALIC,14));
                            l3.setFont(new Font("Serief",Font.ITALIC,14));
                            l4.setFont(new Font("Serief",Font.ITALIC,14));
                            l5.setFont(new Font("Serif", Font.BOLD, 20));

                            f5.add(l1);
                            f5.add(l2);
                            f5.add(l3);
                            f5.add(l4);
                            f5.add(l5);

                        }
                    });

                    JButton button2 = new JButton("Cancel");
                    button2.setBounds(240, 620, 110, 30);
                    button2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.exit(0);
                        }
                    });
                    frame.add(button1);
                    frame.add(button2);
//Frame Setting
                    frame.setLayout(null);
                    frame.setSize(600, 800);
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setResizable(false);
                    //Addding to the Panel
                    frame.getContentPane().add(title);
                    frame.getContentPane().add(reservation);
                    frame.getContentPane().add(f_name);
                    frame.getContentPane().add(name);
                    frame.getContentPane().add(l_name);
                    frame.getContentPane().add(last_name);
                    frame.getContentPane().add(cnic);
                    frame.getContentPane().add(cnic_no);
                    frame.getContentPane().add(email);
                    frame.getContentPane().add(email_text);
                    frame.getContentPane().add(phone_no);
                    frame.getContentPane().add(phone_text);
                    frame.getContentPane().add(residence);
                    frame.getContentPane().add(residence_text);
                    frame.getContentPane().add(state);
                    frame.getContentPane().add(state_text);
                    frame.getContentPane().add(zipcode);
                    frame.getContentPane().add(zipcode_text);

                    //check_iN
                    frame.getContentPane().add(Check_in);
                    frame.getContentPane().add(dates);
                    frame.getContentPane().add(year);
                    frame.getContentPane().add(months);
                    //Check out
                    frame.getContentPane().add(Check_out);
                    frame.getContentPane().add(dates_exit);
                    frame.getContentPane().add(months_exit);
                    frame.getContentPane().add(year_exit);
                    frame.getContentPane().add(payment);
                    frame.getContentPane().add(R_Prefernce);
                    frame.getContentPane().add(r_pref);
                    frame.getContentPane().add(packages);
                    frame.getContentPane().add(optional);

                }});

//8TH HOTEL HOTEL ONE JINNAH

            b8 = new JRadioButton("Hotel One Jinnah");
            b8.setBounds(500, 400, 150, 50);

            b8.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {



                    JFrame frame=new JFrame("Form");

                    frame.setSize(900, 900);
                    frame.setLocationRelativeTo(null);
                    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    frame.setVisible(true);
                    frame.setLayout(new BorderLayout());
                    frame.setContentPane(new JLabel(new ImageIcon("C:\\Users\\hp\\Desktop\\image1.jpg")));
                    frame.setLayout(new FlowLayout());
                    frame.getContentPane().setBackground(Color.RED);

                    Font myfont;
                    JLabel title = new JLabel("HOTEL ONE JINNAH");

                    title.setBounds(150,10,300,50);
                    title.setFont(new Font("Serif", Font.BOLD, 20));
                    title.setForeground(Color.BLACK);
                    frame.add(title);
                    JLabel reservation=new JLabel("Reservation Details");
                    reservation.setBounds(40,20,180,100);
                    // First Name

                    JLabel f_name = new JLabel(" First Name");
                    f_name.setBounds(40, 60, 80, 100);

                    JTextField name = new JTextField();
                    name.setBounds(40, 120, 160, 30);
                    //Last_Name
                    JLabel l_name = new JLabel("Last Name");
                    l_name.setBounds(250, 60, 100, 100);

                    JTextField last_name= new JTextField();
                    last_name.setBounds(250, 120, 160, 30);

                    //CNIC
                    JLabel cnic=new JLabel("CNIC");
                    cnic.setBounds(40,130,280,100);
                    JTextField cnic_no=new JTextField();
                    cnic_no.setBounds(40, 195, 250, 30);
                    //Email

                    JLabel email = new JLabel("Email Address");
                    email.setBounds(40, 205, 100, 100);
                    JTextField email_text = new JTextField();
                    email_text.setBounds(40, 270, 160, 30);

                    //Phone no

                    JLabel phone_no = new JLabel("Phone_no");
                    phone_no.setBounds(250, 205, 100, 100);
                    JTextField phone_text = new JTextField();
                    phone_text.setBounds(250, 270, 160, 30);
                    phone_text.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyPressed(KeyEvent e) {
                            String value = phone_text.getText();
                            int l = value.length();
                            if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
                                phone_text.setEditable(true);
                            } else {
                                phone_text.setEditable(false);
                                JOptionPane.showMessageDialog(null, "Enter only numeric digits(0-9)");
                            }
                        }
                    });


                    //Region of residence

                    JLabel residence=new JLabel("Region of Residence");
                    residence.setBounds(40,285,140,100);
                    JTextField residence_text=new JTextField();
                    residence_text.setBounds(40,350,140,30);
                    //State
                    JLabel state=new JLabel("State");
                    state.setBounds(200,285,100,100);
                    JTextField state_text=new JTextField();
                    state_text.setBounds(200,350,100,30);

                    //Zipcode

                    JLabel zipcode=new JLabel("Zip Code");
                    zipcode.setBounds(310,285,100,100);
                    JTextField zipcode_text=new JTextField();
                    zipcode_text.setBounds(310,350,100,30);

                    //Check in:
                    JLabel Check_in=new JLabel("Check_in_Date:");
                    Check_in.setBounds(40,370,130,100);

                    String date[] = {"1","2","3","4","5","6","7","8","9",
                            "10","11","12","13","14","15","16","17","18","19","20","21",
                            "22","23","24","25","26","27","28","29","30","31"};
                    JComboBox dates = new JComboBox(date);
                    dates.setBounds(170, 400, 40, 30);

                    String mon[]={"Jan","Feb","March","April","May","June","July","Aug","Sep","Oct","Nov","Dec"};
                    JComboBox months=new JComboBox(mon);
                    months.setBounds(220,400,60,30);

                    String Year[]={"2022","2023","2024"};
                    JComboBox year=new JComboBox(Year);
                    year.setBounds(290,400,60,30);

                    //Check_out

                    JLabel Check_out=new JLabel("Check_Out_Date:");
                    Check_out.setBounds(40,410,130,100);

                    String date_exit[] = {"1","2","3","4","5","6","7","8","9",
                            "10","11","12","13","14","15","16","17","18","19","20","21",
                            "22","23","24","25","26","27","28","29","30","31"};
                    JComboBox dates_exit = new JComboBox(date_exit);
                    dates_exit.setBounds(170, 450, 40, 30);

                    String mon_exit[]={"Jan","Feb","March","April","May","June","July","Aug","Sep","Oct","Nov","Dec"};
                    JComboBox months_exit=new JComboBox(mon_exit);
                    months_exit.setBounds(220,450,60,30);

                    String Year_exit[]={"2022","2023","2024"};
                    JComboBox year_exit=new JComboBox(Year_exit);
                    year_exit.setBounds(290,450,60,30);

                    ButtonGroup bg;


                    //Room Preference
                    JLabel R_Prefernce=new JLabel("Room Prefernce");
                    R_Prefernce.setBounds(40,500,100,100);
                    JTextField r_pref=new JTextField();
                    r_pref.setBounds(170,530,150,30);

//Packages
                    JLabel packages=new JLabel("Packages:");
                    packages.setBounds(40,500,70,20);

                    JRadioButton Packages = new JRadioButton("Avail the Packages");
                    Packages.setBounds(160,500,150,20);
                    frame.add(Packages);

                    JLabel optional=new JLabel("(Optional)");
                    optional.setBounds(320,500,70,20);

                    Packages.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {


                            JFrame f5=new JFrame("Available Packages");


                            f5.setSize(350, 350);
                            f5.setLocationRelativeTo(null);
                            f5.setDefaultCloseOperation(EXIT_ON_CLOSE);
                            f5.setVisible(true);
                            //f5.setContentPane(new JLabel(new ImageIcon("C:\\Users\\hp\\Desktop\\Islamabad_collage_1.jpg")));
                            f5.getContentPane().setBackground(Color.lightGray);
                            // frame.getContentPane().setBackground(Color.PINK);
                            f5.setLayout(new FlowLayout());

                            //Adding
                            JLabel packages0=new JLabel("> Pick and Drop services from Airport/Station");
                            packages0.setBounds(40,60,270,20);
                            packages0.setFont(new Font("Serief",Font.BOLD,15));
                            JLabel packages1=new JLabel("> Buffet Breakfast in Restaurant");
                            packages1.setBounds(40,90,210,20);
                            packages1.setFont(new Font("Serief",Font.BOLD,15));

                            JLabel packages2=new JLabel("> Under the age of 12 Years Free with Parents");
                            packages2.setBounds(40,120,270,20);
                            packages2.setFont(new Font("Serief",Font.BOLD,15));

                            JLabel packages3=new JLabel("> 5% Discount on Laundry Service");
                            packages3.setBounds(40,150,210,20);
                            packages3.setFont(new Font("Serief",Font.BOLD,15));

                            JLabel packages4=new JLabel("> 10% Discount on Food Items");
                            packages4.setBounds(40,180,170,20);
                            packages4.setFont(new Font("Serief",Font.BOLD,15));

                            JLabel packages5=new JLabel("> 10% Discount on Room Service");
                            packages5.setBounds(40,210,210,20);
                            packages5.setFont(new Font("Serief",Font.BOLD,18));
//
//                            JLabel packages6=new JLabel("> 5% Discount on  10 days Stay");
//                            packages6.setBounds(40,210,210,20);
//                            packages6.setFont(new Font("Serief",Font.BOLD,15));

                            //Confirm

                            JButton button1 = new JButton("Yes");
                            button1.setBounds(20, 20, 50, 30);

                            JButton button2 = new JButton("No");
                            button2.setBounds(100, 270, 70, 30);
                            button2.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {

                                    f5.setDefaultCloseOperation(EXIT_ON_CLOSE);
                                    //System.exit(0);
                                }
                            });

                            //Addding to the Panel
                            f5.getContentPane().add(packages0);
                            f5.getContentPane().add(packages1);
                            f5.getContentPane().add(packages2);
                            f5.getContentPane().add(packages3);
                            f5.getContentPane().add(packages4);
                            f5.getContentPane().add(packages5);

                            f5.add(button1);
                            f5.add(button2);

                        }
                    });


//Payment Method
                    JLabel payment=new JLabel("Payment Method");
                    payment.setBounds(40,535,130,100);

                    JRadioButton r1 = new JRadioButton("Credit Card");
                    r1.setBounds(170, 570, 100, 20);
                    frame.add(r1);
                    bg = new ButtonGroup();
                    bg.add(r1);
                    JRadioButton r2=new JRadioButton("Pay through Cash");
                    r2.setBounds(270, 570, 140, 20);
                    frame.add(r2);
                    bg = new ButtonGroup();
                    bg.add(r2);

                    r1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JFrame f4=new JFrame("Card Details");
                            String name=JOptionPane.showInputDialog(f4,"Enter Credit_Card num:");


                        }
                    });
//Clear Button

                    JButton button1 = new JButton("Confirm");
                    button1.setBounds(120, 620, 100, 30);
                    button1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JFrame f5=new JFrame("Confirm Message");

                            f5.setSize(500,350);
                            f5.setLocationRelativeTo(null);
                            f5.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
                            f5.setVisible(true);
                            f5.setLayout(new BorderLayout());
                            f5.setBackground(Color.WHITE);
                            f5.setLayout(new FlowLayout());
                            f5.setVisible(true);

                            JLabel l1=new JLabel("Dear Guest \nYour Reservation is Confirmed..");
                            JLabel l2=new JLabel("This is Confirmation message of your Stay");
                            JLabel l3=new JLabel("If you have any queries please don't hesitate to call us directly");
                            JLabel l4=new JLabel("We are looking forward for your visit and hope that you enjoy your visit");
                            JLabel l5=new JLabel("Best Regards:  HOTEL ONE JINNAH ISLAMABAD");

                            l1.setFont(new Font("Serief",Font.ITALIC,14));
                            l2.setFont(new Font("Serief",Font.ITALIC,14));
                            l3.setFont(new Font("Serief",Font.ITALIC,14));
                            l4.setFont(new Font("Serief",Font.ITALIC,14));
                            l5.setFont(new Font("Serif", Font.BOLD, 20));

                            f5.add(l1);
                            f5.add(l2);
                            f5.add(l3);
                            f5.add(l4);
                            f5.add(l5);

                        }
                    });

                    JButton button2 = new JButton("Cancel");
                    button2.setBounds(240, 620, 110, 30);
                    button2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.exit(0);
                        }
                    });
                    frame.add(button1);
                    frame.add(button2);
//Frame Setting
                    frame.setLayout(null);
                    frame.setSize(600, 800);
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setResizable(false);
                    //Addding to the Panel
                    frame.getContentPane().add(title);
                    frame.getContentPane().add(reservation);
                    frame.getContentPane().add(f_name);
                    frame.getContentPane().add(name);
                    frame.getContentPane().add(l_name);
                    frame.getContentPane().add(last_name);
                    frame.getContentPane().add(cnic);
                    frame.getContentPane().add(cnic_no);
                    frame.getContentPane().add(email);
                    frame.getContentPane().add(email_text);
                    frame.getContentPane().add(phone_no);
                    frame.getContentPane().add(phone_text);
                    frame.getContentPane().add(residence);
                    frame.getContentPane().add(residence_text);
                    frame.getContentPane().add(state);
                    frame.getContentPane().add(state_text);
                    frame.getContentPane().add(zipcode);
                    frame.getContentPane().add(zipcode_text);

                    //check_iN
                    frame.getContentPane().add(Check_in);
                    frame.getContentPane().add(dates);
                    frame.getContentPane().add(year);
                    frame.getContentPane().add(months);
                    //Check out
                    frame.getContentPane().add(Check_out);
                    frame.getContentPane().add(dates_exit);
                    frame.getContentPane().add(months_exit);
                    frame.getContentPane().add(year_exit);
                    frame.getContentPane().add(payment);
                    frame.getContentPane().add(R_Prefernce);
                    frame.getContentPane().add(r_pref);
                    frame.getContentPane().add(packages);
                    frame.getContentPane().add(optional);

                }});

// 9TH HOTEL HOTEL ISLAMABAD
        b9 = new JRadioButton("Hotel Islamabad");
            b9.setBounds(300, 450, 200, 50);

            b9.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {


                    JFrame frame=new JFrame("Form");

                    frame.setSize(900, 900);
                    frame.setLocationRelativeTo(null);
                    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    frame.setVisible(true);
                    frame.setLayout(new BorderLayout());
                    frame.setContentPane(new JLabel(new ImageIcon("C:\\Users\\hp\\Desktop\\image1.jpg")));
                    frame.setLayout(new FlowLayout());
                    frame.getContentPane().setBackground(Color.RED);

                    Font myfont;
                    JLabel title = new JLabel("HOTEL  ISLAMABAD");


                    title.setBounds(150,10,300,50);
                    title.setFont(new Font("Serif", Font.BOLD, 25));
                    title.setForeground(Color.BLACK);
                    frame.add(title);
                    JLabel reservation=new JLabel("Reservation Details");
                    reservation.setBounds(40,20,180,100);
                    // First Name

                    JLabel f_name = new JLabel(" First Name");
                    f_name.setBounds(40, 60, 80, 100);

                    JTextField name = new JTextField();
                    name.setBounds(40, 120, 160, 30);
                    //Last_Name
                    JLabel l_name = new JLabel("Last Name");
                    l_name.setBounds(250, 60, 100, 100);

                    JTextField last_name= new JTextField();
                    last_name.setBounds(250, 120, 160, 30);

                    //CNIC
                    JLabel cnic=new JLabel("CNIC");
                    cnic.setBounds(40,130,280,100);
                    JTextField cnic_no=new JTextField();
                    cnic_no.setBounds(40, 195, 250, 30);
                    //Email

                    JLabel email = new JLabel("Email Address");
                    email.setBounds(40, 205, 100, 100);
                    JTextField email_text = new JTextField();
                    email_text.setBounds(40, 270, 160, 30);

                    //Phone no

                    JLabel phone_no = new JLabel("Phone_no");
                    phone_no.setBounds(250, 205, 100, 100);
                    JTextField phone_text = new JTextField();
                    phone_text.setBounds(250, 270, 160, 30);
                    phone_text.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyPressed(KeyEvent e) {
                            String value = phone_text.getText();
                            int l = value.length();
                            if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
                                phone_text.setEditable(true);
                            } else {
                                phone_text.setEditable(false);
                                JOptionPane.showMessageDialog(null, "Enter only numeric digits(0-9)");
                            }
                        }
                    });


                    //Region of residence

                    JLabel residence=new JLabel("Region of Residence");
                    residence.setBounds(40,285,140,100);
                    JTextField residence_text=new JTextField();
                    residence_text.setBounds(40,350,140,30);
                    //State
                    JLabel state=new JLabel("State");
                    state.setBounds(200,285,100,100);
                    JTextField state_text=new JTextField();
                    state_text.setBounds(200,350,100,30);

                    //Zipcode

                    JLabel zipcode=new JLabel("Zip Code");
                    zipcode.setBounds(310,285,100,100);
                    JTextField zipcode_text=new JTextField();
                    zipcode_text.setBounds(310,350,100,30);

                    //Check in:
                    JLabel Check_in=new JLabel("Check_in_Date:");
                    Check_in.setBounds(40,370,130,100);

                    String date[] = {"1","2","3","4","5","6","7","8","9",
                            "10","11","12","13","14","15","16","17","18","19","20","21",
                            "22","23","24","25","26","27","28","29","30","31"};
                    JComboBox dates = new JComboBox(date);
                    dates.setBounds(170, 400, 40, 30);

                    String mon[]={"Jan","Feb","March","April","May","June","July","Aug","Sep","Oct","Nov","Dec"};
                    JComboBox months=new JComboBox(mon);
                    months.setBounds(220,400,60,30);

                    String Year[]={"2022","2023","2024"};
                    JComboBox year=new JComboBox(Year);
                    year.setBounds(290,400,60,30);

                    //Check_out

                    JLabel Check_out=new JLabel("Check_Out_Date:");
                    Check_out.setBounds(40,410,130,100);

                    String date_exit[] = {"1","2","3","4","5","6","7","8","9",
                            "10","11","12","13","14","15","16","17","18","19","20","21",
                            "22","23","24","25","26","27","28","29","30","31"};
                    JComboBox dates_exit = new JComboBox(date_exit);
                    dates_exit.setBounds(170, 450, 40, 30);

                    String mon_exit[]={"Jan","Feb","March","April","May","June","July","Aug","Sep","Oct","Nov","Dec"};
                    JComboBox months_exit=new JComboBox(mon_exit);
                    months_exit.setBounds(220,450,60,30);

                    String Year_exit[]={"2022","2023","2024"};
                    JComboBox year_exit=new JComboBox(Year_exit);
                    year_exit.setBounds(290,450,60,30);

                    ButtonGroup bg;


                    //Room Preference
                    JLabel R_Prefernce=new JLabel("Room Prefernce");
                    R_Prefernce.setBounds(40,500,100,100);
                    JTextField r_pref=new JTextField();
                    r_pref.setBounds(170,530,150,30);

//Packages
                    JLabel packages=new JLabel("Packages:");
                    packages.setBounds(40,500,70,20);

                    JRadioButton Packages = new JRadioButton("Avail the Packages");
                    Packages.setBounds(160,500,150,20);
                    frame.add(Packages);

                    JLabel optional=new JLabel("(Optional)");
                    optional.setBounds(320,500,70,20);

                    Packages.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {



                            JFrame f5=new JFrame("Available Packages");


                            f5.setSize(350, 350);
                            f5.setLocationRelativeTo(null);
                            f5.setDefaultCloseOperation(EXIT_ON_CLOSE);
                            f5.setVisible(true);
                            //f5.setContentPane(new JLabel(new ImageIcon("C:\\Users\\hp\\Desktop\\Islamabad_collage_1.jpg")));
                            f5.getContentPane().setBackground(Color.lightGray);
                            // frame.getContentPane().setBackground(Color.PINK);
                            f5.setLayout(new FlowLayout());

                            //Adding
                            JLabel packages0=new JLabel("> Pick and Drop services from Airport/Station");
                            packages0.setBounds(40,60,270,20);
                            packages0.setFont(new Font("Serief",Font.BOLD,15));
                            JLabel packages1=new JLabel("> Buffet Breakfast in Restaurant");
                            packages1.setBounds(40,90,210,20);
                            packages1.setFont(new Font("Serief",Font.BOLD,15));

                            JLabel packages2=new JLabel("> Under the age of 12 Years Free with Parents");
                            packages2.setBounds(40,120,270,20);
                            packages2.setFont(new Font("Serief",Font.BOLD,15));

                            JLabel packages3=new JLabel("> 5% Discount on Laundry Service");
                            packages3.setBounds(40,150,210,20);
                            packages3.setFont(new Font("Serief",Font.BOLD,15));

                            JLabel packages4=new JLabel("> 10% Discount on Food Items");
                            packages4.setBounds(40,180,170,20);
                            packages4.setFont(new Font("Serief",Font.BOLD,15));

                            JLabel packages5=new JLabel("> 10% Discount on Room Service");
                            packages5.setBounds(40,210,210,20);
                            packages5.setFont(new Font("Serief",Font.BOLD,18));
//
//                            JLabel packages6=new JLabel("> 5% Discount on  10 days Stay");
//                            packages6.setBounds(40,210,210,20);
//                            packages6.setFont(new Font("Serief",Font.BOLD,15));

                            //Confirm

                            JButton button1 = new JButton("Yes");
                            button1.setBounds(20, 20, 50, 30);

                            JButton button2 = new JButton("No");
                            button2.setBounds(100, 270, 70, 30);
                            button2.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {

                                    f5.setDefaultCloseOperation(EXIT_ON_CLOSE);
                                    //System.exit(0);
                                }
                            });

                            //Addding to the Panel
                            f5.getContentPane().add(packages0);
                            f5.getContentPane().add(packages1);
                            f5.getContentPane().add(packages2);
                            f5.getContentPane().add(packages3);
                            f5.getContentPane().add(packages4);
                            f5.getContentPane().add(packages5);

                            f5.add(button1);
                            f5.add(button2);

                        }
                    });



//Payment Method
                    JLabel payment=new JLabel("Payment Method");
                    payment.setBounds(40,535,130,100);

                    JRadioButton r1 = new JRadioButton("Credit Card");
                    r1.setBounds(170, 570, 100, 20);
                    frame.add(r1);
                    bg = new ButtonGroup();
                    bg.add(r1);
                    JRadioButton r2=new JRadioButton("Pay through Cash");
                    r2.setBounds(270, 570, 140, 20);
                    frame.add(r2);
                    bg = new ButtonGroup();
                    bg.add(r2);

                    r1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JFrame f4=new JFrame("Card Details");
                            String name=JOptionPane.showInputDialog(f4,"Enter Credit_Card num:");


                        }
                    });
//Clear Button

                    JButton button1 = new JButton("Confirm");
                    button1.setBounds(120, 620, 100, 30);
                    button1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JFrame f5=new JFrame("Confirm Message");





                            f5.setSize(500,350);
                            f5.setLocationRelativeTo(null);
                            f5.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
                            f5.setVisible(true);
                            f5.setLayout(new BorderLayout());
                            f5.setBackground(Color.WHITE);
                            f5.setLayout(new FlowLayout());
                            f5.setVisible(true);

                            JLabel l1=new JLabel("Dear Guest \nYour Reservation is Confirmed..");
                            JLabel l2=new JLabel("This is Confirmation message of your Stay");
                            JLabel l3=new JLabel("If you have any queries please don't hesitate to call us directly");
                            JLabel l4=new JLabel("We are looking forward for your visit and hope that you enjoy your visit");
                            JLabel l5=new JLabel("Best Regards: HOTEL ISLAMABAD");

                            l1.setFont(new Font("Serief",Font.ITALIC,14));
                            l2.setFont(new Font("Serief",Font.ITALIC,14));
                            l3.setFont(new Font("Serief",Font.ITALIC,14));
                            l4.setFont(new Font("Serief",Font.ITALIC,14));
                            l5.setFont(new Font("Serif", Font.BOLD, 20));

                            f5.add(l1);
                            f5.add(l2);
                            f5.add(l3);
                            f5.add(l4);
                            f5.add(l5);

                        }
                    });

                    JButton button2 = new JButton("Cancel");
                    button2.setBounds(240, 620, 110, 30);
                    button2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.exit(0);
                        }
                    });
                    frame.add(button1);
                    frame.add(button2);
//Frame Setting
                    frame.setLayout(null);
                    frame.setSize(600, 800);
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setResizable(false);
                    //Addding to the Panel
                    frame.getContentPane().add(title);
                    frame.getContentPane().add(reservation);
                    frame.getContentPane().add(f_name);
                    frame.getContentPane().add(name);
                    frame.getContentPane().add(l_name);
                    frame.getContentPane().add(last_name);
                    frame.getContentPane().add(cnic);
                    frame.getContentPane().add(cnic_no);
                    frame.getContentPane().add(email);
                    frame.getContentPane().add(email_text);
                    frame.getContentPane().add(phone_no);
                    frame.getContentPane().add(phone_text);
                    frame.getContentPane().add(residence);
                    frame.getContentPane().add(residence_text);
                    frame.getContentPane().add(state);
                    frame.getContentPane().add(state_text);
                    frame.getContentPane().add(zipcode);
                    frame.getContentPane().add(zipcode_text);

                    //check_iN
                    frame.getContentPane().add(Check_in);
                    frame.getContentPane().add(dates);
                    frame.getContentPane().add(year);
                    frame.getContentPane().add(months);
                    //Check out
                    frame.getContentPane().add(Check_out);
                    frame.getContentPane().add(dates_exit);
                    frame.getContentPane().add(months_exit);
                    frame.getContentPane().add(year_exit);
                    frame.getContentPane().add(payment);
                    frame.getContentPane().add(R_Prefernce);
                    frame.getContentPane().add(r_pref);
                    frame.getContentPane().add(packages);
                    frame.getContentPane().add(optional);

                }});

            //10TH HOTEL ENVOY CONTENTIAL HOTEL
            b10 = new JRadioButton("Envoy Contential Hotel");
            b10.setBounds(500, 450, 150, 50);
            b10.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    JFrame frame=new JFrame("Form");

                    frame.setSize(900, 900);
                    frame.setLocationRelativeTo(null);
                    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    frame.setVisible(true);
                    frame.setLayout(new BorderLayout());
                    frame.setContentPane(new JLabel(new ImageIcon("C:\\Users\\hp\\Desktop\\image1.jpg")));
                    frame.setLayout(new FlowLayout());
                    frame.getContentPane().setBackground(Color.RED);

                    Font myfont;
                    JLabel title = new JLabel("ENVOY CONTENTIAL HOTEL");


                    title.setBounds(150,10,300,50);
                    title.setFont(new Font("Serif", Font.BOLD, 20));
                    title.setForeground(Color.BLACK);
                    frame.add(title);
                    JLabel reservation=new JLabel("Reservation Details");
                    reservation.setBounds(40,20,180,100);
                    // First Name

                    JLabel f_name = new JLabel(" First Name");
                    f_name.setBounds(40, 60, 80, 100);

                    JTextField name = new JTextField();
                    name.setBounds(40, 120, 160, 30);
                    //Last_Name
                    JLabel l_name = new JLabel("Last Name");
                    l_name.setBounds(250, 60, 100, 100);

                    JTextField last_name= new JTextField();
                    last_name.setBounds(250, 120, 160, 30);

                    //CNIC
                    JLabel cnic=new JLabel("CNIC");
                    cnic.setBounds(40,130,280,100);
                    JTextField cnic_no=new JTextField();
                    cnic_no.setBounds(40, 195, 250, 30);
                    //Email

                    JLabel email = new JLabel("Email Address");
                    email.setBounds(40, 205, 100, 100);
                    JTextField email_text = new JTextField();
                    email_text.setBounds(40, 270, 160, 30);

                    //Phone no

                    JLabel phone_no = new JLabel("Phone_no");
                    phone_no.setBounds(250, 205, 100, 100);
                    JTextField phone_text = new JTextField();
                    phone_text.setBounds(250, 270, 160, 30);
                    phone_text.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyPressed(KeyEvent e) {
                            String value = phone_text.getText();
                            int l = value.length();
                            if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
                                phone_text.setEditable(true);
                            } else {
                                phone_text.setEditable(false);
                                JOptionPane.showMessageDialog(null, "Enter only numeric digits(0-9)");
                            }
                        }
                    });


                    //Region of residence

                    JLabel residence=new JLabel("Region of Residence");
                    residence.setBounds(40,285,140,100);
                    JTextField residence_text=new JTextField();
                    residence_text.setBounds(40,350,140,30);
                    //State
                    JLabel state=new JLabel("State");
                    state.setBounds(200,285,100,100);
                    JTextField state_text=new JTextField();
                    state_text.setBounds(200,350,100,30);

                    //Zipcode

                    JLabel zipcode=new JLabel("Zip Code");
                    zipcode.setBounds(310,285,100,100);
                    JTextField zipcode_text=new JTextField();
                    zipcode_text.setBounds(310,350,100,30);

                    //Check in:
                    JLabel Check_in=new JLabel("Check_in_Date:");
                    Check_in.setBounds(40,370,130,100);

                    String date[] = {"1","2","3","4","5","6","7","8","9",
                            "10","11","12","13","14","15","16","17","18","19","20","21",
                            "22","23","24","25","26","27","28","29","30","31"};
                    JComboBox dates = new JComboBox(date);
                    dates.setBounds(170, 400, 40, 30);

                    String mon[]={"Jan","Feb","March","April","May","June","July","Aug","Sep","Oct","Nov","Dec"};
                    JComboBox months=new JComboBox(mon);
                    months.setBounds(220,400,60,30);

                    String Year[]={"2022","2023","2024"};
                    JComboBox year=new JComboBox(Year);
                    year.setBounds(290,400,60,30);

                    //Check_out

                    JLabel Check_out=new JLabel("Check_Out_Date:");
                    Check_out.setBounds(40,410,130,100);

                    String date_exit[] = {"1","2","3","4","5","6","7","8","9",
                            "10","11","12","13","14","15","16","17","18","19","20","21",
                            "22","23","24","25","26","27","28","29","30","31"};
                    JComboBox dates_exit = new JComboBox(date_exit);
                    dates_exit.setBounds(170, 450, 40, 30);

                    String mon_exit[]={"Jan","Feb","March","April","May","June","July","Aug","Sep","Oct","Nov","Dec"};
                    JComboBox months_exit=new JComboBox(mon_exit);
                    months_exit.setBounds(220,450,60,30);

                    String Year_exit[]={"2022","2023","2024"};
                    JComboBox year_exit=new JComboBox(Year_exit);
                    year_exit.setBounds(290,450,60,30);

                    ButtonGroup bg;


                    //Room Preference
                    JLabel R_Prefernce=new JLabel("Room Prefernce");
                    R_Prefernce.setBounds(40,500,100,100);
                    JTextField r_pref=new JTextField();
                    r_pref.setBounds(170,530,150,30);

//Packages
                    JLabel packages=new JLabel("Packages:");
                    packages.setBounds(40,500,70,20);

                    JRadioButton Packages = new JRadioButton("Avail the Packages");
                    Packages.setBounds(160,500,150,20);
                    frame.add(Packages);

                    JLabel optional=new JLabel("(Optional)");
                    optional.setBounds(320,500,70,20);

                    Packages.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {



                            JFrame f5=new JFrame("Available Packages");


                            f5.setSize(350, 350);
                            f5.setLocationRelativeTo(null);
                            f5.setDefaultCloseOperation(EXIT_ON_CLOSE);
                            f5.setVisible(true);
                            //f5.setContentPane(new JLabel(new ImageIcon("C:\\Users\\hp\\Desktop\\Islamabad_collage_1.jpg")));
                            f5.getContentPane().setBackground(Color.lightGray);
                            // frame.getContentPane().setBackground(Color.PINK);
                            f5.setLayout(new FlowLayout());

                            //Adding
                            JLabel packages0=new JLabel("> Pick and Drop services from Airport/Station");
                            packages0.setBounds(40,60,270,20);
                            packages0.setFont(new Font("Serief",Font.BOLD,15));
                            JLabel packages1=new JLabel("> Buffet Breakfast in Restaurant");
                            packages1.setBounds(40,90,210,20);
                            packages1.setFont(new Font("Serief",Font.BOLD,15));

                            JLabel packages2=new JLabel("> Under the age of 12 Years Free with Parents");
                            packages2.setBounds(40,120,270,20);
                            packages2.setFont(new Font("Serief",Font.BOLD,15));

                            JLabel packages3=new JLabel("> 5% Discount on Laundry Service");
                            packages3.setBounds(40,150,210,20);
                            packages3.setFont(new Font("Serief",Font.BOLD,15));

                            JLabel packages4=new JLabel("> 10% Discount on Food Items");
                            packages4.setBounds(40,180,170,20);
                            packages4.setFont(new Font("Serief",Font.BOLD,15));

                            JLabel packages5=new JLabel("> 10% Discount on Room Service");
                            packages5.setBounds(40,210,210,20);
                            packages5.setFont(new Font("Serief",Font.BOLD,18));
//
//                            JLabel packages6=new JLabel("> 5% Discount on  10 days Stay");
//                            packages6.setBounds(40,210,210,20);
//                            packages6.setFont(new Font("Serief",Font.BOLD,15));

                            //Confirm

                            JButton button1 = new JButton("Yes");
                            button1.setBounds(20, 20, 50, 30);

                            JButton button2 = new JButton("No");
                            button2.setBounds(100, 270, 70, 30);
                            button2.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {

                                    f5.setDefaultCloseOperation(EXIT_ON_CLOSE);
                                    //System.exit(0);
                                }
                            });

                            //Addding to the Panel
                            f5.getContentPane().add(packages0);
                            f5.getContentPane().add(packages1);
                            f5.getContentPane().add(packages2);
                            f5.getContentPane().add(packages3);
                            f5.getContentPane().add(packages4);
                            f5.getContentPane().add(packages5);

                            f5.add(button1);
                            f5.add(button2);

                        }
                    });


//Payment Method
                    JLabel payment=new JLabel("Payment Method");
                    payment.setBounds(40,535,130,100);

                    JRadioButton r1 = new JRadioButton("Credit Card");
                    r1.setBounds(170, 570, 100, 20);
                    frame.add(r1);
                    bg = new ButtonGroup();
                    bg.add(r1);
                    JRadioButton r2=new JRadioButton("Pay through Cash");
                    r2.setBounds(270, 570, 140, 20);
                    frame.add(r2);
                    bg = new ButtonGroup();
                    bg.add(r2);

                    r1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JFrame f4=new JFrame("Card Details");
                            String name=JOptionPane.showInputDialog(f4,"Enter Credit_Card num:");


                        }
                    });
//Clear Button

                    JButton button1 = new JButton("Confirm");
                    button1.setBounds(120, 620, 100, 30);
                    button1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JFrame f5=new JFrame("Confirm Message");





                            f5.setSize(500,350);
                            f5.setLocationRelativeTo(null);
                            f5.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
                            f5.setVisible(true);
                            f5.setLayout(new BorderLayout());
                            f5.setBackground(Color.WHITE);
                            f5.setLayout(new FlowLayout());
                            f5.setVisible(true);

                            JLabel l1=new JLabel("Dear Guest \nYour Reservation is Confirmed..");
                            JLabel l2=new JLabel("This is Confirmation message of your Stay");
                            JLabel l3=new JLabel("If you have any queries please don't hesitate to call us directly");
                            JLabel l4=new JLabel("We are looking forward for your visit and hope that you enjoy your visit");
                            JLabel l5=new JLabel("Best Regards: ENVOY CONTENTIAL HOTEL ISLAMABAD");

                            l1.setFont(new Font("Serief",Font.ITALIC,14));
                            l2.setFont(new Font("Serief",Font.ITALIC,14));
                            l3.setFont(new Font("Serief",Font.ITALIC,14));
                            l4.setFont(new Font("Serief",Font.ITALIC,14));
                            l5.setFont(new Font("Serif", Font.BOLD, 14));

                            f5.add(l1);
                            f5.add(l2);
                            f5.add(l3);
                            f5.add(l4);
                            f5.add(l5);

                        }
                    });

                    JButton button2 = new JButton("Cancel");
                    button2.setBounds(240, 620, 110, 30);
                    button2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.exit(0);
                        }
                    });
                    frame.add(button1);
                    frame.add(button2);
//Frame Setting
                    frame.setLayout(null);
                    frame.setSize(600, 800);
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setResizable(false);
                    //Addding to the Panel
                    frame.getContentPane().add(title);
                    frame.getContentPane().add(reservation);
                    frame.getContentPane().add(f_name);
                    frame.getContentPane().add(name);
                    frame.getContentPane().add(l_name);
                    frame.getContentPane().add(last_name);
                    frame.getContentPane().add(cnic);
                    frame.getContentPane().add(cnic_no);
                    frame.getContentPane().add(email);
                    frame.getContentPane().add(email_text);
                    frame.getContentPane().add(phone_no);
                    frame.getContentPane().add(phone_text);
                    frame.getContentPane().add(residence);
                    frame.getContentPane().add(residence_text);
                    frame.getContentPane().add(state);
                    frame.getContentPane().add(state_text);
                    frame.getContentPane().add(zipcode);
                    frame.getContentPane().add(zipcode_text);

                    //check_iN
                    frame.getContentPane().add(Check_in);
                    frame.getContentPane().add(dates);
                    frame.getContentPane().add(year);
                    frame.getContentPane().add(months);
                    //Check out
                    frame.getContentPane().add(Check_out);
                    frame.getContentPane().add(dates_exit);
                    frame.getContentPane().add(months_exit);
                    frame.getContentPane().add(year_exit);
                    frame.getContentPane().add(payment);
                    frame.getContentPane().add(R_Prefernce);
                    frame.getContentPane().add(r_pref);
                    frame.getContentPane().add(packages);
                    frame.getContentPane().add(optional);

                }});

            //Adding Buttons in Frame1
            frame1.add(b1);
            frame1.add(b2);
            frame1.add(b3);
            frame1.add(b4);
            frame1.add(b5);
            frame1.add(b6);
            frame1.add(b7);
            frame1.add(b8);
            frame1.add(b9);
            frame1.add(b10);
//Adding in One
            ButtonGroup bg = new ButtonGroup();
            bg.add(b1);
            bg.add(b2);
            bg.add(b3);
            bg.add(b4);
            bg.add(b5);
            bg.add(b6);
            bg.add(b7);
            bg.add(b8);
            bg.add(b9);
            bg.add(b10);

            addKeyListener(new KeyAdapter() {

                               public void keyPressed(KeyEvent ex) {
                                   if(ex.getSource()==b1){
                                       JFrame f3=new JFrame("Frame");

                                       f3.setVisible(true);
                                       f3.setSize(200,200);
                                   }
                               }
                           }
            );

            //Frame1 Setting
            frame1.setLayout(new BorderLayout());
            frame1.setSize(850, 900);
            frame1.setVisible(true);
            frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

    }


}
//main ends here

