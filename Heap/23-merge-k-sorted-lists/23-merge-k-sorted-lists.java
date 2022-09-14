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


/**
 brute force solution 
 
 GIven : array of head pointer of list
 
 make a list of integer that contains val of all list , need to add all ist val one by one
 
 sort above list
 make a fresh linked list by pick value from sorted list .
 
 return head pointer of that list.
 
 TC
 =====
 k list
 n log n soluton
 
 better solution 
 ==================
 
 use min heap , put all head pointer in min heap .
 
 pop value from min heap ,push next value of list , and make new list with poped value.
 
 do untill heap is empty;
 return head of newly formd list
 
 TC
 
 building heap is ok size k is O(k)
 
 push/pop in heap is logk
 
 we are doing this operaton n times
 
 O(n log k)
 
*/
class Solution {
 
     public ListNode mergeKLists(ListNode[] lists) {
         
         
         
         PriorityQueue<ListNode> pq = new PriorityQueue(new Comparator<ListNode>(){
             public int compare(ListNode o1,ListNode o2){
                 return o1.val- o2.val;
             }
         });
         
         for(ListNode node:lists){
             if(node != null)
             pq.offer(node);
         }
         
         ListNode newList = new ListNode(0);
         ListNode head = newList;
         
         while(!pq.isEmpty()){
             
             ListNode minNode = pq.poll();   // min node from min heap
             
             ListNode node = new ListNode(minNode.val);  // constryct min node
             
             head.next = node;   // connect min node with last node
             
             if(minNode.next != null){  // add next element of minNode list to the minheap
                 pq.offer(minNode.next);
             }
             head = head.next;   // update last node in linkedlist in which next ,min node will be added
         }
         
         return newList.next;
     }
    
    
    /*   public ListNode mergeKLists(ListNode[] lists) {
        
        List<Integer> list = new ArrayList<>();
        
        for(ListNode listNode:lists){
            
            ListNode head = listNode;
            
            while(head  != null){
                list.add(head.val);
                head = head.next;
            }
        }
        
        Collections.sort(list);
        
        ListNode newList = new ListNode(0);
        
        ListNode head = newList;
        
        for(Integer val:list){
            ListNode listNode = new ListNode(val);
            head.next = listNode;
            head = listNode;
        }
        
        
        return newList.next;
        
    }*/
    
    
    
    
    
}