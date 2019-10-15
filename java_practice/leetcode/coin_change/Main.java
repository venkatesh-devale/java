import java.util.Arrays;

class Main {
	public static void main(String[] args) {
		int[] coins = {2};
		int amount = 3;
		System.out.println(coinChange(coins, amount));
	}

	private static int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount+1];
		for(int i=1;i<=amount;i++) {
			dp[i] = amount+1;
		}

		for(int i=1;i<=amount;i++) {
			for(int coin: coins) {
				if(coin <= i) {
					dp[i] = Math.min(1+dp[i-coin], dp[i]);
				}
			}
		}
		return (dp[amount] == amount+1) ? -1 : dp[amount];
	}
}