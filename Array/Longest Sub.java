class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set  = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        int curr = 0,ans = 0,elem = 0;
        for(int i : set){
            if(!set.contains(i - 1)){
                elem = i;
                while(set.contains(elem)){
                    curr++;
                    elem++;
                }
                ans = Math.max(ans,curr);
                curr = 0;
            }
        }
        return ans;
    }
}
