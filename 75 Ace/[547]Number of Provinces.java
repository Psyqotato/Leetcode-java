
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int n;
    boolean[] visited;
    public int findCircleNum(int[][] isConnected) {
        int result = 0;
        n = isConnected.length;
        visited = new boolean[n];
        for (int i = 0; i < n; i++){
            if (!visited[i]) {
                dfs(isConnected, i);
                result++;
            }
        }
        return result;
    }

    void dfs(int[][] isConnected, int i) {
        for (int j = 0; j < n; j++) {
            if (!visited[j] && isConnected[i][j] == 1) {
                visited[j] = true;
                dfs(isConnected, j);
            }
        }
    }
}