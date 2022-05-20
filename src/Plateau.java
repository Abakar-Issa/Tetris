package src;

import java.util.*;

public class Plateau extends Observable {
 private ArrayList<Piece> listPiece;
 private int hauteur,largeur;
 private int nbrAction;
 private Piece currentPiece;
 private boolean configuration;

 public Plateau(ArrayList<Piece> listPiece, int hauteur, int largeur, int nbrAction,Piece currentPiece){
   this.listPiece = listPiece;
   this.currentPiece = currentPiece;
   this.hauteur = hauteur;
   this.largeur = largeur;
   this.nbrAction = nbrAction;
   this.configuration = false;

 }


public boolean getConfiguration(){
  return this.configuration;
}

public void setConfiguration(boolean config){
  this.configuration = config;
}
 public Piece getCurrentPiece(){

   return this.currentPiece;
 }

 public void setCurrentPiece(Piece piece){
   this.currentPiece=piece;
 }

 public int getHauteur(){
  return this.hauteur;
 }

 public int getLargeur(){
  return this.largeur;
 }


 public int getNbrActions(){

   return this.nbrAction;
 }

 public void setNbrActions(int a){
	 this.setChanged();
     this.notifyObservers();
   this.nbrAction = a;
 }

 public ArrayList<Piece> getListPiece(){

   return this.listPiece;
 }

 public void addPiece(Piece p){
   boolean test =true;
   /*on verifie d'abord si cette piece est en collision avec au
    moins une piece existente**/
    Position position = p.getPosition();
    int x = p.getOrientation().length;
    int y = p.getOrientation()[0].length;
   for(int i=0; i<this.listPiece.size(); i++){
    if(this.collision(p,this.listPiece.get(i))){
      test=false;
      break;
    }
   }

   if(!test){
     System.out.println("collision entre deux pieces");
   }
   else{
     if(!((position.getX()+x)<this.hauteur+1 && (position.getY()+y)<this.largeur+1)){
         return;
     }
     this.listPiece.add(p);
    }

 }

//cette methode prend une position dans le plateau
//et retourne la piece concerner par cette position
public Piece pieceConcern(Position position){
  boolean test = false;
  //on parcourt toutes les pieces
  for(int i=0; i<this.listPiece.size();i++){
    Piece piece = this.listPiece.get(i);
    if(this.listPosition(piece).contains(position)){
      //on recupere la piece qui, dont sa listPosition contient cette position
      return this.listPiece.get(i);
    }
  }
  return this.currentPiece;

}

 public void makeListPiece(FactoryBuilder factory){
   this.listPiece.clear();
   while(this.listPiece.size()<5){
     this.addPiece(factory.buildPiece());
   }
 }

/** cette methode permet de retourner toute les positions occuper par
    une piece dans le plateau
**/
 public ArrayList<Position> listPosition(Piece p){
   ArrayList<Position> list = new ArrayList<>();
   /*on considere que la position d'une piece dans le plateau est la position (0,0)
        dans cette meme piece**/

   int x = p.getPosition().getX();
   int y = p.getPosition().getY();
   int longueur , largeur;
   if(p.getOrientation() == p.getTabH() || p.getOrientation()==p.getTabB()){
     longueur = p.getH();
     largeur = p.getL();
   }
   else {
     longueur = p.getL();
     largeur = p.getH();
   }

  for(int i=x; i< longueur+x;i++){
    for(int j=y; j<largeur + y; j++){
       list.add(new Position(i,j));
    }

  }
  return list;
 }


  /**cette methode verifie l'intersection entre 2 pieces*/
 public ArrayList<Position> intersection(Piece p1, Piece p2){
  ArrayList<Position> list = new ArrayList<>();

   if(p1.equals(p2)) return this.listPosition(p1);

   else{

      for(int i=0; i<this.listPosition(p1).size();i++){
          /*si une position est occupée par les deux pieces on
          l'ajoute à notre listIntersection**/
          for(int j=0; j<this.listPosition(p2).size();j++){
             if(this.listPosition(p1).get(i).equals(this.listPosition(p2).get(j))){
               list.add(this.listPosition(p1).get(i));

              }
           }
         }

      return list;
    }

 }


/**cette methode verifie la collision entre 2 pieces*/
 public boolean collision(Piece p1,Piece p2){
   boolean test = false;
   if(p1.equals(p2)) return true;

   /*il ya intersection ssi la listeIntersection n'est pas vide**/
   else if(!(this.intersection(p1,p2).isEmpty())){

      for(int i=0; i<this.intersection(p1,p2).size(); i++){

        Position position = this.intersection(p1, p2).get(i);

        if(p1.occupe(position)==1 && p2.occupe(position)==1){
             test = true;
             break;
          }

      else if(p1.occupe(position)==0 && p2.occupe(position)==1){
             test=true;
             break;
        }




  }
}

  return test;
}

 //move pour déplacer une piece dans la grille
 public void move(Piece piece,int direction){
   Position position = piece.getPosition();


if(!(position.getX()>-1) || !(position.getY()>-1)){
  return;
}

   int X = position.getX();
   int Y = position.getY();

   //1 pour deplcer à gauche

   if(direction==1){
     if(position.getY()==1) position.setY(0);
     else if(!(position.getY()>1)) return;
    else  position.setY(Y-1);
   }
   // 2 pour deplacer vers le haut

   else if(direction==2){
     if(position.getX()==1) position.setX(0);
     else if(!(position.getX()>1)) return;
     else position.setX(X-1);
   }
   // 3 pour deplacer vers la droite
   else if(direction==3) position.setY(Y+1);
   // 4 pour deplacer vers le bas
   else if(direction==4) position.setX(X+1);

   int x1 = piece.getOrientation().length;
   int y1 = piece.getOrientation()[0].length;

   if(!((position.getX()+x1)<this.hauteur+1 && (position.getY()+y1)<this.largeur+1)){
        piece.setPosition(new Position(X,Y));
       return;
   }


   else{
   /*on supprime d'abord la  piece à deplacer */
   listPiece.remove(piece);
   //on stock sa position dans x et y au cas ou on arrive pas
   // à deplacer à cause des collisions

   int x = piece.getPosition().getX();
   int y = piece.getPosition().getY();
   Piece newPiece = piece;
   //newPiece prend la nouvelle position
   newPiece.setPosition(position);
   this.addPiece(newPiece);
  //si newPiece n'est pas ajouter, on remet la piéce à sa place
   if(!this.listPiece.contains(piece)){

     piece.setPosition(new Position(X,Y));
     listPiece.add(piece);

   }
 }

 this.setChanged();
 this.notifyObservers();


 }

 public int getScore(){


   int maxColonne = Integer.MIN_VALUE;
   int minColonne = Integer.MAX_VALUE;
   int maxLigne = Integer.MIN_VALUE;
   int minLigne = Integer.MAX_VALUE;


   for(int i=0; i<this.listPiece.size(); i++){
     Piece p = this.listPiece.get(i);
     Position position = p.getPosition();
     if((position.getX()+p.getOrientation().length)>maxLigne){
       maxLigne = position.getX()+p.getOrientation().length;
     }
     if(position.getX()< minLigne){
       minLigne = position.getX();
     }
     if((position.getY()+p.getOrientation()[0].length)>maxColonne){
       maxColonne = position.getY()+p.getOrientation()[0].length;
     }
     if(position.getY()< minColonne){
       minColonne = position.getY();
     }
   }

   int longueurRectangle = maxLigne - minLigne;
   int largeurRectangle = maxColonne - minColonne;

   return longueurRectangle*largeurRectangle;

 }

 public void doRotation(Piece piece , boolean type){
     boolean test = false;
     //on retire d'abord la piece initiale
      //pour éviter une collision
     this.listPiece.remove(piece);
     if(type){
       //si c'est une rotation horaire
       Piece nextPiece = piece.rotationHoraire();
      for(int i=0;i<this.listPiece.size();i++){
       if(this.collision(nextPiece,this.listPiece.get(i))){
          test = true;
          break;
       }
     }
     //s'il n'ya pas de collision
     if(!test){
       this.addPiece(nextPiece);
     }
     else{
       //si nn on remet à sa place
       piece = nextPiece.rotationAntiHoraire();
       this.addPiece(piece);
     }
   }
   else{
     Piece nextPiece = piece.rotationAntiHoraire();
     for(int i=0;i<this.listPiece.size();i++){
       if(this.collision(nextPiece,this.listPiece.get(i))){
         test = true;
         break;
       }
     }
     if(!test){
       this.addPiece(nextPiece);
    }
    else{
      piece = nextPiece.rotationHoraire();
      this.addPiece(piece);
    }

   }

   this.setChanged();
   this.notifyObservers();

 }

 public boolean isFinished(){

   return this.nbrAction==1;

 }



@Override
 public String toString(){

  int[][] grille = new int[this.hauteur][this.largeur];

  try{

      for(int index=0;index<this.listPiece.size();index++){
            Piece p = this.listPiece.get(index);
            int x = p.getOrientation().length;
            int s = 0;
            for(int i=0; i< p.getOrientation().length;i++){
                for(int j=0; j<p.getOrientation()[i].length; j++){
                  Position position = this.listPosition(p).get(s);
                  grille[position.getX()][position.getY()] = p.getOrientation()[i][j];
                  s++;
                }
            }
          }


      }

        catch (Exception e){
            System.out.println("vous depassez la grille !!!!");
          }

          String ch = "";
          for(int i=0; i<grille.length; i++){
              for(int j=0; j<grille[i].length; j++){
                ch = ch + String.valueOf(grille[i][j]);
              }
              ch = ch + "\n";

            }

            return ch;

      }




}
