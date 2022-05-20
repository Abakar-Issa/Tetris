package src;

import java.util.*;

public class PieceL extends PieceImplement{

  //private int[][] tabL;

  public PieceL(Position p,int h, int l){
    super(p,h,l);
    //this.tabL = this.getTab();
    this.orientation = this.tabD;
    /*la grille de la PieceL est definie en fonction de l'orientation passé en parametre */
      try{
        for(int j=0; j<this.max(h,l); j++){
          this.tabB[j][0] = 1;
          if(j<this.getL()){
          this.tabB[h-1][j] = 1;
          }
        }
      } catch(Exception e){}

     try{
        for(int j=0; j<this.max(h,l); j++){
            if(j<this.getL()){
          this.tabH[0][j] = 1;
          }
          this.tabH[j][l-1] = 1;
        }
      }catch(Exception e){}


     try{
        for(int j=0; j<this.max(h,l); j++){
          if(j<this.getL()){
          this.tabD[j][h-1] = 1;
        }
          this.tabD[l-1][j] = 1;
        }
    }catch(Exception e){}

      try{

        for(int j=0; j<this.max(h,l); j++){
          if(j<this.getL()){
            this.tabG[j][0] = 1;
          }
          this.tabG[l-1][j] = 1;
         }
      }catch(Exception e){}


  }

}
