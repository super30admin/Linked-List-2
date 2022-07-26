'''

## Problem 160: Intersection of two linked lists.

## Author: Neha Doiphode
## Date:   07-23-2022

## Description:
    Given the heads of two singly linked-lists headA and headB,
    return the node at which the two lists intersect.
    If the two linked lists have no intersection at all, return null.

    For example, the following two linked lists begin to intersect at node c1:
    a1->a2->
              \
              c1->c2->c3
              /
    b1->b2->b3

    The test cases are generated such that there are no cycles anywhere in the entire linked structure.
    Note that the linked lists must retain their original structure after the function returns.

    Custom Judge:
        The inputs to the judge are given as follows (your program is not given these inputs):

        * intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
        * listA - The first linked list.
        * listB - The second linked list.
        * skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
        * skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.

        The judge will then create the linked structure based on these inputs and
        pass the two heads, headA and headB to your program.
        If you correctly return the intersected node, then your solution will be accepted.

## Examples:
    Example 1:
        Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
        Output: Intersected at '8'
        Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
                     From the head of A, it reads as [4,1,8,4,5].
                     From the head of B, it reads as [5,6,1,8,4,5].
                     There are 2 nodes before the intersected node in A;
                     There are 3 nodes before the intersected node in B.

    Example 2:
        Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
        Output: Intersected at '2'
        Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
                     From the head of A, it reads as [1,9,1,2,4].
                     From the head of B, it reads as [3,2,4].
                     There are 3 nodes before the intersected node in A;
                     There are 1 node before the intersected node in B.

    Example 3:
        Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
        Output: No intersection
        Explanation: From the head of A, it reads as [2,6,4].
                     From the head of B, it reads as [1,5].
                     Since the two lists do not intersect, intersectVal must be 0,
                     while skipA and skipB can be arbitrary values.
                     The two lists do not intersect, so return null.

## Constraints:
    The number of nodes of listA is in the m.
    The number of nodes of listB is in the n.
    1 <= m, n <= 3 * 104
    1 <= Node.val <= 105
    0 <= skipA < m
    0 <= skipB < n
    intersectVal is 0 if listA and listB do not intersect.
    intersectVal == listA[skipA] == listB[skipB] if listA and listB intersect.

## Follow up: Could you write a solution that runs in O(m + n) time and use only O(1) memory?

## Time complexity: Please refer to respective doc-strings of different approaches used below.

## Space complexity: Please refer to respective doc-strings of different approaches used below.

'''
from typing import List, Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def display(self, head):
        temp = head
        while temp.next:
            print(f"{temp.val} -> ", end = "")
            temp = temp.next
        print(f"{temp.val}")
        print()

    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        '''
        Time complexity: O(m + n), where m and n are lengths of linked list A and B respectively.
                                   since, we traverse both linked lists.
        Space complexity: O(m) or O(n), either of the lists we can choose to store in the hashmap.
        '''
        if headA == None or headB == None:
            return None

        lookup = {}
        intersect = False

        temp = headA

        while temp:
            lookup[temp] = temp.val
            temp = temp.next

        temp = headB
        while temp:
            if temp in lookup:
                intersect = True
                break
            temp = temp.next

        if intersect:
            return temp
        return None

    def getIntersectionNode_no_extra_space(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        '''
        Time complexity: O(m + n), where m and n are lengths of linked list A and B respectively.
                                   since, we traverse both linked lists.
        Space complexity: O(1), No auxiliary space is used.
        '''
        if headA == None or headB == None:
            return None

        len_A = len_B = 0
        temp = headA
        while temp:
            len_A += 1
            temp = temp.next

        temp = headB
        while temp:
            len_B += 1
            temp = temp.next

        diff = 0
        l1 = headA
        l2 = headB

        if len_A > len_B:
            diff = len_A - len_B
            while diff:
                l1 = l1.next
                diff -= 1
        else:
            diff = len_B - len_A
            while diff:
                l2 = l2.next
                diff -= 1

        intersect = False
        while l1 and l2:
            if l1 == l2:
                intersect = True
                break
            l1 = l1.next
            l2 = l2.next

        if intersect:
            return l1
        return None


# Driver code
intersect = ListNode(4)

l1 = ListNode(1)
l1.next = ListNode(2)
l1.next.next = ListNode(3)
l1.next.next.next = intersect

l2 = ListNode(10)
l2.next = ListNode(8)
l2.next.next = intersect
l2.next.next.next = ListNode(7)
l2.next.next.next.next = ListNode(6)

solution = Solution()
print("Test case 1: Original lists are: ")
print()
print("l1 = ", end = "")
solution.display(l1)
print("l2 = ", end = "")
solution.display(l2)
result = solution.getIntersectionNode(l1, l2)
print(f"Approach 1: Using auxiliary space: Lists intersect at node: {result.val}", end = "")
print()
result = solution.getIntersectionNode_no_extra_space(l1, l2)
print(f"Approach 2: No auxiliary space: Lists intersect at node: {result.val}", end = "")
print()

l1 = ListNode(1)
l1.next = ListNode(2)
l1.next.next = ListNode(3)
l1.next.next.next = ListNode(4)

l2 = ListNode(10)
l2.next = ListNode(8)
l2.next.next = ListNode(7)
l2.next.next.next = ListNode(6)

print()
print("Test case 2: Original lists are: ")
print()
print("l1 = ", end = "")
solution.display(l1)
print("l2 = ", end = "")
solution.display(l2)
result = solution.getIntersectionNode(l1, l2)
if result != None:
    result = result.val
print(f"Approach 1: Using auxiliary space: Lists intersect at node: {result}", end = "")
print()
result = solution.getIntersectionNode_no_extra_space(l1, l2)
if result != None:
    result = result.val
print(f"Approach 2: No auxiliary space: Lists intersect at node: {result}", end = "")
print()
