'''
160 Intersection of Two Linked Lists

https://leetcode.com/problems/intersection-of-two-linked-lists/description/


Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

For example, the following two linked lists begin to intersect at node c1:

The test cases are generated such that there are no cycles anywhere in the entire linked structure.

Note that the linked lists must retain their original structure after the function returns.


Example 1:
Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
Output: Intersected at '8'
Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
- Note that the intersected node's value is not 1 because the nodes with value 1 in A and B (2nd node in A and 3rd node in B) are different node references. In other words, they point to two different locations in memory, while the nodes with value 8 in A and B (3rd node in A and 4th node in B) point to the same location in memory.

Example 2:
Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
Output: Intersected at '2'
Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.

Example 3:
Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
Output: No intersection
Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
Explanation: The two lists do not intersect, so return null.

Constraints:
The number of nodes of listA is in the m.
The number of nodes of listB is in the n.
1 <= m, n <= 3 * 104
1 <= Node.val <= 105
0 <= skipA <= m
0 <= skipB <= n
intersectVal is 0 if listA and listB do not intersect.
intersectVal == listA[skipA] == listB[skipB] if listA and listB intersect.

Solution:
1. Brute Force:
For each node in list 1, traverse every node in list 2 and check if node from list 1 == node from list 2.
Time: O(MN), Space: O(1)

2. Hashing:
Traverse list 1 and save every node in a hash set. Now traverse list 2 and compare if the node from list 2 already exists in the hast set. The first node that exists in the hash set is the intersecting node. If none of the nodes in list 2 exist in the hash set, then the two lists do not intersect.
Time: O(M+N), Space: O(min(M,N)) (min(M,N) since we save the nodes from the smaller list in the hash set)

3. Difference of lengths:
Compute the length of the two lists. Whichever is the longer list, traverse that list up to a node where the distance between that node and end of longer list = length of the shorter list.

Now, traverse both the lists, one node at a time, and check if both the nodes match. If they match we have found the intersecting node. If not, go to the next node. If we reach end of the lists, then there is no intersecting node.
https://youtu.be/6laukTeU1WY?t=7

Time: O(M+N), Space: O(1)
'''
from linked_list import *

def compute_len(head):
    node = head
    if not node:
        return 0
    l = 0
    while node:
        l += 1
        node = node.next
    return l

def build_intersecting_lists(list_1, list_2, n):
    '''
      list_1 = array of node values of linked list 1
      list_2 = array of node values of linked list 2
      n = index of first intersecting node from the end
      If the lists do not intersect, use n = -1

      e.g.
      list_1 = [4,1,8,4,5]
      list_2 = [5,6,1,8,4,5]
      n = 3  (hence, intersecting node = 8)
    '''
    sll_1, len_1 = build_linked_list(list_1), len(list_1)
    sll_2, len_2 = build_linked_list(list_2), len(list_2)

    if n != -1:
        # index of the intersecting node from the beginning of list 1
        k = len_1 - n
        node_1 = sll_1
        i = 0
        while node_1:
            if i == k:
                break
            node_1 = node_1.next
            i += 1

        # index of the node prior to the intersecting node from the beginning of list 2
        k = len_2 - n - 1
        node_2 = sll_2
        i = 0
        while node_2:
            if i == k:
                break
            node_2 = node_2.next
            i += 1

        # connect both the lists using the intersecting node
        node_2.next = node_1

    return sll_1, sll_2

def get_intersection_node(head_A, head_B):
    if not head_A or not head_B:
        return None

    len_A = compute_len(head_A)
    len_B = compute_len(head_B)

    # whichever is the longer list, traverse that list up to a node where the distance between that node and end of longer list = len of the shorter list
    if len_A > len_B:
        node = head_A
        while node and len_A > len_B:
            len_A -= 1
            node = node.next
        head_A = node
    elif len_B > len_A:
        node = head_B
        while node and len_B > len_A:
            len_B -= 1
            node = node.next
        head_B = node

    # At this point, head_A and head_B are positioned at the same distance from end of list
    node_A, node_B = head_A, head_B
    common_node = None
    while node_A:
        if node_A == node_B:
            common_node = node_A
            break
        node_A = node_A.next
        node_B = node_B.next

    return common_node

def run_get_intersection_node():
    tests = [([4,1,8,4,5],[5,6,1,8,4,5], 3, 8),
             ([1,9,1,2,4],[3,2,4], 2, 2),
             ([2,6,4],[1,5],-1,None),
            ]
    for test in tests:
        head_A, head_B, nth_node_from_end, ans = test[0], test[1], test[2], test[3]
        sll_A, sll_B = build_intersecting_lists(head_A, head_B, nth_node_from_end)

        common_node = get_intersection_node(sll_A, sll_B)
        print(f"\nSLL A = {head_A}")
        print(f"SLL B = {head_B}")
        result = common_node.val if common_node else None
        print(f"Intersecting node = {result}")
        print(f"Pass: {ans == result}")

run_get_intersection_node()