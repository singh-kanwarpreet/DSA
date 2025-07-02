class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        long n2 = (long)Math.pow(grid.length,2);
        long sum = (n2*(n2 + 1))/2;
        long sumSquare = (n2*(n2 + 1)*(2*n2+1))/6;
        long realSum = 0;
        long realSumSquare = 0;
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                realSum += grid[i][j];
            }
        }
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                realSumSquare += (grid[i][j] * grid[i][j]);
            }
        }

        realSumSquare = sumSquare - realSumSquare;
        realSum = sum - realSum;
        realSumSquare /= realSum;
        realSumSquare -= realSum;
        int[] ans = new int[2];
        ans[0] = (int)realSumSquare/2;
        ans[1] = (int)(realSum + ans[0]);
        return ans;
    }
}
