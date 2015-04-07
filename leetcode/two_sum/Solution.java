import java.util.HashMap;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] a = {1, 5, 3, 4, 8};

        int[] r1 = s.twoSum(a, 4);
        System.out.println(r1[0]);
        System.out.println(r1[1]);

        int[] r2 = s.twoSum(a, 6);
        System.out.println(r2[0]);
        System.out.println(r2[1]);

        int[] r3 = s.twoSum(a, 11);
        System.out.println(r3[0]);
        System.out.println(r3[1]);

        int[] r4 = s.twoSum(a, 9);
        System.out.println(r4[0]);
        System.out.println(r4[1]);
    }

    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, LinkedList<Integer>> hash = new HashMap<Integer, LinkedList<Integer>>();
        for (int i = 0; i < numbers.length; i ++) {
            if (hash.containsKey(numbers[i])) {
                LinkedList<Integer> list = hash.get(numbers[i]);
                list.add(i);
            } else {
                LinkedList<Integer> list = new LinkedList<Integer>();
                list.add(i);
                hash.put(numbers[i], list);
            }
        }

        for (int i = 0; i < numbers.length; i ++) {
            if (hash.containsKey(target - numbers[i])) {
                LinkedList<Integer> list = hash.get(target - numbers[i]);
                Integer[] indexes = list.toArray(new Integer[0]);
                for (int j = 0; j < indexes.length; j ++) {
                    if (indexes[j] != i) {
                        int[] result = new int[2];
                        result[0] = i + 1;
                        result[1] = indexes[j].intValue() + 1;
                        return result;
                    }
                }
            }
        }

        throw new RuntimeException("unable to find a two sum pair in numbers");
    }

}
