import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        int a = 0;

        int[] sample1 = new int[0];
        int[][] result1 = new int[][] { new int[0] };
        System.out.println(assetEquals(s.subsets(sample1), result1));

        int[] sample2 = new int[] { 1 };
        int[][] result2 = new int[][] {
            new int[0],
            new int[] { 1 }
        };
        System.out.println(assetEquals(s.subsets(sample2), result2));

        int[] sample3 = new int[] { 1, 2 };
        int[][] result3 = new int[][] {
            new int[0],
            new int[] { 1 },
            new int[] { 2 },
            new int[] { 1, 2 }
        };
        System.out.println(assetEquals(s.subsets(sample3), result3));

        int[] sample4 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 10, 0 };
        int[][] result4 = new int[][] {
            new int[0],
            new int[] { 1 },
            new int[] { 2 },
            new int[] { 3 },
            new int[] { 4 },
            new int[] { 5 },
            new int[] { 6 },
            new int[] { 1, 2 }
        };
        printList(s.subsets(sample4));
        System.out.println(s.subsets(sample4).size());
        System.out.println(assetEquals(s.subsets(sample4), result4));
    }

    public static void printList(List<List<Integer>> list) {
        Iterator<List<Integer>> it = list.iterator();
        while (it.hasNext()) {
            Iterator<Integer> iit = it.next().iterator();
            while (iit.hasNext()) {
                System.out.print(iit.next());
                System.out.print(' ');
            }
            System.out.println();
        }
    }

    public static boolean assetEquals(List<List<Integer>> list, int[][] result) {
        if (list.size() != result.length) {
            return false;
        }

        for (int i = 0; i < result.length; i ++) {
            int[] numbers = result[i];
            Iterator<List<Integer>> it = list.iterator();
            while (it.hasNext()) {
                boolean match = false;
                List<Integer> l = it.next();
                int[] listNumbers = listToArray(l);

                if (listNumbers.length != numbers.length) {
                    continue;
                }

                if (listNumbers.length == 0) {
                    return true;
                }

                for (int j = 0; j < listNumbers.length; j ++) {
                    if (listNumbers[j] == numbers[j]) {
                        match = true;
                    } else {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public static int[] listToArray(List<Integer> list) {
        int[] result = new int[list.size()];
        int index = 0;
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            result[index ++] = it.next();
        }
        return result;
    }

    public List<List<Integer>> subsets(int[] S) {
        int[] sortedSet = Arrays.copyOf(S, S.length);
        Arrays.sort(sortedSet);

        List<List<Integer>> result = new LinkedList<List<Integer>>();
        Map<Integer, List<List<Integer>>> map = new HashMap<Integer, List<List<Integer>>>();

        for (int n = 0; n <= sortedSet.length; n ++) {
            result.addAll(pickNItemsFromSet(map, sortedSet, n));
        }

        return result;
    }

    private List<List<Integer>> pickNItemsFromSet(Map<Integer, List<List<Integer>>> cache, int[] set, int n) {
        List<List<Integer>> combinations = new LinkedList<List<Integer>>();
        if (n > 1) {
            List<List<Integer>> previous = cache.get(n - 1);
            for (int i = 0; i < set.length; i ++) {
                Iterator<List<Integer>> it = previous.iterator();
                while (it.hasNext()) {
                    List<Integer> previousCombination = it.next();
                    boolean smaller = set[i] < previousCombination.get(0);
                    boolean contained = listContains(previousCombination, set[i]);
                    if (smaller && !contained) {
                        List<Integer> l = new LinkedList<Integer>();
                        l.add(set[i]);
                        l.addAll(previousCombination);
                        combinations.add(l);
                    }
                }

            }
        } else if (n == 1) {
            for (int i = 0; i < set.length; i ++) {
                List<Integer> l = new LinkedList<Integer>();
                l.add(set[i]);
                combinations.add(l);
            }
        } else {
            combinations.add(new LinkedList<Integer>());
        }
        cache.put(n, combinations);
        return combinations;
    }

    private boolean listContains(List<Integer> list, int i) {
        Iterator<Integer> it = list.iterator();

        while (it.hasNext()) {
            int value = it.next();
            if (value == i) {
                return true;
            } else if (value > i) {
                return false;
            }
        }

        return false;
    }
}
