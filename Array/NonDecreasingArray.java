class Solution {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i+1]) {  // Violation detected.
                if (i == 0 || nums[i-1] <= nums[i+1]) {
                    // Lower the current element.
                    nums[i] = nums[i+1];
                } else {
                    // Raise the next element.
                    nums[i+1] = nums[i];
                }
                count++;
            }
            if (count > 1) return false;  // Early exit if more than one modification is needed.
        }
        return true;
    }
}
