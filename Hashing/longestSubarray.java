class Solution {
    public int longestSubarray(int[] arr, int k) {
        
        // HashMap to store prefix sum and its first occurrence index
        HashMap<Integer,Integer> st = new HashMap<>();
        
        // Initial condition: sum 0 at index -1 (helps handle cases where subarray starts from index 0)
        st.put(0, -1); 
        
        int sum = 0;  // Stores the cumulative sum
        int max = 0;  // Stores the length of the longest subarray with sum k
        
        for(int i = 0; i < arr.length; i++) {
            
            sum += arr[i];  // Update cumulative sum
            
            // Check if (sum - k) exists in the map, which means a subarray with sum k is found
            if(st.containsKey(sum - k)) {
                int curr = i - st.get(sum - k); // Calculate subarray length
                max = Math.max(curr, max);  // Update max length if the current one is longer
            }
            
            // Store the first occurrence of this cumulative sum (to ensure longest subarray is found)
            if(!st.containsKey(sum)) {
                 st.put(sum, i);
            }
        }
        
        return max; // Return the longest subarray length found
    }
}

