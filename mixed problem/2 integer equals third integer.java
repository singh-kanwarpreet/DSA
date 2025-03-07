import java.util.*;
import java.io.*; 

public class Solution {
    public static ArrayList<Integer> findTriplets(int[] arr, int n) {
        // Create an ArrayList to store the triplet (if found)
        ArrayList<Integer> list = new ArrayList<>();
        
        // Sort the array in non-decreasing order to enable two-pointer technique
        Arrays.sort(arr);
        
        // Iterate from the end of the array to the beginning.
        // We treat arr[i] as the candidate for c in the equation a + b = c.
        for (int i = n - 1; i >= 0; i--) {
            // Initialize two pointers:
            // j starts at the beginning (smallest element)
            // k starts just before i (largest element among remaining)
            int j = 0;
            int k = i - 1;
            
            // Use the two-pointer approach to find a pair (arr[j], arr[k])
            // such that their sum equals the candidate arr[i]
            while (j < k) {
                int sum = arr[j] + arr[k];
                
                // If the sum of arr[j] and arr[k] equals arr[i], we found our triplet
                if (sum == arr[i]) {
                    list.add(arr[i]);
                    list.add(arr[j]);
                    list.add(arr[k]);
                    return list;  // Return immediately once the triplet is found
                } 
                // If the sum is greater than the candidate, decrement k to try a smaller number
                else if (sum > arr[i]) {
                    k--;
                } 
                // If the sum is less than the candidate, increment j to try a larger number
                else {
                    j++;
                }
            }
        }
        // If no triplet is found, return the empty list
        return list;
    }
}
