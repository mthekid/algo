package com.company.epi262.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 한 주를 최대 두 번까지 매매할 수 있을 때, 최대 이윤을 구하는 프로그램을 작성하라.
 * {@link StockTrade} 후속 문제이다.
 * 두 번째 주식의 경우 첫 번째 주식을 판뒤에 구입할 수 있다.
 */
public class StockTwiceTrade {
    public static void main(String[] args) {
        List<Integer> prices = Arrays.asList(12, 11, 13, 9, 12, 8, 14, 13, 15);
        System.out.println(buyAndSellStockTwice(prices));
    }

    /**
     * 접근법. 배열을 2개로 나누어서 관리하라.
     * A[0, j] = 0~j까지의 최대 이익값을 기록해 놓는다.
     * A[j, n-1] = j ~ n-1 사이의 최대 이익값을 기록해 놓는다.
     * 이전에 얻는 최대 이익과 현재 이후에 얻은 최대 이익의 합을 구하면 된다.
     * M[i] = F[i-1] + B[i] [ 우아한 수식이다. ]
     */
    public static int buyAndSellStockTwice(List<Integer> prices) {
        int maxTotalProfit = 0;
        List<Integer> firstBuySellProfits = new ArrayList<>();
        int minPrice = Integer.MAX_VALUE;

        // 각 날짜마다, 해당 날짜에 주식을 팔았을 때의 최대 이익 값을 구해 놓는다.
        for (int i = 0; i < prices.size(); i++) {
            minPrice = Math.min(minPrice, prices.get(i));
            maxTotalProfit = Math.max(maxTotalProfit, prices.get(i) - minPrice);
            firstBuySellProfits.add(maxTotalProfit);
        }
        System.out.println("각 날짜마다 해당 날짜에 주식을 팔았을 때의 최대 이익값들 " + firstBuySellProfits);


        // 뒤로 읽어나가는 부분이다.
        List<Integer> secondBuySellProfits = new ArrayList<>();
        int maxPrice = Integer.MIN_VALUE;
        for (int i = prices.size() - 1; i > 0; --i) {
            maxPrice = Math.max(maxPrice, prices.get(i));
            // 최대값은 이전 날짜에서 얻을 수 있는 최대이익값(i-1이 최대값이다) + 현재날짜까지 얻을 수 있는 최대 이익값이다.
            maxTotalProfit = Math.max(maxTotalProfit, maxPrice - prices.get(i) + firstBuySellProfits.get(i - 1));
        }
        return maxTotalProfit;
    }
}
