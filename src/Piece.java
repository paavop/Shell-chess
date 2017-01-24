import java.util.ArrayList;

public abstract class Piece {
 protected int xC;
 protected int yC;
 protected Color color;
 protected String print;
 protected Square[][] board;
 
 public Piece(Square place, Color color, Square[][] board){
  this.xC=place.getX();
  this.yC=place.getY();
  this.color=color;
  this.board = board;
  
  
 }
 /**
  * @param xC the xC to set
  */
 public void setX(int xC) {
  this.xC = xC;
 }
 /**
  * @param yC the yC to set
  */
 public void setY(int yC) {
  this.yC = yC;
 }
 public int getX(){
  return xC;
 }
 public int getY(){
  return yC;
 }
 public String getPrint(){
  return print;
 }
 
 /**
  * Metodi palauttaa listan ruuduista, joihin nappulan on mahdollisista liikkua
  **/
 public abstract ArrayList<String> possibleSquares();
 

}
enum Color{
 BLACK,WHITE;
}
