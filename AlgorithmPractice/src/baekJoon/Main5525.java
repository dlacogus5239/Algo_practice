package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main5525 {
	// 백준 IOIOI
	// N : 찾을 IOI 문자의 길이(O의 개수)
	// M : 문자열의 길이
	static int N, M;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		String input = br.readLine();
		br.close();
		// input END

		int result = 0;
		int cnt = 0;
		for (int i = 1; i < M - 1; i++) {
			if (input.charAt(i - 1) == 'I' && input.charAt(i) == 'O' && input.charAt(i + 1) == 'I') {
				cnt++;

				if (cnt == N) {
//					System.out.println("index At : " + i);
					cnt--;
					result++;
				}
				i++;
			} else {
				cnt = 0;
			}

		}

		System.out.println(result);

	}

}
