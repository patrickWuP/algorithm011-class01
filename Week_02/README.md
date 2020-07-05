####学习笔记
1.遇到不会的情况，可以先将代码抄下来，先记下疑问点，根据疑问点去找答案，进行debug，照着题目图像（如果有的话），
边debug边想象，渐渐的待思路清晰，解法图清晰

2.关于HashSet为什么要使用PRESENT，我觉得是很有必要的，如下HashSet中的方法，如果不存放PRESENT，而是
null，那么remove方法无论删除成功与否都将返回true，造成方法返回结果的不正确性。
~~~ java
public boolean remove(Object o) {
        return map.remove(o)==PRESENT;
    }
~~~
3.HashMap的源码总结（jdk1.8）：
a.哈希函数加数组加链表/红黑树实现。

b.负载因子参数，控制数组列表元素的的稀疏度，减少hash碰撞的概率。

c.数组大小为2的次方，方便使用二进制&操作进行求模操作。

