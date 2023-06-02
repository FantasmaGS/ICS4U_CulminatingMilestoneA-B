import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class quit extends JFrame implements ActionListener {
   
   private JButton btnYes, btnNo; 
   private JLabel question, background; 

   public quit() {
    
      btnYes = new JButton("Yes");
      btnNo = new JButton("No");
      question = new JLabel("Are you sure you want to close the screen?", SwingConstants.CENTER);
      question.setForeground(Color.WHITE);
      
      ImageIcon img = new ImageIcon("quitScreen.png");
      background = new JLabel("", img, JLabel.CENTER);

      btnNo.addActionListener(this);
      btnYes.addActionListener(this);
      
      background.setLayout(new BorderLayout());

      //Nested Layout
      JPanel questionPanel = new JPanel();
      questionPanel.setOpaque(false);
      questionPanel.setLayout(new GridBagLayout());
      questionPanel.add(question);
      background.add(questionPanel, BorderLayout.CENTER);

      JPanel buttonsPanel = new JPanel();
      buttonsPanel.setOpaque(false);
      buttonsPanel.add(btnYes);
      buttonsPanel.add(btnNo);
      background.add(buttonsPanel, BorderLayout.SOUTH);
      
      setContentPane(background);
      
      //setting JFrame's title, window size and making it visible 
      setTitle("Quit?"); //"super" JFrame sets its title
      setSize(356, 223); //"super" JFrame sets its initial window size 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // closes all windows
      setLocationRelativeTo(null); // Centers JFrame
      setVisible(true); //"super" JFrame shows
   }
   
   public void actionPerformed(ActionEvent e){
      if (e.getSource() == btnYes) {
         System.exit(0);
      } else if (e.getSource() == btnNo) {
         this.dispose();
      }
   }
        
   //The main() method 
   public static void main(String[] args) {
      quit app = new quit();
   }  
}