/*
经典的二分查找，之前c/c++刷过一些，现在用java二刷一次
 */

class Solution {
    public int search(int[] nums, int target) {
        // 获取数组的长度
        int n = nums.length;

        // 如果数组长度为0，返回-1
        if (n == 0)
            return -1;

        // 初始化左右指针
        int left = 0, right = n - 1;
        int mid;  // 定义中间指针

        // 进入二分查找的循环
        while (left <= right) {
            // 计算中间索引，避免整型溢出使用 (left + right) / 2
            mid = left + (right - left) / 2;

            // 如果目标值大于中间值，则目标值在右半部分
            if (target > nums[mid]) {
                left = mid + 1;
            }
            // 如果目标值等于中间值，则返回中间值索引
            else if (target == nums[mid]) {
                return mid;
            }
            // 如果目标值小于中间值，则目标值在左半部分
            else {
                right = mid - 1;
            }
        }

        // 如果循环结束仍未找到目标值，返回-1
        return -1;
    }
}
