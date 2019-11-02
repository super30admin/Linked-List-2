// Time Complexity : O(MN)
// Space Complexity : O(M+N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : can reduce the time complexity but not sure about the algo


// Your code here along with comments explaining your approach



//  Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution{

    public void remove(ListNode node){
        node.val = node.next.val;
        node.next = node.next.next;

    }
}