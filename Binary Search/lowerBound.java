class Solution {
    int lowerBound(int[] arr, int target) {
        int i = 0, j = arr.length - 1;

        // First binary search: Tries to find the first occurrence of 'target'
        while (i <= j) {
            int mid = (i + j) / 2;

            if (arr[mid] == target) {
                // If there are duplicates, move left to find the first occurrence
                if (mid > 0 && arr[mid - 1] == arr[mid]) { 
                    j = mid - 1;  // Shrink the right boundary
                } else {
                    return mid; // Found the first occurrence
                }
            } 
            else if (arr[mid] > target) {
                j = mid - 1; // Search in the left half
            } 
            else {
                i = mid + 1; // Search in the right half
            }
        }

        // Reset search space for the second binary search
        i = 0;
        j = arr.length - 1;

        // Second binary search: Finds the position where 'target' would be inserted
        while (i <= j) {
            int mid = (i + j) / 2;
            if (arr[mid] > target) {
                j = mid - 1; // Move left
            } else {
                i = mid + 1; // Move right
            }
        }
        
        // Return the index where 'target' should be inserted if not found
        return i;
    }
}
