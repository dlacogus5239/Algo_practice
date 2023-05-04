package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main7662 {
	// 백준 7662 이중 우선순위 큐
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		// test case Start
		for (int t = 0; t < T; t++) {
			int k = Integer.parseInt(br.readLine());

			// 전체 수를 저장할 Map
			// TreeMap 자료구조 살펴보기 --> 이중 우선순위 큐와 같이 동작한다
			TreeMap<Integer, Integer> map = new TreeMap<>();
			for (int i = 0; i < k; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				// 연산
				// 삽입 : I
				// 삭제 : D
				String operation = st.nextToken();

				// 값
				// 삽입 : 삽입할 값
				// 삭제 : (최솟값 -1 , 최대값 1)
				int val = Integer.parseInt(st.nextToken());

				try {
					// 삽입
					if (operation.equals("I")) {
						map.put(val, map.getOrDefault(val, 0) + 1);
					} else {
						// 최솟값 삭제
						if (val == -1) {
							int cur = map.firstKey();
							map.replace(cur, map.get(cur) - 1);
							if (map.get(cur) == 0) {
								map.remove(cur);
							}
						}
						// 최댓값 삭제
						else {
							int cur = map.lastKey();
							map.replace(cur, map.get(cur) - 1);
							if (map.get(cur) == 0) {
								map.remove(cur);
							}
						}
					}
				} catch (NoSuchElementException | NullPointerException e) {
					continue;
				}

			}
			if (map.isEmpty()) {
				sb.append("EMPTY\n");
			} else {
				sb.append(map.lastKey() + " " + map.firstKey()).append("\n");
			}

		}
		// test case End
		System.out.println(sb.toString());
	}

}
