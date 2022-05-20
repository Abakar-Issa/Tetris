package src;

import java.util.*;


/*cette classe permet d'implementer l'interface Piece et créer une piece quelconque*/
public abstract class PieceImplement implements Piece {
/*  on a 4 tabs dont chacun correspon à une orientation*/
  protected int[][] tabH;
  protected int[][] tabB;
  protected int[][] tabD;
  protected int[][] tabG;
  protected int[][] orientation;
  protected int h;
  protected int l;
  protected Position p;



  public  PieceImplement(Position p,int h, int l){
    this.p = p;
    this.h = h;
    this.l = l;
    this.tabH = new int[h][l];
    this.tabB = new int[h][l];
    this.tabG = new int[l][h];
    this.tabD = new int[l][h];
    /*l'orientation par defaut est le bas*/
      this.orientation = this.tabH;

 /* on rempli les tabs avec des zeros au debut et apres on modifie pour chaque type de piece*/
 /*Les tabs orientés vers le Haut et Bas ont la meme taille*/
 /*if(l>=h) {
          throw new ArithmeticException("la largeur doit etre inferieure a la longueur");
         }
 else {*/
    for(int i=0; i<this.h; i++){
      for(int j=0; j<this.l; j++){
        this.tabH[i][j] = 0;
        this.tabB[i][j] = 0;
      }
    }
    /*Les tabs orientés vers le Gauche et Droite ont la meme taille*/

    for(int i=0; i<this.l; i++){
      for(int j=0; j<this.h; j++){
        this.tabD[i][j] = 0;
        this.tabG[i][j] = 0;
      }
    }

}


@Override
  public int getH(){
    return this.h;
  }
  @Override
  public int getL(){
    return this.l;
  }

  public void setH(int h){
    this.h=h ;
  }

  public void setL(int l){
    this.l=l ;
  }
  @Override
  public void setPosition(Position p){
    this.p = p;
  }
  @Override
  public void setOrientation(int[][] newO){
    this.orientation = newO;
  }
  @Override
  public int[][] getOrientation(){
    return this.orientation;
  }

  @Override
  public int[][] getTabH(){
    return this.tabH;
  }
  @Override
  public int[][] getTabD(){
    return this.tabD;
  }
@Override
  public int[][] getTabG(){
    return this.tabG;
  }
@Override
  public int[][] getTabB(){
    return this.tabB;
  }
  /* cette methode permet de definir la position de la piece*/
  @Override
  public Position getPosition(){
  return this.p;
  }

  /* cette methode permet de faire une rotationHoraire */
  /*on defini l'orientation suivante en fonction de l'orientation actuelle */
  @Override
  public Piece rotationHoraire(){
    if(Arrays.equals(this.orientation,this.tabD)){
     //le suivant de droite est le bas
     this.setOrientation(this.tabB);
   }

    else if(Arrays.equals(this.orientation,this.tabH)){
       //le suivant de heut est droite
       this.setOrientation(this.tabD);
     }

       else if(Arrays.equals(this.orientation,this.tabB)){
       //le suivant du Bas est le gauche
       this.setOrientation(this.tabG);
     }
       else {
       //le suivant de gauche est le haut
       this.setOrientation(this.tabH);
     }

    return this;

  }
  /*cette methode permet de faire une rotationAntiHoraire*/
  @Override
  public Piece rotationAntiHoraire(){

    if(Arrays.equals(this.orientation,this.tabH)){

      this.setOrientation(this.tabG);
    }
     else if(Arrays.equals(this.orientation,this.tabD)){
      this.setOrientation(this.tabH);
    }
      else if(Arrays.equals(this.orientation,this.tabB)){
      this.setOrientation(this.tabD);
    }
      else {
      this.setOrientation(this.tabB);
    }

    return this;

  }
 /*cette methode permet de sauvegarder le tab dans une chaine de caractere et l'affiché*/
 @Override
  public String toString(){
    //String[] str = new String[this.orientation.length];
    String ch = "";
    for(int i=0; i<this.orientation.length; i++){
      for(int j=0; j<this.orientation[i].length; j++){
        ch = ch + String.valueOf(this.orientation[i][j]);
      }
      ch = ch + "\n";

    }
   return ch;
  }

@Override
 public Position convertPos(Position pos){
   int x = pos.getX() - this.p.getX();
   int y = pos.getY() - this.p.getY() ;
   return  (new Position(x,y));
 }
  @Override
  public int occupe(Position position){

  int x = this.convertPos(position).getX(); /*position.getX() - this.p.getX();*/
  int y = this.convertPos(position).getY(); /*position.getY() - this.p.getY() ;*/
  return this.orientation[x][y];

  }
  /*cette methode retourne le max entre la hauteur et la largeur*/
  public int max(int x,int y){
    return x>y ? x:y;
  }




}
