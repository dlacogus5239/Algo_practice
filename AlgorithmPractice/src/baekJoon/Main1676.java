package baekJoon;

import java.util.Scanner;

public class Main1676 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		int result = 0;
		while (N >= 5) {
			result += N / 5;
			N /= 5;
		}
		System.out.println(result);
	}

}
