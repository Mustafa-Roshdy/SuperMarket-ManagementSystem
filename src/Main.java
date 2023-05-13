import javax.swing.*;
public class Main {
    public static void main(String[] args) {

        Login login =new Login();
        login.setResizable(true);
        login.setExtendedState(JFrame.MAXIMIZED_BOTH);
        login.setVisible(true);
        login.setLayout(null);
        login.setTitle("SuperMarket");
        login.setVisible(true);

        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
