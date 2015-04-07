public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.convert("PAYPALISHIRING", 3));
        System.out.println(s.convert("PAYPALISHIRING", 1));
        System.out.println(s.convert("PAYPALISHIRING", 2));
        System.out.println(s.convert("ABC", 3));
        System.out.println(s.convert("ABCDE", 3));

        System.out.println(s.getConvertedIndexFor(0, 3, 3) == 0);
        System.out.println(s.getConvertedIndexFor(1, 3, 3) == 1);
        System.out.println(s.getConvertedIndexFor(2, 3, 3) == 2);

        System.out.println(s.getConvertedIndexFor(0, 5, 3) == 0);
        System.out.println(s.getConvertedIndexFor(1, 5, 3) == 2);
        System.out.println(s.getConvertedIndexFor(2, 5, 3) == 4);
        System.out.println(s.getConvertedIndexFor(3, 5, 3) == 3);
        System.out.println(s.getConvertedIndexFor(4, 5, 3) == 1);

        System.out.println(s.getConvertedIndexFor(0, 12, 4) == 0);
        System.out.println(s.getConvertedIndexFor(1, 12, 4) == 2);
        System.out.println(s.getConvertedIndexFor(2, 12, 4) == 6);
        System.out.println(s.getConvertedIndexFor(3, 12, 4) == 10);
        System.out.println(s.getConvertedIndexFor(4, 12, 4) == 7);
        System.out.println(s.getConvertedIndexFor(5, 12, 4) == 3);
        System.out.println(s.getConvertedIndexFor(6, 12, 4) == 1);
        System.out.println(s.getConvertedIndexFor(7, 12, 4) == 4);
        System.out.println(s.getConvertedIndexFor(8, 12, 4) == 8);
        System.out.println(s.getConvertedIndexFor(9, 12, 4) == 11);
        System.out.println(s.getConvertedIndexFor(10, 12, 4) == 9);
        System.out.println(s.getConvertedIndexFor(11, 12, 4) == 5);
    }

    public String convert(String s, int nRows) {
        if (nRows == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int totalChars = chars.length;
        char[] covertedChars = new char[totalChars];

        for (int i = 0; i < totalChars; i ++) {
            covertedChars[getConvertedIndexFor(i, totalChars, nRows)] = chars[i];
        }
        return new String(covertedChars);
    }

    public int getConvertedIndexFor(int i, int totalChars, int nRows) {
        int batchSize = 2 * nRows - 2;
        int lastBatchSize = totalChars % batchSize;
        int totalBatches = totalChars / batchSize + (lastBatchSize > 0 ? 1 : 0);
        int batch = i / batchSize;
        int offsetInBatch = i % batchSize;
        int row = (offsetInBatch < nRows ? offsetInBatch : batchSize - offsetInBatch);
        int rowOffset = row > 0 ? totalBatches : 0;
        for (int j = 1; j < row; j ++) {
            rowOffset += 2 * totalBatches;
            if (lastBatchSize > 0) {
                if (lastBatchSize <= j) {
                    rowOffset -= 2;
                } else if (lastBatchSize < nRows) {
                    rowOffset -= 1;
                } else if (j <= batchSize - lastBatchSize) {
                    rowOffset -= 1;
                }
            }
        }
        if (row == 0 || row == nRows - 1) {
            return rowOffset + batch + (offsetInBatch < nRows ? 0 : 1);
        } else {
            return rowOffset + 2 * batch + (offsetInBatch < nRows ? 0 : 1);
        }
    }
}
