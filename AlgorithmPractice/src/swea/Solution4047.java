package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution4047 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int S = 13, D = 13, H = 13, C = 13;
			boolean[] deckS = new boolean[14];
			boolean[] deckD = new boolean[14];
			boolean[] deckH = new boolean[14];
			boolean[] deckC = new boolean[14];
			String input = br.readLine();
			int cur = 0;
			boolean flag = false;
			while (cur < input.length()) {
				char shape = input.charAt(cur);
				int num = (input.charAt(cur + 1) - '0') * 10 + input.charAt(cur + 2) - '0';
//				System.out.println(shape + " " + num);

				switch (shape) {
				case 'S':
					if (deckS[num]) {
						flag = true;
						break;
					}
					deckS[num] = true;
					S--;
					break;
				case 'D':
					if (deckD[num]) {
						flag = true;
						break;
					}
					deckD[num] = true;
					D--;
					break;
				case 'H':
					if (deckH[num]) {
						flag = true;
						break;
					}
					deckH[num] = true;
					H--;
					break;
				case 'C':
					if (deckC[num]) {
						flag = true;
						break;
					}
					C--;
					deckC[num] = true;
					break;
				}

				cur += 3;
			}

			if (flag) {
				System.out.println("#" + test_case + " ERROR");
			} else {
				System.out.println("#" + test_case + " " + S + " " + D + " " + H + " " + C);
			}
		}
	}

}
