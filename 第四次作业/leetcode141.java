/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode p=head,q=head;
        boolean result=false;
        if(head==null||head.next==null)
        {
            return result;
        }
        while(q!=null&&q.next!=null&&q.next.next!=null)
        {
           
            p=p.next;
            q=q.next;
            q=q.next;
             if(p.val==q.val)
            {
                result=true;
                break;
            }
        }
        return result;
    }
}