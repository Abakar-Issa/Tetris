package src;

import java.util.*;

public class PieceT extends PieceImplement{

  public PieceT(Position p,int h, int l){
    /*notre tab dois avoir une largeur ou longueur impair suivant les rotations subies*/
       super(p,h,l);
  this.orientation = this.tabD;


    /*la grille de la Piece */
    try{
        for(int j=0; j<this.max(h,l); j++){
          this.tabB[j][(this.l-1)/2] = 1;
          if(j<this.getL()){
          this.tabB[h-1][j] = 1;
          }
        }
      }catch(Exception e){}

     try{
        for(int j=0; j<this.max(h,l); j++){
            if(j<this.getL()){
          this.tabH[0][j] = 1;
              }
          this.tabH[j][(this.l-1)/2] = 1;
         }
      }catch(Exception e){}

     try{
        for(int j=0; j<this.max(h,l); j++){
          if(j<this.getL()){
          this.tabD[j][h-1] = 1;
          }
          this.tabD[(this.l-1)/2][j] = 1;
        }
      }catch(Exception e){}


      try{
        for(int j=0; j<this.max(h,l); j++){
          if(j<this.getL()){
            this.tabG[j][0] = 1;
            }
          this.tabG[(this.l-1)/2][j] = 1;
          }
        }catch(Exception e){}

    }





}
