import java.util.*;

public class SecondSmallestLargest {

    public List<Integer> SecSmallLarg(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int n = arr.length;

        // Base case: if array has less than 2 elements
        if (n < 2) {
            return list; // cannot find second smallest/largest
        }

        /*
         * IBH Explanation:
         * Hypothesis: We maintain 4 variables (largest, secLargest, smallest, secSmallest)
         * Induction: Update them while traversing the array
         * Base: Initially set extreme values
         */

        int largest = Integer.MIN_VALUE;
        int secLargest = Integer.MIN_VALUE;

        int smallest = Integer.MAX_VALUE;
        int secSmallest = Integer.MAX_VALUE;

        for (int num : arr) {

            // ===== Largest & Second Largest =====
            if (num > largest) {
                secLargest = largest; // shift previous largest
                largest = num;
            } 
            else if (num > secLargest && num != largest) {
                secLargest = num;
            }

            // ===== Smallest & Second Smallest =====
            if (num < smallest) {
                secSmallest = smallest; // shift previous smallest
                smallest = num;
            } 
            else if (num < secSmallest && num != smallest) {
                secSmallest = num;
            }
        }

        // Handle edge case where second values don't exist
        if (secLargest == Integer.MIN_VALUE || secSmallest == Integer.MAX_VALUE) {
            return list; // means no valid second smallest/largest
        }

        list.add(secLargest);
        list.add(secSmallest);

        return list;
    }
} 