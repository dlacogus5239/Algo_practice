package codeTreeSamsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main45 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> freqStr = new HashMap<>();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String cur = br.readLine();
			freqStr.put(cur, freqStr.getOrDefault(cur, 0) + 1);
		}
		int max = Integer.MIN_VALUE;
		for (Integer i : freqStr.values()) {
			max = Math.max(max, i);
		}

		System.out.println(max);
	}

}
