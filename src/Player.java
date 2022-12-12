import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    String name;
    int lives;
    int points;
    Stopwatch stopwatch;
    static ArrayList<Player> game = new ArrayList<Player>();
    static ArrayList<Player> top = new ArrayList<>();

    Player(Stopwatch stopwatch){
        this.stopwatch = stopwatch;
        setName();
        this.lives = 10;
        this.points = 0;
        game.add(this);
    }

    void setName(){
        Main.inputReader = new Scanner(System.in);
        boolean isValidName = false;
        int nameLengthLimit = 5;
        String inputName = "";
        do {
            inputName = Main.inputReader.nextLine().trim().toLowerCase();
            inputName = inputName.substring(0,1).toUpperCase() + inputName.substring(1);
            if (inputName.length() > nameLengthLimit) {
                isValidName = true;
            }else
                System.out.println(inputName + " not a good username! It's too short! Please enter your name again and press [ENTER]");
        }while (!isValidName);
        name = inputName;
    }

    boolean isAlive() {
        if (lives > 0)
            return true;
        return false;
    }

    void deductLive(){
        this.lives--;
    }

    void addPoints(){
        this.points++;
    }
    public String toString(){
        return this.name + " " + isAlive() + " = " + this.lives;
    }
}