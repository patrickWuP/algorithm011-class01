###学习笔记
####BFS广度优先算法
a.广度优先算法，处理树的层级遍历问题；使用队列+for loop写法实现。

重点：使用队列时，脑海中可以想象一个简单层级的节点进队列和出队列的效果，即是树的层级遍历效果。
    完整遍历每一层，还使用到了queue的size进行处理，同时新的节点放入到queue中。
    
####DFS深度优先算法
a.深度优先算法，记录树的层级接口；使用递归实现。
   
    
    
####贪心算法
a.适用场景：简单地说，问题能够分解成子问题来解决，子问题的最优解能递推到最终问题的最优解。这种子问题最优解称为最优子结构。

能够证明贪心算法能获取到全局最优解；贪心的角度比较巧妙（从前往后，从后往前等）。

b.贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，不能回退。动态规划则会保存以前的运算结果，并根据以前的结果
对当前进行选择，有回退功能。
    
####二分查找的前提
1.目标函数单调性（单调递增或者递减）

2.存在上下界（bounded）

3.能够通过索引访问（index accessible）
    

#####使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方

````
/** 
    查找原理，翻转过的数组，data[0] < data[last]
    查找的点为，右半部分数组的第一个元素的索引，即为返回值
    mid > data[0];left = mid + 1;
    mid < data[0];right = mid - 1;
**/
private int findIndex(int[] data) {
    int left = 0;
    int right = n - 1;
    int start = data[0];//第一个元素值
    
    while (left <= right) {
        int mid = ((right - left) >> 1) + left;
        if (data[mid] < data[mid - 1]) {
            return mid;
        } 
        if (data[mid] > start) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return -1;
}

//测试数据:
public static void main(String[] args) {
    System.out.println(new Recursive().findIndex(new int[]{}));//空数组
    System.out.println(new Recursive().findIndex(new int[]{4,5,6,7}));//未翻转的数组
    System.out.println(new Recursive().findIndex(new int[]{4,5,6,7,0,1,2}));//正常数组
}