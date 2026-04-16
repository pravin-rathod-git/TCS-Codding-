import java.util.HashMap;

public class FrequencyCount {

    // Function to calculate frequency of elements
    public static HashMap<Integer, Integer> Frequency(int[] arr) {

        // HashMap to store element (key) and its frequency (value)
        HashMap<Integer, Integer> map = new HashMap<>();

        // Traverse each element in the array
        for (int num : arr) {

            /*
             * IBH Logic:
             * Hypothesis: Assume map already contains frequency of previous elements
             * Induction: Update frequency of current element
             * Base: If element not present → default value = 0
             */

            // getOrDefault(num, 0) → returns current count or 0 if not present
            // Then we add 1 to increment frequency
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Return the frequency map
        return map;
    }

    // Main method to test the function
    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 3, 1, 4, 2};

        // Call the function
        HashMap<Integer, Integer> result = Frequency(arr);

        // Print the result
        System.out.println("Element Frequencies:");
        for (Integer key : result.keySet()) {
            System.out.println(key + " -> " + result.get(key));
        }
    }
}