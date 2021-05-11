package so;

/**
 * @author drone
 * @date 2021/5/12
 */
public class Q29 {
    public int[] spiralOrder(int[][] matrix) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] order = new int[rows * cols];
        int index = 0;

        int left = 0;
        int right = cols - 1;
        int top = 0;
        int bottom = rows - 1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                order[index++] = matrix[top][i];
            }
            for (int i = top + 1; i <= bottom; i++) {
                order[index++] = matrix[i][right];
            }

            if (left < right && top < bottom) {
                for (int i = right - 1; i > left; i--) {
                    order[index++] = matrix[bottom][i];
                }
                for (int i = bottom; i > top; i--) {
                    order[index++] = matrix[i][left];
                }
            }

            left++;
            right--;
            top++;
            bottom--;

        }
        return order;
    }
}
