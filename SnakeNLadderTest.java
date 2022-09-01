import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

class SnakeNLadder {
    
    final static int WINPOINT = 100;
     
     
    static Map < Integer , Integer > snake = new HashMap < Integer , Integer >();
    static Map < Integer , Integer > ladder = new HashMap< Integer , Integer >();
     
    {
        snake.put(98,79);
        snake.put(94,75);
        snake.put(93,73);
        snake.put(87,36);
        snake.put(64,60);
        snake.put(62,19);
        snake.put(54,34);
        snake.put(17,7);
        
        
         
        ladder.put(99,80);
        ladder.put(91,72);
        ladder.put(84,28);
        ladder.put(67,51);
        ladder.put(42,21);
        ladder.put(38,1);
        ladder.put(31,9);
        ladder.put(14,4);
    }

    //TO-DO Methods
 
    //rollDice()
public int rollDice()
{
    int n = 0;
    Random r = new Random();
    n=r.nextInt(7);
    return (n==0?1:n);
}

    // calculatePlayerValue()
    public int calculatePlayerValue(int player, int diceValue)
    {
        player = player + diceValue;
          
        if(player > WINPOINT)
        {
            player = player - diceValue;
            return player;
        }
          
        if(null!=snake.get(player))
        {
            System.out.println("swallowed by snake");
            player= snake.get(player);
        }
          
        if(null!=ladder.get(player))
        {
            System.out.println("climb up the ladder");
            player= ladder.get(player);
        }
        return player;
    }
//isWin()
public boolean isWin(int player)
{
    return WINPOINT == player;
}
//startGame()
public void startGame()
{
    int player1 =0, player2=0;
    int currentPlayer=-1;
    Scanner s = new Scanner(System.in);
    String str;
    int diceValue =0;
    do
    {
        System.out.println(currentPlayer==-1?"\n\nFIRST PLAYER TURN":"\n\nSECOND PLAYER TURN");
        System.out.println("Press r to roll Dice");
        str = s.next();
        diceValue = rollDice();
          
          
        if(currentPlayer == -1)
        {
            player1 = calculatePlayerValue(player1,diceValue);
            System.out.println("First Player :: " + player1);
            System.out.println("Second Player :: " + player2);
            System.out.println("------------------");
            if(isWin(player1))
            {
                System.out.println("First player wins");
                return;
            }
        }
        else
        {
            player2 = calculatePlayerValue(player2,diceValue);
            System.out.println("First Player :: " + player1);
            System.out.println("Second Player :: " + player2);
            System.out.println("------------------");
            if(isWin(player2))
            {
                System.out.println("Second player wins");
                return;
            }
        }
          
        currentPlayer= -currentPlayer;
          
          
          
    }while("r".equals(str));
}
     
}
 
public class SnakeNLadderTest {
 
    public static void main(String[] args) {
        SnakeNLadder s = new SnakeNLadder();
        s.startGame();
 
    }
}
