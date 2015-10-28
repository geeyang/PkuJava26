public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> nums = new ArrayList<Integer>();
        Stack<TreeNode> sk = new Stack<TreeNode>(); 
        
        if(root==null){
            return nums;
        }
        if(root.left==null&root.right==null){
            nums.add(root.val);
            return nums;
        }
        sk.push(root);
        TreeNode p;
        TreeNode[] yongguo = new TreeNode[100];
        boolean b=false;
        int i;int n=1;
        for(i=0;i<100;i++){
            yongguo[i]=null;
        }
        while(!sk.isEmpty()){
            b= false;
            p=sk.pop();
            
            for(i=0;i<100;i++){
                if(yongguo[i]==p){
                    b=true;
                }
            }
            if(!b){
                nums.add(p.val);
                if(p.left!=null){
                    sk.push(p);
                    sk.push(p.left);
                    yongguo[n]=p;
                    n++;
                }else{
                    if(p.right!=null){
                        sk.push(p.right);
                    }
                }
            }else{
                if(p.right!=null){
                    sk.push(p.right);
                }
            }
        }
        return nums;
    }
}