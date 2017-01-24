import java.util.ArrayList;

public class King extends Piece {
 private String print="K";
 private ArrayList<Piece> blackPieces;
 private ArrayList<Piece> whitePieces;
 
 public King(Square place, Color color, Square[][] board, ArrayList<Piece> blackPieces, ArrayList<Piece> whitePieces) {
  super(place, color, board);
  place.whatPiece(color,print);
  this.blackPieces = blackPieces;
  this.whitePieces = whitePieces;
 }
 
 public String getPrint(){
  return print;
 }
 /**
  * Metodi palauttaa listan ruuduista, joihin nappulan on mahdollisista liikkua
  **/
 public ArrayList<String> possibleSquares() {
  
  ArrayList<String> squares = new ArrayList<String>();
  
  if(this.color == Color.WHITE){
   
   if(this.getX() >= 0 && this.getX() <= 7 && this.getY() - 1 >= 0 && this.getY() - 1 <= 7){
    if(board[this.getX()][this.getY() - 1].whatColor() != Color.WHITE ){
     squares.add((this.getX()) + "," + (this.getY() - 1));
    }
   }
   if(this.getX() + 1 >= 0 && this.getX() + 1 <= 7 && this.getY() - 1 >= 0 && this.getY() - 1 <= 7){
    if(board[this.getX() + 1][this.getY() - 1].whatColor() != Color.WHITE){
     squares.add((this.getX() + 1) + "," + (this.getY() - 1));
    }
   }
   if(this.getX() + 1 >= 0 && this.getX() + 1 <= 7 && this.getY() >= 0 && this.getY() <= 7){
    if(board[this.getX() + 1][this.getY()].whatColor() != Color.WHITE ){
     squares.add((this.getX() + 1) + "," + (this.getY()));
    }
   }
   if(this.getX() + 1 >= 0 && this.getX() + 1 <= 7 && this.getY() + 1 >= 0 && this.getY() + 1 <= 7){
    if(board[this.getX() + 1][this.getY() + 1].whatColor() != Color.WHITE ){
     squares.add((this.getX() + 1) + "," + (this.getY() + 1));
    }
   }
   if(this.getX() >= 0 && this.getX() <= 7 && this.getY() + 1 >= 0 && this.getY() + 1 <= 7){
    if(board[this.getX()][this.getY() + 1].whatColor() != Color.WHITE ){
     squares.add((this.getX()) + "," + (this.getY() + 1));
    }
   }
   if(this.getX() - 1 >= 0 && this.getX() - 1 <= 7 && this.getY() + 1 >= 0 && this.getY() + 1 <= 7){
    if(board[this.getX() - 1][this.getY() + 1].whatColor() != Color.WHITE ){
     squares.add((this.getX() - 1) + "," + (this.getY() + 1));
    }
   }
   if(this.getX() - 1 >= 0 && this.getX() - 1 <= 7 && this.getY() >= 0 && this.getY() <= 7){
    if(board[this.getX() - 1][this.getY()].whatColor() != Color.WHITE ){
     squares.add((this.getX() - 1) + "," + (this.getY()));
    }
   }
   if(this.getX() - 1 >= 0 && this.getX() - 1 <= 7 && this.getY() - 1 >= 0 && this.getY() - 1 <= 7){
    if(board[this.getX() - 1][this.getY() - 1].whatColor() != Color.WHITE ){
     squares.add((this.getX() - 1) + "," + (this.getY() - 1));
    }
   }
  
  }else{
   
   if(this.getX() >= 0 && this.getX() <= 7 && this.getY() - 1 >= 0 && this.getY() - 1 <= 7){
    if(board[this.getX()][this.getY() - 1].whatColor() != Color.BLACK ){
     squares.add((this.getX()) + "," + (this.getY() - 1));
    }
   }
   if(this.getX() + 1 >= 0 && this.getX() + 1 <= 7 && this.getY() - 1 >= 0 && this.getY() - 1 <= 7){
    if(board[this.getX() + 1][this.getY() - 1].whatColor() != Color.BLACK ){
     squares.add((this.getX() + 1) + "," + (this.getY() - 1));
    }
   }
   if(this.getX() + 1 >= 0 && this.getX() + 1 <= 7 && this.getY() >= 0 && this.getY() <= 7){
    if(board[this.getX() + 1][this.getY()].whatColor() != Color.BLACK ){
     squares.add((this.getX() + 1) + "," + (this.getY()));
    }
   }
   if(this.getX() + 1 >= 0 && this.getX() + 1 <= 7 && this.getY() + 1 >= 0 && this.getY() + 1 <= 7){
    if(board[this.getX() + 1][this.getY() + 1].whatColor() != Color.BLACK ){
     squares.add((this.getX() + 1) + "," + (this.getY() + 1));
    }
   }
   if(this.getX() >= 0 && this.getX() <= 7 && this.getY() + 1 >= 0 && this.getY() + 1 <= 7){
    if(board[this.getX()][this.getY() + 1].whatColor() != Color.BLACK ){
     squares.add((this.getX()) + "," + (this.getY() + 1));
    }
   }
   if(this.getX() - 1 >= 0 && this.getX() - 1 <= 7 && this.getY() + 1 >= 0 && this.getY() + 1 <= 7){
    if(board[this.getX() - 1][this.getY() + 1].whatColor() != Color.BLACK ){
     squares.add((this.getX() - 1) + "," + (this.getY() + 1));
    }
   }
   if(this.getX() - 1 >= 0 && this.getX() - 1 <= 7 && this.getY() >= 0 && this.getY() <= 7){
    if(board[this.getX() - 1][this.getY()].whatColor() != Color.BLACK ){
     squares.add((this.getX() - 1) + "," + (this.getY()));
    }
   }
   if(this.getX() - 1 >= 0 && this.getX() - 1 <= 7 && this.getY() - 1 >= 0 && this.getY() - 1 <= 7){
    if(board[this.getX() - 1][this.getY() - 1].whatColor() != Color.BLACK ){
     squares.add((this.getX() - 1) + "," + (this.getY() - 1));
    }
   }
   
  }
  
  return squares;
 }
}
