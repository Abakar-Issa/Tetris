package src;
import java.util.*;


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

public class MainConsole{



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

    Scanner scan = new Scanner(System.in);
    System.out.println("tapez entre 0 et 3 pour choisir une piece; ");
    System.out.println("tapez a pour rotation horaire et z pour antiHoraire;");
    System.out.println("directions : gauche (1), haut (2), droite (3), bas (4) ");

    while(!plateau.isFinished()){
      System.out.println(plateau);
      int i = scan.nextInt();
      Piece piece = plateau.getListPiece().get(i);
      System.out.println("deplacement (d) et rotation (r)");
      char c = scan.next().charAt(0);
      if(c == 'd') {
        System.out.println("direction ?");
        int dir = scan.nextInt();
        plateau.move(piece,dir);
      }
      else if(c=='r'){
        System.out.println("type de rotation");
        char b = scan.next().charAt(0);
        if(b=='a') plateau.doRotation(piece,true);
        else if(b=='z') plateau.doRotation(piece,false);
      }

      plateau.setNbrActions(plateau.getNbrActions()-1);


    }







 }

}
