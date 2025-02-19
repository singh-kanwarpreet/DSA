public class Solution {
    public static int makeBeautiful(String str) {
        int count1 = 0;
        int count2 = 0;
        for(int i = 0;i<str.length();i++){
           char a =  (i % 2 == 0?'0':'1');
           char b =  (i % 2 == 0?'1':'0');
           char c = str.charAt(i);
           if(c != a) count1++;
           if(c != b) count2++;

        }
        return Math.min(count1,count2);
    }
}
