package greedy_algos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
* Given start and end time of N jobs, find the maximum number of jobs you can complete.
* At any point of time t, there could only be one job running, and you cannot start next
* job until the current one finishes.
* start = {1, 5, 7, 2}
* end   = {7, 8, 8, 8}
* answer = 2
* */
public class JobsScheduling {
    public static void main(String[] args) {
        int[] start = {0, 1, 5, 7, 2, 8, 8, 9, 10, 7};
        int[] end = {10, 7, 8, 8, 8, 15, 10, 10, 12, 10};

        JobsScheduling j = new JobsScheduling();
        List<Job> jobs = j.getJobList(start, end);

        int maxJobs = scheduleMaxJobs(jobs);
        System.out.println(maxJobs);

    }

    private static int scheduleMaxJobs(List<Job> jobs) {
        int maxJobs = 0;
        int lastJobEndTime = 0;

        jobs.sort(new JobEndTimeComparator());

        for (Job job : jobs) {
            if (job.startTime >= lastJobEndTime) {
                maxJobs++;
                lastJobEndTime = job.endTime;
                System.out.println(job);
            }
        }
        return maxJobs;
    }


    ArrayList<Job> getJobList(int[] startTime, int[] endTime) {
        ArrayList<Job> jobs = new ArrayList<>();

        for (int i = 0; i < startTime.length; i++) {
            jobs.add(new Job(startTime[i], endTime[i]));
        }
        return jobs;
    }

}




class JobEndTimeComparator implements Comparator<Job> {

    @Override
    public int compare(Job job1, Job job2) {
        int endTimeCompare = Integer.compare(job1.endTime, job2.endTime);
        if (endTimeCompare != 0) {
            return endTimeCompare;
        }

        return Integer.compare(job1.startTime, job2.startTime);
    }
}
