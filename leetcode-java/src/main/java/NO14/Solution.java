package NO14;
/*
思路分析：

首先检查字符串数组是否为空，如果为空则直接返回空字符串，因为没有公共前缀。
将第一个字符串作为初始的最长公共前缀，然后从第二个字符串开始遍历。
对于每个字符串，使用 indexOf() 方法来判断当前字符串是否以当前的最长公共前缀开头。
如果不是，则逐渐缩短当前的最长公共前缀，直到它成为当前字符串的前缀。
如果在缩短过程中最长公共前缀变为空字符串，则说明不存在公共前缀，直接返回空字符串。
当遍历结束时，当前的最长公共前缀即为字符串数组中的最长公共前缀。

 */
class Solution {
    // 定义一个方法，用于找到字符串数组中的最长公共前缀
    public String longestCommonPrefix(String[] strs) {
        // 如果字符串数组为空，则返回空字符串
        if (strs.length == 0) {
            return "";
        }
        // 将第一个字符串作为初始的最长公共前缀
        String what = strs[0];
        // 从第二个字符串开始遍历字符串数组
        for (int i = 1; i < strs.length; i++) {
            // 使用 indexOf 方法查找当前字符串是否以 what 开头
            // 如果不是，则逐渐缩短 what 直到它成为当前字符串的前缀
            while (strs[i].indexOf(what) != 0) {
                what = what.substring(0, what.length() - 1);
                // 如果 what 缩短为空字符串，说明没有公共前缀，直接返回空字符串
                if (what.isEmpty()) {
                    return "";
                }
            }
        }
        // 当循环结束时，what中存储的就是字符串数组中的最长公共前缀
        return what;
    }
}

