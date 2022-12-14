import java.util.*;

public class Main {
    static Scanner inputReader = new Scanner(System.in);
    static String initialMessage = "Hello! This is a game, where you have to pick correct capital of a country. At the start of the game you have 10 lives.\n" +
            "For every correct answer you get 1 point, but if you guess wrong then 1 live will be deducted!\n" +
            "If you want to continue, enter your username (at least 5 characters loong) and press [ENTER]";
    public static void main(String[] args) {
        Country.readInFromFile();
        System.out.println(initialMessage);
        Stopwatch stopwatch = new Stopwatch();
        Player player = new Player(stopwatch);
        System.out.println("Hi, " + player.name + "! Let's get started!" + "\n");
        stopwatch.setStartTime();
        while (player.isAlive()) {
            Question question = new Question();
            question.displayOptions();
            if(question.checkAnswer()){
                player.addPoints();
                System.out.print("Correct! You got 1 point! In total you have ");
                printPoints(player.points);
                System.out.println();
            }else {
                player.deductLive();
                System.out.print("Wrong! The correct answer is " + question.correctAnswer.capital + "! You lost 1 life! You have got left " );
                printLives(player.lives);
                System.out.println();
            }
        }
        stopwatch.setEndTime();
        System.out.print(player.name + ", game is over! You got ");
        printPoints(player.points);
        System.out.print("You answered correctly to " + player.points + " questions in ");
        stopwatch.displayTimeSpentPlaying(stopwatch.calculateTimeSpentPlaying());
        System.out.println();
        System.out.println("\nTop players and their correct answers: ");
        Result result = new Result(player.name, player.points, stopwatch.calculateTimeSpentPlaying());
        result.addToFile();
        Result.displayTop();
        inputReader.close();
    }

    static void printPoints(int number){
        if(number == 1) {
            System.out.println(number + " point!");
        }else
            System.out.println(number + " points!");
    }

    static void printLives(int number) {
        if (number == 1) {
            System.out.println(number + " life!");
        } else
            System.out.println(number + " lives!");
    }
}