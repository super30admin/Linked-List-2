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

        Set<ListNode> nodesA = new HashSet<>();

        // store all node one linked list in a set
        while(headA != null){
            nodesA.add(headA);
            headA = headA.next;
        }

        //traverse through the other list and check if any treenode is matching or not if so return the node
        while(headB!=null){
            if(nodesA.contains(headB)){
            return headB;
        }
            headB = headB.next;
        }

        //else return null
        return null;

    }
}

//  TimeComplexity : O(N+M)
//Space Complexity : O(N)
