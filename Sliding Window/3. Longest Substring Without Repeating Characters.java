class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0,ans = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                int index = map.get(c);
                start = Math.max(index + 1,start);
                map.put(c,i);
            }
            else{
                map.put(c,i);
            }
            ans = Math.max(ans,i - start + 1);
        }
        return ans;
    }
}
