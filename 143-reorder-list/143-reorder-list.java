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
    public void reorderList(ListNode head) {
    //      if(head == null || head.next == null || head.next.next == null) {
    //   return head;
    // }
    
    ListNode middleNode = getMiddleNode(head);
    ListNode nextList = middleNode.next;
    middleNode.next = null;
    
    ListNode reversedList = reverse(nextList);
    ListNode firstList = head;
    
    // ListNode finalList = new ListNode();
    // ListNode node = finalList;
    
//     while(firstList != null || reversedList != null) {
      
//       if(firstList != null) {
//         node.next = firstList;
//         node = node.next;
//         firstList = firstList.next;
//       }
      
//       if(reversedList != null) {
//         node.next = reversedList;
//         node = node.next;
//         reversedList = reversedList.next;
//       }
//     }
       while(reversedList!=null){ 
        ListNode temp1=firstList.next;
        ListNode temp2=reversedList.next;
            firstList.next=reversedList;
            reversedList.next=temp1;
            firstList=temp1;
            reversedList=temp2;
       }
    // return finalList.next;
  }
  
  public ListNode getMiddleNode(ListNode node) {
    ListNode slow, fast;
    
    slow = fast = node;
    
    while(fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    
    return slow;
  }
  
  public ListNode reverse(ListNode node) {
    if(node == null || node.next == null) {
      return node;
    }
    
    ListNode prev, next;
    prev = next = null;
    
    while(node != null) {
      next = node.next;
      node.next = prev;
      prev = node;
      node = next;
    }
    
    return prev;
    }
}