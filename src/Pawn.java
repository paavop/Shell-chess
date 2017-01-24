import java.util.ArrayList;

public class Pawn extends Piece {
 private String print = "P";
 
 public Pawn(Square place, Color color, Square[][] board) {
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
   
   if(this.color == Color.WHITE){
    if(this.getY() == 6){
     if(this.getX() >= 0 && this.getX() <= 7 && this.getY() - 1 >= 0 && this.getY() - 1 <= 7){
      if(board[this.getX()][this.getY() - 1].whatColor() != Color.WHITE && (board[this.getX()][this.getY() - 1].whatColor() != Color.BLACK)){
       squares.add(this.getX() + "," + (this.getY() - 1));
       if(board[this.getX()][this.getY() - 2].whatColor() != Color.BLACK && board[this.getX()][this.getY() - 2].whatColor() != Color.WHITE){
        squares.add(this.getX() + "," + (this.getY() - 2));
       }
      }
     }
    }else{
     if(this.getX() >= 0 && this.getX() <= 7 && this.getY() - 1 >= 0 && this.getY() - 1 <= 7){
      if(board[this.getX()][this.getY() - 1].whatColor() != Color.WHITE && (board[this.getX()][this.getY() - 1].whatColor() != Color.BLACK)){
       squares.add(this.getX() + "," + (this.getY() - 1));
      }
     }
    }
    if(this.getX() + 1 >= 0 && this.getX() + 1 <= 7 && this.getY() - 1 >= 0 && this.getY() - 1 <= 7){
     if(board[this.getX() + 1][this.getY() - 1].whatColor() == Color.BLACK){
      squares.add((this.getX() + 1) + "," + (this.getY() - 1));
     }
    }
    if(this.getX() - 1 >= 0 && this.getX() - 1 <= 7 && this.getY() - 1 >= 0 && this.getY() - 1 <= 7){
     if(board[this.getX() - 1][this.getY() - 1].whatColor() == Color.BLACK){
      squares.add((this.getX() - 1) + "," + (this.getY() - 1));
     }
    }
    
   }else{
    if(this.getY() == 1){
     if(this.getX() >= 0 && this.getX() <= 7 && this.getY() + 1 >= 0 && this.getY() + 1 <= 7){
      if(board[this.getX()][this.getY() + 1].whatColor() != Color.BLACK && board[this.getX()][this.getY() + 1].whatColor() != Color.WHITE){
       squares.add(this.getX() + "," + (this.getY() + 1));
       if(board[this.getX()][this.getY() + 2].whatColor() != Color.WHITE && board[this.getX()][this.getY() + 2].whatColor() != Color.BLACK){
        squares.add(this.getX() + "," + (this.getY() + 2));
       }
      }
     }
    }else{
      if(this.getX() >= 0 && this.getX() <= 7 && this.getY() + 1 >= 0 && this.getY() + 1 <= 7){
       if(board[this.getX()][this.getY() + 1].whatColor() != Color.BLACK && board[this.getX()][this.getY() + 1].whatColor() != Color.WHITE){
        squares.add(this.getX() + "," + (this.getY() + 1));
       }
      }
     }
    
    if(this.getX() + 1 >= 0 && this.getX() + 1 <= 7 && this.getY() + 1 >= 0 && this.getY() + 1 <= 7){
     if(board[this.getX() + 1][this.getY() + 1].whatColor() == Color.WHITE){
      squares.add((this.getX() + 1) + "," + (this.getY() + 1));
     }
    }
    if(this.getX() - 1 >= 0 && this.getX() - 1 <= 7 && this.getY() + 1 >= 0 && this.getY() + 1 <= 7){
     if(board[this.getX() - 1][this.getY() + 1].whatColor() == Color.WHITE){
      squares.add((this.getX() - 1) + "," + (this.getY() + 1));
     }
    }
   }
   
 return squares;
 }
 
}
