package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1225 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int T = 0; T < 10; T++) {
			int test_case = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());

			Queue<Integer> queue = new LinkedList<Integer>();
			for (int i = 0; i < 8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}

			int cnt = 0;
			while (true) {
				int tmp = 0;
				tmp = queue.poll() - (++cnt);

				if (tmp == 0 || tmp < 0) {
					queue.offer(0);
					break;
				} else {
					queue.offer(tmp);
				}
				if (cnt == 5) {
					cnt = 0;
				}
			} // END while

			System.out.print("#" + test_case + " ");
			while (!queue.isEmpty()) {
				System.out.print(queue.poll() + " ");
			}
			System.out.println();
		}

	}

}
