package referoffer;
import java.util.Scanner;
/**
 * @author crazy邹
 * @create 2021/3/24 15:30
 */

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author crazy邹
 */

import java.util.Deque;
import java.util.LinkedList;

/**
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 *["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 *
 */
//方法一官方解法
/*class CQueue {
    //声明两个栈stack1，stack2；
    Deque<Integer> stack1;
    Deque<Integer> stack2;
    public CQueue() {
    //分配存储空间；
        stack1 = new LinkedList<Integer>();
        stack2 = new LinkedList<Integer>();
    }
    //入栈操作；
    public void appendTail(int value) {
        stack1.push(value);
    }
    //出栈；
    public int deleteHead() {
    //判断栈stack2是否为空；
        if (stack2.isEmpty()){
        //如果为空，则可以把栈stack1的元素入stack2栈；
            while (!stack1.isEmpty()){//stack1不为空，把元素出栈入stack2；
                stack2.push((stack1.pop()));
            }
        }
        if (stack2.isEmpty()){//如果stack2也没有元素了，则返回-1；
            return -1;
        }else{//否则返回stack2出栈的元素，则对应着队列“先进先出”的顺序出队列；
            int deleteItem = stack2.pop();
            return deleteItem;
        }
    }
}*/
//方法二
class CQueue{//声明双向列表A,B；
    LinkedList<Integer> A,B;//LinkedList是双向列表；
    public CQueue(){//分配相应的存储空间，泛型<Interger>.
        //A为出栈，的列表LinkedList可以用来当栈使用；
        //B为入栈，的列表；
        A = new LinkedList<Integer>();
        B = new LinkedList<Integer>();
    }
    public void appendTail(int value) {//添加元素；
        A.addLast(value);

    }
    public int deleteHead() {
        //判断B是否为空，B不为空返回列表最后一个元素，相当于出栈对应后进先出的栈；
        if(!B.isEmpty()){ return B.removeLast();}
        if (A.isEmpty()) {return -1;}//如果用来出栈的B栈也空了，则返回题目要求的-1；
        while (!A.isEmpty()){//如果用来入栈的，栈A，不为空，则向栈B添加，A出栈的元素，从而完成倒叙，使得栈B的出栈就可以对应队列的出队顺序了；
            B.addLast(A.removeLast());
        }
        return B.removeLast();//返回用来作为出栈的栈B当中的元素；
    }
}
public class Offer09 {
    public static void main(String[] args) {
        CQueue queue = new CQueue();//创建对象queue
        System.out.println("您想输入几个数呢");
        int num = new Scanner(System.in).nextInt();
        System.out.print("请连续输入数据：");
        int val;
        for (int i = 1;i <= num;i++ ){//向栈A中输入元素；
            val = new Scanner(System.in).nextInt();
            queue.appendTail(val);
        }
        for (int i = 1;i <= num;i++){//输出栈B中的元素，也就是对应着队列当中的出队顺序；
            System.out.print(queue.deleteHead() + " ");
        }
    }
}
