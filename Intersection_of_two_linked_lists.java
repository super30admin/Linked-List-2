import java.util.HashSet;

public class Intersection_of_two_linked_lists {
	//Approach: 
	//1. We traverse through one of the list and store them in hashset, meanwhile traverse through the other list and check if any of the nodes is already in the set.
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode curr = headA;
        while(curr != null)
        {
            set.add(curr);
            curr = curr.next;
        }
        curr = headB;
        while(curr != null)
        {
            if(set.contains(curr))
            {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

//Time Complexity : O(n)  
//Space Complexity : O(n) where n is the number of nodes 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :
