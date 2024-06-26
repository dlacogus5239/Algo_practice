package codeTreeSamsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main46 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] arr = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		} // input END

		HashMap<Long, Integer> count = new HashMap<>();
		int answer = 0;
		for (int i = 0; i < N; i++) {
			long diff = (long) M - (long) arr[i];
			if (count.containsKey(diff)) {
				answer += count.get(diff);
			}

			if (!count.containsKey(arr[i])) {
				count.put(arr[i], 1);
			} else {
				count.put(arr[i], count.get(arr[i]) + 1);
			}
		}

		System.out.println(answer);

	}

}
