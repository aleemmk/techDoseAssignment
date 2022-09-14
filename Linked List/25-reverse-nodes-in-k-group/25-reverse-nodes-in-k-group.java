/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head == null || head.next == null || k==1) return head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode begin = dummy;
        ListNode next;
       // ListNode curr =head;
        int i=0;
        while(head != null){
            i++;
            next = head.next;
            if(i%k == 0)
            {
               begin =reverkGroup(begin,next);
            }
            head = next;
        }
        return dummy.next;
        
    }
    ListNode reverkGroup(ListNode begin,ListNode end){
        ListNode prev = begin;
        ListNode curr = begin.next;
        ListNode first = curr;
        ListNode next;
        
        while(curr !=end){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            
        }
        
        begin.next = prev;
        first.next = curr;
        
        return first;
    }
}