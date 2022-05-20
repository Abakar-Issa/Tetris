package vue;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.*;
import java.util.*;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import src.*;
import control.*;



public class Vue extends JFrame implements Observer{

private Plateau plateauPuzzle;

 private int[][] grille;
 public JPanel pan;
 public JButton fin ;
 public JButton newConfig ;


public Vue(Plateau plateau){
  this.plateauPuzzle = plateau;
  this.plateauPuzzle.addObserver(this);
  this.fin  = new JButton("FINIR");
  fin.setActionCommand("fin");
  this.grille = new int[plateauPuzzle.getHauteur()][plateauPuzzle.getLargeur()];

  this.pan = new JPanel(new GridLayout (plateauPuzzle.getHauteur(),plateauPuzzle.getLargeur()));
  fin =new JButton("fin");
  fin.setActionCommand("fin");
  newConfig =new JButton("NewConfiguration");
  newConfig.setActionCommand("NewConfiguration");


}



//Pour initialiser La vue
public void init() {

  JPanel panneau = new JPanel();
  Controller controller = new Controller(this.plateauPuzzle,0,0);
  Border blackline = BorderFactory.createLineBorder(Color.black,1);
  FactoryBuilder build = new FactoryBuilder();
  if(this.plateauPuzzle.getNbrActions()!=1){
      this.grille = new int[plateauPuzzle.getHauteur()][plateauPuzzle.getLargeur()];

  if(this.plateauPuzzle.getConfiguration()){
   this.plateauPuzzle.makeListPiece(build);
  }

  try{
      for(int index=0;index<this.plateauPuzzle.getListPiece().size();index++){
              Piece piece = this.plateauPuzzle.getListPiece().get(index);
              int s = 0;
              for(int i=0; i< piece.getOrientation().length;i++){
                  for(int j=0; j<piece.getOrientation()[i].length; j++){
                    Position position = this.plateauPuzzle.listPosition(piece).get(s);
                    this.grille[position.getX()][position.getY()] = piece.getOrientation()[i][j];
                    s++;
                    }
                  }

                }


      } catch(Exception e){}


    for(int i = 0; i<this.plateauPuzzle.getHauteur();i++){
      for(int j=0;j<this.plateauPuzzle.getLargeur();j++){

        if(this.grille[i][j]==1){
          JButton bouton = new JButton();
          bouton.setActionCommand("("+i +","+j+")");
          bouton.setBackground(Color.BLUE);
          Controller control = new Controller(this.plateauPuzzle,i,j);
          bouton.addKeyListener(control);
          //bouton.addMouseListener(control);
          this.setFocusable(true);
          bouton.setSize(20,20);
          this.pan.add(bouton);
        }

        else{

          JPanel test = new JPanel();
          test.setSize(20,20);
          test.setBorder(blackline);
          this.pan.add(test);
            }
        }
    }

    this.pan.setBorder(blackline);
    this.pan.setPreferredSize(new Dimension(700,800));
    fin.addActionListener(controller);
    newConfig.addActionListener(controller);
    fin.setBackground(Color.ORANGE);
    newConfig.setBackground(Color.ORANGE);
    panneau.add(this.pan);
    panneau.add(fin);
    panneau.add(newConfig);

   JLabel label2 = new JLabel("votre score actuelle: " + String.valueOf(plateauPuzzle.getScore()));
   panneau.add(label2);

  }




  else{

    JLabel label3 = new JLabel("Dimension du rectangle ( SCORE ): " + String.valueOf(plateauPuzzle.getScore()));
    panneau.add(label3);


  }

    this.setTitle("Plateau");
    this.setResizable(false);
    this.setSize(800,900);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(panneau);
    this.setVisible(true);

    this.setContentPane(panneau);
    this.setVisible(true);
  }









  @Override
  public void update(Observable o, Object arg){

      this.pan.removeAll();
      this.init();
}

}
