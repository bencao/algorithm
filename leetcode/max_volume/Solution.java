public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] height1 = {1, 2, 3, 4, 5};
        System.out.println(s.maxArea(height1));

        int[] height2 = {1, 3, 5, 7, 9};
        System.out.println(s.maxArea(height2));

        int[] height3 = new int[4096];
        for (int i = 0; i < 4096; i ++) {
            height3[i] = i;
        }
        System.out.println(s.maxArea(height3));

        int[] height4 = new int[4096];
        for (int i = 0; i < 4096; i ++) {
            height4[i] = 4095 - i;
        }
        System.out.println(s.maxArea(height4));
    }

    public int maxArea(int[] height) {
        int maxVolume = 0;
        int bound = height.length;
        for (int i = 0; i < bound; i ++) {
            // calculate the maxVolume which using i as lower side
            if (height[i] == 0) {
                continue;
            }
            int miniumSpan = Math.round(maxVolume / height[i]);
            for (int j = 0, span = 0; (span = i - j) > miniumSpan; j ++) {
                if (height[j] >= height[i]) {
                    int volume = span * height[i];
                    if (volume > maxVolume) {
                        maxVolume = volume;
                    }
                    break;
                }
            }
            for (int j = bound - 1, span = 0; (span = j - i) > miniumSpan; j --) {
                if (height[j] >= height[i]) {
                    int volume = span * height[i];
                    if (volume > maxVolume) {
                        maxVolume = volume;
                    }
                    break;
                }
            }
        }
        return maxVolume;
    }
}
