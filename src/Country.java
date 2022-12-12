import java.io.File;
import java.util.*;

public class Country {
    String name;
    String capital;
    static ArrayList<Country> all = new ArrayList<Country>();
    static String filePath = "/Users/loretavitina/IdeaProjects/Geogame/countries.csv";
    static File csvFile = new File(filePath);
    static String encoding = "UTF-8";
    static String delimiter = ",";
    static String unusableData = "N/A";
    static String unusableContinent = "Antarctica";

    Country(String name, String capital){
        this.name = name;
        this.capital = capital;
        all.add(this);
    }

    public String toString(){
        return this.name + " has " + this.capital;
    }

    static void readInFromFile(){
        try {
            Main.inputReader = new Scanner(csvFile, encoding);
            Main.inputReader.nextLine();
            while (Main.inputReader.hasNextLine()) {
                String line = Main.inputReader.nextLine();
                String[] parts = line.split(delimiter);
                if (parts[1].trim().equals(unusableData) || parts[5].trim().equals(unusableContinent)) continue;
                String name = parts[0].trim();
                String capital = parts[1].trim();
                Country country = new Country(name, capital);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static HashSet<Country> getRandom(){
        HashSet<Country> randomlySelected = new HashSet<>();
        while(randomlySelected.size() != Question.choices.length){
            randomlySelected.add(Country.all.get(getRandomCountryNumber()));
        }
        return randomlySelected;
    }

    static int getRandomCountryNumber(){
        Random random = new Random();
        int number = random.nextInt(Country.all.size());
        return number;
    }
}
/*
static void readInFromFile(){
        try {
            Scanner fileReader = new Scanner(csvFile, encoding);
            fileReader.nextLine();
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] parts = line.split(delimiter);
                if (parts[1].trim().equals(unusableData) || parts[5].trim().equals(unusableContinent)) continue;
                String name = parts[0].trim();
                String capital = parts[1].trim();
                Country country = new Country(name, capital);
            }
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 */