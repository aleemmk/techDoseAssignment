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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //  3 4 2   2 ->4->3
       //   4 6 5   5->6->4
        //  8 0 7   7 ->0->8
        
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;
        ListNode curr1 = l1; 
        ListNode curr2 = l2;
        int carry = 0;
        
         // ListNode prev = result;   
        while(curr1 != null || curr2!= null){
            int sum = carry;
            
            
            if(curr1 != null){
               sum += curr1.val; 
                curr1 = curr1.next;
            }
            
             if(curr2 != null){
               sum += curr2.val; 
                curr2 = curr2.next;
             }
            
            ListNode newNode = new ListNode(sum % 10);
                carry = sum/10;
                result.next = newNode;
            
            result = result.next;
        
        }
        if(carry != 0){
             ListNode newNode = new ListNode(carry);
             result.next = newNode;
        }
      
        return dummy.next;
        
    }
}