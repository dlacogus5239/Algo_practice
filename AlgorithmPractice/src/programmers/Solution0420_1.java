package programmers;

import java.util.*;

public class Solution0420_1 {

	class Solution {
	    class File implements Comparable<File>{
	        String HEAD;
	        String NUMBER;
	        String TAIL;
	        
	        public File(String HEAD, String NUMBER, String TAIL){
	            this.HEAD = HEAD;
	            this.NUMBER = NUMBER;
	            this.TAIL = TAIL;
	        }
	        
	        public int compareTo(File o){
	            
	            
	            if(this.HEAD.compareToIgnoreCase(o.HEAD) == 0){
	                int num1 = Integer.parseInt(this.NUMBER);
	                int num2 = Integer.parseInt(o.NUMBER);
	                return num1 - num2; 
	            }else{
	                return this.HEAD.compareToIgnoreCase(o.HEAD);
	            }
	            
	        }
	        public String toString(){
	            return HEAD + NUMBER + TAIL;
	        }
	        
	    }
	    public String[] solution(String[] files) {
	        String[] answer = new String[files.length];
	        File[] arr = new File[files.length];
	        StringTokenizer st;
	        
	        // File 객체로 HEAD, NUMBER, TAIL 나눔
	        for(int i = 0; i < files.length; i++){
	            char[] cur = files[i].toCharArray();
	            String head = "", number = "", tail = "";
	            int idx = 0;
	            while(!Character.isDigit(cur[idx])){
	                head += cur[idx];
	                idx++;
	                if(idx >= cur.length){
	                    break;
	                }
	            }
	            while(Character.isDigit(cur[idx])){
	                number += cur[idx];
	                idx++;
	                if(idx >= cur.length){
	                    break;
	                }
	            }
	            
	            while(idx < cur.length){
	                tail += cur[idx];
	                idx++;
	            }
	            arr[i] = new File(head, number, tail);
	            
	            
	        }
	        
	        // comparable 이용해서 정렬
	        Arrays.sort(arr);
	        
	        for(int i = 0; i < arr.length; i++){
	            answer[i] = arr[i].toString();
	        }
	        
	        return answer;
	    }
	}
}
