package baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1259 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		StringBuilder sb = new StringBuilder();

		while (true) {
			input = br.readLine();
			if (input.compareTo("0") == 0) {
				break;
			}
			int start = 0;
			int end = input.length() - 1;
			boolean flag = true;
			while (start < end) {
				if (input.charAt(start) != input.charAt(end)) {
					flag = false;
					break;
				}
				start++;
				end--;
			}
			sb.append(flag ? "yes" : "no").append("\n");

		}

		System.out.println(sb.toString());
	}

}
