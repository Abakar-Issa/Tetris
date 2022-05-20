package control;
import java.awt.event.ActionListener;



import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

import src.*;
import vue.*;


public class CheckControl  implements ActionListener{
  private Plateau plateau;
	public CheckControl(Plateau plateau) {
		//super(plateau);
    this.plateau = plateau;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	      if (e.getActionCommand() == "fin")
	      {
	         this.plateau.setNbrActions(1);

	         System.out.println( this.plateau.isFinished());
	        System.out.println( this.plateau.getNbrActions());
	      }

	}




}
