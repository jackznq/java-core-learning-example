package org.javacore.leetCode.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Date 18/11/29 下午10:31
 * @Auther znq
 * @ClassName SlidingWindowMaximum
 **/
public class SlidingWindowMaximum {


    //双端队列初始化
    private  Deque deque;
    /**
     * 239. Sliding Window Maximum
     * 解法:用有限队列或者双端队列
     * @see java.util.PriorityQueue
     * @see java.util.Deque
     * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null) return null;
        int[] resultNums ={nums.length};
        deque= new LinkedBlockingDeque(k);
        for (int i = 0;i<nums.length;i++){
            if (deque.size()<k){
                deque.add(nums[i]);
            }

        }
        return resultNums;
    }

    public static void main(String[] args) {
        Deque deque =  new ArrayDeque();
        deque.add(3);
        deque.add(10);
        deque.add(5);
        deque.add(6);
        deque.add(20);
        while (!deque.isEmpty()){
            System.out.println(deque.pop());
        }
    }
}
