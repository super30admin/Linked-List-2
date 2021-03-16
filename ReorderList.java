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
 
 // TC - O(n), SC - O(1)
 
class Solution {
    // find middle point
    // Reverse second list (from mid next point)
    // Merge 
    public void reorderList(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = reverse(slow.next);
        slow.next = null;
        
        slow = head;
        
        while(fast != null && slow != null){
            ListNode nextS = slow.next;
            ListNode nextF = fast.next;
            
            slow.next = fast;
            fast.next = nextS;
            
            slow = nextS;
            fast = nextF;
        }
        
    }
    
    private ListNode reverse(ListNode node){
        ListNode prev = null;
        while(node != null){
            ListNode newHead = new ListNode(node.val);
            newHead.next = prev;
            prev = newHead;
            node = node.next;
        }
        return prev;
    }
    
}

// class Solution {
//     public void reorderList(ListNode head) {
        
//         ListNode temp = head;
//         ListNode revListNode = reverse(temp);
//         int size = 0;
//         while(head!=null){
//             System.out.print(head.val+"->");
//             head = head.next;
//         }
//         System.out.print("null");
//         System.out.println();
        
//         while(revListNode != null){
//             System.out.print(revListNode.val+"->");
//             revListNode = revListNode.next;
//         }
//         System.out.print("null");
//     }
    
    
//     private ListNode reverse(ListNode node){
    
//         ListNode prev = null;
        
//         while(node != null){
//             ListNode newHead = new ListNode(node.val);
            
//             newHead.next = prev;
//             prev = newHead;
            
//             node = node.next;
//         }
//         return prev;
//     }
    
// }