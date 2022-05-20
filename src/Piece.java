package src;


public interface Piece {

  public Position getPosition();
  public void setPosition(Position p);
  public int[][] getOrientation();
  public Piece rotationHoraire();
  public Piece rotationAntiHoraire();
  public int occupe(Position p);
  //public String showTab();
  public int getH();
  public int getL();
  public int[][] getTabB();
  public int[][] getTabH();
  public int[][] getTabD();
  public int[][] getTabG();
  public Position convertPos(Position pos);
  public void  setOrientation(int[][] tab);





}
