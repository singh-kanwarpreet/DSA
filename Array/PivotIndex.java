class Solution {
    public int pivotIndex(int[] nums) {
        int ans = -1;
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        int left = 0;
        for (int i = 0; i < nums.length; i++) {

            left += nums[i];
            int right = total - left;

            if ((left - nums[i]) == right) {
                return i;
            }
        }
        return ans;
    }
}
