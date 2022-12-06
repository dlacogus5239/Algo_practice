package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1244 {
	static int[] swi;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int switchNum = Integer.parseInt(br.readLine());
		swi = new int[switchNum + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < swi.length; i++) {
			swi[i] = Integer.parseInt(st.nextToken());
		}

		int studentNum = Integer.parseInt(br.readLine());
		for (int i = 1; i <= studentNum; i++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int cur = Integer.parseInt(st.nextToken());

			if (sex == 1) {
				for (int j = cur; j <= switchNum; j += cur) {
					change(j);
				}
			} else {
				change(cur);
				for (int j = 0; j <= switchNum; j++) {
					if (cur - j <= 0 || cur + j > switchNum) {
						continue;
					}
					if (swi[cur + j] == swi[cur - j]) {
						change(cur + j);
						change(cur - j);
					} else {
						break;
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= switchNum; i++) {
			sb.append(swi[i]).append(" ");
			if (i % 20 == 0) {
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}

	public static void change(int i) {
		if (swi[i] == 1) {
			swi[i] = 0;
		} else {
			swi[i] = 1;
		}
	}

}
