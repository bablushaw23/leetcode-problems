import javax.swing.text.rtf.RTFEditorKit;

/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 */

// @lc code=start
class Solution {

    // My approach: faster: 66%
    // public int romanToInt(String s) {
    // int number = 0, prev = Integer.MAX_VALUE;

    // for (char elem : s.toCharArray()) {
    // switch (elem) {
    // case 'M':
    // if (prev < 1000) {
    // number -= 2 * prev;
    // number += 1000;
    // } else {
    // number += 1000;
    // }
    // prev = 1000;
    // break;
    // case 'D':
    // if (prev < 500) {
    // number -= 2 * prev;
    // number += 500;
    // } else {
    // number += 500;
    // }
    // prev = 500;
    // break;
    // case 'C':
    // if (prev < 100) {
    // number -= 2 * prev;
    // number += 100;
    // } else {
    // number += 100;
    // }
    // prev = 100;
    // break;
    // case 'L':
    // if (prev < 50) {
    // number -= 2 * prev;
    // number += 50;
    // } else {
    // number += 50;
    // }
    // prev = 50;
    // break;
    // case 'X':
    // if (prev < 10) {
    // number -= 2 * prev;
    // number += 10;
    // } else {
    // number += 10;
    // }
    // prev = 10;
    // break;
    // case 'V':
    // if (prev < 5) {
    // number -= 2 * prev;
    // number += 5;
    // } else {
    // number += 5;
    // }
    // prev = 5;
    // break;
    // case 'I':
    // number += 1;
    // prev = 1;

    // }

    // }
    // return number;
    // }

    // Fastest approach: faster 74% but my logic is easy to understand
    public int romanToInt(String s) {
        int ans = 0, num = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'I':
                    num = 1;
                    break;
                case 'V':
                    num = 5;
                    break;
                case 'X':
                    num = 10;
                    break;
                case 'L':
                    num = 50;
                    break;
                case 'C':
                    num = 100;
                    break;
                case 'D':
                    num = 500;
                    break;
                case 'M':
                    num = 1000;
                    break;
            }
            if (4 * num < ans)
                ans -= num;
            else
                ans += num;
        }
        return ans;
    }
}
// @lc code=end
