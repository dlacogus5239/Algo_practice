package baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1629 {
	static long C;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		long A, B;
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());

		long result = pow(A, B);

		System.out.println(result);

	}

	static public long pow(long A, long exponent) {
		if (exponent == 1) {
			return A % C;
		}
		long tmp = pow(A, exponent / 2);

		//
		// 현재 지수가 홀수 였다면
		// A^(exponent / 2) * A^(exponent/2) * A
//		이므로 A를 한번 더 곱해주어야 한다
		// Ex)A ^ 9 = A ^ 4 * A ^ 4 * A;

		if (exponent % 2 == 1) {
			return (tmp * tmp % C) * A % C;
		}

		return tmp * tmp % C;
	}

}
