package codeTreeSamsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main48 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());// N개의 숫자
		int K = Integer.parseInt(st.nextToken());// 자주 등장한 순으로 k개의 숫자 출력

		HashMap<Integer, Integer> freq = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());

			freq.put(tmp, freq.getOrDefault(tmp, 0) + 1);
		}
		ArrayList<int[]> result = new ArrayList<>();
		for (int i : freq.keySet()) {
			result.add(new int[] { i, freq.get(i) });
		}
		Collections.sort(result, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] != o2[1]) {
					return o2[1] - o1[1];
				} else {

					return o2[0] - o1[0];
				}
			}

		});
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < K; i++) {
			sb.append(result.get(i)[0]).append(" ");
		}
		System.out.println(sb.toString());
	}

}
