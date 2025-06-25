class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int ans1 = 0, ans2 = 1;     
        int curr1 = 0, curr2 = 0;

        // 1) find the two potential candidates
        for (int x : nums) {
            if (x == ans1) {
                curr1++;
            }
            else if (x == ans2) {
                curr2++;
            }
            else if (curr1 == 0) {
                ans1 = x;
                curr1 = 1;
            }
            else if (curr2 == 0) {
                ans2 = x;
                curr2 = 1;
            }
            else {
                curr1--;
                curr2--;
            }
        }

        // 2) verify which candidate(s) really occur > n/3 times
        List<Integer> res = new ArrayList<>();
        curr1 = curr2 = 0;
        for (int x : nums) {
            if (x == ans1) curr1++;
            else if (x == ans2) curr2++;
        }
        int threshold = nums.length / 3;
        if (curr1 > threshold) res.add(ans1);
        if (curr2 > threshold) res.add(ans2);

        return res;
    }
}
