/*
Time complexity : O(N+M).

Firstly, we need to build up the hash table. It costs O(1) to insert an item into a hash table, and we need to do
this for each of the M nodes in list B. This gives a cost of O(M) for building the hash table.

Secondly, we need to traverse list A, and for each node, we need to check whether or not it is in the hash table.
In the worst case, there will not be a match, requiring us to check all N nodes in list A. As it is also O(1) to
check whether or not an item is in a hash table, this checking has a total cost of O(N).

Finally, combining the two parts, we get O(M)+O(N)=O(M+N).

Space complexity : O(M).

As we are storing each of the nodes from list B into a hash table, the hash table will require O(M) space. Note
that we could have instead stored the nodes of list A into the hash table, this would have been a space complexity
of O(N). Unless we know which list is longer though, it doesn't make any real difference.

Did this code successfully run on Leetcode: Yes

For BruteForce check leetcode, it is O(M*N) as it will be a nested while loop comparing one node in lisA to
all the nodes in listB and then moving on to next node in listA which will again be compared to all the nodes in
listB, this goes on till nodeA becomes null or an intersection is found (bad approach, only explain in interviews,
don't code); SC = O(1)
*/

import java.util.HashSet;
import java.util.Set;

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
public class IntersectionTwoLLUsingHashSet {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB)
    {
        Set<ListNode> setB = new HashSet<>();

        //Add any list in hash set, here we add B, we are adding nodes not values so duplicates does not matter
        while(headB != null)
        {
            setB.add(headB);
            headB = headB.next;
        }

        //now we traverse over listA to see any node present in set having listb nodes
        while(headA != null)
        {
            if(setB.contains(headA)) {
                return headA;
            }

            headA = headA.next;
        }

        return null;
    }
}
