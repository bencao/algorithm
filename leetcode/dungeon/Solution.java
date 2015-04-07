public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] dungeon0 = new int[][] {
            { 0 }
        };
        System.out.println(s.calculateMinimumHP(dungeon0) == 1);

        int[][] dungeon1 = new int[][] {
            { 0, 1 }
        };
        System.out.println(s.calculateMinimumHP(dungeon1) == 1);

        int[][] dungeon2 = new int[][] {
            { 0, -1 }
        };
        System.out.println(s.calculateMinimumHP(dungeon2) == 2);

        int[][] dungeon3 = new int[][] {
            { 0, -1 },
            { 1, -2 }
        };
        System.out.println(s.calculateMinimumHP(dungeon3) == 2);

        int[][] dungeon4 = new int[][] {
            { 0, -10, 30 },
            { 1, -2 , -12 }
        };
        System.out.println(s.calculateMinimumHP(dungeon4) == 11);

        int[][] dungeon5 = new int[][] {
            { 0, -10, 40, -99 },
            { 10, -2 , -12, -11 }
        };
        System.out.println(s.calculateMinimumHP(dungeon5) == 11);
    }

    int[][] dungeon = null;
    int xs          = 0;
    int ys          = 0;
    int initialHP   = 0;
    int availableHP = 0;
    int minHP       = 0;

    public int calculateMinimumHP(int[][] dungeon) {
        this.dungeon = dungeon;
        xs           = dungeon.length;
        ys           = dungeon[0].length;
        initialHP    = 1;
        availableHP  = 1;
        minHP        = Integer.MAX_VALUE;

        enterDungeon(0, 0);

        return minHP;
    }

    public void enterDungeon(int x, int y) {
        int originalInitialHP   = initialHP;
        int originalAvailableHP = availableHP;

        if (dungeon[x][y] + availableHP < 1) {
            initialHP += 1 - availableHP - dungeon[x][y];
            availableHP = 1;
        } else {
            // keep initial HP not changed
            availableHP += dungeon[x][y];
        }

        if (x == xs - 1 && y == ys - 1) {
            minHP = Math.min(initialHP, minHP);
        } else {
            if (x < xs - 1) {
                enterDungeon(x + 1, y);
            }

            if (y < ys - 1) {
                enterDungeon(x, y + 1);
            }
        }

        initialHP   = originalInitialHP;
        availableHP = originalAvailableHP;
    }
}
