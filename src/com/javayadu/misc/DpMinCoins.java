// https://www.topcoder.com/community/competitive-programming/tutorials/dynamic-programming-from-novice-to-advanced/		
package com.javayadu.misc;

import java.util.HashMap;
import java.util.Map;

public class DpMinCoins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = {1,3,5};
		int sum = 11;
		System.out.println(min_coins(coins,sum));
	}
	
	public static int min_coins(int[] coins, int sum) {
		Map<Integer,Integer> coin_min = new HashMap<Integer,Integer>();
		coin_min.put(0, 0);
		for(int i=1; i<=sum; i++) {
			for(int j=0; j<coins.length && coins[j] <= i; j++) {
				// what are the coins that can be considered for sum 'i'?
				int diff = i-coins[j];
				int coins_i = coin_min.get(diff) + 1;
				if(coin_min.get(i) != null) {
					if(coins_i < coin_min.get(i))
						coin_min.put(i, coins_i);
				}
				else
					coin_min.put(i, coins_i);
				int min_i = coin_min.get(diff);
			}
		}
		return coin_min.get(sum);
	}

}
