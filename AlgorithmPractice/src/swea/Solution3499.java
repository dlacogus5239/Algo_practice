package swea;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution3499 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int deckNum = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());
			LinkedList<String> deck1;
			LinkedList<String> deck2;
			LinkedList<String> result = new LinkedList<String>();
			LinkedList<String> input = new LinkedList<String>();
//			for (int i = 0; i < deckNum; i++) {
//				input.add(st.nextToken());
//			}
//			System.out.println(input.toString());
			if (deckNum % 2 != 0) { // 홀수
				deck1 = new LinkedList<String>();
				deck2 = new LinkedList<String>();
				for (int i = 0; i < deckNum / 2 + 1; i++) {
					deck1.add(st.nextToken());
				}
				for (int i = 0; i < deckNum / 2; i++) {
					deck2.add(st.nextToken());
				}
			} else { // 짝수
				deck1 = new LinkedList<String>();
				deck2 = new LinkedList<String>();
				for (int i = 0; i < deckNum / 2; i++) {
					deck1.add(st.nextToken());
				}
				for (int i = 0; i < deckNum / 2; i++) {
					deck2.add(st.nextToken());
				}
			} // input END
				// 2개의 덱으로 나눔

			// Suffle Start
			while (!deck1.isEmpty()) {
				result.add(deck1.pollFirst());
				if(!deck2.isEmpty()) {
					result.add(deck2.pollFirst());
				}
				
			}
			System.out.print("#" + test_case + " ");
			for(String s : result) {
				System.out.print(s + " ");
			}
			System.out.println();
		}
	}

}
