package test1;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其总和大于等于 target 的长度最小的 连续
 * 子数组
 * [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 */
public class SlidingWindow1 {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        int result = minSubArrayLen(target, nums);
        System.out.println("满足条件的最小子数组长度是" + result);
    }

    //滑动窗口
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;  //left表示窗口起始位置,right表示窗口结束位置
        int result = Integer.MAX_VALUE;    //设置为整型的最大值以防比较值的最初值不够大
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right]; //最右边元素进入窗口
            while (sum >= target) {   //此时可以开始移动窗口起始位置
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];    //这里减去后不用补上,正好继续找新的子串
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;  //result没变说明根本没有子串满足和大于target的要求
    }
}
