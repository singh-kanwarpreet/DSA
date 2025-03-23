class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int pivot = -1;

        // Finding the pivot (point of rotation)
        while (low <= high) {
            int mid = (low + high) / 2;

            if (mid < high && nums[mid] > nums[mid + 1]) {
                pivot = mid;
                break;
            }
            if (mid > low && nums[mid - 1] > nums[mid]) {
                pivot = mid - 1;
                break;
            }

            if (nums[mid] <= nums[low] && nums[mid] < nums[high]) {
                high = mid - 1;
            } else if (nums[mid] == nums[low] && nums[mid] == nums[high]) {
                if(low < high && nums[low] > nums[low +1]){
                    pivot = low;
                    break;
                }
                low++;
                if(high > low &&  nums[high] < nums[high - 1]){
                    pivot = high -1;
                    break;
                }
                high--;
            } else {
                low = mid + 1;
            }
        }

        // If no pivot is found, perform a normal binary search
        if (pivot == -1) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }

        // Search in the left part of the array
        if (nums[0] <= target && target <= nums[pivot]) {
            return binarySearch(nums, 0, pivot, target);
        }

        // Search in the right part of the array
        return binarySearch(nums, pivot + 1, nums.length - 1, target);
    }

    private int binarySearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
