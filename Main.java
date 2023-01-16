import java.util.Scanner; 

public class Main
{
  public static void main(String [] args)
  {
    System.out.println("\n     -----------------------");
    System.out.println("          Tic Tac Toe ");
    System.out.println("     -----------------------\n");
    Game newGame = new Game();
    newGame.setup(); 
    while(true)
    {
      newGame.turn(newGame.getPlayer1());
      if(newGame.getWin())
        break;
      newGame.turn(newGame.getPlayer2());
      if(newGame.getWin())
        break;
    }
  }
}