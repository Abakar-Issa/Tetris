package src;

import java.util.ArrayList;
import java.util.*;

public class FactoryBuilder {

	public FactoryBuilder() {}

	

	public Piece buildPiece() {
		ArrayList<Piece> mesPiece= new ArrayList<>();
		int  x=0,y=0,h=0,l=3;
		Random positionx =new Random();
		Random positiony =new Random();
		Random hauteur =new Random();
		Random largeur=new Random();
		x = positionx.nextInt(15);
		y=positiony.nextInt(18);
		h=2+hauteur.nextInt(4);
		//l=  3+ largeur.nextInt(2);


		Piece pL = new PieceL(new Position(x,y),h,l);
		Piece pR = new PieceRectangle(new Position(x,y),h,l);
		Piece pT = new PieceT(new Position(x,y),h,l);
		Random index =new Random();
		int i =0;
		i = index.nextInt(3);
		mesPiece.add(pL);
		mesPiece.add(pR);
		mesPiece.add(pT);

		return mesPiece.get(i);


	}


}
