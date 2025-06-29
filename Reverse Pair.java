class Solution {
    int ans = 0;
    public int reversePairs(int[] nums) {
        divide(nums,0,nums.length - 1);
        return ans;
    }
    
    public void divide(int[] arr,int i,int j){
        if(i >= j) return;
        int mid = (i + j)/2;
        divide(arr,i,mid);
        divide(arr,mid + 1,j);
        int high = mid + 1;
        for(int low = i;low <= mid;low++){
            while(high <= j && (long)arr[low] > (2L * arr[high])){
                ans += (mid - low + 1);
                high++;
            }
        }
        merge(arr,i,mid,j);
    }

    public void merge(int[] arr,int i,int mid,int j){
        ArrayList<Integer> list = new ArrayList<>();
        int low = i,high = mid + 1;

        while(low <= mid && high <= j){
            if(arr[low] > arr[high]){
                list.add(arr[high]);
                high++;
            }
            else{
                list.add(arr[low]);
                low++;
            }
        }

        while(low <= mid){
                list.add(arr[low]);
                low++;
        }

        while(high <= j){
                list.add(arr[high]);
                high++;
        }

        for(int x = 0;x < list.size();x++){
            arr[i + x] = list.get(x);
        }
    }
}
