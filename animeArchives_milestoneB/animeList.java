import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class animeList extends JFrame implements ActionListener, ListSelectionListener {
   // Components
   private JButton btnBack, btnProfile, btnSort, btnNew, btnDelete, btnHelp, btnSearch;
   private JList<String> animeList;
   private DefaultListModel<String> animeListModel;
   private JLabel myAnime, nack;
   private JTextField tfSearch;
   
   // Anime list initialization
   // Might need to put these names into a txt file like the LTS
   String[] animes = { "Naruto Shipudden", "One Piece", "Bleach", "Fairy Tail", "Neon Genesis Evangelion",
             "My Hero Academia", "Classroom of the Elite", "Sword Art Online", "Attack on Titans", "Code Geass",
             "Hunter x Hunter", "Spriggan", "Cowboy Bebop", "Ocean Waves", "The Wind Rises" };

   public animeList() {
      // Button initialization
      btnBack = new JButton("Back");
      btnBack.addActionListener(this);
        
      btnProfile = new JButton("Profile");
      btnProfile.addActionListener(this);
        
      btnSort = new JButton("Sort");
      btnSort.addActionListener(this);
        
      btnNew = new JButton("New");
      btnNew.addActionListener(this);
        
      btnDelete = new JButton("Delete");
      btnDelete.addActionListener(this);
        
      btnHelp = new JButton("Help");
      btnHelp.addActionListener(this);
      
      btnSearch = new JButton("Search");
      btnSearch.addActionListener(this);
      
      //Milestone B
      //Search text field
      tfSearch = new JTextField();
      tfSearch.setBounds(160, 35, 310, 25);
      add(tfSearch);
      
      animeListModel = new DefaultListModel<>();
      for (String anime: animes) {
         animeListModel.addElement(anime);
      }

      animeList = new JList<>(animeListModel);
      animeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      animeList.setLayoutOrientation(JList.VERTICAL);
      animeList.setOpaque(false);
      animeList.setBackground(new Color(0, 0, 0, 123)); // Half transparent

      //Anime List + scroll bar
      JScrollPane listScroller = new JScrollPane(animeList);
      listScroller.setPreferredSize(new Dimension(400, 200));
      listScroller.setBounds(160, 70, 400, 220);
      listScroller.setOpaque(false);
      listScroller.getViewport().setOpaque(false); // Making JScrollPane transparent

      // Labels initialization
      myAnime = new JLabel("Anime List");
      myAnime.setForeground(Color.WHITE);
      myAnime.setFont(new Font("Courier", Font.BOLD,25));
      ImageIcon img = new ImageIcon("backgroundAnimeList.jpg");
      nack = new JLabel("", img, JLabel.CENTER);

      // Adding list selection listener for anime list
      animeList.addListSelectionListener(this);
      animeList.setForeground(Color.WHITE);

      // Setting bounds
      myAnime.setBounds(270, 0, 210, 30);
      btnBack.setBounds(8, 300, 90, 50);
      btnProfile.setBounds(128, 300, 90, 50);
      btnSort.setBounds(248, 300, 90, 50);
      btnNew.setBounds(368, 300, 90, 50);
      btnDelete.setBounds(488, 300, 90, 50);
      btnHelp.setBounds(608, 300, 90, 50);
      nack.setBounds(0, 0, 720, 405);
      btnSearch.setBounds(470, 35, 90, 25); // Search Button for milestone B
      add(btnSearch);

      // Adding components to JFrame container
      add(myAnime);
      add(btnBack);
      add(btnProfile);
      add(btnSort);
      add(btnNew);
      add(btnDelete);
      add(btnHelp);
      add(listScroller); // Add JScrollPane instead of JList
      add(nack);

      // Setting JFrame's title, window size and making it visible
      setTitle("Anime List");
      setSize(720, 405);
      setLayout(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }

   // Action listener for buttons
   public void actionPerformed(ActionEvent e) {
      Object source = e.getSource();

      if (source == btnBack) {
         System.out.println("Back button clicked");
         this.dispose();
         Menu app = new Menu();
      } else if (source == btnProfile) {
         System.out.println("Profile button clicked");
      } else if (source == btnSort) {
         System.out.println("Sort button clicked");
      } else if (source == btnNew) {
         System.out.println("New button clicked");
      } else if (source == btnDelete) {
         System.out.println("Delete button clicked");
      } else if (source == btnHelp) {
         System.out.println("Help button clicked");
      } else if (source == btnSearch) {
         System.out.println("Search button clicked");
         String searchTerm = tfSearch.getText().toLowerCase();
         animeListModel.clear();
         for (String anime: animes) {
            if (anime.toLowerCase().contains(searchTerm)) {
               animeListModel.addElement(anime);
            }
         }
      }
   }

   // List selection listener for anime list
   public void valueChanged(ListSelectionEvent e) {
      if (!e.getValueIsAdjusting()) {
         String selectedAnime = animeList.getSelectedValue();
         System.out.println("Anime selected: " + selectedAnime);
      }
   }

   // The main() method
   public static void main(String[] args) {
      animeList app = new animeList();
   }
}