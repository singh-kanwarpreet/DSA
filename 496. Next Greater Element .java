class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }
        Stack<Integer> st = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop();
            }
            if (map.containsKey(nums2[i])) {
                int index = map.get(nums2[i]);
                nums1[index] = (!st.isEmpty()) ? st.peek() : -1;
            }
            st.push(nums2[i]);
        }
        return nums1;

    }
}
