package baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main5397 {
	// 백준 5397 키로거
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		// 테스트 케이스 수행
		for (int t = 0; t < T; t++) {
			char[] input = br.readLine().toCharArray();

			// 스택 두개 써서
			// 가운데를 커서라 생각하자.
			// 커서가 왼쪽으로 가면, 오른쪽 스택에서 뽑아서 왼쪽으로 이동
			// 커서가 오른쪽으로 가면, 왼쪽 스택에서 뽑아서 오른쪽으로 이동
			// -가 나오면 현재 커서에서 왼쪽 문자가 삭제되므로 left.pop()
			Stack<Character> left = new Stack<>();
			Stack<Character> right = new Stack<>();
			for (int i = 0; i < input.length; i++) {
				switch (input[i]) {
				case '<':
					if (!left.isEmpty()) {
						right.push(left.pop());
					}
					break;
				case '>':
					if (!right.isEmpty()) {
						left.push(right.pop());
					}
					break;
				case '-':
					if (!left.isEmpty()) {
						left.pop();
					}
					break;
				default:
					left.add(input[i]);

				}
			}

			while (!right.isEmpty()) {
				left.add(right.pop());
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < left.size(); i++) {
				sb.append(left.elementAt(i));
			}
			bw.write(sb.toString());
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

}
