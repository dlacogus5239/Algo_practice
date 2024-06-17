package binarySearchTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main7662 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		TreeMap<Integer, Integer> tm;
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			tm = new TreeMap<>(); // Key : 수 , Value : 수가 들어온 개수
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());

				char oper = st.nextToken().charAt(0);
				int num = Integer.parseInt(st.nextToken());

				switch (oper) {
				case 'I':
					tm.put(num, tm.getOrDefault(num, 0) + 1);
					break;
				case 'D':
					if (tm.isEmpty()) {
						continue;
					}
					if (num == -1) { // 최솟값 삭제
						tm.put(tm.firstKey(), tm.firstEntry().getValue() - 1);
						if (tm.firstEntry().getValue() == 0) {
							tm.remove(tm.firstKey());
						}
					} else { // 최댓값 삭제
						tm.put(tm.lastKey(), tm.lastEntry().getValue() - 1);
						if (tm.lastEntry().getValue() == 0) {
							tm.remove(tm.lastKey());
						}
					}
					break;
				}

//				System.out.println(tm.toString());
			}
			if (tm.isEmpty()) {
				sb.append("EMPTY").append("\n");
				continue;
			} else {
				sb.append(tm.lastEntry().getKey()).append(" ").append(tm.firstEntry().getKey());
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());

	}

}
