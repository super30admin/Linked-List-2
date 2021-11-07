// reorder list
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

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
        
        
        ListNode head2 = null;
        ListNode slow = head;
        ListNode fast = head;
        
        //finding mid
        
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        head2 = slow.next;
        
        slow.next = null;
        
        head2=reverse(head2);
        
        //merge
        
        while(head2!=null){
            
            ListNode temp = head.next;
            head.next=head2;
            head2=head2.next;
            head.next.next=temp;
            head=temp;
        }
    
        
    }
    
    private ListNode reverse(ListNode head){
        
        if(head==null){
            return null;
        }
        
        ListNode curr = head;
        ListNode prev = null;
        ListNode forw = null;
        
        while(curr!=null){
            forw=curr.next;
            curr.next=prev;
            prev=curr;
            curr=forw;
//             if(forw!=null){
                
//             forw=forw.next;
//             }
        }
        
        return prev;
        
    }
}

// delete without head pointer
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}

// intersection of two linked lists
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         Set<ListNode> nodesInB = new HashSet<ListNode>();

//         while (headB != null) {
//             nodesInB.add(headB);
//             headB = headB.next;
//         }

//         while (headA != null) {
//             // if we find the node pointed to by headA,
//             // in our set containing nodes of B, then return the node
//             if (nodesInB.contains(headA)) {
//                 return headA;
//             }
//             headA = headA.next;
//         }

//         return null;
        
        
        int l1 = 0;
        int l2 = 0;
        
        ListNode curr = headA;
        
        while(curr!=null){
            
            l1++;
            curr=curr.next;
            
        }
        
        curr = headB;
        
        while(curr!=null){
            
            l2++;
            curr=curr.next;
            
        }
        
        while(l1>l2){
            
            l1--;
            headA=headA.next;
            
        }
        
        while(l2>l1){
            
            l2--;
            headB=headB.next;
            
        }
        
        while(headA!=headB){
            
            headA=headA.next;
            headB = headB.next;
            
        }
        
        return headA;
        
    }
}
