import java.util.*;
public class leetcode234 {
	public static void main(String[] args){
		int[] ss = new int[100];
		Scanner in = new Scanner(System.in);
		int i=0;
		ListNode head ;
		
        head = new ListNode(1);
        ListNode x = new ListNode(2);
        head.next = x;
        ListNode y = new ListNode(3);
        x.next = y;
        ListNode z = new ListNode(2);
        y.next = z;
        ListNode t = new ListNode(2);
        z.next = t;
        ListNode u = new ListNode(1);
        t.next = u;
        System.out.println(isPalindrome(head));
	}
	
	 public static boolean isPalindrome(ListNode head) {
	        if(head==null){
	            return true;
	        }
	        if(head.next==null){
	            return true;
	        }
	        int n=1;
	        int i=1;
	        ListNode x=head;
	        ListNode y=head;
	        ListNode z;
	        while(x.next!=null){
	            n++;
	            x=x.next;
	        }
	        ListNode rear = x;
	        if(n%2==0){
	            while(i<n/2){
	                y=y.next;
	                i++;
	            }
	        }
	        else{
	            while(i<n/2+1){
	                y=y.next;
	                i++;
	            }
	        }
	        
	            while(y.next!=rear){
	                z=y.next;
	                y.next = z.next;
	                z.next = rear.next;
	                rear.next=z;
	            }
	            x=head;
	            z=y.next;
	            while(z!=null){
	                if(x.val==z.val){
	                    x=x.next;
	                    z=z.next;
	                }
	                else{
	                    return false;
	                }
	            }
	            return true;
	       
	        
	    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) 
    { val = x;
    next = null;
    }
}
