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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(); // Dummy node to simplify code
        ListNode current = dummy; // Pointer to build the new list
        
        // Traverse both lists
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1; // Attach list1 node
                list1 = list1.next; // Move list1 pointer
            } else {
                current.next = list2; // Attach list2 node
                list2 = list2.next; // Move list2 pointer
            }
            current = current.next; // Move the current pointer
        }
        
        // Attach the remaining elements of list1 or list2, if any
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }
        
        // Return the merged list, starting from the next node of dummy
        return dummy.next;
    }
}