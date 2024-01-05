package baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1436 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 1;
		int num = 666;
		while (cnt < N) {
			num++;
			String tmp = Integer.toString(num);

			while (!tmp.contains("666")) {
				num++;
				tmp = Integer.toString(num);
			}
			cnt++;
		}
		System.out.println(num);

	}

}
