class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int n = nums.length;
        reverse(nums,0,n - 1);
        reverse(nums,0,k - 1);
        reverse(nums,k,n - 1);
    //7 6 5 4 3 2 1
    //5 6 7 4 3 2 1
    //5 6 7 1 2 3 4
        
    }
    public static void reverse(int[] nums,int start,int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

    }
}
