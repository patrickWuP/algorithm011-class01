package com.sp.concurrent.algorithm;

public class Solution_42 {
    public int trap(int[] height) {
        //双指针 时间复杂度O(n),空间复杂度O(1)
        //左右夹逼法，细节那一方更高，则移动另一方，
        int sum = 0;
        int maxLeft = 0;
        int maxRight = 0;
        int left = 1;//当前左柱子
        int right = height.length - 2;//当前右柱子
        for (int i = 1; i < height.length - 1;i++) {
            //左边界高度大于右边界高度
            if (height[left - 1] > height[right + 1]) {
                maxRight = Math.max(height[right + 1], maxRight);
                //符合条件开始计算接水量
                if (height[right] < maxRight) {
                    sum = sum + maxRight - height[right];//此时左边界肯定大于右边界
                }
                right--;
            } else {
                maxLeft = Math.max(height[left - 1], maxLeft);
                if (maxLeft > height[left]) {
                    sum = sum + maxLeft - height[left];
                }
                left++;
            }
        }

        return sum;
    }
}
