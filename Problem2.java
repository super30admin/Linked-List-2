// Time Complexity : O(n) where n = length of linked list
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.*;

// Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Problem2 {
    
    public static void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        
        // Find the mid node 
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse second part of linked list
        ListNode prev = null, curr = slow;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        // Merge 2 linked lists
        ListNode ptr_first = head, ptr_second = prev;
        while (ptr_second.next != null) {
            ListNode next_first = ptr_first.next;
            ptr_first.next = ptr_second;
            ptr_first = next_first;
            
            ListNode next_second = ptr_second.next;
            ptr_second.next = ptr_first;
            ptr_second = next_second;
        }
        
    }

    public static ListNode makeLinkedList(int[] arr) {
        ListNode head = null;
        for (int i = 0; i < arr.length; i++)
            head = insertNode(head, arr[i]);
        return head;
    }

    private static ListNode insertNode(ListNode head, int val) {
        ListNode temp = new ListNode(val);
        if (head == null)
            head = temp;
        else {
            ListNode curr = head;
            while (curr.next != null)
                curr = curr.next;
            curr.next = temp;
        }
        return head;
    }

    public static void printLinkedList(ListNode head) {
        ListNode curr = head;
        List<Integer> ans = new ArrayList<Integer>(); 
        while (curr != null) {
            ans.add(curr.val);
            curr = curr.next;
        }
        System.out.println(ans);
    }
 
    public static void main(String args[]) {
        int arr[] = {1,2,3,4};
        ListNode head = makeLinkedList(arr);
        // printLinkedList(head);
        reorderList(head);
        printLinkedList(head);
    }
}
