import java.util.*;

public class Question {
    HashMap<String, Country> options = new HashMap<>();
    Country correctAnswer;
    static String[] choices = {"A", "B", "C", "D"};
    HashSet<Country> selectedCountries = Country.getRandom();

    Question(){
        setCorrectAnswer();
        setOptions();
    }

    void setCorrectAnswer(){
        ArrayList<Country> arrayList = new ArrayList<Country>(selectedCountries);
        this.correctAnswer = arrayList.get(getRandomChoiceNumber());
    }

    static int getRandomChoiceNumber(){
        Random random = new Random();
        int number = random.nextInt(Question.choices.length);
        return number;
    }

    void setOptions() {
        options.put(choices[getRandomChoiceNumber()], correctAnswer);
        ArrayList<Country> arrayList = new ArrayList<Country>(selectedCountries);
        arrayList.remove(correctAnswer);
        while(!arrayList.isEmpty()){
                int num = getRandomChoiceNumber();
                if (options.containsKey(choices[num])) continue;
                Country countryToAdd = arrayList.get(0);
                options.put(choices[num], countryToAdd);
                arrayList.remove(countryToAdd);
        }
    }

    void displayOptions(){
        System.out.println("What is the capital of " + correctAnswer.name + "?");
        System.out.println("A: " + options.get("A").capital);
        System.out.println("B: " + options.get("B").capital);
        System.out.println("C: " + options.get("C").capital);
        System.out.println("D: " + options.get("D").capital);
    }

    boolean checkAnswer(){
        Main.inputReader = new Scanner(System.in);
        String answer = Main.inputReader.nextLine().trim().toUpperCase();
        if(correctAnswer.equals(options.get(answer)))
            return true;
        return false;
    }
}