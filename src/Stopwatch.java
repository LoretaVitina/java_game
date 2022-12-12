public class Stopwatch {
    long startTime;
    long endTime;

    Stopwatch(){
    }

    void setStartTime(){
        this.startTime = System.currentTimeMillis();
    }

    void setEndTime(){
        this.endTime = System.currentTimeMillis();
    }

    void displayTimeSpentPlaying(){
        long time = (endTime - startTime)/1000;
        long minutes = time/60;
        long seconds = time%60;
        if(time/60 < 1)
            System.out.print(time + " seconds!");
        else{
            System.out.print(minutes + " minutes and " + seconds + " seconds!");
        }
    }
}
