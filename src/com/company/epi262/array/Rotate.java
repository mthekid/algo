package com.company.epi262.array;

import java.util.List;

/**
 * n x n 크기의 2차원 배열이 주어졌을 때 이를 시계 방향으로 90도만큼 회전시키는 프로그램 작성하기.
 * 행렬을 회전시켰을 때 i번째 열은 기존 행렬의 i번쨰 행과 같다.
 * 1은 4의 위치로, 4는 16의 위치로, 16은 13의 위치로 13은 1의 위치로 옮기는 방식으로 하나하나 처리하면 된다.
 */
public class Rotate {

    public static void rotateMatrix(List<List<Integer>> squareMatrix) {
        final int matrixSize = squareMatrix.size() - 1;
        for(int i = 0; i < (squareMatrix.size() / 2); ++i) {
            for(int j = i; j < matrixSize - i; ++j) {
                int temp1 = squareMatrix.get(matrixSize - j).get(i);
                int temp2 = squareMatrix.get(matrixSize).get(i);
                int temp3 = squareMatrix.get(j).get(matrixSize - i);
                int temp4 = squareMatrix.get(i).get(j);

                squareMatrix.get(i).set(j, temp1);
                squareMatrix.get(matrixSize - j).set(i, temp2);
                squareMatrix.get(matrixSize - i).set(matrixSize - j, temp3);
                squareMatrix.get(j).set(matrixSize - i, temp4);
            }
        }
    }
}
