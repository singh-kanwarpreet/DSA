class Solution {
    public int maxProduct(int[] nums) {   
      
      int pre = 1,suf = 1,ans = Integer.MIN_VALUE;
    
      for(int i = 0;i < nums.length;i++){
        suf *= nums[nums.length - i - 1];
        pre *= nums[i];
        ans = Math.max(ans,pre);
        ans = Math.max(ans,suf);
        if(pre == 0) pre = 1;
        if(suf == 0) suf = 1;
      }

      return ans;
    
    }
}
