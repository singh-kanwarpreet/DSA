class Solution {
    public int trap(int[] height) {
        int left = 0,right = height.length - 1,leftMax = 0,rightMax = 0,total = 0;
        while(left <= right){
            if(height[left] < height[right]){
                if(leftMax >= height[left]) total += leftMax - height[left];
                leftMax = Math.max(leftMax,height[left]);
                left++;
            }
            else{
                if(rightMax >= height[right]) total += rightMax - height[right];
                rightMax = Math.max(rightMax,height[right]);
                right--;
            }
        }
        return total;
    }
}
