package recursion;

import java.util.Arrays;

public class reverseArray {
    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 4, 5, 1 };
        reverse(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void reverse(int[] arr, int l, int r) {
        if (r <= l)
            return;
        int t = arr[l];
        arr[l] = arr[r];
        arr[r] = t;
        reverse(arr, l + 1, r - 1);
    }
}
