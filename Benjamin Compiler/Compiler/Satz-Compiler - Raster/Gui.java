import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  *
  * description
  *
  * @version 1.0 from 16.01.2012
  * @author Daniel Garmann
  */

public class Gui extends JFrame {
  // Anfang Attribute
  private JLabel jLabel1 = new JLabel();
  private JTextField jTextField1 = new JTextField();
  private JButton jButton1 = new JButton();
  private JLabel jLabelScanner = new JLabel();
  private JLabel jLabelParser = new JLabel();
  // Ende Attribute

  public Gui (String title) {
    super (title);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    int frameWidth = 350;
    int frameHeight = 190;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    jLabel1.setBounds(32, 24, 135, 20);
    jLabel1.setText("zu überprüfender Satz:");
    jLabel1.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(jLabel1);
    jTextField1.setBounds(32, 40, 257, 24);
    jTextField1.setText("die katze frisst die maus");
    jTextField1.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(jTextField1);
    jButton1.setBounds(120, 72, 75, 25);
    jButton1.setText("prüfen");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        jButton1_ActionPerformed(evt);
      }
    });
    jButton1.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(jButton1);
    jLabelScanner.setBounds(27, 104, 269, 20);
    jLabelScanner.setText("Der Satz ist...");
    jLabelScanner.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(jLabelScanner);
    jLabelParser.setBounds(27, 128, 269, 20);
    jLabelParser.setText("Der Satz ist...");
    jLabelParser.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(jLabelParser);
    // Ende Komponenten
    setResizable(false);
    setVisible(true);
  }

  // Anfang Methoden
  public void jButton1_ActionPerformed(ActionEvent evt) {
    Satzcompiler sc = new Satzcompiler(jTextField1.getText());
    if (sc.scannen() == true) {
      jLabelScanner.setText("Der Satz ist lexikalisch korrekt!");
      if (sc.parsen() == true) {
        jLabelParser.setText("Der Satz ist syntaktisch korrekt!");
      } else {                                                                                                                               
        jLabelParser.setText("Der Satz ist syntaktisch falsch!");
      }
    } else {
      jLabelScanner.setText("Der Satz ist lexikalisch falsch!");       
      jLabelParser.setText("Der Satz ist syntaktisch ungeprüft!");
    }
  }

  // Ende Methoden

  public static void main(String[] args) {
    new Gui("Gui");
  }
}
