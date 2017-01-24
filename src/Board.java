import java.util.ArrayList;

public class Board {
 private Square[][] board;
 private ArrayList<Piece> blackPieces;
 private ArrayList<Piece> whitePieces;
 
 /**
  * Alustaa 8x8 -kokoisen pöydän sekä tyhjät ArrayList:it mustille ja valkoisille 
  * nappuloille
  */
 public ArrayList<Piece> getblack(){
  return blackPieces;
 }
 public ArrayList<Piece> getwhite(){
  return whitePieces;
 }
 /**
  * Konstrukstori kun aloitetaan uusi peli
  */
 public Board(){
  board=new Square[8][8];
  for (int i=0;i<8;i++){
   for (int j=0;j<8;j++){
    board[i][j]=new Square(i,j);
   }
  }
  blackPieces=new ArrayList<Piece>();
  whitePieces=new ArrayList<Piece>();
  this.setPieces();


 }
 /**
  * Konstruktori kun ladataan peli
  * @param save
  */
 public Board(String save){
  board=new Square[8][8];
  for (int i=0;i<8;i++){
   for (int j=0;j<8;j++){
    board[i][j]=new Square(i,j);
   }
  }
  blackPieces=new ArrayList<Piece>();
  whitePieces=new ArrayList<Piece>();
  this.setPieces(save);


 }
 /**
  * Asettaa laudalle tallennusdatan mukaiset nappulat
  * AE:Tallennusdatan tulee olla yhdellä rivillä ja tietyssä muodossa
  */
public void setPieces(String save){
 int index=0;
 for (int i=1;i<=8;i++){
  for (int j=1;j<=8;j++){
   Color color=null;
   String colour="";
   if (save.charAt(index)=='B'){
    color=Color.BLACK;
    colour="black";
   }
   if (save.charAt(index)=='W'){
    color=Color.WHITE;
    colour="white";
   }
   char piece=save.charAt(index+1);
   index+=3;
   Piece piece1=null;
   switch (piece){
    case 'R':
     piece1=new Rook(board[j-1][i-1],color,board);
     break;
    case 'H':
     piece1=new Knight(board[j-1][i-1],color,board);
     break;
    case 'B':
     piece1=new Bishop(board[j-1][i-1],color,board);
     break;
    case 'Q':
     piece1=new Queen(board[j-1][i-1],color,board);
     break;
    case 'K':
     piece1=new King(board[j-1][i-1],color,board, blackPieces, whitePieces);
     break;
    case 'P':
     piece1=new Pawn(board[j-1][i-1],color,board);
     break;
   }
    
   switch (colour){
   case "white":
    whitePieces.add(piece1);
    break;
   case "black":
    blackPieces.add(piece1);
    break;
   }
  }
 }
  
  
  
 }
 /**
  * Asettaa pelilaudalle molempien nappulat
  */
 public void setPieces(){
  blackPieces.add(new Rook(board[0][0],Color.BLACK, board));
  blackPieces.add(new Knight(board[1][0],Color.BLACK, board));
  blackPieces.add(new Bishop(board[2][0],Color.BLACK, board));
  blackPieces.add(new Queen(board[3][0],Color.BLACK, board));
  blackPieces.add(new King(board[4][0],Color.BLACK, board, blackPieces, whitePieces));
  blackPieces.add(new Bishop(board[5][0],Color.BLACK, board));
  blackPieces.add(new Knight(board[6][0],Color.BLACK, board));
  blackPieces.add(new Rook(board[7][0],Color.BLACK, board));
  for (int i=0;i<8;i++){
   blackPieces.add(new Pawn(board[i][1],Color.BLACK, board));
  }

  whitePieces.add(new Rook(board[0][7],Color.WHITE, board));
  whitePieces.add(new Knight(board[1][7],Color.WHITE, board));
  whitePieces.add(new Bishop(board[2][7],Color.WHITE, board));
  whitePieces.add(new Queen(board[3][7],Color.WHITE, board));
  whitePieces.add(new King(board[4][7],Color.WHITE, board, blackPieces, whitePieces));
  whitePieces.add(new Bishop(board[5][7],Color.WHITE, board));
  whitePieces.add(new Knight(board[6][7],Color.WHITE, board));
  whitePieces.add(new Rook(board[7][7],Color.WHITE, board));
  for (int i=0;i<8;i++){
   whitePieces.add(new Pawn(board[i][6],Color.WHITE, board));
  }

 }
 /**
  * Metodi tappaa kyseisessä ruudussa olevan nappulan
  */
 public void killPiece(int x, int y){
  for (int i=0;i<blackPieces.size();i++){
   if (blackPieces.get(i).getX()==x && blackPieces.get(i).getY()==y){
    blackPieces.remove(i);
   }
  }
  for (int i=0;i<whitePieces.size();i++){
   if (whitePieces.get(i).getX()==x && whitePieces.get(i).getY()==y){
    whitePieces.remove(i);
   }
  }
  board[x][y].empty();
 }
 /**
  * Metodi siirtää mustaa nappulaa annetuista koordinaateista toisiin annettuihin koordinaatteihin
  * AE:kaikki x:t ja y:t tulee olla 0-7
  */
 public boolean moveBlackPiece(int startX, int startY, int endX, int endY){
  boolean moved=false;
  for (int i=0;i<blackPieces.size();i++){
   if (blackPieces.get(i).getX()==startX && blackPieces.get(i).getY()==startY){
    if ((board[endX][endY].toString().charAt(0)+"").equals("B")){
     System.out.print("\nYou can't eat your own pieces");
     break;
    }
    if (!possible(endX, endY, blackPieces.get(i))){
     System.out.print("\nYou can't move there");
     break;
    }
    if ((board[endX][endY].toString().charAt(0)+"").equals("W")){
     killPiece(endX,endY);
    }
    blackPieces.get(i).setX(endX);
    blackPieces.get(i).setY(endY);
    board[endX][endY].whatPiece(Color.BLACK,blackPieces.get(i).getPrint());
    board[startX][startY].empty();
    moved=true;
    
   }
  }
  
  return moved;
 }
 /**
  * Metodi siirtää mustaa nappulaa annetuista koordinaateista toisiin annettuihin koordinaatteihin
  * AE:kaikki x:t ja y:t tulee olla 0-7
  */
 public boolean moveWhitePiece(int startX, int startY, int endX, int endY){
  boolean moved=false;
  for (int i=0;i<whitePieces.size();i++){
   if (whitePieces.get(i).getX()==startX && whitePieces.get(i).getY()==startY){
    if ((board[endX][endY].toString().charAt(0)+"").equals("W")){
     System.out.print("\nYou can't eat your own pieces");
     break;
    }
    if (!possible(endX, endY, whitePieces.get(i))){
     System.out.print("\nYou can't move there");
     break;
    }
    if ((board[endX][endY].toString().charAt(0)+"").equals("B")){
     killPiece(endX,endY);
    }
    whitePieces.get(i).setX(endX);
    whitePieces.get(i).setY(endY);
    board[endX][endY].whatPiece(Color.WHITE,whitePieces.get(i).getPrint());
    board[startX][startY].empty();
    moved=true;
    
   }
  }
  
  return moved;
 }
 /**
  * Metodi tutkii mihin nappula voiko nappula siirtyä annettuun koordinaattiin.
  */
 public boolean possible(int x, int y, Piece piece){
  boolean possible=false;
  ArrayList<String> squares=piece.possibleSquares();
  for (int i=0;i<squares.size();i++){
   if ((x==Integer.parseInt(squares.get(i).charAt(0)+""))&&(y==Integer.parseInt(squares.get(i).charAt(2)+""))){
    
     possible=true;
     break;
    }
   }
  
  return possible;
 }
 /**
  * Metodi tutkii onko valkoisilla kuningas vielä hengissä
  * @return
  */
 public boolean checkIfWhiteWins(){
   boolean whiteWin = true;
   for(int i = 0; i < blackPieces.size(); i++){
     if(blackPieces.get(i).getPrint().charAt(0) == 'K'){
       whiteWin = false;
     }
   }
   return whiteWin;
 }
 /**
  * Metodi tutkii onko mustilla kuningas vielä hengissä
  * @return
  */
 public boolean checkIfBlackWins(){
   boolean blackWin = true;
   for(int i = 0; i < whitePieces.size(); i++){
     if(whitePieces.get(i).getPrint().charAt(0) == 'K'){
       blackWin = false;
     }
   }
   return blackWin;
 }
 
 /**
  * Palauttaa pelitilanteen tulosteena
  */
 public String toSave(){
  String a="";
  for (int i=0;i<8;i++){
     for (int j=0;j<8;j++){
      a+=board[j][i].toString()+" ";
     }
  }
 return a;   
 }
 /**
  * Tulostaa simppelin shakkilaudan
  */
 public String toString(){
  String a="    a    b    c    d    e    f    g    h   \n";
  for (int i=0;i<8;i++){
   a+=(i+1)+" |";
   for (int j=0;j<8;j++){
    a+=" "+board[j][i].toString()+" |";
   }a+=" "+(i+1)+"\n";
   if (i!=7){
     a+="\n";
   }
  }a+="    a    b    c    d    e    f    g    h   \n";
  return a;
 }
}
