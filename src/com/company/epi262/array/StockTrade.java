package com.company.epi262.array;

import java.util.Arrays;
import java.util.List;

/**
 * 주식을 한번 사고 파는 것이다.
 * 주식 한 주를 사서 되팔았을 때 최대 이익을 얻을 수 있는 알고리즘을 설계하라.
 * 매수 이후 매도가 가능하다.
 */
public class StockTrade {

    public static void main(String[] args) {
        List<Integer> prices = Arrays.asList(310, 315, 275, 295, 260, 270, 290, 230, 255, 250);
        System.out.println(highestDiff(prices));

    }

    /**
     * 현재까지의 최저가를 기록해둔다. 그리고 해당 최저가와 현재가와의 차이점을 기록한다.
     * 가장 큰 차이가 나는 지점이 최대 이익이된다.
     */
    private static int highestDiff(List<Integer> prices) {
        int min = prices.get(0);
        int maxDiff = 0;
        for (int i = 1; i < prices.size(); i++) {
            if(prices.get(i) < min) {
                min = prices.get(i);
            } else {
                maxDiff = Math.max(maxDiff, prices.get(i) - min);
            }
        }
        return maxDiff;
    }

    // solution
    public static double computeMaxProfit(List<Double> prices) {
        double minPrice = Double.MAX_VALUE, maxProfit = 0.0;
        for(Double price : prices) {
            maxProfit = Math.max(maxProfit, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }
        return maxProfit;
    }
}
