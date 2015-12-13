public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    /*if (root==null||p==null||q==null) 
    {
        return NULL;
    }*/
    if (p.val< root.val&&q.val< root.val )
    {
        return lowestCommonAncestor(root.left, p, q);
    }else if (p.val> root.val&&q.val> root.val)
    {
        return lowestCommonAncestor(root.right, p, q);
    }else
    {
        return root;
    }
    }
    /*
    {
        TreeNode r=root;
       Stackp sp = new Stackp();
       void parent()
       {
            if(r)
            {
            if(r->lchild == p  || r->rchild== p){  
            printf(t->data);      
            else
            {
            parent(r->lchild);
            parent(r->rchild);
            }
        }
    }*/
}