package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main5430 {
	// 백준 5430 AC
	// 처음 LinkedList로 구현했다가 시간복잡도 초과
	// deque사용하면 바로 풀림;; 개어이없어
	static ArrayDeque<Integer> function;
	static int N;
	static boolean flag;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		StringTokenizer st;
		// 테스트 케이스 개수
		int T = Integer.parseInt(br.readLine());

		sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			// 명령어 입력
			// R : 뒤집기
			// D : 버리기 ( 배열 비어있을 경우 에러 )
			String[] operation = br.readLine().split("");
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), "[],");
			function = new ArrayDeque<>();

			for (int i = 0; i < N; i++) {
				function.offer(Integer.parseInt(st.nextToken()));
			}
			// input END

			// flag true이면 처음부터 빼고, (뒤집히기 전)
			// flag false 이면 뒤에서부터 뺌 (뒤집히고 난 후)
			flag = true;
			boolean error = false;
			for (int i = 0; i < operation.length; i++) {
				if (operation[i].equals("R")) {
					flag = !flag;
				} else if (operation[i].equals("D")) {
					// 삭제명령어인데 함수가 아무것도 없을 경우
					if (function.isEmpty()) {
						error = true;
						break;
					}

					if (flag) {
						// 정방향
						function.removeFirst();
					} else {
						// 역방향
						function.removeLast();
					}
				}
			}
			if (error) {
				sb.append("error\n");
				continue;
			}
			sb.append("[");

			if (flag) {
				while (!function.isEmpty()) {
					sb.append(function.pollFirst());
					if (function.size() != 0) {
						sb.append(",");
					}
				}
			} else {
				while (!function.isEmpty()) {
					sb.append(function.pollLast());
					if (function.size() != 0) {
						sb.append(",");
					}
				}
			}
			sb.append("]\n");

		}

		System.out.println(sb.toString());

	}

}
