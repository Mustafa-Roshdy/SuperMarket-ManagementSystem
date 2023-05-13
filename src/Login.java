import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.*;
import java.util.Objects;


class Login extends JFrame implements ActionListener, MouseListener {
    JTextField  input;
    JPasswordField password;
    JButton  login;
    JToggleButton button;
    JLabel top,link,text1,text2;
    JPanel panel;
    Login(){
        Image icon;
        try {
            icon = ImageIO.read(Objects.requireNonNull(getClass().getResource("img/supermarket.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.setIconImage(icon);
        this.setResizable(true);
        this.setLayout(null);
        this.setTitle("SuperMarket");
        this.setVisible(false);
        this.setSize(1300, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Color WM =new Color(217, 56, 74);
        this.getContentPane().setBackground(WM);
        Font newFont = new Font("HANGING_BASELINE", Font.BOLD, 38);
        Font word = new Font("Verdana", Font.BOLD, 15);

        panel=new JPanel(null);
        panel.setBounds(500, 80, 520, 400);
        panel.setBorder(new LineBorder(Color.BLACK,5,true));

        top = new JLabel("Login");
        top.setFont(newFont);
        top.setBounds(205, 10, 380, 100);

        text1 = new JLabel("Email");
        text1.setBounds(70, 110, 170, 26);
        text1.setFont(word);

        input = new JTextField("example@gmail.com", 30);
        input.setBounds(100, 140, 360, 30);

        text2 = new JLabel("Password");
        text2.setBounds(70, 190, 170, 26);
        text2.setFont(word);

        password = new JPasswordField("", 14);
        password.setBounds(100, 220, 285, 30);

        button = new JToggleButton("Show");
        button.setBounds(390, 220, 70, 30);
        button.addActionListener(this);

        login = new JButton("Login");
        login.setBounds(70, 300, 400, 30);
        login.addActionListener(this);

        link = new JLabel("Don't have an account?");
        link.setBounds(165, 345, 370, 26);
        link.setFont(word);
        link.addMouseListener(this);

        panel.add(link);
        panel.add(button);
        panel.add(login);
        panel.add(text1);
        panel.add(text2);
        panel.add(input);
        panel.add(password);
        panel.add(top);
        this.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (button.isSelected()){
            password.setEchoChar((char)0);
            button.setText("Hide");
        }
        else {
            password.setEchoChar('•');
            button.setText("Show");
        }
        if(e.getSource()==this.login){
            String url="jdbc:mysql://localhost:3306/SuperMarketDB";
            String username="root";
            String password="Mm28102000*#";
            Connection connection=null;
            Statement stmt=null;
            ResultSet rs=null;
            String sql=null;
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url,username,password);
            }
            catch (Exception e1){
                System.out.println(e1);
            }
            try {
                if (connection != null) {
                    stmt = connection.createStatement();
                    sql = "select * from Customers where Email='"+this.input.getText()+"' and CPassword='"+this.password.getText()+"'";
                    rs=stmt.executeQuery(sql);
                    if(rs.next()){
                        this.setVisible(false);
                        Store store=new Store();
                        store.t[55].setText(input.getText());
                        store.setVisible(true);
                    }else {
                        JOptionPane.showMessageDialog(null,"Email or Password isn't Correct");
                    }
                }
            }catch (SQLException e2){
                JOptionPane.showMessageDialog(null,"Error");
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==this.link){
            this.setVisible(false);
            SignUp signUp=new SignUp();
            signUp.setVisible(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

class SignUp extends JFrame implements ActionListener,MouseListener {
    JTextField  input,fName,lName;
    JPasswordField password;
    JButton  signup;
    JToggleButton button;
    JLabel top,link,text1,text2,fText,lText;
    JPanel panel;
    SignUp(){
        Image icon;
        try {
            icon = ImageIO.read(Objects.requireNonNull(getClass().getResource("img/supermarket.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.setIconImage(icon);
        this.setResizable(true);
        this.setLayout(null);
        this.setTitle("SuperMarket");
        this.setVisible(false);
        this.setSize(1300, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        Color WM =new Color(217, 56, 74);
        this.getContentPane().setBackground(WM);
        Font newFont = new Font("HANGING_BASELINE", Font.BOLD, 38);
        Font word = new Font("Verdana", Font.BOLD, 15);

        panel=new JPanel(null);
        panel.setBounds(500, 60, 540, 560);
        panel.setBorder(new LineBorder(Color.BLACK,5,true));

        top = new JLabel("Sign up");
        top.setFont(newFont);
        top.setBounds(205, 10, 380, 100);

        fText = new JLabel("First Name");
        fText.setBounds(70, 110, 270, 26);
        fText.setFont(word);

        fName = new JTextField("", 30);
        fName.setBounds(100, 140, 360, 30);

        lText = new JLabel("Last Name");
        lText.setBounds(70, 190, 270, 26);
        lText.setFont(word);

        lName = new JTextField("", 30);
        lName.setBounds(100, 220, 360, 30);

        text1 = new JLabel("Email");
        text1.setBounds(70, 270, 170, 26);
        text1.setFont(word);

        input = new JTextField("example@gmail.com", 30);
        input.setBounds(100, 300, 360, 30);

        text2 = new JLabel("Password");
        text2.setBounds(70, 350, 170, 26);
        text2.setFont(word);

        password = new JPasswordField("password", 14);
        password.setBounds(100, 380, 285, 30);

        button = new JToggleButton("Show");
        button.setBounds(390, 380, 70, 30);
        button.addActionListener(this);

        signup = new JButton("Sign Up");
        signup.setBounds(70, 460, 400, 30);
        signup.addActionListener(this);

        link = new JLabel("Already have an account?");
        link.setBounds(165, 500, 370, 26);
        link.setFont(word);
        link.addMouseListener(this);

        panel.add(fName);
        panel.add(fText);
        panel.add(lName);
        panel.add(lText);
        panel.add(link);
        panel.add(button);
        panel.add(signup);
        panel.add(text1);
        panel.add(text2);
        panel.add(input);
        panel.add(password);
        panel.add(top);
        this.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (button.isSelected()){
            password.setEchoChar((char)0);
            button.setText("Hide");
        }
        else {
            password.setEchoChar('•');
            button.setText("Show");
        }
        if (e.getSource()==this.signup){
            String url="jdbc:mysql://localhost:3306/SuperMarketDB";
            String username="root";
            String password="Mm28102000*#";
            Connection connection=null;
            Statement stmt=null;
            String sql=null;
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                 connection = DriverManager.getConnection(url,username,password);
            }
            catch (Exception e1){
                System.out.println(e1);
            }
            try {
                if (connection != null) {
                    sql="INSERT INTO Customers(Fname,Lname,Email,CPassword) VALUES(?,?,?,?)";
                    PreparedStatement ps=connection.prepareStatement(sql);
                    ps.setString(1,fName.getText());
                    ps.setString(2,lName.getText());
                    ps.setString(3,input.getText());
                    ps.setString(4,this.password.getText());
                    ps.executeUpdate();
                    this.setVisible(false);
                    Login login=new Login();
                    login.setVisible(true);
                }
            }catch (SQLException e2){
                JOptionPane.showMessageDialog(null,"Records can't be inserted");
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==this.link){
            this.setVisible(false);
            Login login=new Login();
            login.setVisible(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

class Store extends JFrame implements ActionListener,MouseListener {
    JButton ok,show;
    JTextField[] in=new JTextField[13];
    JMenu home;
    JMenuBar mb;
    JToggleButton button;
    JLabel top;
    JLabel[] t = new JLabel[60];
    JPanel panel;
    JPanel[] p = new JPanel[20];

    public void Data(){
        String url = "jdbc:mysql://localhost:3306/SuperMarketDB";
        String username = "root";
        String password = "Mm28102000*#";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Products");
            int i=3;
            while (resultSet.next()) {
                if(i<52){
                    t[i].setText(String.valueOf(resultSet.getInt("amount")));
                    i=i+4;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    Store() {
        Image icon;
        try {
            icon = ImageIO.read(Objects.requireNonNull(getClass().getResource("img/supermarket.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.setIconImage(icon);
        this.setResizable(true);
        this.setLayout(null);
        this.setTitle("SuperMarket");
        this.setVisible(false);
        this.setSize(1300, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Color WM =new Color(217, 56, 74);
        this.getContentPane().setBackground(WM);
        Font newFont = new Font(Font.SANS_SERIF, Font.BOLD, 48);
        Font word = new Font("Verdana", Font.BOLD, 15);
        Font sp = new Font("Verdana", Font.BOLD, 10);
        Font des = new Font("Verdana", Font.BOLD, 30);
        Color Dark_green = new Color(0, 133, 0);
        Color Purple = new Color(175, 0, 165);
        Color Dark_Blue = new Color(0, 0, 103);

        top = new JLabel("Super Market");
        top.setFont(newFont);
        top.setBounds(520, 10, 380, 100);

        home = new JMenu("Home");
        home.addMouseListener(this);
        mb = new JMenuBar();

        panel = new JPanel(null);
        panel.setBounds(100, 40, 1320, 700);
        panel.setBorder(new LineBorder(Color.BLACK, 5, true));

        p[0] = new JPanel(null);
        p[0].setBounds(30, 250, 180, 110);
        p[0].setBackground(Color.red);

        t[0] = new JLabel("");
        t[0].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("img/apple.png"))));
        t[0].setBounds(5, 5, 100, 100);

        t[1] = new JLabel("Apples");
        t[1].setBounds(110, 0, 60, 50);
        t[1].setFont(word);

        t[2] = new JLabel("EGP 35");
        t[2].setBounds(117, 25, 100, 50);

        t[3] = new JLabel("0");
        t[3].setBounds(135, 43, 75, 50);

        in[0]=new JTextField("Amount");
        in[0].setBounds(110,80,60,25);

        p[1] = new JPanel(null);
        p[1].setBounds(220, 250, 180, 110);
        p[1].setBackground(Color.red);

        t[4] = new JLabel("");
        t[4].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("img/banana.png"))));
        t[4].setBounds(5, 5, 100, 100);

        t[5] = new JLabel("Banana");
        t[5].setBounds(110, 0, 80, 50);
        t[5].setFont(word);

        t[6] = new JLabel("EGP 15");
        t[6].setBounds(117, 25, 100, 50);

        t[7] = new JLabel("0");
        t[7].setBounds(135, 43, 75, 50);

        in[1]=new JTextField("Amount");
        in[1].setBounds(110,80,60,25);

        p[2] = new JPanel(null);
        p[2].setBounds(30, 370, 180, 110);
        p[2].setBackground(Color.red);

        t[8] = new JLabel("");
        t[8].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("img/orange.png"))));
        t[8].setBounds(5, 5, 100, 100);

        t[9] = new JLabel("Orange");
        t[9].setBounds(110, 0, 80, 50);
        t[9].setFont(word);

        t[10] = new JLabel("EGP 10");
        t[10].setBounds(117, 25, 100, 50);

        t[31] = new JLabel("0");
        t[31].setBounds(135, 43, 75, 50);

        in[2]=new JTextField("Amount");
        in[2].setBounds(110,80,60,25);

        p[3] = new JPanel(null);
        p[3].setBounds(220, 370, 180, 110);
        p[3].setBackground(Color.red);

        t[12] = new JLabel("");
        t[12].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("img/strawberry.png"))));
        t[12].setBounds(5, 5, 100, 100);

        t[13] = new JLabel("Strawberry");
        t[13].setBounds(109, 0, 80, 50);
        t[13].setFont(sp);

        t[14] = new JLabel("EGP 20");
        t[14].setBounds(117, 25, 100, 50);

        t[43] = new JLabel("0");
        t[43].setBounds(135, 43, 75, 50);

        in[3]=new JTextField("Amount");
        in[3].setBounds(110,80,60,25);

        p[4] = new JPanel(null);
        p[4].setBounds(30, 490, 180, 110);
        p[4].setBackground(Color.red);

        t[16] = new JLabel("");
        t[16].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("img/watermelon.png"))));
        t[16].setBounds(5, 5, 100, 100);

        t[17] = new JLabel("Watermelon");
        t[17].setBounds(107, 0, 95, 50);
        t[17].setFont(sp);

        t[18] = new JLabel("EGP 40");
        t[18].setBounds(117, 25, 100, 50);

        t[51] = new JLabel("0");
        t[51].setBounds(135, 43, 75, 50);

        in[4]=new JTextField("Amount");
        in[4].setBounds(110,80,60,25);

        p[5] = new JPanel(null);
        p[5].setBounds(480, 250, 180, 110);
        p[5].setBackground(Dark_green);

        t[20] = new JLabel("");
        t[20].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("img/tomato.png"))));
        t[20].setBounds(5, 5, 100, 100);

        t[21] = new JLabel("Tomato");
        t[21].setBounds(109, 0, 95, 50);
        t[21].setFont(word);

        t[22] = new JLabel("EGP 10");
        t[22].setBounds(117, 25, 100, 50);

        t[47] = new JLabel("0");
        t[47].setBounds(135, 43, 75, 50);

        in[5]=new JTextField("Amount");
        in[5].setBounds(110,80,60,25);

        p[6] = new JPanel(null);
        p[6].setBounds(670, 250, 180, 110);
        p[6].setBackground(Dark_green);

        t[24] = new JLabel("");
        t[24].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("img/carrot.png"))));
        t[24].setBounds(5, 5, 100, 100);

        t[25] = new JLabel("Carrot");
        t[25].setBounds(112, 0, 95, 50);
        t[25].setFont(word);

        t[26] = new JLabel("EGP 10");
        t[26].setBounds(117, 25, 100, 50);

        t[11] = new JLabel("0");
        t[11].setBounds(135, 43, 75, 50);

        in[6]=new JTextField("Amount");
        in[6].setBounds(110,80,60,25);

        p[7] = new JPanel(null);
        p[7].setBounds(480, 370, 180, 110);
        p[7].setBackground(Dark_green);

        t[28] = new JLabel("");
        t[28].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("img/cucumber.png"))));
        t[28].setBounds(5, 5, 100, 100);

        t[29] = new JLabel("Cucumber");
        t[29].setBounds(110, 0, 95, 50);
        t[29].setFont(sp);

        t[30] = new JLabel("EGP 15");
        t[30].setBounds(117, 25, 100, 50);

        t[19] = new JLabel("0");
        t[19].setBounds(135, 43, 75, 50);

        in[7]=new JTextField("Amount");
        in[7].setBounds(110,80,60,25);

        p[8] = new JPanel(null);
        p[8].setBounds(670, 370, 180, 110);
        p[8].setBackground(Dark_green);

        t[32] = new JLabel("");
        t[32].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("img/onion.png"))));
        t[32].setBounds(5, 5, 100, 100);

        t[33] = new JLabel("Onion");
        t[33].setBounds(112, 0, 95, 50);
        t[33].setFont(word);

        t[34] = new JLabel("EGP 15");
        t[34].setBounds(117, 25, 100, 50);

        t[27] = new JLabel("0");
        t[27].setBounds(135, 43, 75, 50);

        in[8]=new JTextField("Amount");
        in[8].setBounds(110,80,60,25);

        p[9] = new JPanel(null);
        p[9].setBounds(480, 490, 180, 110);
        p[9].setBackground(Dark_green);

        t[36] = new JLabel("");
        t[36].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("img/potato.png"))));
        t[36].setBounds(5, 5, 100, 100);

        t[37] = new JLabel("Potato");
        t[37].setBounds(112, 0, 95, 50);
        t[37].setFont(word);

        t[38] = new JLabel("EGP 10");
        t[38].setBounds(117, 25, 100, 50);

        t[35] = new JLabel("0");
        t[35].setBounds(135, 43, 75, 50);

        in[9]=new JTextField("Amount");
        in[9].setBounds(110,80,60,25);

        p[10] = new JPanel(null);
        p[10].setBounds(1110, 250, 180, 110);
        p[10].setBackground(Purple);

        t[40] = new JLabel("");
        t[40].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("img/meat.png"))));
        t[40].setBounds(5, 5, 100, 100);

        t[41] = new JLabel("Meat");
        t[41].setBounds(117, 0, 95, 50);
        t[41].setFont(word);

        t[42] = new JLabel("EGP 240");
        t[42].setBounds(117, 25, 100, 50);

        t[23] = new JLabel("0");
        t[23].setBounds(135, 43, 75, 50);

        in[10]=new JTextField("Amount");
        in[10].setBounds(110,80,60,25);

        p[11] = new JPanel(null);
        p[11].setBounds(920, 250, 180, 110);
        p[11].setBackground(Purple);

        t[44] = new JLabel("");
        t[44].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("img/chicken.png"))));
        t[44].setBounds(5, 5, 100, 100);

        t[45] = new JLabel("Chicken");
        t[45].setBounds(109, 0, 95, 50);
        t[45].setFont(word);

        t[46] = new JLabel("EGP 130");
        t[46].setBounds(117, 25, 100, 50);

        t[15] = new JLabel("0");
        t[15].setBounds(135, 43, 75, 50);

        in[11]=new JTextField("Amount");
        in[11].setBounds(110,80,60,25);

        p[12] = new JPanel(null);
        p[12].setBounds(1110, 370, 180, 110);
        p[12].setBackground(Purple);

        t[48] = new JLabel("");
        t[48].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("img/sausage.png"))));
        t[48].setBounds(5, 5, 100, 100);

        t[49] = new JLabel("Sausage");
        t[49].setBounds(107, 0, 95, 50);
        t[49].setFont(word);

        t[50] = new JLabel("EGP 200");
        t[50].setBounds(117, 25, 100, 50);

        t[39] = new JLabel("0");
        t[39].setBounds(135, 43, 75, 50);

        in[12]=new JTextField("Amount");
        in[12].setBounds(110,80,60,25);

        t[52] = new JLabel("FRUITS");
        t[52].setBounds(150, 160, 500, 100);
        t[52].setFont(des);

        t[53] = new JLabel("VEGETABLES");
        t[53].setBounds(550, 160, 500, 100);
        t[53].setFont(des);

        t[54] = new JLabel("MEATS");
        t[54].setBounds(1050, 160, 500, 100);
        t[54].setFont(des);

        t[55]=new JLabel("22");
        t[55].setBounds(6050, 100, 500, 100);

        Data();

        ok = new JButton("Submit");
        ok.setBounds(640, 630, 380, 50);
        ok.setFont(des);
        ok.setBackground(Dark_Blue);
        ok.setForeground(Color.white);
        ok.addActionListener(this);
        ok.addMouseListener(this);

        show = new JButton("Show Orders");
        show.setBounds(250, 630, 380, 50);
        show.setFont(des);
        show.setBackground(Color.PINK);
        show.setForeground(Color.white);
        show.addActionListener(this);
        show.addMouseListener(this);

        if (Objects.equals(t[3].getText(), "0")){
            t[0].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("img/sold_out.png"))));
        }

        if (Objects.equals(t[7].getText(), "0")){
            t[4].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("img/sold_out.png"))));
        }

        if (Objects.equals(t[31].getText(), "0")){
            t[8].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("img/sold_out.png"))));
        }

        if (Objects.equals(t[43].getText(), "0")){
            t[12].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("img/sold_out.png"))));
        }

        if (Objects.equals(t[51].getText(), "0")){
            t[16].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("img/sold_out.png"))));
        }

        if (Objects.equals(t[47].getText(), "0")){
            t[20].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("img/sold_out.png"))));
        }

        if (Objects.equals(t[11].getText(), "0")){
            t[24].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("img/sold_out.png"))));
        }

        if (Objects.equals(t[19].getText(), "0")){
            t[28].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("img/sold_out.png"))));
        }

        if (Objects.equals(t[27].getText(), "0")){
            t[32].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("img/sold_out.png"))));
        }

        if (Objects.equals(t[35].getText(), "0")){
            t[36].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("img/sold_out.png"))));
        }

        if (Objects.equals(t[23].getText(), "0")){
            t[40].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("img/sold_out.png"))));
        }

        if (Objects.equals(t[15].getText(), "0")){
            t[44].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("img/sold_out.png"))));
        }

        if (Objects.equals(t[39].getText(), "0")){
            t[48].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("img/sold_out.png"))));
        }

        for (int i = 0; i < 4; i++) {
            p[0].add(t[i]);
        }
        for (int i = 4; i < 8; i++) {
            p[1].add(t[i]);
        }
        for (int i = 8; i < 11; i++) {
            p[2].add(t[i]);
        }
        for (int i = 12; i < 15; i++) {
            p[3].add(t[i]);
        }
        for (int i = 16; i < 19; i++) {
            p[4].add(t[i]);
        }
        for (int i = 20; i < 23; i++) {
            p[5].add(t[i]);
        }
        for (int i = 24; i < 27; i++) {
            p[6].add(t[i]);
        }
        for (int i = 28; i < 31; i++) {
            p[7].add(t[i]);
        }
        for (int i = 32; i < 35; i++) {
            p[8].add(t[i]);
        }
        for (int i = 36; i < 39; i++) {
            p[9].add(t[i]);
        }
        for (int i = 40; i < 43; i++) {
            p[10].add(t[i]);
        }
        for (int i = 44; i < 47; i++) {
            p[11].add(t[i]);
        }
        for (int i = 48; i < 51; i++) {
            p[12].add(t[i]);
        }
        p[2].add(t[31]);
        p[3].add(t[43]);
        p[4].add(t[51]);
        p[5].add(t[47]);
        p[6].add(t[11]);
        p[7].add(t[19]);
        p[8].add(t[27]);
        p[9].add(t[35]);
        p[10].add(t[23]);
        p[11].add(t[15]);
        p[12].add(t[39]);
        for (int i=0;i<13;i++){
            p[i].add(in[i]);
        }
        for (int i = 0; i < 13; i++) {
            panel.add(p[i]);
        }
        mb.add(home);
        panel.add(t[52]);
        panel.add(t[53]);
        panel.add(t[54]);
        panel.add(t[55]);
        panel.add(top);
        panel.add(ok);
        panel.add(show);
        this.setJMenuBar(mb);
        this.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String url = "jdbc:mysql://localhost:3306/SuperMarketDB";
        String username = "root";
        String password = "Mm28102000*#";
        Connection connection = null;
        if (e.getSource() == this.ok) {
            try {
                if ((Integer.parseInt(in[0].getText())) <= (Integer.parseInt(t[3].getText()))) {
                    String sql = null;
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        connection = DriverManager.getConnection(url, username, password);
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(null, "Connections failed");
                    }
                    try {
                        if (connection != null) {
                            sql = "INSERT INTO Orders(Email,Pname,Amount,Price) VALUES(?,?,?,?)";

                            PreparedStatement ps = connection.prepareStatement(sql);

                            ps.setString(1, t[55].getText());
                            ps.setString(2, t[1].getText());
                            ps.setString(3, in[0].getText());
                            ps.setString(4, String.valueOf(Integer.parseInt(in[0].getText()) * 35));
                            ps.executeUpdate();
                            String sql1 = "UPDATE Products SET amount=? where Pname=?";
                            PreparedStatement ps1 = connection.prepareStatement(sql1);
                            t[3].setText(String.valueOf((Integer.parseInt(t[3].getText())) - (Integer.parseInt(in[0].getText()))));
                            ps1.setString(1, t[3].getText());
                            ps1.setString(2, t[1].getText());
                            ps1.executeUpdate();
                            System.out.println("Successfully Inserted");
                        }
                    } catch (SQLException e2) {
                        JOptionPane.showMessageDialog(null, "Records can't be inserted");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "your AMOUNT is invalid");
                }
            } catch (NumberFormatException e3) {
                System.out.println("not inserted");
            }
            try {
                if ((Integer.parseInt(in[1].getText())) <= (Integer.parseInt(t[7].getText()))) {
                String sql = null;
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connection = DriverManager.getConnection(url, username, password);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Connection failed");
                }
                try {
                    if (connection != null) {
                        sql = "INSERT INTO Orders(Email,Pname,Amount,Price) VALUES(?,?,?,?)";

                        PreparedStatement ps = connection.prepareStatement(sql);

                        ps.setString(1, t[55].getText());
                        ps.setString(2, t[5].getText());
                        ps.setString(3, in[1].getText());
                        ps.setString(4, String.valueOf(Integer.parseInt(in[1].getText()) * 15));
                        ps.executeUpdate();
                        String sql1 = "UPDATE Products SET amount=? where Pname=?";
                        PreparedStatement ps1 = connection.prepareStatement(sql1);
                        t[7].setText(String.valueOf((Integer.parseInt(t[7].getText())) - (Integer.parseInt(in[1].getText()))));
                        ps1.setString(1, t[7].getText());
                        ps1.setString(2, t[5].getText());
                        ps1.executeUpdate();
                        System.out.println("Successfully Inserted");
                    }
                } catch (SQLException e2) {
                    JOptionPane.showMessageDialog(null, "Records can't be inserted");
                }
            } else {
                JOptionPane.showMessageDialog(null, "your AMOUNT is invalid");
            }}catch (NumberFormatException e3) {
                System.out.println("not inserted");
            }
            try {
            if ((Integer.parseInt(in[2].getText())) <= (Integer.parseInt(t[31].getText()))) {
                String sql = null;
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connection = DriverManager.getConnection(url, username, password);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Connection failed");
                }
                try {
                    if (connection != null) {
                        sql = "INSERT INTO Orders(Email,Pname,Amount,Price) VALUES(?,?,?,?)";

                        PreparedStatement ps = connection.prepareStatement(sql);

                        ps.setString(1, t[55].getText());
                        ps.setString(2, t[9].getText());
                        ps.setString(3, in[2].getText());
                        ps.setString(4, String.valueOf(Integer.parseInt(in[2].getText()) * 10));
                        ps.executeUpdate();
                        String sql1 = "UPDATE Products SET amount=? where Pname=?";
                        PreparedStatement ps1 = connection.prepareStatement(sql1);
                        t[31].setText(String.valueOf((Integer.parseInt(t[31].getText())) - (Integer.parseInt(in[2].getText()))));
                        ps1.setString(1, t[31].getText());
                        ps1.setString(2, t[9].getText());
                        ps1.executeUpdate();
                        System.out.println("Successfully Inserted");
                    }
                } catch (SQLException e2) {
                    JOptionPane.showMessageDialog(null, "Records can't be inserted");
                }
            } else {
                JOptionPane.showMessageDialog(null, "your AMOUNT is invalid");
            }}catch (NumberFormatException e3) {
                System.out.println("not inserted");
            }
            try {
            if ((Integer.parseInt(in[3].getText())) <= (Integer.parseInt(t[43].getText()))) {
                String sql = null;
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connection = DriverManager.getConnection(url, username, password);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Connection failed");
                }
                try {
                    if (connection != null) {
                        sql = "INSERT INTO Orders(Email,Pname,Amount,Price) VALUES(?,?,?,?)";

                        PreparedStatement ps = connection.prepareStatement(sql);

                        ps.setString(1, t[55].getText());
                        ps.setString(2, t[13].getText());
                        ps.setString(3, in[3].getText());
                        ps.setString(4, String.valueOf(Integer.parseInt(in[3].getText()) * 20));
                        ps.executeUpdate();
                        String sql1 = "UPDATE Products SET amount=? where Pname=?";
                        PreparedStatement ps1 = connection.prepareStatement(sql1);
                        t[43].setText(String.valueOf((Integer.parseInt(t[43].getText())) - (Integer.parseInt(in[3].getText()))));
                        ps1.setString(1, t[43].getText());
                        ps1.setString(2, t[13].getText());
                        ps1.executeUpdate();
                        System.out.println("Successfully Inserted");
                    }
                } catch (SQLException e2) {
                    JOptionPane.showMessageDialog(null, "Records can't be inserted");
                }
            } else {
                JOptionPane.showMessageDialog(null, "your AMOUNT is invalid");
            }}catch (NumberFormatException e3) {
                System.out.println("not inserted");
            }
            try {
                if ((Integer.parseInt(in[4].getText())) <= (Integer.parseInt(t[51].getText()))) {
                String sql = null;
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connection = DriverManager.getConnection(url, username, password);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Connection failed");
                }
                try {
                    if (connection != null) {
                        sql = "INSERT INTO Orders(Email,Pname,Amount,Price) VALUES(?,?,?,?)";

                        PreparedStatement ps = connection.prepareStatement(sql);

                        ps.setString(1, t[55].getText());
                        ps.setString(2, t[17].getText());
                        ps.setString(3, in[4].getText());
                        ps.setString(4, String.valueOf(Integer.parseInt(in[4].getText()) * 40));
                        ps.executeUpdate();
                        String sql1 = "UPDATE Products SET amount=? where Pname=?";
                        PreparedStatement ps1 = connection.prepareStatement(sql1);
                        t[51].setText(String.valueOf((Integer.parseInt(t[51].getText())) - (Integer.parseInt(in[4].getText()))));
                        ps1.setString(1, t[51].getText());
                        ps1.setString(2, t[17].getText());
                        ps1.executeUpdate();
                        System.out.println("Successfully Inserted");
                    }
                } catch (SQLException e2) {
                    JOptionPane.showMessageDialog(null, "Records can't be inserted");
                }
            } else {
                JOptionPane.showMessageDialog(null, "your AMOUNT is invalid");
            }}catch (NumberFormatException e3) {
                System.out.println("not inserted");
            }
            try {
            if ((Integer.parseInt(in[5].getText())) <= (Integer.parseInt(t[47].getText()))) {
                String sql = null;
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connection = DriverManager.getConnection(url, username, password);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Connection failed");
                }
                try {
                    if (connection != null) {
                        sql = "INSERT INTO Orders(Email,Pname,Amount,Price) VALUES(?,?,?,?)";

                        PreparedStatement ps = connection.prepareStatement(sql);

                        ps.setString(1, t[55].getText());
                        ps.setString(2, t[21].getText());
                        ps.setString(3, in[5].getText());
                        ps.setString(4, String.valueOf(Integer.parseInt(in[5].getText()) * 10));
                        ps.executeUpdate();
                        String sql1 = "UPDATE Products SET amount=? where Pname=?";
                        PreparedStatement ps1 = connection.prepareStatement(sql1);
                        t[47].setText(String.valueOf((Integer.parseInt(t[47].getText())) - (Integer.parseInt(in[5].getText()))));
                        ps1.setString(1, t[47].getText());
                        ps1.setString(2, t[21].getText());
                        ps1.executeUpdate();
                        System.out.println("Successfully Inserted");
                    }
                } catch (SQLException e2) {
                    JOptionPane.showMessageDialog(null, "Records can't be inserted");
                }
            } else {
                JOptionPane.showMessageDialog(null, "your AMOUNT is invalid");
            }}catch (NumberFormatException e3) {
                System.out.println("not inserted");
            }
            try {
            if ((Integer.parseInt(in[6].getText())) <= (Integer.parseInt(t[11].getText()))) {
                String sql = null;
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connection = DriverManager.getConnection(url, username, password);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Connection failed");
                }
                try {
                    if (connection != null) {
                        sql = "INSERT INTO Orders(Email,Pname,Amount,Price) VALUES(?,?,?,?)";

                        PreparedStatement ps = connection.prepareStatement(sql);

                        ps.setString(1, t[55].getText());
                        ps.setString(2, t[25].getText());
                        ps.setString(3, in[6].getText());
                        ps.setString(4, String.valueOf(Integer.parseInt(in[6].getText()) * 10));
                        ps.executeUpdate();
                        String sql1 = "UPDATE Products SET amount=? where Pname=?";
                        PreparedStatement ps1 = connection.prepareStatement(sql1);
                        t[11].setText(String.valueOf((Integer.parseInt(t[11].getText())) - (Integer.parseInt(in[6].getText()))));
                        ps1.setString(1, t[11].getText());
                        ps1.setString(2, t[25].getText());
                        ps1.executeUpdate();
                        System.out.println("Successfully Inserted");
                    }
                } catch (SQLException e2) {
                    JOptionPane.showMessageDialog(null, "Records can't be inserted");
                }
            } else {
                JOptionPane.showMessageDialog(null, "your AMOUNT is invalid");
            }}catch (NumberFormatException e3) {
                System.out.println("not inserted");
            }
            try {
            if ((Integer.parseInt(in[7].getText())) <= (Integer.parseInt(t[19].getText()))) {
                String sql = null;
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connection = DriverManager.getConnection(url, username, password);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Connection failed");
                }
                try {
                    if (connection != null) {
                        sql = "INSERT INTO Orders(Email,Pname,Amount,Price) VALUES(?,?,?,?)";

                        PreparedStatement ps = connection.prepareStatement(sql);

                        ps.setString(1, t[55].getText());
                        ps.setString(2, t[29].getText());
                        ps.setString(3, in[7].getText());
                        ps.setString(4, String.valueOf(Integer.parseInt(in[7].getText()) * 15));
                        ps.executeUpdate();
                        String sql1 = "UPDATE Products SET amount=? where Pname=?";
                        PreparedStatement ps1 = connection.prepareStatement(sql1);
                        t[19].setText(String.valueOf((Integer.parseInt(t[19].getText())) - (Integer.parseInt(in[7].getText()))));
                        ps1.setString(1, t[19].getText());
                        ps1.setString(2, t[29].getText());
                        ps1.executeUpdate();
                        System.out.println("Successfully Inserted");
                    }
                } catch (SQLException e2) {
                    JOptionPane.showMessageDialog(null, "Records can't be inserted");
                }
            } else {
                JOptionPane.showMessageDialog(null, "your AMOUNT is invalid");
            }}catch (NumberFormatException e3) {
                System.out.println("not inserted");
            }
            try {
            if ((Integer.parseInt(in[8].getText())) <= (Integer.parseInt(t[27].getText()))) {
                String sql = null;
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connection = DriverManager.getConnection(url, username, password);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Connection failed");
                }
                try {
                    if (connection != null) {
                        sql = "INSERT INTO Orders(Email,Pname,Amount,Price) VALUES(?,?,?,?)";

                        PreparedStatement ps = connection.prepareStatement(sql);

                        ps.setString(1, t[55].getText());
                        ps.setString(2, t[33].getText());
                        ps.setString(3, in[8].getText());
                        ps.setString(4, String.valueOf(Integer.parseInt(in[8].getText()) * 15));
                        ps.executeUpdate();
                        String sql1 = "UPDATE Products SET amount=? where Pname=?";
                        PreparedStatement ps1 = connection.prepareStatement(sql1);
                        t[27].setText(String.valueOf((Integer.parseInt(t[27].getText())) - (Integer.parseInt(in[8].getText()))));
                        ps1.setString(1, t[27].getText());
                        ps1.setString(2, t[33].getText());
                        ps1.executeUpdate();
                        System.out.println("Successfully Inserted");
                    }
                } catch (SQLException e2) {
                    JOptionPane.showMessageDialog(null, "Records can't be inserted");
                }
            } else {
                JOptionPane.showMessageDialog(null, "your AMOUNT is invalid");
            }}catch (NumberFormatException e3) {
                System.out.println("not inserted");
            }
            try {
            if ((Integer.parseInt(in[9].getText())) <= (Integer.parseInt(t[35].getText()))) {
                String sql = null;
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connection = DriverManager.getConnection(url, username, password);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Connection failed");
                }
                try {
                    if (connection != null) {
                        sql = "INSERT INTO Orders(Email,Pname,Amount,Price) VALUES(?,?,?,?)";

                        PreparedStatement ps = connection.prepareStatement(sql);

                        ps.setString(1, t[55].getText());
                        ps.setString(2, t[37].getText());
                        ps.setString(3, in[9].getText());
                        ps.setString(4, String.valueOf(Integer.parseInt(in[9].getText()) * 10));
                        ps.executeUpdate();
                        String sql1 = "UPDATE Products SET amount=? where Pname=?";
                        PreparedStatement ps1 = connection.prepareStatement(sql1);
                        t[35].setText(String.valueOf((Integer.parseInt(t[35].getText())) - (Integer.parseInt(in[9].getText()))));
                        ps1.setString(1, t[35].getText());
                        ps1.setString(2, t[37].getText());
                        ps1.executeUpdate();
                        System.out.println("Successfully Inserted");
                    }
                } catch (SQLException e2) {
                    JOptionPane.showMessageDialog(null, "Records can't be inserted");
                }
            } else {
                JOptionPane.showMessageDialog(null, "your AMOUNT is invalid");
            }}catch (NumberFormatException e3) {
                System.out.println("not inserted");
            }
            try {
            if ((Integer.parseInt(in[10].getText())) <= (Integer.parseInt(t[23].getText()))) {
                String sql = null;
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connection = DriverManager.getConnection(url, username, password);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Connection failed");
                }
                try {
                    if (connection != null) {
                        sql = "INSERT INTO Orders(Email,Pname,Amount,Price) VALUES(?,?,?,?)";

                        PreparedStatement ps = connection.prepareStatement(sql);

                        ps.setString(1, t[55].getText());
                        ps.setString(2, t[41].getText());
                        ps.setString(3, in[10].getText());
                        ps.setString(4, String.valueOf(Integer.parseInt(in[10].getText()) * 240));
                        ps.executeUpdate();
                        String sql1 = "UPDATE Products SET amount=? where Pname=?";
                        PreparedStatement ps1 = connection.prepareStatement(sql1);
                        t[23].setText(String.valueOf((Integer.parseInt(t[23].getText())) - (Integer.parseInt(in[10].getText()))));
                        ps1.setString(1, t[23].getText());
                        ps1.setString(2, t[41].getText());
                        ps1.executeUpdate();
                        System.out.println("Successfully Inserted");
                    }
                } catch (SQLException e2) {
                    JOptionPane.showMessageDialog(null, "Records can't be inserted");
                }
            } else {
                JOptionPane.showMessageDialog(null, "your AMOUNT is invalid");
            }}catch (NumberFormatException e3) {
                System.out.println("not inserted");
            }
            try {
            if ((Integer.parseInt(in[11].getText())) <= (Integer.parseInt(t[15].getText()))) {
                String sql = null;
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connection = DriverManager.getConnection(url, username, password);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Connection failed");
                }
                try {
                    if (connection != null) {
                        sql = "INSERT INTO Orders(Email,Pname,Amount,Price) VALUES(?,?,?,?)";

                        PreparedStatement ps = connection.prepareStatement(sql);

                        ps.setString(1, t[55].getText());
                        ps.setString(2, t[45].getText());
                        ps.setString(3, in[11].getText());
                        ps.setString(4, String.valueOf(Integer.parseInt(in[11].getText()) * 130));
                        ps.executeUpdate();
                        String sql1 = "UPDATE Products SET amount=? where Pname=?";
                        PreparedStatement ps1 = connection.prepareStatement(sql1);
                        t[15].setText(String.valueOf((Integer.parseInt(t[15].getText())) - (Integer.parseInt(in[11].getText()))));
                        ps1.setString(1, t[15].getText());
                        ps1.setString(2, t[45].getText());
                        ps1.executeUpdate();
                        System.out.println("Successfully Inserted");
                    }
                } catch (SQLException e2) {
                    JOptionPane.showMessageDialog(null, "Records can't be inserted");
                }
            } else {
                JOptionPane.showMessageDialog(null, "your AMOUNT is invalid");
            }}catch (NumberFormatException e3) {
                System.out.println("not inserted");
            }
            try {
            if ((Integer.parseInt(in[12].getText())) <= (Integer.parseInt(t[39].getText()))) {
                String sql = null;
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connection = DriverManager.getConnection(url, username, password);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Connection failed");
                }
                try {
                    if (connection != null) {
                        sql = "INSERT INTO Orders(Email,Pname,Amount,Price) VALUES(?,?,?,?)";

                        PreparedStatement ps = connection.prepareStatement(sql);

                        ps.setString(1, t[55].getText());
                        ps.setString(2, t[49].getText());
                        ps.setString(3, in[12].getText());
                        ps.setString(4, String.valueOf(Integer.parseInt(in[12].getText()) * 200));
                        ps.executeUpdate();
                        String sql1 = "UPDATE Products SET amount=? where Pname=?";
                        PreparedStatement ps1 = connection.prepareStatement(sql1);
                        t[39].setText(String.valueOf((Integer.parseInt(t[39].getText())) - (Integer.parseInt(in[12].getText()))));
                        ps1.setString(1, t[39].getText());
                        ps1.setString(2, t[49].getText());
                        ps1.executeUpdate();
                        System.out.println("Successfully Inserted");
                    }
                } catch (SQLException e2) {
                    JOptionPane.showMessageDialog(null, "Records can't be inserted");
                }
            } else {
                JOptionPane.showMessageDialog(null, "your AMOUNT is invalid");
            }
        }catch (NumberFormatException e3) {
                System.out.println("not inserted");
            }
        }

        if(e.getSource()==this.show){
            Statement stmt=null;
            ResultSet rs=null;
            String sql=null;
            int total=0;
            FinalList finalList=new FinalList();
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url,username,password);
            }
            catch (Exception e1){
                System.out.println(e1);
            }
            try {

                if (connection != null) {
                    stmt = connection.createStatement();
                    sql = "select * from Orders where Email='"+this.t[55].getText()+"'";
                    rs=stmt.executeQuery(sql);

                    int i=0,j=0;
                    while (rs.next()){
                        if(j>=3){
                            j=0;
                        }
                        finalList.data[i][j]=String.valueOf(rs.getInt("orderID"));
                        j+=1;
                        finalList.data[i][j]=String.valueOf(rs.getString("Pname"));
                        j+=1;
                        finalList.data[i][j]=String.valueOf(rs.getInt("Amount"));
                        j+=1;
                        finalList.data[i][j]=String.valueOf(rs.getInt("Price"));
                        i+=1;
                        total +=rs.getInt("Price");
                    }
                }
            }catch (SQLException e2){
                JOptionPane.showMessageDialog(null,"Error");
            }catch (Exception e3){
                JOptionPane.showMessageDialog(null,"List is FULL!");
            }
            try {
            Statement stmt1=null;
            ResultSet rs1=null;
            String sql1=null;
            if (connection != null) {
                stmt1 = connection.createStatement();
                sql1 = "select * from Customers where Email='"+this.t[55].getText()+"'";
                rs1=stmt1.executeQuery(sql1);

                while (rs1.next()){
                    finalList.name.setText(rs1.getString("Fname"));
                }
            }
        }catch (SQLException e2){
            JOptionPane.showMessageDialog(null,"Error");
        }catch (Exception e3){
            JOptionPane.showMessageDialog(null,e3);
        }

            finalList.num.setText(String.valueOf(total));
            finalList.l.setText(this.t[55].getText());
            finalList.setVisible(true);
            this.setVisible(false);
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==this.home){
            this.setVisible(false);
            Login login=new Login();
            login.setVisible(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

class FinalList extends JFrame implements ActionListener,MouseListener {
    JMenu home,back;
    JMenuBar mb;
    JPanel panel;
    JLabel top,name,total,num,l;
    JTable table;
    JButton del;
    String[] column={"OrderID","Product","Quantity","Price"};
    String[][] data=new String[50][50];  ;
    JScrollPane s;
    Color WM =new Color(217, 56, 74);
    Color New_White=new Color(245, 243, 253);
    Color Dark_Red = new Color(103, 0, 0);
    Color Dark_Blue = new Color(0, 0, 103);
    public void UpdateData(){
        String url = "jdbc:mysql://localhost:3306/SuperMarketDB";
        String username = "root";
        String password = "Mm28102000*#";
        Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,username,password);
        }
        catch (Exception e1){
            System.out.println(e1);
        }
        try {
            Statement stmt=null;
            ResultSet rs=null;
            String sql=null;
            int total=0;
            if (connection != null) {
                stmt = connection.createStatement();
                sql = "select * from Orders where Email='"+this.l.getText()+"'";
                rs=stmt.executeQuery(sql);

                int i=0,j=0;
                while (rs.next()){
                    if(j>=3){
                        j=0;
                    }
                    this.data[i][j]=String.valueOf(rs.getInt("orderID"));
                    j+=1;
                    this.data[i][j]=String.valueOf(rs.getString("Pname"));
                    j+=1;
                    this.data[i][j]=String.valueOf(rs.getInt("Amount"));
                    j+=1;
                    this.data[i][j]=String.valueOf(rs.getInt("Price"));
                    i+=1;
                    total +=rs.getInt("Price");
                }
                this.num.setText(String.valueOf(total));
            }
        }catch (SQLException e2){
            JOptionPane.showMessageDialog(null,"Error");
        }catch (Exception e3){
            JOptionPane.showMessageDialog(null,"List is FULL!");
        }

    }
    FinalList(){
        Image icon;
        try {
            icon = ImageIO.read(Objects.requireNonNull(getClass().getResource("img/supermarket.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.setIconImage(icon);
        this.setResizable(true);
        this.setLayout(null);
        this.setTitle("SuperMarket");
        this.setVisible(false);
        this.setSize(1300, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.getContentPane().setBackground(WM);
        Font des = new Font("Verdana", Font.BOLD, 30);
        home=new JMenu("Home");
        home.addMouseListener(this);
        back=new JMenu("Back");
        back.addMouseListener(this);
        mb=new JMenuBar();

        table=new JTable(data,column);
        table.setBackground(Color.orange);
        table.setGridColor(Color.red);
        table.setSelectionBackground(Color.BLUE);
        s=new JScrollPane(table);
        s.setBounds(30,100,840,400);

        total=new JLabel("Total Price:");
        total.setBounds(30,550,200,30);
        total.setFont(des);

        num=new JLabel("Null");
        num.setBounds(230,550,200,30);
        num.setFont(des);
        num.setForeground(Color.red);

        panel=new JPanel(null);
        panel.setBounds(320, 80, 900, 620);
        panel.setBorder(new LineBorder(Color.BLACK,5,true));
        panel.setBackground(New_White);

        top=new JLabel("Hello:");
        top.setBounds(40,10,100,100);
        top.setFont(des);

        name=new JLabel("Name");
        name.setBounds(150,10,300,100);
        name.setFont(des);
        name.setForeground(Dark_Blue);

        del=new JButton("Delete");
        del.setBounds(700,550,150,50);
        del.setFont(des);
        del.setBackground(Dark_Red);
        del.setForeground(Color.white);
        del.addActionListener(this);
        del.addMouseListener(this);

        l=new JLabel("");
        l.setBounds(6000,40,245,45);


        panel.add(top);
        panel.add(name);
        panel.add(s);
        panel.add(total);
        panel.add(num);
        panel.add(del);
        panel.add(l);
        this.add(panel);
        mb.add(back);
        mb.add(home);
        this.setJMenuBar(mb);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String url = "jdbc:mysql://localhost:3306/SuperMarketDB";
        String username = "root";
        String password = "Mm28102000*#";
        Connection connection = null;
        if (e.getSource() == del) {
            int row=table.getSelectedRow();
            String cell=table.getModel().getValueAt(row,0).toString();
            String sql1="DELETE FROM Orders where orderID = " +cell;
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url,username,password);
            }
            catch (Exception e1){
                System.out.println(e1);
            }
            try {
                if (connection != null){
                PreparedStatement ps=connection.prepareStatement(sql1);
                ps.execute();
                JOptionPane.showMessageDialog(null,"Deleted Successfully!");
                UpdateData();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex);
            }
        }
        }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==this.home){
            Login login=new Login();
            login.setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource()==this.back){
            Store store=new Store();
            store.t[55].setText(this.l.getText());
            store.setVisible(true);
            this.setVisible(false);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

