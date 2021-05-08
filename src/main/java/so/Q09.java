package so;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhangyizhang01
 * @date 2021-05-02
 */
public class Q09 {
    class CQueue {

        Deque<Integer> stackIn;
        Deque<Integer> stackOut;

        public CQueue() {
            stackIn=new LinkedList();
            stackOut=new LinkedList();
        }

        public void appendTail(int value) {
            stackIn.push(value);
        }

        public int deleteHead() {
            if(!stackOut.isEmpty()){
                return stackOut.pop();
            }else{
                while(!stackIn.isEmpty()){
                    stackOut.push(stackIn.pop());
                }
                return stackOut.isEmpty()?-1:stackOut.pop();
            }
        }
    }
}
