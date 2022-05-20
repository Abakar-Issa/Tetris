package src;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.text.View;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import src.*;
import vue.*;
import control.*;


public class Robot {

  public static void main(String [] args){

  //  Piece currentPiece =  new PieceRectangle(new Position(0,0),3,5);
    FactoryBuilder factoryBuilder = new FactoryBuilder();
    Plateau plateau = new Plateau(new ArrayList<>(),15,18,20,factoryBuilder.buildPiece());
    Vue vue = new Vue(plateau);
    Controller control = new Controller(plateau,0,0);
    vue.fin.addActionListener(control);
    vue.addKeyListener(control);


    while(!plateau.isFinished()){
      Piece piece = factoryBuilder.buildPiece();
      plateau.makeListPiece(factoryBuilder);
      Random rand = new Random();
      int direction = 1 + rand.nextInt(5);
      int index = rand.nextInt(5);
      boolean rotationType = rand.nextBoolean();
      plateau.move(plateau.getListPiece().get(index),direction);
      plateau.doRotation(plateau.getListPiece().get(index),rotationType);
      vue.init();
      plateau.setNbrActions(plateau.getNbrActions()-1);
    }
  }
}
