package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main1759 {
	// static String[] vowel = { "a", "e", "i", "o", "u" };
	static String[] input;
	static String[] tmp;
	// static List<String> result = new ArrayList<String>();
	static int L, C;

	public static void main(String[] args) throws IOException, NumberFormatException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		input = new String[C];
		tmp = new String[L];
		input = br.readLine().split(" ");
		Arrays.sort(input);
		comb(0, 0, 0);
	}

	public static void comb(int cnt, int start, int flag) {
		if (cnt == L) {
			// 만들어진 문자열 검사해서 최소한의 조건 만족하면 넣어주기
			int vowelCnt = 0; // 모음 개수
			int consonantCnt = 0; //자음 개수
			for (int i = 0; i < L; i++) {
				if (tmp[i].equals("a") || tmp[i].equals("e") || tmp[i].equals("i") || tmp[i].equals("o")
						|| tmp[i].equals("u")) {
					vowelCnt++;
				} else {
					consonantCnt++;
				}

			}
			if (vowelCnt >= 1 && consonantCnt >= 2) {
				for (int i = 0; i < L; i++) {
					System.out.print(tmp[i]);
				}
				System.out.println();
			}

			return;
		}
		for (int i = start; i < C; i++) {
			if ((flag & 1 << i) != 0) {
				continue;
			}
			tmp[cnt] = input[i];
			comb(cnt + 1, i + 1, flag | 1 << i);
		}
	}

}