import java.util.List;

public class BuySellStockOnce {

    /*
     * 6.6 Write a program that takes an array denoting the daily stock price,
     * and returns the maximum profit that could be made by buying and then
     * selling one share of that stock.
     *
     * Hint: Identifying the minimum and maximum is not enough since the minimum
     * may appear after the maximum height. Focus on valid differences.
    */

    public static int buySellStockOnce(List<Integer> A) {
        int maxProfit = 0;
        if(A.size() > 1) {
            int lowestValue = A.get(0);
            for(int i = 0; i < A.size(); i++) {
                int currentValue = A.get(i);
                maxProfit = Math.max(maxProfit, currentValue - lowestValue);
                lowestValue = Math.min(lowestValue, currentValue);
            }
        }
        return maxProfit;
    }
}
