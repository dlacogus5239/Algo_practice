package programmers;

public class Solution0207_7 {
	public int solution(int n) {
		int answer = 0;
		long[] fibo = new long[n + 1];
		long divid = 1234567;
		fibo[0] = 0;
		fibo[1] = 1;
		for (int i = 2; i <= n; i++) {
			fibo[i] = (fibo[i - 1] + fibo[i - 2]) % divid;
		}

		return (int) (fibo[n]);
	}
}
