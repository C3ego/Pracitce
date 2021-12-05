package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class greedy {
	private static final int coinType [] = {500, 100, 50, 10};
	
	public static void main(String [] arg) throws IOException {
		
		//getLeastCoinCnt();
		//theLowOfLargeNum();
		//cardNumGame();
		untilToNum1();
	}
	
	static Scanner sc = new Scanner(System.in);
	
	// 01. 거스름돈 동전 최소 갯수 구하기
	public static void  getLeastCoinCnt() {
		int cnt = 0;
		int n;
		System.out.println("가격을 입력하세요.");
		n = sc.nextInt();

		for (int coin : coinType) {
			cnt += n / coin;
			n %= coin;
		}
		System.out.println("필요한 동전의 최소 갯수" + cnt + "개");
	}
	

	// 02. 큰 수의 법칙
	public static void theLowOfLargeNum () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<Integer> numList = new ArrayList<Integer>();
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++){
	        numList.add( Integer.parseInt(st2.nextToken())); 
	    }
		
		Collections.sort(numList);
		
		int cnt = 0;
		int sum = 0;
		
		int firstBigNum = numList.get(numList.size() - 1);
		int secBigNum  = numList.get(numList.size() - 2);
		
		for (int x = 0; x < M; x++) {
			
			cnt ++;
			
			if (cnt % K ==0) sum += secBigNum;
			else  sum += firstBigNum;
		}
		
		System.out.println(sum);
	
	}
	
	// 03. 가장 높은 숫자가 적힌 카드 뽑기 (N*M 행열)
	public static void cardNumGame () throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	    
		int row = Integer.parseInt(st.nextToken());
        String[] minArr = new String[row];

        for(int i = 0; i < row; i++)
        {
            String s = br.readLine();
            String[] arr = s.split(" ");

           Arrays.sort(arr);

            minArr[i] = arr[0];
        }
        Arrays.sort(minArr);
        System.out.println(minArr[row-1]);
	}
	
	// 04. 1이 될 때까지
	public static void untilToNum1 () {
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int resultCnt = 0;
		
		while (N != 1) {
			if(N % K == 0) {
				N /= K;
				resultCnt ++;
			} else {
				N --;
			}
		}
		System.out.println(resultCnt);
	}
	
}
