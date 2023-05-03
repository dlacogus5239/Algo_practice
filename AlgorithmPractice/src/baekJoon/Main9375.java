package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main9375 {
	// 백준 9375 패션왕 신해빈
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());

			StringTokenizer st;
			HashMap<String, Integer> map = new HashMap<>();
			// input START
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				String sort = st.nextToken();

				if (!map.containsKey(sort)) {
					map.put(sort, 1);
				} else {
					int cur = map.get(sort);
					cur++;
					map.replace(sort, cur);
				}
			}
			// input END

			int result = 1;
			for (int val : map.values()) {
				result *= (val + 1);
			}

			System.out.println(result - 1);
		}
	}

}
