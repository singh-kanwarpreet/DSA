class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        for(int i = 0;i < heights.length;i++){
            int count = 0;
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                int curr = st.pop();
                int nse = i;
                int pse = !st.isEmpty() ?st.peek() : -1;
                count  = nse - pse - 1;
                ans = Math.max(ans,count * heights[curr]);
            }
            st.push(i);
        }
        int nse = heights.length;
        while(!st.isEmpty()){
                int curr = st.pop();
                int pse = !st.isEmpty() ? st.peek() : -1;
                int count  = nse - pse - 1;
                ans = Math.max(ans,count * heights[curr]);
        }
        return ans;
    }
}
