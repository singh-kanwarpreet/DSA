class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparingInt(row -> row[0]));
        ArrayList<int[]> ans = new ArrayList<>();
        int[] first = intervals[0];
        ans.add(first);
        for(int i = 1;i<intervals.length;i++){
            if(intervals[i][0] <= ans.get(ans.size() - 1)[1]){

                int a = Math.max(ans.get(ans.size() - 1)[1],intervals[i][1]);
                ans.get(ans.size() - 1)[1] = a;

            }
            else{

                ans.add(intervals[i]);

            }
        }
        
        return ans.toArray(new int[0][]);
    }
}
