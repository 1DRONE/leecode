package so;

/**
 * @author drone
 * @date 2021/5/9
 */
public class Q04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int rows=matrix.length;
        if(0==rows){
            return false;
        }
        int cols=matrix[0].length;

        int row=0;
        int col=cols-1;
        while(row<rows && col>=0){
            int cur=matrix[row][col];
            if(cur==target){
                return true;
            }else if(cur>target){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }
}
