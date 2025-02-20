class Solution {
    // This method finds the nearest palindromic number to the input string 'n'.
    public String nearestPalindromic(String n) {
        // Get the length of the input number
        int length = n.length();
        // Convert the input string to a long for numerical operations
        long original = Long.parseLong(n);
        
        // Calculate the half-length of the string.
        // For odd lengths, this includes the middle digit.
        int half = (int) Math.ceil(length / 2.0);
        
        // Extract the first half of the string (this is our "prefix")
        String str = n.substring(0, half);
        // Convert the prefix to a long
        long prefix = Long.parseLong(str);
        
        // Determine if the input has an even number of digits
        boolean even = (length % 2 == 0);
        
        // Create a list to store candidate palindromic numbers
        ArrayList<Long> res = new ArrayList<>();
        // Generate candidate palindromes by adjusting the prefix:
        res.add(increement(prefix, even));  // Candidate by incrementing the prefix
        res.add(decreement(prefix, even));  // Candidate by decrementing the prefix
        res.add(same(prefix, even));         // Candidate using the same prefix
        
        // Add edge-case candidates:
        res.add(nines(length));   // Candidate for a number with one extra digit (e.g., 100...001)
        res.add(hundreds(length)); // Candidate for a number with one fewer digit (e.g., 99...9)
        
        // Initialize variables to keep track of the closest palindrome
        long ans = -1;
        long minDiff = Long.MAX_VALUE;
        
        // Iterate over each candidate to find the closest palindrome
        for (int i = 0; i < res.size(); i++) {
            long candidate = res.get(i);
            // Skip the candidate if it is exactly the original number
            if (candidate == original)
                continue;
            // Calculate the absolute difference between candidate and original
            long diff = Math.abs(candidate - original);
            // Update answer if a closer candidate is found.
            // In case of a tie, choose the smaller candidate.
            if (diff < minDiff || (diff == minDiff && candidate < ans)) {
                minDiff = diff;
                ans = candidate;
            }
        }
        // Return the closest palindromic number as a string
        return Long.toString(ans);
    }
    
    // Generates a palindrome candidate by incrementing the prefix.
    // It mirrors the digits of the new prefix to form the palindrome.
    public static Long increement(long num, boolean even) {
        num++; // Increment the prefix value
        long res = num; // Start with the new prefix for constructing the palindrome
        long temp = num;  // Use a temporary variable to reverse the number
        
        if (even) {
            // For even-length numbers, mirror the entire prefix
            while (temp > 0) {
                long digit = temp % 10;  // Get the last digit
                res = res * 10 + digit;  // Append the digit to the result
                temp /= 10;              // Remove the last digit
            }
        } else {
            // For odd-length numbers, drop the last digit (middle digit) before mirroring
            temp /= 10;
            while (temp > 0) {
                long digit = temp % 10;
                res = res * 10 + digit;
                temp /= 10;
            }
        }
        return res;
    }
    
    // Generates a palindrome candidate by decrementing the prefix.
    // It mirrors the digits of the new prefix to form the palindrome.
    public static Long decreement(long num, boolean even) {
        num--; // Decrement the prefix value
        long res = num; // Start with the new prefix
        long temp = num;  // Temporary variable for reversal
        
        if (even) {
            // Mirror the entire prefix for even-length numbers
            while (temp > 0) {
                long digit = temp % 10;
                res = res * 10 + digit;
                temp /= 10;
            }
        } else {
            // For odd-length numbers, drop the last digit before mirroring
            temp /= 10;
            while (temp > 0) {
                long digit = temp % 10;
                res = res * 10 + digit;
                temp /= 10;
            }
        }
        return res;
    }
    
    // Generates a palindrome candidate using the same prefix (no increment/decrement).
    // It mirrors the digits of the prefix to form the palindrome.
    public static Long same(long num, boolean even) {
        long res = num; // Start with the original prefix
        long temp = num; // Temporary variable for reversal
        
        if (even) {
            // For even-length numbers, mirror the entire prefix
            while (temp > 0) {
                long digit = temp % 10;
                res = res * 10 + digit;
                temp /= 10;
            }
        } else {
            // For odd-length numbers, drop the last digit before mirroring
            temp /= 10;
            while (temp > 0) {
                long digit = temp % 10;
                res = res * 10 + digit;
                temp /= 10;
            }
        }
        return res;
    }
    
    // Generates an edge-case candidate for the next palindromic number with one extra digit.
    // For example, for an input like "99", this will return "101".
    public static Long nines(int len) {
       // Compute 10^len and then add 1.
       // For len=2, 10^2 = 100, so result is 100 + 1 = 101.
       Long nines = (long)Math.pow(10, len) + 1;
       return nines;
    }
    
    // Generates an edge-case candidate for the palindromic number with one fewer digit.
    // For example, for an input like "100", this will return "99".
    public static Long hundreds(int len) {
       // Compute 10^(len-1) and then subtract 1.
       // For len=3, 10^(3-1)=100, so result is 100 - 1 = 99.
       Long hundreds = (long)Math.pow(10, len - 1) - 1;
       return hundreds;
    }
}
