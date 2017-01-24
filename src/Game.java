import java.io.*;
import java.util.*;

public class Game {

 public static void main(String[] args) {
  System.out.println("Lets play chess!");
  boolean chess = true;
  while(chess){
    Board board=new Board();
    int round=1;
    Scanner scanner =new Scanner(System.in);
    System.out.println("1. New game\n2. Load game\n3. End game");
    String mode=scanner.nextLine();
    
    switch (mode){
      case "1":
        System.out.println("Starting new game \nInput 'end' any time to end game.");
        break;
      case "2":
        System.out.println("Loading previous game... ");
        String save=loadGame();
        if (save.length()==0){
        	System.out.println("Starting new game \nInput 'end' any time to end game.");
        	break;
        }
        board=new Board(save);
        String rounds= save.substring(save.lastIndexOf(' ')+1,save.length());
        round=Integer.parseInt(rounds);
        System.out.println("\nInput 'end' any time to end game.");
        break;
      case "3":
        System.exit(0);
    }
    
    boolean gameOn=true;
    while (gameOn){
      System.out.println("Round "+round);
      boolean whitePlay=true;
      while (whitePlay){
        System.out.println("White's turn");
        System.out.println(board);
        System.out.println("Which piece do you want to move?");
        String piece=scanner.nextLine();
        if(piece.equals("end")){
          System.exit(0);
        }
        if (piece.length()!=2){
            System.out.println("Input one alphabet and one number, for example a8 or g7");
            continue;
          }
        if ((Character.isDigit(piece.charAt(0)) || (Character.isLetter(piece.charAt(1))))){
         System.out.println("Input one alphabet and one number, for example a8 or g7");
         continue;
        }
        if (!inBounds(piece)){
          System.out.println("\nOut of bounds\nTry again.\n");
          continue;
        }
       
        System.out.println("Where do you want to move it?");
        String newPlace=scanner.nextLine();
        if(newPlace.equals("end")){
          System.exit(0);
        }
        if (newPlace.length()!=2){
            System.out.println("Input one alphabet and one number, for example a8 or g7");
            continue;
          }
        if ((Character.isDigit(newPlace.charAt(0)) || (Character.isLetter(newPlace.charAt(1))))){
         System.out.println("Input one alphabet and one number, for example a8 or g7");
         continue;
        }
        if (!inBounds(newPlace)){
          System.out.println("\nOut of bounds\nTry again.\n");
          continue;
        }
        if(newPlace.equals(piece)){
          continue;
        }
        if (board.moveWhitePiece(makeX(piece),Integer.parseInt(piece.charAt(1)+"")-1, makeX(newPlace),Integer.parseInt(newPlace.charAt(1)+"")-1)){
          whitePlay=false;
        }else{
          System.out.println("\nTry again\n");
        }
      }
      
      if(board.checkIfWhiteWins()){
        System.out.println("\nWhite wins!\n");
        break;
      }
      
      boolean blackPlay=true;
      while (blackPlay){
        System.out.println("Black's turn");
        System.out.println(board);
        System.out.println("Which piece do you want to move?");
        String piece1=scanner.nextLine();
        if(piece1.equals("end")){
          System.exit(0);
        }
        if (piece1.length()!=2){
            System.out.println("Input one alphabet and one number, for example a8 or g7");
            continue;
          }
        if ((Character.isDigit(piece1.charAt(0)) || (Character.isLetter(piece1.charAt(1))))){
         System.out.println("Input one alphabet and one number, for example a8 or g7");
         continue;
        }
        if (!inBounds(piece1)){
            System.out.println("\nOut of bounds\nTry again.\n");
            continue;
          }
        System.out.println("Where do you want to move it?");
        String newPlace1=scanner.nextLine();
        if(newPlace1.equals("end")){
          System.exit(0);
        }
        if (newPlace1.length()!=2){
            System.out.println("Input one alphabet and one number, for example a8 or g7");
            continue;
          }
        if ((Character.isDigit(newPlace1.charAt(0)) || (Character.isLetter(newPlace1.charAt(1))))){
         System.out.println("Input one alphabet and one number, for example a8 or g7");
         continue;
        }
        if (!inBounds(newPlace1)){
          System.out.println("\nOut of bounds\nTry again.\n");
          continue;
        }
        if(newPlace1.equals(piece1)){
          continue;
        }
        if (board.moveBlackPiece(makeX(piece1),Integer.parseInt(piece1.charAt(1)+"")-1, makeX(newPlace1),Integer.parseInt(newPlace1.charAt(1)+"")-1)){
          blackPlay=false;
        }else{
          System.out.println("\nTry again.\n");
        }
      }
      if(board.checkIfBlackWins()){
        System.out.println("\nBlack wins!\n");
        break;
      }
      round++;
      System.out.println("\nAutosaving...\n");
      saveGame(board.toSave(),round);
      
    }
    scanner.close(); 
  }
 }
 
 /**
  * Tarkistaa ovatko annetut koordinaatit laudan rajoissa
  * AE:koordinaatit tulee antaa muodossa [Kirjain][Numero], 
  * esim, A8 tai B7
  **/
 public static boolean inBounds(String coord){
  boolean inBounds=true;
  int x=makeX(coord)+1;
  int y=Integer.parseInt(coord.charAt(1)+"");
  if (!(x>=1 && x<=8 && y>=1 && x<=8)){
   inBounds=false;
  }
  return inBounds;
 }
 /**
  * Tallentaa pelin tekstitiedostoon
  * AE:Metodille tulee antaa pelitilanne String-muodossa ja kierrosten lukumäärä kokonaislukuna
  */
 public static void saveGame(String game, int rounds){
  try {
   BufferedWriter out = new BufferedWriter(new FileWriter("save.txt"));
   out.flush();
   out.write(game);
   out.newLine();
   out.write(Integer.toString(rounds));
   out.close();
  }
  catch (IOException e){
   System.out.println("Exception ");  
  }

 }
 /**
  * Lataa pelin tekstitiedostosta
  */
 public static String loadGame(){
  String save="";
  try {
   BufferedReader reader = new BufferedReader(new FileReader("save.txt"));
   save=reader.readLine();
   save += reader.readLine();
   reader.close();
  }
  catch (IOException e){
   System.out.println("No save file found. ");  
  }
  return save;


 }
 /**
  * Muuttaa kirjainmuotoisen koordinaatin numeromuotoon,
  * jos kirjain ei ole a-h metodi palauttaa -1  
 */
 public static int makeX(String coord){
  int a=-1;
  if (coord.charAt(0)=='a'){
   a=0;
  }
  if (coord.charAt(0)=='b'){
    a=1;
  }
  if (coord.charAt(0)=='c'){
    a=2;
  }
  if (coord.charAt(0)=='d'){
    a=3;
  }
  if (coord.charAt(0)=='e'){
    a=4;
  }
  if (coord.charAt(0)=='f'){
    a=5;
  }
  if (coord.charAt(0)=='g'){
    a=6;
  }
  if (coord.charAt(0)=='h'){
    a=7;
  }
  return a;
 }
}
