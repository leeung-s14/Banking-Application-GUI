package com.application;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class loginpage{
    JPanel page_login = new JPanel();
    boolean isAuthorized = false;
    boolean toregister = false;
    String preaccountname;
    int prePIN;

    void addintopage_setfont_settextcolor(JLabel object){
        object.setFont(new Font("Open Sans",Font.PLAIN,16));
        object.setForeground(new Color(98, 0, 238));
        page_login.add(object);
    }

    void addintopage_setfont(JTextField object){
        object.setFont(new Font("Open Sans",Font.PLAIN,16));
        object.setForeground(new Color(98, 0, 238));
        Border whiteBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(98,0,238));
        object.setBorder(whiteBorder);
        object.setBackground(new Color(255,255,255));
        page_login.add(object);
    }

    void addintopage_setfont(JPasswordField object){
        object.setFont(new Font("Open Sans",Font.PLAIN,16));
        object.setForeground(new Color(98, 0, 238));
        Border whiteBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(98,0,238));
        object.setBorder(whiteBorder);
        object.setBackground(new Color(255,255,255));
        page_login.add(object);
    }

    loginpage(){
        page_login.setLayout(null);
        page_login.setBackground(new Color(255,255,255));
        page_login.setBounds(0,0,400,700);

        JLabel LoginLabel = new JLabel("Login");
        LoginLabel.setBounds(150,50,80,40);
        addintopage_setfont_settextcolor(LoginLabel);
        LoginLabel.setFont(new Font("Open Sans", Font.BOLD,30));


        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(60,180,80,25);
        addintopage_setfont_settextcolor(usernameLabel);


        JTextField usernameText = new JTextField(20);
        usernameText.setBounds(60,220,250,35);
        addintopage_setfont(usernameText);

        JLabel PINLabel = new JLabel("PIN");
        PINLabel.setBounds(60,270,80,25);
        addintopage_setfont_settextcolor(PINLabel);


        JPasswordField PINText = new JPasswordField(4);
        PINText.setBounds(60,300,250,35);
        addintopage_setfont(PINText);


        JButton button_login = new JButton("Login");
        button_login.setBounds(60,370,250,40);
        button_login.setBackground(new Color(98, 0, 238));
        button_login.setForeground(Color.white);
        page_login.add(button_login);
        button_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                askinfo preloginacc = new askinfo(usernameText.getText(),Integer.parseInt(PINText.getText()));
                preaccountname = preloginacc.Name_value;
                prePIN = preloginacc.PIN_value;
                preloginacc.authorization();
            }
        });

        JButton button_toregister = new JButton("Register");
        button_toregister.setBounds(35,420,100,40);
        button_toregister.setBackground(Color.white);
        button_toregister.setForeground(new Color(98,0,238));
        Border whiteBorder = BorderFactory.createMatteBorder(0, 0, 5, 0, Color.WHITE);
        button_toregister.setBorder(whiteBorder);
        page_login.add(button_toregister);

        button_toregister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                toregister = true;
            }
        });






    }

    class askinfo {
        String Name_value;
        int PIN_value;
        askinfo(String Name_value , int PIN_value) {
            this.Name_value = Name_value;
            this.PIN_value = PIN_value;
        }

        public void authorization() {
            login();
        }


        private void login(){
            boolean authorize = false;
            String[] account_list = {"George","Mikey","Leeung"};
            int[] pin_list = {1234,4321,17079};
            for (int i=0;i<account_list.length;i++)
            {
                if(Name_value.equals(account_list[i])&&PIN_value == pin_list[i])
                {
                    authorize = true;
                }
            }

            if (authorize)
            {
                JOptionPane.showMessageDialog(null,"Successful Login");
                isAuthorized = true;
                System.out.println(isAuthorized);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Login Unsuccessful");
                new loginpage();
            }
        }
        }
    }

class registerpage {
    JPanel page_register = new JPanel();
    boolean register_complete = false;
    String registeraccountname;
    int registerPINname;

    void addintopage_setfont_settextcolor(JLabel object){
        object.setFont(new Font("Open Sans",Font.PLAIN,16));
        object.setForeground(new Color(98,0,238));
        page_register.add(object);
    }

    void addintopage_setfont(JTextField object){
        object.setFont(new Font("Open Sans",Font.PLAIN,16));
        object.setForeground(new Color(98,0,238));
        Border whiteBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(98,0,238));
        object.setBorder(whiteBorder);
        object.setBackground(Color.WHITE);
        page_register.add(object);
    }

    void addintopage_setfont(JPasswordField object){
        object.setFont(new Font("Open Sans",Font.PLAIN,16));
        object.setForeground(new Color(98,0,238));
        Border whiteBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(98,0,238));
        object.setBorder(whiteBorder);
        object.setBackground(Color.WHITE);
        page_register.add(object);
    }

    registerpage() {
        page_register.setLayout(null);
        page_register.setBackground(new Color(255,255,255));

        JLabel Register = new JLabel("Register");
        Register.setBounds(135,50,200,40);
        addintopage_setfont_settextcolor(Register);
        Register.setFont(new Font("Open Sans",Font.BOLD,26));


        JLabel FirstName = new JLabel("First Name");
        FirstName.setBounds(20,140,100,25);
        addintopage_setfont_settextcolor(FirstName);


        JTextField FirstNameText = new JTextField(20);
        FirstNameText.setBounds(20,180,150,35);
        addintopage_setfont(FirstNameText);

        JLabel LastName = new JLabel("Last Name");
        LastName.setBounds(210,140,100,25);
        addintopage_setfont_settextcolor(LastName);


        JTextField LastNameText = new JTextField(20);
        LastNameText.setBounds(210,180,150,35);
        addintopage_setfont(LastNameText);

        JLabel Email = new JLabel("Email");
        Email.setBounds(20,230,80,25);
        addintopage_setfont_settextcolor(Email);


        JTextField EmailInput = new JTextField(20);
        EmailInput.setBounds(20,270,350,35);
        addintopage_setfont(EmailInput);

        JLabel Password = new JLabel("PIN");
        Password.setBounds(20,330,70,25);
        addintopage_setfont_settextcolor(Password);


        JPasswordField PasswordInput = new JPasswordField(4);
        PasswordInput.setBounds(20,370,350,35);
        addintopage_setfont(PasswordInput);


        JButton button_register = new JButton("Register Now");
        button_register.setBounds(20,450,350,40);
        button_register.setBackground(new Color(98,0,238));
        button_register.setForeground(Color.white);

        page_register.add(button_register);
        button_register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                register_complete = true;
                registeraccountname = FirstNameText.getText();
                registerPINname = Integer.parseInt(PasswordInput.getText());
            }
        });

    }


}

class account{

    String customer_name;
    int customer_pin;
    account (String name, int pin)
    {
        customer_name = name;
        customer_pin = pin;
        new homepage();
        System.out.println("I am here");
    }
    JPanel heading = new JPanel();
    JPanel title = new JPanel();
    JPanel homepage = new JPanel();
    JPanel deposit = new JPanel();
    JPanel withdraw = new JPanel();
    JPanel transaction = new JPanel();
    JPanel statistic = new JPanel();

    public String getName(){ return customer_name; };
    public int getPIN() { return customer_pin;}

     double balance;

    boolean athomepage = true;
    boolean atdepositpage= false;
    boolean atwithdrawpage= false;
    boolean attransactionpage= false;
    boolean atstatisticpage= false;


    class homepage{

        void addintopage_setfont_settextcolor(JLabel object){
            object.setFont(new Font("Open Sans",Font.BOLD,16));
            object.setForeground(Color.white);
            homepage.add(object);
        }

        void addintopage_setfont_settextcolor_smalltext(JLabel object){
            object.setFont(new Font("Open Sans",Font.BOLD,10));
            object.setForeground(Color.white);
            homepage.add(object);
        }

        ImageIcon resize_addintopage(ImageIcon object){
            Image image = object.getImage(); // transform it
            Image newimg = image.getScaledInstance(35, 40,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            object = new ImageIcon(newimg);
            return object;
        }

        void setborder_color_add(JButton object){
            object.setBackground(new Color(55,0,179));
            Border whiteBorder = BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(55,0,179));
            object.setBorder(whiteBorder);
            homepage.add(object);

        }

        homepage() {

            athomepage = true;
            homepage.add(heading);
            homepage.setLayout(null);
            homepage.setBackground(new Color(55,0,179));
            homepage.setBounds(0,60,400,200);
            heading.setLayout(null);
            heading.setBounds(0,0,400,40);
            heading.setBackground(new Color(255,255,255));


            JLabel companyname = new JLabel("BANKC");
            companyname.setBounds(135,-10,400,50);
            companyname.setFont(new Font("Montserrat",Font.BOLD,30));
            companyname.setForeground(new Color(98, 0, 238));
            heading.add(companyname);

            JLabel welcomecustomer = new JLabel("Good Morning");
            welcomecustomer.setBounds(20,65,160,40);
            addintopage_setfont_settextcolor(welcomecustomer);

            JLabel name = new JLabel(customer_name);
            name.setBounds(20,90,160,40);
            addintopage_setfont_settextcolor(name);

            JLabel accountbalance = new JLabel("Account Balance");
            accountbalance.setBounds(130, 210,160,40);
            addintopage_setfont_settextcolor(accountbalance);



            ImageIcon deposit = new ImageIcon("C:\\Users\\Leeun\\Downloads\\deposit.PNG");
            JButton todeposit = new JButton(resize_addintopage(deposit));
            todeposit.setBounds(0,510,80,40);
            setborder_color_add(todeposit);
            todeposit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    new depositpage();
                    athomepage = false;
                    atdepositpage= true;
                }
            });

            JLabel deposittext = new JLabel("Deposit");
            deposittext.setBounds(20,560,80,20);
            addintopage_setfont_settextcolor_smalltext(deposittext);



            ImageIcon withdraw = new ImageIcon("C:\\Users\\Leeun\\Downloads\\deposit.PNG");
            JButton towithdraw = new JButton(resize_addintopage(withdraw));
            towithdraw.setBounds(100,510,80,40);
            setborder_color_add(towithdraw);
            towithdraw.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    athomepage = false;
                    atwithdrawpage= true;
                    new withdrawpage();
                }
            });

            JLabel withdrawtext = new JLabel("Withdraw");
            withdrawtext.setBounds(117,560,80,20);
            addintopage_setfont_settextcolor_smalltext(withdrawtext);




            ImageIcon transaction = new ImageIcon("C:\\Users\\Leeun\\Downloads\\deposit.PNG");
            JButton tohistory = new JButton(resize_addintopage(transaction));
            tohistory.setBounds(200,510,80,40);
            setborder_color_add(tohistory);
            tohistory.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    athomepage = false;
                    attransactionpage= true;
                    new transactionpage();
                }
            });

            JLabel transactiontext = new JLabel("Transaction");
            transactiontext.setBounds(213,560,80,20);
            addintopage_setfont_settextcolor_smalltext(transactiontext);



            ImageIcon statistics = new ImageIcon("C:\\Users\\Leeun\\Downloads\\deposit.PNG");
            JButton tostatistic = new JButton(resize_addintopage(statistics));
            tostatistic.setBounds(300,510,80,40);
            setborder_color_add(tostatistic);
            tostatistic.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    athomepage = false;
                    atstatisticpage= true;
                    new statisticpage();
                }
            });

            JLabel statistictext = new JLabel("Statistics");
            statistictext.setBounds(317,560,80,20);
            addintopage_setfont_settextcolor_smalltext(statistictext);
        }
    }

    class depositpage{
        void addintopage_setfont_settextcolor(JLabel object) {
            object.setFont(new Font("Open Sans", Font.BOLD, 16));
            object.setForeground(Color.white);
            title.add(object);
        }
        ImageIcon resize_addintopage(ImageIcon object){
            Image image = object.getImage(); // transform it
            Image newimg = image.getScaledInstance(20, 20,  Image.SCALE_SMOOTH); // scale it the smooth way
            object = new ImageIcon(newimg);
            return object;
        }

        void addintopage_setfont_settextcolor_smalltext(JLabel object){
            object.setFont(new Font("Open Sans",Font.BOLD,12));
            object.setForeground(Color.BLACK);
            deposit.add(object);
        }

        void setborder_color_add(JButton object){
            object.setBackground(new Color(55,0,179));
            object.setForeground(Color.white);
            Border whiteBorder = BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(55,0,179));
            object.setBorder(whiteBorder);
            title.add(object);
            }

        void addintopage_setfont(JTextField object){
            object.setFont(new Font("Open Sans",Font.PLAIN,16));
            object.setForeground(Color.black);
            Border whiteBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black);
            object.setBorder(whiteBorder);
            object.setBackground(Color.WHITE);
            deposit.add(object);
        }

        depositpage(){
            atdepositpage = true;
            deposit.setLayout(null);
            deposit.setBounds(0,60,400,200);

            title.setLayout(null);
            title.setBounds(0,0,400,100);
            title.setBackground(new Color(55,0,179));

            ImageIcon backarrow = new ImageIcon("C:\\Users\\Leeun\\Downloads\\back arrow.PNG");
            JButton backbutton = new JButton(resize_addintopage(backarrow));
            backbutton.setBounds(20,30,25,25);
            setborder_color_add(backbutton);

            JLabel intro = new JLabel("Deposit");
            intro.setBounds(150,20,100,40);
            addintopage_setfont_settextcolor(intro);

            JLabel Enteramount = new JLabel("Enter Amount (USD)");
            Enteramount.setBounds(20,200,120,20);
            addintopage_setfont_settextcolor_smalltext(Enteramount);

            JTextField enteramount = new JTextField();
            enteramount.setBounds(20,250,200,20);
            addintopage_setfont(enteramount);

            JButton confirm = new JButton("Confirm");
            confirm.setBounds(20,350,350,40);
            setborder_color_add(confirm);
            deposit.add(confirm);

            confirm.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    double entervalue = Double.parseDouble(enteramount.getText());
                    balance += entervalue;
                    atdepositpage = false;
                    athomepage= true;

                }
            });

        }
    }

    class withdrawpage{
        withdrawpage(){
            atwithdrawpage = true;
            withdraw.setLayout(null);
            withdraw.setBackground(new Color(55,0,179));
            withdraw.setBounds(0,60,400,200);
            title.setLayout(null);
            title.setBounds(0,0,400,40);
            title.setBackground(new Color(255,255,255));
        }
    }
    class transactionpage{
        transactionpage(){
            attransactionpage = true;
            transaction.setLayout(null);
            transaction.setBackground(new Color(55,0,179));
            transaction.setBounds(0,60,400,200);
            title.setLayout(null);
            title.setBounds(0,0,400,40);
            title.setBackground(new Color(255,255,255));
        }
    }
    class statisticpage{
        statisticpage(){
            statistic.setLayout(null);
            statistic.setBackground(new Color(55,0,179));
            statistic.setBounds(0,60,400, 200);
            title.setLayout(null);
            title.setBounds(0,0,400,40);
            title.setBackground(new Color(255,255,255));
        }
    }
}

