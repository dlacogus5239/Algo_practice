package programmers;

import java.util.Arrays;

public class Solution0407_01 {
	class Solution {
	    public int solution(int[] people, int limit) {
	        int answer = 0;
	        // 오름차순 정렬
	        Arrays.sort(people);
	        
	        int start = 0;
	        int end = people.length - 1;
	        
	        while(start < end){
	            if(people[start] == -1){
	                start ++;
	            }
	            if(people[end] == -1){
	                end --;
	            }
	            int tmp = people[start] + people[end];
	            if(tmp <= limit){
	                people[start] = -1;
	                people[end] = -1;
	                start++;
	                end--;
	            }
	            else if(tmp > limit){
	                end--;
	            }
	        }
	        
	        int cnt = 0;
	        for(int i = 0; i < people.length; i++){
	            if(people[i] == -1){
	                cnt++;
	            }else{
	                answer++;
	            }
	        }
	        
	        answer +=  cnt /2;
	        
	        
	        return answer;
	    }
	}
}
