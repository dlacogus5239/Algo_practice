package codeTreeSamsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main47 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long[] arr = new long[N];
		st = new StringTokenizer(br.readLine());
		HashMap<Long, Integer> count = new HashMap<>();
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			count.put(arr[i], count.getOrDefault(arr[i], 0) + 1);
		}
		// input END
		int answer = 0;
		for (int i = 0; i < N; i++) {
			if (!count.containsKey(arr[i])) {
				count.put(arr[i], -1);
			} else {
				count.put(arr[i], count.get(arr[i]) - 1);
			}
			for (int j = 0; j < i; j++) {
				long diff = K - arr[i] - arr[j];

				if (count.containsKey(diff)) {
					answer += count.get(diff);
				}
			}

		}
		System.out.println(answer);
	}

}
