package baekJoon;

import java.math.BigInteger;
import java.util.Scanner;

public class Main2407 {
	// 백준 2407 조합
	static long N, M;

	// Combination 계산
	// nCm => nPm / m! => n! / m!(n - m)!

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = (long) sc.nextInt();
		M = (long) sc.nextInt();
		BigInteger n1 = BigInteger.ONE;
		BigInteger n2 = BigInteger.ONE;

		for (int i = 0; i < M; i++) {
			n1 = n1.multiply(new BigInteger(String.valueOf(N - i)));
			n2 = n2.multiply(new BigInteger(String.valueOf(i + 1)));
		}

		System.out.println(n1.divide(n2));
	}

}
