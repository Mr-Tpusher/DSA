package revision_oct2025.greedy_algo;

import dsa_2024_25.greedy_algos.JobsScheduling;

import java.util.Arrays;
import java.util.Comparator;

/*
* Start and end times of N jobs has been given.
* At any point of time t, there could only be one job running, and you cannot start next job until the current one
* finishes.
* Find the max number of jobs you can complete.
* start = {1, 5, 7, 2}
* end   = {7, 8, 8, 8}
* answer = 2
*
* */
public class MaxJobs {
    public static void main(String[] args) {
        int[] start = {1, 5, 7, 2};
        int[] end   = {7, 8, 8, 8};

        Job[] jobs = new Job[start.length];

        for (int i = 0; i < start.length; i++) {
            jobs[i] = new Job(start[i], end[i]);
        }

        Arrays.sort(jobs, Comparator.comparingInt((Job j) -> j.end));

        System.out.println(getMaxJobs(jobs));
    }

    private static int getMaxJobs(Job[] jobs) {
        int prevEnd = 0;
        int maxJobs = 0;
        for (Job job : jobs) {
            if (job.start >= prevEnd) {
                maxJobs++;
                prevEnd = job.end;
            }
        }
        return maxJobs;
    }

    private static class Job {
        int start;
        int end;
        Job(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
