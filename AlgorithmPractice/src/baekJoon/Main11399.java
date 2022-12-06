package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 백준 11399 ATM
public class Main11399 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		ArrayList<Integer> time = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			time.add(Integer.parseInt(st.nextToken()));
		} // Input END
		time.sort((o1, o2) -> o1 - o2);
		for (int i = 0; i < time.size(); i++) {
			int tmp = 0;
			for (int j = 0; j <= i; j++) {
				tmp += time.get(j);
			}
			result += tmp;
		}
		System.out.println(result);
	}

}