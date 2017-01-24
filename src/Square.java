
public class Square {
 int xCoord;
 int yCoord;
 String print;
 
 public Square(int x, int y){
  this.xCoord=x;
  this.yCoord=y;
  print="  ";
  
 }
 /**
  * Palauttaa x-koordinaatin
  */
 public int getX(){
  return xCoord;
 }
 /**
  * Palauttaa y-koordinaatin
  */
 public int getY(){
  return yCoord;
 }
 /**
  * M‰‰ritt‰‰ olion printtiin oikean tulosteen
  */
 public void whatPiece(Color color, String string) {
  if (color==Color.WHITE){
   print="W"+string;
  }
  if (color==Color.BLACK){
   print="B"+string;
  }
 }
 // Antaa nappulan v‰rin
 public Color whatColor(){
  if((print.substring(0,1)).equals("W")){
   return Color.WHITE;
  }
  else if((print.substring(0,1)).equals("B")){
   return Color.BLACK;
  }else{
   return null;
  }
 }
 
 public void empty(){
  print="  ";
 }
 
 public String toString(){
  return print;
 }

}
