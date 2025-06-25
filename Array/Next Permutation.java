class Solution {
    public void nextPermutation(int[] nums) {
        int diff = -1;
        for(int i = nums.length - 1;i > 0;i--){
            if(nums[i] > nums[i - 1]){
                diff = i - 1;
                break;
            }
        }
       if(diff >= 0) {for(int i = nums.length - 1;i > diff ;i--){
            if(nums[diff] < nums[i]){
                int temp = nums[diff];
                nums[diff] = nums[i];
                nums[i] = temp;
                break;
            }
        }}
        int i = diff + 1,j = nums.length -1;
            while(i <= j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
       
        
    }
}
