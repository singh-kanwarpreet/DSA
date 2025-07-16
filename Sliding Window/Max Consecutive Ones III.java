class Solution {
    public int longestOnes(int[] nums, int k) {
        int pos = -1,ans = 0;
        for(int i = 0; i < nums.length;i++){
            if(k == 0 && nums[i] == 0){
                pos++;
                while(pos < nums.length && nums[pos] != 0) pos++;
                if(pos >= nums.length) return ans;
                k++;
                i--;
                continue;
            }
             if(pos == -1){
                ans = Math.max(ans,i + 1);
             }
             else {
              ans = Math.max(ans,i - pos);
              }

               if(nums[i] == 0) k--; 
        
        }
        return ans;
    }
}
