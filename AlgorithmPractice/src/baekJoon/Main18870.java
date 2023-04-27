package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main18870 {
	// 백준 18870 좌표 압축
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();

		HashMap<Integer, Integer> map = new HashMap<>();

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			int cur = Integer.parseInt(st.nextToken());
			arr[i] = cur;
		}
		int[] sorted = arr.clone();
		Arrays.sort(sorted);

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (!map.containsKey(sorted[i])) {
				map.put(sorted[i], cnt);
				cnt++;
			}
		}
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			int cur = map.get(arr[i]);
			sb.append(cur).append(" ");
		}

		System.out.println(sb.toString());
	}

}
