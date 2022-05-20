package src;
import java.util.*;


//import vue.Panneau;
import vue.Vue;
import control.CheckControl;
import control.Controller;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JButton;

import java.awt.*;
import java.util.*;
import control.*;

public class Test{



  public static void main (String [] args){

  
    Piece p1 = new PieceRectangle(new Position(0,0),3,5);
    Piece p2 = new PieceL(new Position(10,7),5,3);
    Piece p3 = new PieceRectangle(new Position(10,0),5,3);
    Piece p4 = new PieceT(new Position(0,7),5,3);
    ArrayList<Piece> list = new ArrayList<>();


    Plateau plateau = new Plateau(list,15,18,80,p1);
    plateau.addPiece(p1);
    plateau.addPiece(p2);
    plateau.addPiece(p3);
    plateau.addPiece(p4);






  //while(!plateau.isFinished()){

      Vue vue = new Vue(plateau);
      //vue.remplitView();
     vue.init();
    //
     // Panneau pan =new Panneau(plateau);
      Controller control = new Controller(plateau,1,1);
      vue.fin.addActionListener(control);

      vue.addKeyListener(control);




 }

}
