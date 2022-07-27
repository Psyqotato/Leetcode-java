class Solution {
    public void solve(char[][] board) {
        if (board.length == 0) return;

        int m = board.length, n = board[0].length;
        UnionFind unionFind = new UnionFind(m * n + 1);
        int boardZero = m * n;

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') unionFind.union(i * n, boardZero);
            if (board[i][n - 1] == 'O') unionFind.union(i * n + n - 1, boardZero);
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') unionFind.union(j, boardZero);
            if (board[m - 1][j] == 'O') unionFind.union(n * (m - 1) + j, boardZero);
        }

        int[][] dir = new int[][]{{1,0}, {0,1}, {0,-1}, {-1,0}};
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O') {
                    for (int k = 0; k < 4; k++) {
                        int x = i + dir[k][0];
                        int y = j + dir[k][1];
                        if (board[x][y] == 'O') unionFind.union(x * n + y, i * n + j);
                    }
                }
            }
        }
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++){
                if (!unionFind.connected(i * n + j, boardZero)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
class UnionFind {
    private int count;
    private int [] parent;

    public UnionFind(int n) {
        this.count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    public void union(int pointP, int pointQ) {
        int rootP = find(pointP);
        int rootQ = find(pointQ);
        if (rootP == rootQ) return;
        parent[rootP] = rootQ;
        count--;
    }
    public boolean connected(int pointP, int pointQ) {
        int rootP = find(pointP);
        int rootQ = find(pointQ);
        return rootP == rootQ;
    }
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public int count() {
        return count;
    }
}