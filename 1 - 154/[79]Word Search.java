import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                if (existSolution(board, word, i, j, 0, used)) return true;
            }
        }
        return false;
    }
    public boolean existSolution(char[][] board, String word, int i, int j, int index, boolean[][] used) {
        if (used[i][j] == true) return false;
        if (board[i][j] != word.charAt(index)) {
            return false;
        }else if (index == word.length() - 1){
            return true;
        }
        used[i][j] = true;
        int up = 0, down = board.length - 1, left = 0, right = board[0].length - 1;
        if (i > up && existSolution(board, word, i - 1, j, index + 1, used)) {
            return true;
        }
        if (i < down && existSolution(board, word, i + 1, j, index + 1, used)) {
            return true;
        }
        if (j > left && existSolution(board, word, i, j - 1, index + 1, used)) {
            return true;
        }
        if (j < right && existSolution(board, word, i, j + 1, index + 1, used)) {
            return true;
        }
        used[i][j] = false;
        return false;
    }
}