package referoffer;

/**
 * @author crazy邹
 * @create 2021/3/27 9:29
 */

/**
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * 2 <= n <= 100000
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 */
//方法一：源地址换：空间复杂度O（1）

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode上的解释
 * 1、题目明确说明了数组长度为n，范围为 n-1，也就是若无重复元素排序后下标0123对应的数字就应该是0123；
 *
 * 2、对数组排序，其实也就是让萝卜归位，1号坑要放1号萝卜，2号坑要放2号萝卜......排序过程中查找有无重复元素。先考虑没有重复元素的情况：
 *
 *  nums[i]     3  1  0  2   萝卜
 *      i       0  1  2  3   坑
 * 0号坑说我要的是0号萝卜，不要3号萝卜，所以会去和3号坑的萝卜交换，因为如果0号坑拿了3号坑的3号萝卜，那说明3号坑装的也肯定是别人家的萝卜，所以要跟3号坑换，换完是这样的：
 *
 *  nums[i]     2  1  0  3   萝卜
 *      i       0  1  2  3   坑
 * 然而0号坑还没找到自己的萝卜，它不要2号萝卜，又去和2号坑的萝卜交换，换完是这样的：
 *
 *  nums[i]     0  1  2  3   萝卜
 *      i       0  1  2  3   坑
 * 这时候刚好就是一一对应的，交换过程也不会出现不同坑有相同编号的萝卜。要注意交换用的是while，也就是0号坑只有拿到0号萝卜，1号坑才能开始找自己的萝卜。
 *
 * 3、如果有重复元素，例如：
 *
 *  nums[i]     1  2  3  2    萝卜
 *      i       0  1  2  3    坑
 * 同样的，0号坑不要1号，先和1号坑交换，交换完这样的：
 *
 *  nums[i]     2  1  3  2    萝卜
 *      i       0  1  2  3    坑
 * 0号坑不要2号萝卜，去和2号坑交换，交换完这样的：
 *
 *  nums[i]     3  1  2  2    萝卜
 *      i       0  1  2  3    坑
 * 0号坑不要3号萝卜，去和3号坑交换，交换完这样的：
 *
 *  nums[i]     2  1  2  3    萝卜
 *      i       0  1  2  3    坑
 * 0号坑不要2号萝卜，去和2号坑交换，结果发现你2号坑也是2号萝卜，那我还换个锤子，同时也说明有重复元素出现。
 *
 * 4、总结
 *
 * 其实这种原地交换就是为了降低空间复杂度，只需多要1个坑来周转交换的萝卜就好了，空间复杂度O（1）。
  */
class Solution {
    public int findRepeatNumber(int[] nums) {
        //设置temp来当一个坑位，用于置换。
        int temp;
        //遍历数组
        for(int i=0;i < nums.length;i++){
            while (nums[i]!=i){
                //如果数组下标于下标对应的元素不相等，则进入循环
                if(nums[i]==nums[nums[i]]){
                    //此时想置换，用下标对应的数组元素来当作下标来找到对应的数组元素，如果发现该位置已经存在该元素，
                    //证明重复元素已经出现就是nums[i],则返回他。
                    return nums[i];
                }
                //如果不重复，则置换他们。
                temp=nums[i];
                nums[i]=nums[temp];
                nums[temp]=temp;
            }
        }
        return -1;
    }
}
//方法二引入哈希表：遍历数组，如果哈希表中没有该元素则添加到哈希表中，如果有这个元素了说明重新添加失败，
// set.add()失败则，返回false

/**
 * 由于只需要找出数组中任意一个重复的数字，因此遍历数组，遇到重复的数字即返回。
 * 为了判断一个数字是否重复遇到，使用集合存储已经遇到的数字，如果遇到的一个数字已经在集合中，则当前的数字是重复数字。
 * 初始化集合为空集合，重复的数字 repeat = -1
 * 遍历数组中的每个元素：
 * 将该元素加入集合中，判断是否添加成功
 * 如果添加失败，说明该元素已经在集合中，因此该元素是重复元素，将该元素的值赋给 repeat，并结束遍历
 * 返回 repeat
 */
class Solution2{
    public int findRepeatNumber(int[] nums) {
        //set集合，HashSet类：集合是按Hash算法来存储集合中的元素。
        Set<Integer> set = new HashSet<Integer>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                //如果添加失败返回false，则repeat=num;跳出for循环。
                repeat = num;
                break;
            }
        }
        return repeat;
    }
}
public class SolutionText {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        Solution text = new Solution();
        text.findRepeatNumber(nums);
        //输出重复的数字；
        System.out.println(text.findRepeatNumber(nums));
        //输出重新占位的数字；
        for (int i = 0;i < nums.length;i++){
            System.out.print(nums[i]+" ");
        }

    }
}
