package programmers;

import java.util.*;
import java.util.Map.Entry;

public class Solution0420_2 {

	class Solution {
	    // <조합, 나온 횟수> HashMap으로 구성
	    HashMap<String, Integer> map;
	    public ArrayList<String> solution(String[] orders, int[] course) {
	        ArrayList<String> answer = new ArrayList<>();
	        
	        // 각 문자열 오름차순 정렬
	        for(int i = 0; i < orders.length; i++){
	            char[] charArr = orders[i].toCharArray();
	            
	            Arrays.sort(charArr);
	            orders[i] = String.valueOf(charArr);
	        }
	        
	        // 필요한 길이만큼 조합을 구한다.
	        for(int i = 0; i < course.length;i++){
	            map = new HashMap<>();
	            
	            int max = Integer.MIN_VALUE;
	            
	            for(int j = 0; j < orders.length; j++){
	                StringBuilder sb = new StringBuilder();
	                if(course[i] <= orders[j].length()){
	                    comb(orders[j], sb, 0, 0, course[i]);
	                }
	            }
	            
	            for(Entry<String, Integer> entry : map.entrySet()){
	                max = Math.max(max, entry.getValue());
	            }
	            
	            for(Entry<String, Integer> entry : map.entrySet()){
	                if(max >= 2 && entry.getValue() == max){
	                    answer.add(entry.getKey());
	                }
	            }
	        }
	        
	        Collections.sort(answer);
	        
	        
	        return answer;
	    }
	    
	    public void comb(String str, StringBuilder sb, int idx, int cnt, int n){
	        
	        // 원하는 개수만큼 조합 완성
	        if (cnt == n){
	             map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
	            return;
	        }
	        
	        
	        // 조합 구할때 
	        // isSelected = true
	        // isSelected = false
	        // 동작을 sb에 붙였다 떼는걸로 구현
	        for(int i = idx; i< str.length(); i++){
	            sb.append(str.charAt(i));
	            
	            comb(str, sb, i + 1, cnt + 1, n);
	            
	            sb.delete(cnt, cnt + 1);
	        }
	    }
	}
}
