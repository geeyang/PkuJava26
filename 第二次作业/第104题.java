public class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        int ldept,rdept;
        ldept=maxDepth(root.left)+1;
        rdept=maxDepth(root.right)+1;
        if(ldept>rdept){
            return ldept;
        }
        else{
            return rdept;
        }
    }
}