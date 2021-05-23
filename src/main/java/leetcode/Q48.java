package leetcode;

/**
 * @author drone
 * @date 2021/5/24
 */
public class Q48 {
    /**
     * 旋转方式
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        if (null == matrix || 0 == matrix.length) {
            return;
        }

        int n = matrix.length;

        //一边小于一半  一边大于一半
        for (int r = 0; r < (n + 1) / 2; r++) {
            for (int c = 0; c < n / 2; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[n - 1 - c][r];
                matrix[n - 1 - c][r] = matrix[n - r - 1][n - 1 - c];
                matrix[n - r - 1][n - 1 - c] = matrix[c][n - 1 - r];

                matrix[c][n - 1 - r] = temp;
            }
        }
    }

    /**
     * 翻转方式
     * @param matrix
     */
    public void rotate2(int[][] matrix) {
        if(null==matrix || 0==matrix.length){
            return;
        }

        int n=matrix.length;

        //水平翻转
        for(int r=0; r<n/2;r++){
            for(int c=0; c<n;c++){
                swap(matrix,r,c, n-1-r,c);
            }
        }

        //对角线翻转
        for(int r=0; r<n;r++){
            for(int c=0; c<r;c++){
                swap(matrix,r,c,c,r);
            }
        }
    }

    private void swap(int[][] matrix, int i,int j,int ni,int nj){
        int tmp=matrix[i][j];
        matrix[i][j]=matrix[ni][nj];
        matrix[ni][nj] = tmp;

    }
}
