package swea;

import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
public class Solution1289
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int testCase = Integer.parseInt(sc.nextLine());
		char[] tmp;

		for (int i = 0; i < testCase; i++) {
			int cnt = 0;
			tmp = sc.nextLine().toCharArray();	// 원래 상태
			char[] dif = new char[tmp.length];	
			for (int j = 0; j < tmp.length; j++) {
				dif[j] = '0';	// 초기 상태
			}
			for (int p = 0; p < tmp.length; p++) {
				if (tmp[p] != dif[p]) {
					char toChange = 0;
					if(tmp[p] == '1') {
						toChange = '1';
					}
					else if(tmp[p] == '0') {
						toChange = '0';
					}
					for(int k = p ; k <tmp.length;k++) {
						dif[k] = toChange;
					}
					cnt++;
				}
			}

			System.out.println("#" + (i + 1) + " " + cnt);
		}
    }
}