/*
问题描述
给定一个含有正整数的数组 nums 和一个正整数 target，找到一个子数组的最小长度，使得子数组的和大于或等于 target。如果不存在符合条件的子数组，返回 0。

思路分析
初始化变量:

left 指针：初始化为 0，表示当前子数组的左边界。
right 指针：初始化为 0，表示当前子数组的右边界。
sum：初始化为 0，表示当前子数组的元素和。
minLength：初始化为 Integer.MAX_VALUE，表示找到的最小子数组长度。
滑动窗口:

使用 right 指针遍历数组，并将 nums[right] 加到 sum 中。这样不断扩大窗口的右边界。
当 sum 大于或等于 target 时，尝试缩小窗口的左边界 (left 指针) 来找到更短的符合条件的子数组。
在缩小窗口的过程中，更新 minLength，即每次计算当前窗口长度 right - left 并与 minLength 进行比较，取最小值。
每次缩小窗口时，将 nums[left] 从 sum 中减去，并递增 left 指针。
返回结果:

如果 minLength 在遍历过程中没有被更新过（即仍为初始值 Integer.MAX_VALUE），则表示没有找到符合条件的子数组，返回 0。
否则，返回 minLength。

 */

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        // 特殊情况下的处理
        if (n == 0) return 0;

        int left = 0, right = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        while (right < n) {
            // 增加窗口大小
            sum += nums[right++];

            // 收缩窗口大小直到 sum < target
            while (sum >= target) {
                minLength = Math.min(minLength, right - left);
                sum -= nums[left++];
            }
        }

        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
}
