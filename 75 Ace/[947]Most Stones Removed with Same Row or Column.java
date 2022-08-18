class Solution {

    public int removeStones(int[][] stones) {
        UF uf = new UF(stones.length);
        for (int i = 0; i < stones.length - 1; i++) {
            for (int j = i + 1; j < stones.length; j++) {
                if ((stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) && !uf.isConnected(i, j)) {
                    uf.union(i, j);
                }
            }
        }
        return stones.length - uf.count();
    }
}

class UF {
    private int count;
    private int[] parent;

    public UF(int n) {
        this.count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        parent[rootQ] = rootP;
        count--;
    }

    public boolean isConnected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
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