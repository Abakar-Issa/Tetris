package src;

import java.util.*;

public class PieceRectangle extends PieceImplement{

  //private int[][] tabL;

  public PieceRectangle(Position p,int h, int l){
    super(p,h,l);
    
    //this.tabL = this.getTab();
   this.orientation = this.tabH;
    /*la grille de la PieceL est definie en fonction de l'orientation passé en parametre */
    for(int i=0; i<this.h; i++){
      for(int j=0; j<this.l; j++){
        this.tabH[i][j] = 1;
        this.tabB[i][j] = 1;
      }
    }
    /*Les tabs orientés vers le Gauche et Droite ont la meme taille*/
    for(int i=0; i<this.l; i++){
      for(int j=0; j<this.h; j++){
        this.tabD[i][j] = 1;
        this.tabG[i][j] = 1;
      }
    }

  }


}
