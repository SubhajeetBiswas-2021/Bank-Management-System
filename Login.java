import java.awt.Image;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{  //extending  class JFrame of swing by inheritance concept

    JButton login,signup,clear; // Declared the buttons globally
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login(){
        setTitle("AUTOMATED TELLER MACHINE");


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg")); 
        Image i2 = i1.getImage().getScaledInstance(100,100 ,Image.SCALE_DEFAULT );    //it is present in awt (Image)
        ImageIcon i3 = new ImageIcon(i2);     //we cannot place a icon directly in a frame we have to put it in JLabel
        JLabel label = new JLabel(i3);
        setLayout(null);                    //we are making the border layout null so that our custom setBounds works
        label.setBounds(70,10,100,100);
        add(label);          //for placing in the frame

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);

        JLabel cardno = new JLabel("Card No");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120,150,150,40);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300,150,230,40);
        cardno.setFont(new Font("Arial",Font.BOLD,14));                        //For increaing the size of input
        add(cardTextField);

        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,220,250,40);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220,230,40);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));           //For increaing the size of input
        add(pinTextField);

        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");           //JButton.clear not already  defined as  globally so locally need not be done
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);  //whole frame selected and then coloured.

        

        setSize(800,480);
        setVisible(true);                 //now frame will open in top left because by default it is the origin
        setLocation(350,200);           //here we changed the location now it will not open from origin

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if(e.getSource() == login){
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"'and pinnumber = '"+pinnumber+"'";
            try{
                ResultSet rs = conn.s.executeQuery(query);        //For DDL command
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }
            }catch(Exception ae){
                System.out.println(ae);
            }
        }else if(e.getSource() == signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login();                   //created class object
    }

   
}