import java.util.ArrayList;

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        List<Integer> num = new ArrayList<>();
        num.add(head.val);
        while (head.next != null) {
            head = head.next;
            num.add(head.val);
        }
        int[] nums = new int[num.size()];
        for (int i = 0; i < num.size(); i++) nums[i] = num.get(i);
        return buildTree(nums, 0, nums.length - 1);
    }

    public TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) return null;
        TreeNode cur = new TreeNode();
        int mid = left + (right - left) / 2;
        cur.val = nums[mid];
        cur.left = buildTree(nums, left, mid - 1);
        cur.right = buildTree(nums, mid + 1, right);
        return cur;
    }
}