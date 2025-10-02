package dsa_2024_25.util;

import java.util.ArrayList;
import java.util.Arrays;

public class ValueFrequency {

    int value;
    int frequency;

    public ValueFrequency(int value, int frequency) {
        this.value = value;
        this.frequency = frequency;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public static ArrayList<ValueFrequency> generateValueFrequency(int[] Arr) {
        int[] A = Arrays.copyOf(Arr, Arr.length);
        Arrays.sort(A);
        ArrayList<ValueFrequency> vfList = new ArrayList<>();

        if (A.length == 0) {
            return vfList;
        }

        int prev = A[0];
        int freq = 1;
        for (int i = 1; i < A.length; i++) {
            int curr = A[i];
            if (curr == prev) {
                freq++;
            } else {
                ValueFrequency ValueFrequency = new ValueFrequency(prev, freq);
                vfList.add(ValueFrequency);
                prev = curr;
                freq = 1;
            }
        }
        ValueFrequency ValueFrequency = new ValueFrequency(prev, freq);
        vfList.add(ValueFrequency);

        return vfList;
    }


    @Override
    public String toString() {
        return "ValueFrequency{" + "value=" + value + ", frequency=" + frequency + '}';
    }
}