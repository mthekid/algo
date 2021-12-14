package com.company.epi262.array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {

        System.out.println(generatePascalTriangle(5));
    }

    public static List<List<Integer>> generatePascalTriangle(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> currRow = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                // j가 0보다 크면서 i보다 작은 경우. 두 값을 합친 값을 PacsalTriangle에 추가한다.
                currRow.add( (0 < j && j < i)  ?
                        pascalTriangle.get(i - 1).get(j - 1) + pascalTriangle.get(i - 1).get(j)
                        : 1 );
            }
            pascalTriangle.add(currRow);
        }

        return pascalTriangle;
    }
}
