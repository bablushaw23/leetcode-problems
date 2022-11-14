package recursion;

import java.util.ArrayList;
import java.util.List;

public class SubArray {
    public static void main(String[] args) {
        int A[] = new int[] { 1, 2, 3 };
        List<List<Integer>> subarrays = new ArrayList();
        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                List<Integer> subarray = new ArrayList();
                for (int k = i; k <= j; k++)
                    subarray.add(A[k]);
                subarrays.add(subarray);
            }
        }
        System.out.println(subarrays);
    }
}
