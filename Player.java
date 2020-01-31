import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.*;
abstract class Master{}
public class Player extends Master {
    String name;
    Scanner in = new Scanner(System.in);

    Player(String inName){
        name = inName;
    }

    private Game game;
    public Player(Game game){
        this.game = game;
    }



public static void main(String[] args) {
    String Nombre = JOptionPane.showInputDialog("Player 1 Name: ");
    String Nombre2 = JOptionPane.showInputDialog("Player 2 Name:");
     
    }
}