import java.util.ArrayList;

public class Knight extends Piece {
 private String print = "H";
 
 public Knight(Square place, Color color, Square[][] board) {
  super(place, color, board);
  place.whatPiece(color,print);
 }
 public String getPrint(){
  return print;
 }
  /**
  * Metodi palauttaa listan ruuduista, joihin nappulan on mahdollisista liikkua
  **/
 public ArrayList<String> possibleSquares(){
  
  ArrayList<String> squares = new ArrayList<String>();
  
   if(this.getX() + 1 >= 0 && this.getX() + 1 <= 7 && this.getY() - 2 >= 0 && this.getY() - 2 <= 7){
    if(board[this.getX() + 1][this.getY() - 2].whatColor() != this.color){
     squares.add((this.getX() + 1) + "," + (this.getY() - 2));
    }
   }
   if(this.getX() + 2 >= 0 && this.getX() + 2 <= 7 && this.getY() - 1 >= 0 && this.getY() - 1 <= 7){
    if(board[this.getX() + 2][this.getY() - 1].whatColor() != this.color){
     squares.add((this.getX() + 2) + "," + (this.getY() - 1));
    }
   }
   if(this.getX() + 2 >= 0 && this.getX() + 2 <= 7 && this.getY() + 1 >= 0 && this.getY() + 1 <= 7){
    if(board[this.getX() + 2][this.getY() + 1].whatColor() != this.color){
     squares.add((this.getX() + 2) + "," + (this.getY() + 1));
    }
   }
   if(this.getX() + 1 >= 0 && this.getX() + 1 <= 7 && this.getY() + 2 >= 0 && this.getY() + 2 <= 7){
    if(board[this.getX() + 1][this.getY() + 2].whatColor() != this.color){
     squares.add((this.getX() + 1) + "," + (this.getY() + 2));
    }
   }
   if(this.getX() - 1 >= 0 && this.getX() - 1 <= 7 && this.getY() + 2 >= 0 && this.getY() + 2 <= 7){
    if(board[this.getX() - 1][this.getY() + 2].whatColor() != this.color){
     squares.add((this.getX() - 1) + "," + (this.getY() + 2));
    }
   }
   if(this.getX() - 2 >= 0 && this.getX() - 2 <= 7 && this.getY() + 1 >= 0 && this.getY() + 1 <= 7){
    if(board[this.getX() - 2][this.getY() + 1].whatColor() != this.color){
     squares.add((this.getX() -2) + "," + (this.getY() + 1));
    }
   }
   if(this.getX() - 2 >= 0 && this.getX() - 2 <= 7 && this.getY() - 1 >= 0 && this.getY() - 1 <= 7){
    if(board[this.getX() - 2][this.getY() - 1].whatColor() != this.color){
     squares.add((this.getX() - 2) + "," + (this.getY() -1));
    }
   }
   if(this.getX() - 1 >= 0 && this.getX() - 1 <= 7 && this.getY() - 2 >= 0 && this.getY() - 2 <= 7){
    if(board[this.getX() - 1][this.getY() - 2].whatColor() != this.color){
     squares.add((this.getX() - 1) + "," + (this.getY() - 2));
    }
   }
  return squares;
 }

}
