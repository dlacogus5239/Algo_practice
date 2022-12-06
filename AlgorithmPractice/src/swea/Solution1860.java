package swea;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1860 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // N명의 사람
			int M = Integer.parseInt(st.nextToken()); // M초의 시간
			int K = Integer.parseInt(st.nextToken()); // K개의 붕어빵
			st = new StringTokenizer(br.readLine());
			boolean flag = true;

			ArrayList<Integer> customer = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				customer.add(Integer.parseInt(st.nextToken()));
			}
			customer.sort((o1, o2) -> o1 - o2);
			int bread = 0;
			for (int i = 0; i < N; i++) {
				bread = K * (customer.get(i) / M);
				if (bread < i + 1) {
					flag = false;
					break;
				}
			}

			System.out.print("#" + test_case + " ");
			if (flag) {
				System.out.println("Possible");
			} else {
				System.out.println("Impossible");
			}
		}
	}

}
