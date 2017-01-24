import java.util.ArrayList;

public class Bishop extends Piece {
 private String print="B"; 
 
 public Bishop(Square place, Color color, Square[][] board) {
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
  boolean rightup = true;
  boolean rightdown = true;
  boolean leftdown = true;
  boolean leftup = true;
  
  for(int i = 1; i < 7; i++){
   
   if(this.color == Color.WHITE){ 
    // oikea-ylös
    if(this.getX() + i >= 0 && this.getX() + i <= 7 && this.getY() - i >= 0 && this.getY() - i <= 7){
     if(board[this.getX() + i][this.getY() - i].whatColor() != Color.WHITE && rightup == true){
      squares.add((this.getX() + i) + "," + (this.getY() - i));
      if(board[this.getX() + i][this.getY() - i].whatColor() == Color.BLACK){
       rightup = false;
      }
     }else{
      if(board[this.getX() + i][this.getY() - i].whatColor() == Color.WHITE){
       rightup = false;
      }
     }
    }
    // oikea-alas
    if(this.getX() + i >= 0 && this.getX() + i <= 7 && this.getY() + i >= 0 && this.getY() + i <= 7){
     if(board[this.getX() + i][this.getY() + i].whatColor() != Color.WHITE && rightdown == true){
      squares.add((this.getX() + i) + "," + (this.getY() + i));
      if(board[this.getX() + i][this.getY() + i].whatColor() == Color.BLACK){
       rightdown = false;
      }
     }else{
      if(board[this.getX() + i][this.getY() + i].whatColor() == Color.WHITE){
       rightdown = false;
      }
     }
    }
    // vasen-alas
    if(this.getX() - i >= 0 && this.getX() - i <= 7 && this.getY() + i >= 0 && this.getY() + i <= 7){
     if(board[this.getX() - i][this.getY() + i].whatColor() != Color.WHITE && leftdown == true){
      squares.add((this.getX() - i) + "," + (this.getY() + i));
      if(board[this.getX() - i][this.getY() + i].whatColor() == Color.BLACK){
       leftdown = false;
      }
     }else{
      if(board[this.getX() - i][this.getY() + i].whatColor() == Color.WHITE){
       leftdown = false;
      }
     }
    }
    // vasen-ylös
    if(this.getX() - i >= 0 && this.getX() - i <= 7 && this.getY() - i >= 0 && this.getY() - i <= 7){
     if(board[this.getX() - i][this.getY() - i].whatColor() != Color.WHITE && leftup == true){
      squares.add((this.getX() - i)+ "," + (this.getY() - i));
      if(board[this.getX() - i][this.getY() - i].whatColor() == Color.BLACK){
       leftup = false;
      }
     }else{
      if(board[this.getX() - i][this.getY() - i].whatColor() == Color.WHITE){
       leftup = false;
      }
     }
    }
   
   }else{ // mustat
    // oikea-ylös
    if(this.getX() + i >= 0 && this.getX() + i <= 7 && this.getY() - i >= 0 && this.getY() - i <= 7){
     if(board[this.getX() + i][this.getY() - i].whatColor() != Color.BLACK && rightup == true){
      squares.add((this.getX() + i) + "," + (this.getY() - i));
      if(board[this.getX() + i][this.getY() - i].whatColor() == Color.WHITE){
       rightup = false;
      }
     }else{
      if(board[this.getX() + i][this.getY() - i].whatColor() == Color.BLACK){
       rightup = false;
      }
     }
    }
    // oikea-alas
    if(this.getX() + i >= 0 && this.getX() + i <= 7 && this.getY() + i >= 0 && this.getY() + i <= 7){
     if(board[this.getX() + i][this.getY() + i].whatColor() != Color.BLACK && rightdown == true){
      squares.add((this.getX() + i) + "," + (this.getY() + i));
      if(board[this.getX() + i][this.getY() + i].whatColor() == Color.WHITE){
       rightdown = false;
      }
     }else{
      if(board[this.getX() + i][this.getY() + i].whatColor() == Color.BLACK){
       rightdown = false;
      }
     }
    }
    // vasen-alas
    if(this.getX() - i >= 0 && this.getX() - i <= 7 && this.getY() + i >= 0 && this.getY() + i <= 7){
     if(board[this.getX() - i][this.getY() + i].whatColor() != Color.BLACK && leftdown == true){
      squares.add((this.getX() - i) + "," + (this.getY() + i));
      if(board[this.getX() - i][this.getY() + i].whatColor() == Color.WHITE){
       leftdown = false;
      }
     }else{
      if(board[this.getX() - i][this.getY() + i].whatColor() == Color.BLACK){
       leftdown = false;
      }
     }
    }
    // vasen-ylös
    if(this.getX() - i >= 0 && this.getX() - i <= 7 && this.getY() - i >= 0 && this.getY() - i <= 7){
     if(board[this.getX() - i][this.getY() - i].whatColor() != Color.BLACK && leftup == true){
      squares.add((this.getX() - i)+ "," + (this.getY() - i));
      if(board[this.getX() - i][this.getY() - i].whatColor() == Color.WHITE){
       leftup = false;
      }
     }else{
      if(board[this.getX() - i][this.getY() - i].whatColor() == Color.BLACK){
       leftup = false;
      }
     }
    }
   }
  }
  return squares;
 }
}