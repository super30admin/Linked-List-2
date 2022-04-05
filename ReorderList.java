// Time Complexity : O(n) - traversing once till the end and then reversing(n/2) and then one-by-one(n/2) till middle changing links
// Space Complexity : O(1) - storing the references only
// Did this code successfully run on Leetcode : Yes; (https://leetcode.com/submissions/detail/674510888/)
// Any problem you faced while coding this : No
// My Notes : Traverse - Reverse till middle - Change 1-by-1 node till middle

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
            if(head.next == null){return;}
            // Find the middle=
            ListNode fastPtr = head;
            ListNode middle = head;
            while(fastPtr.next!=null && fastPtr.next.next!=null){
                fastPtr = fastPtr.next.next;
                middle = middle.next;
            }
        
            //System.out.println(" Mid Val :"+middle.val);
            // Reverse the list from the middle
            ListNode prev = null;
            ListNode curr = middle.next;
            ListNode next = null;
            while(curr!=null && curr.next!=null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            curr.next = prev;
            middle.next = curr;
            
            // Point start to the middle next
            ListNode start = head;
            while(start!=middle){
                //System.out.println(" start : "+start.val);
                // Store the 2nd Node link in temp
                ListNode temp = start.next;
                ListNode middleNext = middle.next;
                middle.next = middle.next.next;
                start.next = middleNext;
                middleNext.next = temp;
                start = temp;
            }
        }
        
        // Brute Force by moving the last node the first node next
        // Time : O(N^N) - as going from N * n-2 ...
        // Space : O(1) - just storing the node references
        public void reorderListBruteForce(ListNode head) {
            ListNode endPtr = head;
            ListNode start = head;
            while(start.next!=null && start.next.next!=null) {
                // Reach the 2nd last element; so that we can make the next as null
                while(endPtr.next.next!=null){
                    endPtr = endPtr.next;
                }
                // Store the 2nd Node link in temp
                ListNode temp = start.next;
                // Attach the last node to 1st node start
                start.next = endPtr.next;
                // Atach the 3rd node as the previously stored temp
                start.next.next = temp;
                
                // Move the start to the temp and keep doing the process
                start = temp;
                endPtr.next = null;
                endPtr = head;
            }
            
        }
    }