class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] room = new boolean[rooms.size()];
        Queue<Integer> keys = new LinkedList<>();
        keys.offer(0);
        while (!keys.isEmpty()) {
            int unlock = keys.poll();
            room[unlock] = true;
            List<Integer> key = rooms.get(unlock);
            for (int value : key) {
                if (!keys.contains(value) && room[value] == flase) keys.offer(value);
            }
        }
        for (boolean value : room){
            if (value == false) return false;
        }
        return true;
    }
}