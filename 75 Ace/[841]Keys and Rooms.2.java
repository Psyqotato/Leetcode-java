class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] room = new boolean[rooms.size()];
        Queue<Integer> keys = new LinkedList<>();
        keys.offer(0);
        room[0] = true;
        int num = 0;
        while (!keys.isEmpty()) {
            int unlock = keys.poll();
            num++;
            for (int value : rooms.get(unlock)) {
                if (!room[value]) {
                    room[value] = true;
                    keys.offer(value);
                }
            }
        }
        return num == rooms.size();
    }
}