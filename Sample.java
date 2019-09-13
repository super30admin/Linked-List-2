// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes, no of times submit was done to be accepted: 2, missed an edge case
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Approach:
//1. Keep iterating over the 2 lists simultaneously using 2 pointers until end of the lists is reached.
//2. When end is reached, make pointer of the list to point to head of the other list.
//3. Intuition: If there is an intersection btw 2 lists, then the 2 pointers should meet within m+n moves, where m+n is sum of the lengths of 2 lists.
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
        if(headA==null || headB==null) return null;
        int m = 0;
        int n = 0;
        ListNode a = headA;
        ListNode b = headB;
        
        while(a!=null){
            m++;
            a=a.next;
        }
        while(b!=null){
            n++;
            b=b.next;
        }
        a=headA;
        b=headB;
        int counter = 0;
        while(a!=b && counter<m+n){
            if(a.next==null){
                a=headB;                   
            }
            else {
                a=a.next;
            }
            if(b.next==null){
                b=headA;
            }
            else{
                b=b.next;
            }
            counter++;
        }
        if(a==b){
            return a;    
        }
        return null;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes, no of times submit was done to be accepted: 1
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Approach:
//starting from the node to be deleted to the end of list, copy the value of next node to current node.
//when we reach the last but one node, we remove the last node by making last but one node point to null.
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
        while(node.next!=null){
            node.val=node.next.val;
            if(node.next.next==null){
                node.next=null;
            }
            else{
                node=node.next;
            }
        }
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n), considering recursion stack
// Did this code successfully run on Leetcode : Yes, no of times submit was done to be accepted: 3
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Approach:
//1. reverse the second half of the list.
//2. now rearrange the pointers to get the output.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;
        int length=0;
        ListNode a = head;
        while(a!=null){ // find the length of list
            a=a.next;
            length++;
        }
        a=head;
        int mid=length/2-1;
        int count=0;
        while(count<mid){ // assign a pointer to mid of list
            a=a.next;
            count++;
        }
        ListNode b=reverse(a.next, null); // reverse the second half of list
        
        a.next=null;
        a=head;
        ListNode t1=null;
        ListNode t2=null;
        while(true){ // change order of each node in 2 lists
            t1=a.next;
            a.next=b;
            t2=b.next;
            if(t1==null){
                break;
            }
            b.next=t1;
            a=t1;
            b=t2;
        }
    }
    
    private ListNode reverse(ListNode curr, ListNode prev){
        if(curr==null){
            return prev;
        }
        ListNode node = reverse(curr.next, curr);
        curr.next=prev;
        return node;
    }
}
