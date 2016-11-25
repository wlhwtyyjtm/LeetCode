/*
解决方案1：
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
