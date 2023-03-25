package programmers;

import java.util.Queue;
import java.util.LinkedList;

public class Solution0325_3 {
	class Solution {

	    public int solution(int cacheSize, String[] cities) {

	        Queue<String> caches = new LinkedList<>();
	        int time = 0;
	        if(cacheSize == 0){
	            return cities.length * 5;
	        }
	        for (String city : cities) {
	            String cityLowerCase = city.toLowerCase();
	            if (caches.contains(cityLowerCase)) { // 이미 존재하면
	                caches.remove(cityLowerCase); // 최신화
	                caches.offer(cityLowerCase);
	                time++;
	            } else {// 캐시 미스라면
	                if (caches.size() < cacheSize) { // 여유 공간이 있다면
	                    caches.offer(cityLowerCase);
	                } else { // 여유 공간이 없다면, 가장 먼저 참조된 페이지 삭제
	                    caches.poll();
	                    caches.offer(cityLowerCase);
	                }
	                time += 5;
	            }
	        }
	        
	        return time;
	    }
	}
}
