package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution1229 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int T = 0; T < 10; T++) {
			int N = Integer.parseInt(br.readLine());
			LinkedList<Integer> code = new LinkedList<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				code.add(Integer.parseInt(st.nextToken()));
			}
			int operationNum = Integer.parseInt(br.readLine());
			int operationCnt = 0;
			st = new StringTokenizer(br.readLine());
			while (operationCnt < operationNum) {
				String operation = st.nextToken();
				if (operation.equals("I")) {
					operationCnt++;
					int idx = Integer.parseInt(st.nextToken());
					int len = Integer.parseInt(st.nextToken());
					for (int n = 0; n < len; n++) {
						code.add(idx + n, Integer.parseInt(st.nextToken()));
					}
				} else if (operation.equals("D")) {
					operationCnt++;
					int idx = Integer.parseInt(st.nextToken());
					int amount = Integer.parseInt(st.nextToken());
					for (int n = 0; n < amount; n++) {
						code.remove(idx);
					}
				}

			}
			System.out.print("#" + (T + 1) + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(code.get(i) + " ");
			}
			System.out.println();
		}
	}
}
