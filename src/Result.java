import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;

public class Result {
    String playersName;
    int points;
    long time;
    static String filePath = "/Users/loretavitina/IdeaProjects/Geogame/results.csv";
    static File csvFile = new File(filePath);
    static String encoding = "UTF-8";
    static String delimiter = ",";
    static ArrayList<Result> all = new ArrayList<Result>();

    Result(String playersName, int points, long time) {
        this.playersName = playersName;
        this.points = points;
        this.time = time;
    }

    void addToFile() {
        File file = new File(filePath);
        boolean append = true;
        if (file.exists() == false) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                System.out.println("Results file can't be created!");
                e.printStackTrace();
            }
        }
        if (file.isFile()) {
            try {
                FileWriter writer = new FileWriter(filePath, append);
                writer.write( playersName + "," + points + "," + time + "\n");
                writer.close();
            } catch (Exception e) {
                System.out.println("Couldn't write players data in the file!");
                e.printStackTrace();
            }
        }
    }

    static void readFromFile(){
        try{
            Main.inputReader = new Scanner(csvFile, encoding);
            while(Main.inputReader.hasNextLine()){
                String line = Main.inputReader.nextLine();
                String[] parts = line.split(delimiter);
                String userName = parts[0].trim();
                int gamePoints = getInt(parts[1].trim());
                long gameTime = getLong(parts[2].trim());
                Result result = new Result(userName, gamePoints, gameTime);
                all.add(result);
            }
        } catch (Exception e) {
            System.out.println("Couldn't read results file!");
            e.printStackTrace();
        }
    }

    static void displayTop() {
        Result.readFromFile();
        Collections.sort(Result.all, new ResultComparator());
        Iterator i = Result.all.iterator();
        int place = 1;
        while (i.hasNext()) {
            Result r = (Result) i.next();
            System.out.println(place + ". " + r.playersName + " || " + r.points);
            place++;
        }
    }
    static int getInt(String string){
        try{
            return Integer.parseInt(string);
        } catch (Exception e) {
            return 0;
        }
    }

    static long getLong(String string) {
        try {
            return Long.parseLong(string);
        } catch (Exception e) {
            return 0;
        }
    }
}
