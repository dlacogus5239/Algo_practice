package programmers;

import java.util.*;

// 프로그래머스 "순위 검색"
class Solution {
	static HashMap<String, ArrayList<Integer>> map;

	public int[] solution(String[] info, String[] query) throws NumberFormatException {
		int[] answer = new int[query.length];
		map = new HashMap<>();
		for (int i = 0; i < info.length; i++) {
			String[] cur = info[i].split(" ");
			String[] lan = { cur[0], "-" };
			String[] group = { cur[1], "-" };
			String[] career = { cur[2], "-" };
			String[] food = { cur[3], "-" };

			for (String l : lan) {
				for (String g : group) {
					for (String c : career) {
						for (String f : food) {
							String tmp = l + g + c + f;
							if (map.containsKey(tmp)) {
								map.get(tmp).add(Integer.parseInt(cur[4]));
							} else {
								ArrayList<Integer> list = new ArrayList<>();
								list.add(Integer.parseInt(cur[4]));
								map.put(tmp, list);
							}
						}
					}
				}
			}
		}
		// value 정렬
		for (String key : map.keySet()) {
			Collections.sort(map.get(key));
		}

		for (int i = 0; i < query.length; i++) {
			String[] que = query[i].replaceAll(" and ", " ").split(" ");
			String tmp = que[0] + que[1] + que[2] + que[3];
			int score = Integer.parseInt(que[4]);

			if (map.containsKey(tmp)) {
				// 1개일 경우?
				if (map.get(tmp).size() == 1) {
					if (score <= map.get(tmp).get(0)) {
						answer[i] = 1;
					}
				} else {
					// 점수가 같은 경우도 있으니까 이분탐색
					int left = 0;
					int right = map.get(tmp).size() - 1;
					int mid;
					while (left <= right) {
						mid = (left + right) / 2;
						if (map.get(tmp).get(mid) < score) {
							left = mid + 1;
						} else {
							right = mid - 1;
						}
					}
					answer[i] = map.get(tmp).size() - left;
				}
			}

		}

		return answer;
	}
}
