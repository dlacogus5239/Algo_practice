package swea;

import java.util.Scanner;

//SWEA 1940 가랏! RC카! 
public class Solution1940 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int commandNum = sc.nextInt();
			int curSpeed = 0;
			int traveled = 0;
			for (int i = 0; i < commandNum; i++) {
				int command = sc.nextInt();
				switch (command) {
				case 0:
					break;
				case 1:
					int accerlation = sc.nextInt();
					curSpeed += accerlation;
					break;
				case 2:
					int deceleration = sc.nextInt();
					curSpeed = curSpeed - deceleration < 0 ? 0 : curSpeed - deceleration;
					break;
				}
				traveled += curSpeed;
			}
			System.out.println("#" + test_case + " " + traveled);
		}
	}

}
