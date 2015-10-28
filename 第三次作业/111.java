public class Solution {
    public int minDepth(TreeNode root) {
        List<TreeNode> queue = new ArrayList<TreeNode>();
        
        if(root == null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        TreeNode q;
        
        int n=1;int yunxing=0;
        int[] size=new int[10000];
        for(int i=0;i<10000;i++){
            size[i]=0;
        }
        size[1]=1;
        int depth=1;
        queue.add(root);
        int i=0;
        int next;
        while(queue.get(i)!=null){
            next = n+1;
            q = queue.get(i++);
            yunxing++;
            if(yunxing==size[n]){
                yunxing=0;
                n++;
            }
            if(q.left!=null){
                queue.add(q.left);
                size[next]++;
            }
            if(q.right!=null){
                queue.add(q.right);
                size[next]++;
            }
            if(q.left==null&&q.right==null){
                if(yunxing==0){
                    return n-1;
                }else{
                    return n;
                }
            }
            
        }
        return 0;
    }
}