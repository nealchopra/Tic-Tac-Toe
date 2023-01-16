import java.util.Scanner;

public class Game
{
  private char[][] board;
  private int row;
  private int column;
  private String player1;
  private String player2; 
  private Scanner myScanner;
  private boolean win;

  public Game()
  {
    row = 0; 
    column = 0;
    myScanner = new Scanner(System.in);
    board = new char[3][3];
    for(int row = 0; row < board.length; row++) {
      for(int col = 0; col < board[row].length; col++) 
      {
        board[row][col] = '-';
      }
    }
    win = false; 
  }

  public String getPlayer1()
  {
    return player1;
  }
  public String getPlayer2()
  {
    return player2;
  }

  public boolean getWin()
  {
    return win;
  }

  public void setup()
  {
    System.out.println("What is player 1's name?");
    player1 = myScanner.nextLine();
    System.out.println("What is player 2's name?");
    player2 = myScanner.nextLine();
    displayBoard();
  }

  public void displayBoard()
  {
    System.out.println("\nCurrent Board: ");
    for(int row = 0; row < board.length; row++) 
    {
      for(int col = 0; col < board[row].length; col++) 
      {
        System.out.print(board[row][col]);
      }
      System.out.println();
    }
    System.out.println();
  }

  public void turn(String player)
  {
    while(true)
    {
      System.out.println(player + "'s Turn:");
      System.out.print(player + ", pick a row (0,1,2): ");
      try
      {
        row = Integer.parseInt(myScanner.nextLine());
      } 
      catch (Exception e)
      {
        System.out.println("Invalid input!\n");
        continue; 
      }
      System.out.print(player + ", pick a column (0,1,2): ");
      try
      {
        column = Integer.parseInt(myScanner.nextLine());
      }
      catch (Exception e)
      {
        System.out.println("Invalid input!\n");
        continue; 
      }
      if(row>2 || row<0 || column>2 || column<0)
      {
        System.out.println("Invalid input!\n");
        continue;
      }
      if(board[row][column] != '-')
      {
        System.out.println("Somebody has already made a move there!\n");
        continue; 
      }
      break;
    }
    updateBoard(row, column, player);
  }

  public void updateBoard(int row, int column, String player){
    if(player.equals(player1))
    {
      board[row][column] = 'X';
      displayBoard();
      if(winCondition())
      {
        gameOver(player1);
      }
    }
    else{
      board[row][column] = 'O';
      displayBoard();
      if(winCondition())
      {
        gameOver(player2);
      }
    }
  }

  public boolean winCondition()
  {
    for(int i = 0; i < 3; i++) 
    {
      if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') 
      {
        return true;
      }
    }
    for(int j = 0; j < 3; j++) 
    {
      if(board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '-') 
      {
        return true;
      }
    }
    if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') 
    {
      return true;
    }
    if(board[2][0] == board[1][1] && board[1][1] ==  board[0][2] && board[2][0] != '-') 
    {
      return true;
    }
    return false;
  }

  public void gameOver(String player)
  {
    win = true;
    System.out.println("Congratulations! " + player + " has won!!\n");
  }
}