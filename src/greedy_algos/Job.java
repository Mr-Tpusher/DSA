package greedy_algos;

public class Job {
    int startTime;
    int endTime;

    Job(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Job{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
