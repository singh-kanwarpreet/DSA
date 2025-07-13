class Solution {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        long ans = 0;
        for(int i = 0;i < arr.length;i++){
            int count = 1;
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
             
                count += left[st.pop()];
            }
            left[i] = count;
            st.push(i);
        } 


        st.clear();
        for(int i = arr.length - 1;i >= 0;i--){
            int count = 1;
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                
                count += right[st.pop()];
            }
            right[i] = count;
            st.push(i); 
        } 
        for(int i = 0;i < arr.length;i++){
            ans =  (ans + (long) arr[i] * left[i] * right[i]) % (long)((Math.pow(10,9) + 7));
        }
return (int)(ans);

    }
}
