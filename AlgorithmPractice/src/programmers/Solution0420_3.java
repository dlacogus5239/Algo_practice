package programmers;

import java.util.Queue;
import java.util.ArrayDeque;

public class Solution0420_3 {

	class Solution {
	    public int solution(int[] queue1, int[] queue2) {
	        Queue<Integer> q1 = new ArrayDeque<>();
	        Queue<Integer> q2 = new ArrayDeque<>();
	        
	        long sum1 = 0L, sum2 = 0L;
	        long sum = 0L;
	        
	        for(int i = 0; i < queue1.length; i++){
	            q1.offer(queue1[i]);
	            q2.offer(queue2[i]);
	            sum1 += queue1[i];
	            sum2 += queue2[i];
	        }
	            // System.out.println(q1.toString());
	            // System.out.println(q2.toString());
	        
	        sum = sum1 + sum2;
	        
	        if(sum % 2 != 0){
	            return -1;
	        }
	        sum /= 2;
	        
	        int cnt1 = 0, cnt2 = 0;
	        int limit = queue1.length + queue2.length;
	        
	        while(cnt1 <= limit && cnt2 <= limit){
	            if(sum1 == sum){
	                return cnt1 + cnt2;
	            }
	            if(sum1 > sum){
	                sum1 -= q1.peek();
	                sum2 += q1.peek();
	                q2.offer(q1.poll());
	                cnt1++;
	            }else{
	                sum1 += q2.peek();
	                sum2 -= q2.peek();
	                q1.offer(q2.poll());
	                cnt2++;
	            }
	        }
	        
	        return -1;
	    }
	}
}
