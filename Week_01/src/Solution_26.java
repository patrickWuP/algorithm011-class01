package com.sp.concurrent.algorithm;

class Solution_26 {
    //双指针法
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int j = 1;j < nums.length;j++) {
            if(nums[i] != nums[j]){
                if(j - i >= 1){
                    nums[i + 1] = nums[j];//最差情况是自己赋值给自己,数据不会产生问题
                }
                i++;
            }
        }
        return i + 1;
    }
}
