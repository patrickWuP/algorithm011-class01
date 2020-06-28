package com.sp.concurrent.algorithm;

class Solution_283 {
    public void moveZeroes(int[] nums) {
        //非零数据下标
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            //如果该数据为非零，则更新j下标数据
            if(nums[i] != 0) {
                nums[j] =  nums[i];
                if (i != j) {//如果i不等于j，说明前面有非零数据，i位置的数据已经更新至j，则i可以设置为0
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}
