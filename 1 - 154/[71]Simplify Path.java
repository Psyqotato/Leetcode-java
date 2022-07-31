import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Stack<String> res = new Stack<>();
        for (String onePath :  paths) {
            if (onePath.isEmpty() || onePath.equals(".")) continue;
            if (onePath.equals("..")) {
                if (!res.isEmpty()) res.pop();
                continue;
            }
            res.push(onePath);
        }
        String result = "";
        while (!res.isEmpty()) {
            System.out.println(result);
            result = "/" + res.pop() + result;
            System.out.println(result);
        }
        return (result.isEmpty())? "/" : result;
    }
}