class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> result = new LinkedList<>();
        int[] count = new int[n];
        for (List<Integer> edge : edges) {
            count[edge.get(1)]++;
        }
        for (int i = 0; i < n; i++) {
            if (count[i] == 0) result.add(i);
        }
        return result;
    }
}