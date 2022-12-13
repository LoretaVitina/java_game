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

    long calculateTimeSpentPlaying(){
        long time = (endTime - startTime)/1000;
        return time;
    }

    void displayTimeSpentPlaying(long time){
        long minutes = time/60;
        long seconds = time%60;
        if(time/60 < 1)
            System.out.print(time + " seconds!");
        else{
            System.out.print(minutes + " minutes and " + seconds + " seconds!");
        }
    }
}
