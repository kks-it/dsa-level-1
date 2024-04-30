
import java.util.PriorityQueue;

public class _1FindKthLargestElementLC {
    
}

// Questiion Link: https://leetcode.com/problems/kth-largest-element-in-an-array/

// -> Improvement: make PriorityQueue of lenth k. so that we dont' need to remove from pq. also time complexity will be 
//                 n* log(k)  instead of n * log(n).

// --> do it using quick select also

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        for(int num: nums){
            pq.add(num);
        }

        for(int i = 1; i < k; i++){
            pq.remove();
        }

        return pq.remove();
    }
}