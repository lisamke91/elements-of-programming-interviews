import java.util.ArrayList;
import java.util.List;

public class BuySellStockTwice {

    /*
     * 6.7 Write a program that computes the maximum profit that can be made by
     * buying and selling a share at most twice. The second buy must be made on
     * another date after the first sale.
     *
     * Hint:What do you need to know about the first i elements when processing
     * the (i+l)th element?
    */

    public static int buySellStockTwice(List<Integer> A) {
        List<Integer> singleSaleMaxProfits = new ArrayList<>();
        int maxProfit = 0, lowestValue, highestValue;

        if(A.size() > 1) {
            lowestValue = A.get(0);
            // traverse once to calculate max from single sale
            for (Integer currentValue : A) {
                maxProfit = Math.max(maxProfit, currentValue - lowestValue);
                lowestValue = Math.min(currentValue, lowestValue);
                singleSaleMaxProfits.add(maxProfit);
            }

            // traverse again from end
            highestValue = A.get(A.size()-1);
            for(int i = A.size() - 1; i > 2; i--) {
                int currentValue = A.get(i);
                maxProfit = Math.max(singleSaleMaxProfits.get(i - 1) + highestValue - currentValue, maxProfit);
                highestValue = Math.max(highestValue, currentValue);
            }
        }
        return maxProfit;
    }

}
