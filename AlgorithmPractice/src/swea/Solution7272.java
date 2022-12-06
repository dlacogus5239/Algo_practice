package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution7272 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		String[] oneHole = { "A", "D", "O", "P", "Q", "R" };
		String[] noHole = "CEFGHIJKLMNSTUVWXYZ".split("");
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			for (int i = 0; i < oneHole.length; i++) {
				a = a.replaceAll(oneHole[i], "1");
				b = b.replaceAll(oneHole[i], "1");
			} // 구멍 하나인거 치환

			a = a.replaceAll("B", "2");
			b = b.replaceAll("B", "2"); // 구멍 두개인거 치환

			// 나머지 치환
			for (int i = 0; i < noHole.length; i++) {
				a = a.replaceAll(noHole[i], "0");
				b = b.replaceAll(noHole[i], "0");
			}
			String result = "DIFF";
//			System.out.println(a);
//			System.out.println(b);
			if (a.equals(b)) {
				result = "SAME";
			}
			System.out.println("#" + test_case + " " + result);
		}
	}

}
