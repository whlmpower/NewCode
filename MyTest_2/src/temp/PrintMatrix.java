package temp;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/03/19 0019.
 */
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int[][] matrix){
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null)
            return list;
        int rows = matrix.length;
        int columns = matrix[0].length;
        int start = 0;
        //循环 继续条件为 columns > start *2
        // start 为打印的圈数
        while(columns > start * 2  && rows > start * 2){
            printMatrixInCircle(matrix, rows, columns, start, list);
            start ++;
        }
        return list;
    }

    private void printMatrixInCircle(int[][] matrix, int rows, int columns, int start, ArrayList<Integer> list){
        int endX = columns - 1 -start;
        int endY = rows - 1 - start;
        // 第一步打印肯定会进行
        for (int i = start; i <= endX ; i++) {
            list.add(matrix[start][i]);
        }
        // 第二步打印 想要执行至少有两行
        if (start < endY){
            for (int i = start + 1; i <= endY; i++) {
                list.add(matrix[i][endY]);
            }
            // 第三步打印 想要执行首先必须依赖于第二步 并且至少有两行
            if (start < endX){
                for (int i = endX - 1; i >=start ; i--) {
                    list.add(matrix[endY][i]);
                }
            }
        }
        // 第四步想要执行  至少有三列  且行起始值小于行终止值
        if (start < endY -1 && start < endX ){
            for (int i = endY -1; i > start ; i--) {
                list.add(matrix[i][start]);
            }
        }


    }
}
