package programmers;

import java.util.StringTokenizer;

public class Solution0420_4 {

	class Solution {
	    class Music{
	        int minute;
	        String name;
	        // 음계정보
	        String scale;
	        
	        public Music(int minute, String name, String scale){
	            this.minute = minute;
	            this.name = name;
	            
	            if(minute <= scale.length()){
	                this.scale = scale.substring(0, minute);
	            }else{
	                int idx = minute - scale.length();
	                String tmp = scale;
	                while(idx > scale.length()){
	                    tmp += scale;
	                    idx -= scale.length();
	                }
	                
	                tmp += scale.substring(0, idx);
	                
	                this.scale = tmp;
	            }
	        }
	        
	        public String toString(){
	            return "[minute : " + minute + ", name : " + name + ", scale : " + scale + "]";
	        }
	    }
	    
	    
	    public String solution(String m, String[] musicinfos) {
	        String answer = "";
	        int maxMin = Integer.MIN_VALUE;
	        StringTokenizer st;
	        
	        m = m.replaceAll("C#", "1");
	        m = m.replaceAll("D#", "2");
	        m = m.replaceAll("F#", "3");
	        m = m.replaceAll("G#", "4");
	        m = m.replaceAll("A#", "5");
	        // C# => 1
	        // D# => 2
	        // F# => 3
	        // G# => 4
	        // A# => 5
	        // 로 치환해서 문자열 검사
	        Music[] info = new Music[musicinfos.length];
	        for(int i = 0; i < musicinfos.length; i++){
	            st = new StringTokenizer(musicinfos[i], ",");
	            String start = st.nextToken();
	            String end = st.nextToken();
	            String name = st.nextToken();
	            String scale = st.nextToken();
	            
	            scale = scale.replaceAll("C#", "1");
	            scale = scale.replaceAll("D#", "2");
	            scale = scale.replaceAll("F#", "3");
	            scale = scale.replaceAll("G#", "4");
	            scale = scale.replaceAll("A#", "5");
	            
	            info[i] = new Music(ConvertMinute(start,end), name, scale);
	            // System.out.println(info[i].toString());
	        }
	        
	        for(int i = 0; i < info.length; i++){
	            if(info[i].scale.indexOf(m) != -1){
	                if(info[i].minute > maxMin){
	                    maxMin = info[i].minute;
	                    answer = info[i].name;
	                }
	            }
	        }
	        
	        return  answer.equals("") ? "(None)" : answer;
	    }
	    public int ConvertMinute(String start, String end){
	        StringTokenizer st1 = new StringTokenizer(start, ":");
	        StringTokenizer st2 = new StringTokenizer(end, ":");
	        
	        int startHour = Integer.parseInt(st1.nextToken());
	        int startMinute = Integer.parseInt(st1.nextToken());
	        
	        int endHour = Integer.parseInt(st2.nextToken());
	        int endMinute = Integer.parseInt(st2.nextToken());
	        
	        return (endHour - startHour) * 60 + endMinute - startMinute;
	        
	    }
	}
}
