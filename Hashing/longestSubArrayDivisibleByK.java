class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // Create a HashMap to store frequency counts of prefix sum remainders.
        // Key: remainder value (prefix sum % k), Value: count of occurrences.
        HashMap<Integer, Integer> map = new HashMap<>();
        // Initialize the map with remainder 0 occurring once.
        // This accounts for any subarray that directly sums to a multiple of k.
        map.put(0, 1);

        int length = 0; // Will hold the count of valid subarrays.
        int sum = 0;    // Running prefix sum.

        // Traverse through the array.
        for (int i = 0; i < nums.length; i++) {
            // Update the running sum with the current element.
            sum += nums[i];

            // Compute the remainder of the current sum modulo k.
            int remainder = sum % k;
            // If remainder is negative, adjust it to be within [0, k-1].
            if (remainder < 0) {
                remainder += k;
            }

            // If this remainder has been seen before,
            // it means there are subarrays ending at the current index with a sum divisible by k.
            if (map.containsKey(remainder)) {
                // Add the number of times this remainder has appeared to our count.
                length += map.get(remainder);
            }

            // Update the frequency of the current remainder in the map.
            // Check if the remainder is already a key in the map.
            if (map.containsKey(remainder)) {
                int val = map.get(remainder);
                map.put(remainder, val + 1);
            } else {
                map.put(remainder, 1);
            }
        }
        // Return the total count of subarrays whose sums are divisible by k.
        return length;
    }
}
