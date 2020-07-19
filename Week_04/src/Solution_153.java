class Solution_153 {
    //暴力解法,O(n)
    public int findMin(int[] nums) {
        //长度为1或者，数组未翻转则返回第一个元素
        if(nums.length == 1 || nums[0] < nums[nums.length - 1]) return nums[0];
        //确定数组已翻转，则依次遍历数组，直到第一个单调递增失败处
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] > nums[i + 1]) return nums[i + 1];
        }
        return 0;
    }
    
    //二分查找法,O(logn)
    public int findMin(int[] nums) {
        //长度为1或者，数组未翻转则返回第一个元素
        if(nums.length == 1 || nums[0] < nums[nums.length - 1]) return nums[0];

        int start = nums[0];
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = ((right - left) >> 1) + left;
            if(nums[mid] > nums[mid + 1]) return nums[mid + 1];
            if(nums[mid] < nums[mid - 1]) return nums[mid];
            if(nums[mid] > start) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }
}