package PackageChill;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chill {
    private JButton LogIn;
    private JPanel panelMain;
    private JButton SignUp;
    private JButton ChooseMovie;
    private JLabel ImageLogo;

    public Chill() {
        LogIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Welcome back, please Log in");
            }
        });
        SignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "You've Signed up, welcome to Chill");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Welcome to Chill");
        frame.setContentPane(new Chill().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        ImageLogo = new JLabel(new ImageIcon("Chill.jpg"));
    }
}
