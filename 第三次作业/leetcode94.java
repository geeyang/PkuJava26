/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result= new ArrayList<Integer>();
        Stack<TreeNode> sk = new Stack<TreeNode>(); //节点用的栈
        if(root==null)          //为空直接返回
            return result;
        TreeNode p=root;
        while(!sk.empty()||p!=null)     //栈为空且p为空说明完成树的遍历
        {
            while(p!=null)
            {             
                sk.push(p);
                p=p.left;
            }
            if (!sk.empty())
            {       
                p = sk.pop();
                result.add(p.val);
                p = p.right;
            }
        }
        return result;

    }
}