import java.util.* ;
import java.io.*; 

public class Solution {
	
	public static long maxSubarraySum(int[] arr, int n) {
		long sum = Long.MIN_VALUE;
		long curr = 0;
		for(int i = 0; i < n;i++){
			curr += arr[i];
			sum = Math.max(curr,sum);
			if(curr < 0){
          curr = 0;
          }
		}
	   return 0;
	}

}
