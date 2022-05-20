package vue;


import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.*;
import java.util.*;
import src.*;
import control.*;
import javax.swing.JButton;



public class Panneau extends JPanel {

  private Plateau plateauPuzzle;
  private int[][] grille;
  private JPanel pan;

  public Panneau(Plateau plateauPuzzle){
	   setFocusable(true);
     this.plateauPuzzle = plateauPuzzle;
     this.pan = new JPanel(new GridLayout(plateauPuzzle.getHauteur(),plateauPuzzle.getLargeur()));
     this.grille = new int[plateauPuzzle.getHauteur()][plateauPuzzle.getLargeur()];
    //on remplit la grille en parcourant la liste des positions

    for(int index=0;index<plateauPuzzle.getListPiece().size();index++){
          Piece piece = plateauPuzzle.getListPiece().get(index);
          int s = 0;
          for(int i=0; i< piece.getOrientation().length;i++){
              for(int j=0; j<piece.getOrientation()[i].length; j++){
                Position position = plateauPuzzle.listPosition(piece).get(s);
                this.grille[position.getX()][position.getY()] = piece.getOrientation()[i][j];
                s++;
              }

          }
        }

  }

  public JPanel getPan(){
    return this.pan;
  }

  @Override
  public void paintComponent(Graphics graphic){


     /*for(int i=0;i<this.plateauPuzzle.getHauteur();i++){
      for(int j=0; j<this.plateauPuzzle.getLargeur();j++){
          if(this.grille[i][j]==1){
          //Color c = new Color(255-i,255,255-j);
          graphic.setColor(Color.blue);
          graphic.fillRect(20+i*52,20+j*52,49,49);

        }
        else graphic.drawRect(20+i*52,20+j*52,49,49);

      }
    }*/
      graphic.setColor(Color.black);
    //graphic.drawRect(32,0,128,128);
     graphic.setFont(new Font("TimesRoman",Font.PLAIN,20));
    graphic.drawString("SCORE : "+this.plateauPuzzle.getScore(),810,500);
    graphic.drawString("Nbr actions  : ", 810,550);
    graphic.drawString(" " + this.plateauPuzzle.getNbrActions(),810,600);



  }


}
