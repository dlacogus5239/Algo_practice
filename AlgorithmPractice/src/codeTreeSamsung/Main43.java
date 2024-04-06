package codeTreeSamsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main43 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<Long, Long> hm = new HashMap<>();

		StringTokenizer st;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());

			if (!hm.containsKey(x)) {
				hm.put(x, y);
			} else {
				long pre = hm.get(x);
				hm.replace(x, Math.min(pre, y));
			}
		}
		long result = 0L;
		for (Long y : hm.values()) {
			result += y;
		}

		System.out.println(result);
	}

}
