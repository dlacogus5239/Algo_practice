package baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main1874 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		boolean flag = true;
		StringBuilder sb = new StringBuilder();
		int num = 0;
		for (int i = 0; i < N; i++) {
			int cur = Integer.parseInt(br.readLine());
			if (cur > num) {
				for (int j = num + 1; j <= cur; j++) {
					stack.push(j);
					sb.append("+").append("\n");
				}
				num = cur;
			} else if (stack.peek() != cur) {
				flag = false;
				break;
			}
			stack.pop();
			sb.append("-").append("\n");
		}
		
		System.out.println(flag ? sb.toString() : "NO");
	}

}
