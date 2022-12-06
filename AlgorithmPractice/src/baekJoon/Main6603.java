package baekJoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main6603 {
	static int[] input;
	static int[] lotto;
	static int K;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		K = -1;
		do {
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			if (K == 0) {
				return;
			}
			input = new int[K];
			lotto = new int[6];

			for (int i = 0; i < K; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			} // input END
			comb(0, 0, 0);
			System.out.println();
		} while (K != 0);

	}

	public static void comb(int cnt, int start, int flag) {
		if (cnt == 6) {
			Arrays.sort(lotto);
			sb = new StringBuilder();
			for (int i = 0; i < 6; i++) {
				sb.append(lotto[i]).append(" ");
			}
			System.out.println(sb.toString());
			return;
		}

		for (int i = start; i < K; i++) {
			if ((flag & 1 << i) != 0) {
				continue;
			}
			lotto[cnt] = input[i];
			comb(cnt + 1, i + 1, flag | 1 << i);
		}
	}

}