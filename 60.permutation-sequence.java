import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=60 lang=java
 *
 * [60] Permutation Sequence
 */

// @lc code=start
class Solution {

    // got TLE
    // public String getPermutation(int n, int k) {
    // boolean marked[] = new boolean[n];
    // List<String> results = new ArrayList();
    // kth(marked, n, k, "", results);
    // return results.get(k - 1);
    // }

    // beats 8%
    public String getPermutation(int n, int k) {
        if (n == 1)
            return "1";
        int each = 1;
        for (int i = n - 1; i >= 2; i--)
            each *= i;
        int s;
        if (k % each == 0) {
            s = k / each;
            k = each;
        } else {
            s = k / each + 1;
            k = k % each;
        }
        boolean marked[] = new boolean[n];
        marked[s - 1] = true;
        List<String> results = new ArrayList();
        kth(marked, n, k, String.valueOf(s), results);
        return results.get(k - 1);
    }

    // public static void main(String[] args) {
    // Solution60 s = new Solution60();
    // System.out.println(s.getPermutation(3, 3));
    // }

    public void kth(boolean[] marked, int n, int k, String s, List<String> results) {
        int i = 0;
        for (; i < n; i++) {
            if (!marked[i]) {
                break;
            }
        }
        if (i >= n) {
            results.add(s);
            return;
        }
        String tmp;
        for (; i < n; i++) {
            if (!marked[i]) {
                marked[i] = true;
                tmp = s;
                s += String.valueOf(i + 1);
                kth(marked, n, k, s, results);
                if (results.size() == k)
                    return;
                marked[i] = false;
                s = tmp;
            }
        }
    }
}
// @lc code=end
