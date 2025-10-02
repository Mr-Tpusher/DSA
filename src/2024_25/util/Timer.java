package util;

public class Timer {
    private long startTime;
    private long endTime;

    public Timer() {
        reset();
    };

    public void reset() {
        startTime = 0;
        endTime = 0;
    }

    // Start the TImer
    public void start() {
        startTime = System.nanoTime();
    }

    // stop the Timer
    public void stop() {
        endTime = System.nanoTime();
    }

    // Calculate Elapsed Time
    public long getElapsedTimeMillis() {
        return (endTime - startTime) / 1000000;
    }

    public long getElapsedTimeNano() {
        return endTime - startTime;
    }

    public String getElapsedTime() {
        long durationInNanoseconds = getElapsedTimeNano();
        double durationInMilliseconds = getElapsedTimeMillis();
        return String.format("Time taken: %d nanoseconds (%.3f milliseconds)", durationInNanoseconds, durationInMilliseconds);
    }

    // Print the elapsed time
    public void printElapsedTime() {
        long durationInNanoseconds = getElapsedTimeNano();
        double durationInMilliseconds = getElapsedTimeMillis();
        System.out.printf("Time taken: %d nanoseconds (%.3f milliseconds)%n", durationInNanoseconds, durationInMilliseconds);
    }

}
