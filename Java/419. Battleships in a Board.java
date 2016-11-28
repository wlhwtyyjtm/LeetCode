/*
解决方案1：
  从左到右、从上到下遍历地图，找到上面没有X和左面没有X的X地方就是一艘船
  根据当前搜索到位置进行比较判断，来确定是不是一艘新的船
  
  该方案是从遍历地图的角度考虑，遍历的过程中判断当前的这一个点是不是船头
*/
public class Solution {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return 0;
        }
        int xlen = board[0].length;
        int ylen = board.length;
        int count = 0;
        for (int y = 0; y < ylen; y++) {
            for (int x = 0; x < xlen; x++) {
                if (board[y][x] == 'X') {
                    if (x == 0) {
                        count += y == 0 ? 1 : board[y-1][x] == 'X' ? 0 : 1;
                    } else if (y == 0) {
                        count += board[y][x-1] == 'X' ? 0 : 1;
                    } else {
                        count += board[y-1][x] == 'X' || board[y][x-1] == 'X' ? 0 : 1;
                    }
                }
            }
        }
        return count;
    }
}

/*
解决方案2：
  思路较方案1更为简单，要统计有多少艘船，就需要找到船的唯一标识，显然这里使用船头比较合适
  问题就变成了统计地图中一共有多少个船头，而一个点是一个船头则需要同时满足一下几个方面：
  1. 这个点是X
  2. 这个点位于第一行或者上面没有X的点
  3. 这个点位于第一列或者左面没有X的点
  该方案则是从船的角度进行考虑，判断哪些点是船头，显然较之方案1中的地图角度考虑，方案2更为合理一些
*/
public class Solution {
    public int countBattleships(char[][] board) {
       int count = 0;
       for (int i = 0; i < board.length; i++) {
           for (int j = 0; j < board[0].length; j++) {
               char c = board[i][j];
               if (c == 'X' && (i == 0 || board[i-1][j] != 'X') && (j == 0 || board[i][j-1] != 'X')) {
                   count ++;
               }
           }
       }
       return count;
    }
}
