//Filename: LoginWindow.java 
//Author: Ajanth Suthan 
//Date Created: May 10, 2023 
//Purpose: This programs creates a username box, password box, clear button, and a login button.
//When the correct password is entered, it will open the CreativeGUI. 

//Import Commands
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//LoginWindow class creates a username box, password box, clear button, and a login button.
//When the correct password is entered, it will open the CreativeGUI. 

public class LoginWindow extends JFrame implements ActionListener {
   //Declaring components (Jlabels, JTextfields, JPasswordField, JButton) of the JFrame
   private JLabel lblPasswordMsg;
   private JLabel lblUsernameMsg;
   private JTextField tfUsername;
   private JPasswordField jpfPassword;
   private JButton btnLogin, btnClear;
   private JLabel answer;
   private JLabel mack;
   
   //Constructor to setup GUI components and event handlers 
   public LoginWindow() {
      //Initializing components of JFrame
      lblUsernameMsg = new JLabel("Username");
      tfUsername = new JTextField("", 17); //Username box
      lblPasswordMsg = new JLabel("Password");
      jpfPassword = new JPasswordField(); //Password box
      answer = new JLabel("");
      btnLogin = new JButton("Login");
      btnClear = new JButton("Clear");
      ImageIcon img = new ImageIcon("unnamed.png");
      mack = new JLabel("", img, JLabel.CENTER);
      
      //Sets coordinates of buttons and dimensions (x coordinate, y coordinate, width, height)
      lblUsernameMsg.setBounds(100, 100, 90, 20); 
      tfUsername.setBounds(200, 100, 90, 20);
      lblPasswordMsg.setBounds(100, 150, 90, 20); 
      jpfPassword.setBounds(200, 150, 90, 20); 
      btnClear.setBounds(100, 200, 90, 20); 
      btnClear.addActionListener(this); //Makes the clear button responsive
      btnLogin.setBounds(200, 200, 90, 20); 
      btnLogin.addActionListener(this); //Makes the login button responsive
      answer.setBounds(90, 250, 1000, 40);
      mack.setBounds(0, 0, 400, 100);
      
      //adding components to JFrame container 
      add(tfUsername);
      add(lblPasswordMsg);
      add(jpfPassword);
      add(answer);
      add(btnLogin);
      add(btnClear);
      add(lblUsernameMsg);
      add(mack);
      
      //setting JFrame's title, window size and making it visible
      setTitle("Login"); //"super" JFrame sets its title
      setLayout(null); //sets layout to null meaning you determine where things are placed
      setSize(400, 400); //"super" JFrame sets its initial window size 
      setVisible(true); //"super" JFrame shows   
   }
    
   //actionPerformed (ActionEvent e) implements ActionListener which sets up what the clear button and login button 
   public void actionPerformed(ActionEvent e) {
      String password = "MichealChu"; //Sets the password to MichealChu
      if (e.getSource() == btnLogin) {
         if (new String (jpfPassword.getPassword()).equals(password)) {//creates what happens when the correct password is entered
            answer.setText("Password Accepted");
            dispose();
            Menu app = new Menu();
         } else { //creates what happens when the incorrect password is entered
            answer.setText("Incorrect Password. Please try again.");
         }
      }
      else if (e.getSource() == btnClear) {//clears the password box and username box
         tfUsername.setText(""); 
         jpfPassword.setText("");
      }
   }
     
   //The main() method 
   public static void main(String[] args){
      LoginWindow app = new LoginWindow();
   }  

} 