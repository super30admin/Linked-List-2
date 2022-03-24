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
    
    public class HeapMover{
        ListNode node;
    }
    
    static int size = 0;
    
    public void reorderList(ListNode head) {
        HeapMover left = new HeapMover();
        left.node = head;
        
        size = size(head);
        fold(left, head, 0);
    }
    
    public int size(ListNode node){
        int count = 1;
        ListNode temp = node;
        while(temp.next!=null){
            temp = temp.next;
            count = count + 1;
        }
        return count;
    }
    
    private void fold(HeapMover left, ListNode right, int floor){
        if(right==null){
            return;
        }
        fold(left, right.next, floor + 1);
         if(floor > size / 2){
            ListNode temp = left.node.next;
            left.node.next = right;
            right.next = temp;
            left.node = temp;
        }else if(floor == size / 2){
             right.next = null;
         }
    }
}
