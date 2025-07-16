class Solution {
    public int celebrity(int mat[][]) {
       int i = 0;
       int j = mat.length - 1;
       while(i < j){
           if(mat[i][j] == 1) i++;
           else if(mat[j][i] == 1) j--;
           else{
               i++;
               j--;
           }
       }
       for(int x = 0; x < mat.length;x++){
           if(x != i){
               if(mat[x][i] == 0 || mat[i][x] == 1) return -1;
           }
       }
       return i;
    }
}
