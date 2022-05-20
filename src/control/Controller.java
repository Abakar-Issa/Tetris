package control;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.text.View;

import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import src.*;
import vue.*;


public class Controller implements KeyListener,ActionListener{


protected Plateau plateau;
protected Piece pieceChoisi;
public boolean clickTest =false;
int x,y;
String textFin;

public Controller (Plateau plateau,int x,int y){
  this.plateau = plateau;
  this.pieceChoisi = this.plateau.getCurrentPiece();
  if(x>0 && y>0){
    this.x = x;
    this.y = y;
  }
  this.textFin = "";



}

public String getTextFin(){
  return this.textFin;
}
public void setTextFin(String texte){
  this.textFin = texte;
}

public void setPieceChoisi(Piece piece){
  this.pieceChoisi = piece;
}

@Override
public void actionPerformed(ActionEvent e) {
      if (e.getActionCommand() == "fin")
      {
         this.plateau.setNbrActions(1);
         this.setTextFin("le jeu est fini " + String.valueOf(this.plateau.getScore()));

      }

      if(e.getActionCommand() == "NewConfiguration"){
        FactoryBuilder factory = new FactoryBuilder();
        //this.plateau.makeListPiece(factory);
        this.plateau.setConfiguration(true);
      }

}



  @Override
 public void keyPressed(KeyEvent e){
   Position position  = new Position(this.x,this.y);
   //this.plateau.setConfiguration(false);
   this.setPieceChoisi(this.plateau.pieceConcern(position));
   this.plateau.setCurrentPiece(this.pieceChoisi);
   this.clickTest = true;

  if(clickTest){
      if (!this.plateau.isFinished()){

        this.plateau.setNbrActions(this.plateau.getNbrActions()-1);

        if (e.getKeyCode() == KeyEvent.VK_DOWN ){
          this.plateau.move(this.pieceChoisi,4);

        }
        if (e.getKeyCode() == KeyEvent.VK_UP ){
          this.plateau.move(this.pieceChoisi,2);

        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT ){
          this.plateau.move(this.pieceChoisi,1);
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT ){
          this.plateau.move(this.pieceChoisi,3);

        }
      //cliquer a pour rotation rotationHoraire
        if (e.getKeyChar() == 'a' ){
          this.plateau.doRotation(this.pieceChoisi,false);

        }
     //z pour rotationAntiHoraire
        if (e.getKeyChar() == 'z' ){
          this.plateau.doRotation(this.pieceChoisi,true);
        }


      this.clickTest=false;

       }

  else{
       this.setTextFin("le jeu est fini " + String.valueOf(this.plateau.getScore()));
  }
}


}

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent evt) {}




}
