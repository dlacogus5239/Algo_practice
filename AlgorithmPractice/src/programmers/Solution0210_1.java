package programmers;

import java.util.*;

public class Solution0210_1 {
	public int[] solution(String msg) {
		Map<String, Integer> index = init();
		String[] arr = msg.split("");

		ArrayList<Integer> answer = compress(index, arr);
		return answer.stream().mapToInt(Integer::intValue).toArray();

	}

	public Map<String, Integer> init() {
		Map<String, Integer> index = new HashMap<>();
		for (int i = 65; i <= 90; i++) {
			index.put(Character.toString((char) i), i - 64);
		}

		return index;
	}

	public ArrayList<Integer> compress(Map<String, Integer> index, String[] arr) {
		ArrayList<Integer> answer = new ArrayList<>();
		int length = arr.length;

		for (int i = 0; i < length; i++) {
			StringBuilder sb = new StringBuilder();

			if (i >= length - 1) {
				answer.add(index.get(arr[i]));
				break;
			}

			while (i < length) {
				sb.append(arr[i]);
				if (index.containsKey(sb.toString())) {
					i++;
				} else {
					break;
				}
			}

			if (!index.containsKey(sb.toString())) {
				index.put(sb.toString(), index.size() + 1);
			}
			if (i != length) {
				sb.deleteCharAt(sb.length() - 1);
			}
			answer.add(index.get(sb.toString()));
			i--;
		}
		return answer;
	}
}
