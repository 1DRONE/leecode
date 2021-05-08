package so;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author zhangyizhang01
 * @date 2021-05-06
 */
public class Q31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> stack=  new LinkedList<>();
        int j=0;
        for(int i=0;i<pushed.length;i++){
            stack.push(pushed[i]);

            while(!stack.isEmpty() && stack.peek()==popped[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
