import java.util.* ;
import java.io.*; 
public class Solution {
    public static int pairSum(int arr[], int n, int target) {
        int start  = 0;
        int end = n - 1;
        int count = 0;
        while(start < end){
            if((arr[start] + arr[end]) == target){
                count++;
            }
            if((arr[start] + arr[end]) > target){
                end--;
            }
            else{
                start++;
            }
        }
        return ((count > 0)? count : -1);

    }
}
