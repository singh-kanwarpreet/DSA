class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] >= nums.length)
                continue;
            if ((nums[i] - 1) != i) {
                if (nums[nums[i] - 1] == nums[i])
                    continue;
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
                i--;
            }

        }
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] - 1) != i)
                return i + 1;
        }
        return nums.length + 1;
    }
}
