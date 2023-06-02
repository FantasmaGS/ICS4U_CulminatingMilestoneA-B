import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JFrame implements ActionListener {
   private JButton btnQuit, btnAnime, btnSettings;

   public Menu() {
      // Create buttons
      Dimension buttonSize = new Dimension(100, 30);
      btnQuit = new JButton("Quit");
      btnQuit.setPreferredSize(buttonSize);
      btnQuit.addActionListener(this);
      
      btnAnime = new JButton("Anime List");
      btnAnime.setPreferredSize(buttonSize);
      btnAnime.addActionListener(this);
      
      btnSettings = new JButton("Settings");
      btnSettings.setPreferredSize(buttonSize);
      btnSettings.addActionListener(this);
      
      // Create copyright label
      JLabel copyrightLabel = new JLabel("© 2023 IBM All rights reserved");
      copyrightLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
      copyrightLabel.setForeground(Color.WHITE);
      
      // A Nested layout(it means a layout inside a layout)
      JPanel copyrightPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
      copyrightPanel.setOpaque(false);
      copyrightPanel.add(copyrightLabel);
      
      JPanel buttonPanel = new JPanel(new BorderLayout());
      buttonPanel.setOpaque(false);
      
      JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
      btnPanel.setOpaque(false);
      btnPanel.add(btnQuit);
      btnPanel.add(btnAnime);
      btnPanel.add(btnSettings);
      
      // Add btnPanel and copyrightPanel to buttonPanel
      buttonPanel.add(btnPanel, BorderLayout.CENTER);
      buttonPanel.add(copyrightPanel, BorderLayout.SOUTH);
      
      JPanel picturesPanel = new JPanel(new BorderLayout()) {
         @Override
         public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Toolkit tk = Toolkit.getDefaultToolkit();
            Image backgoundImg = tk.getImage("background.png");
            g.drawImage(backgoundImg, 0, 0, getWidth(), getHeight(), this);
            
            Image logo = tk.getImage("archives.png");
            g.drawImage(logo, getWidth() - 530, -10, 330, 230, this);
            
            Image ibmLogo = tk.getImage("ibm.png");
            g.drawImage(ibmLogo, 0, getHeight() -380, 100, 70, this);
         }//end paint
      };
      
      picturesPanel.add(buttonPanel, BorderLayout.SOUTH);
      setContentPane(picturesPanel);
      
      setTitle("Animes Archives");
      setSize(720, 405);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }

   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == btnQuit) {
         quit app = new quit();
      } else if (e.getSource() == btnAnime) {
         this.dispose();
         animeList app = new animeList();
      } else if (e.getSource() == btnSettings) {
         //Not done
         this.dispose();
         System.out.println("Settings testing");
      }
   }
   
   //The main() method 
   public static void main(String[] args) {
      Menu app = new Menu();
   }
}