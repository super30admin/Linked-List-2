'''

## Problem: Delete without head pointer

## Author: Neha Doiphode
## Date:   07-23-2022

## Description:
    you are given a pointer/ reference to the node which is to be deleted from the linked list of N nodes.
    The task is to delete the node. Pointer/ reference to head node is not given.
    Note: No head reference is given to you.
    It is guaranteed that the node to be deleted is not a tail node in the linked list.

    Your Task:
    You only need to complete the function deleteNode that takes reference to the node that needs to be deleted.
    The printing is done automatically by the driver code.

## Examples:
    Example 1:
        Input:
                N = 2
                value[] = {1,2}
                node = 1
        Output: 2
        Explanation: After deleting 1 from the linked list, we have remaining nodes as 2.

    Example 2:
        Input:
                N = 4
                value[] = {10,20,4,30}
                node = 20
        Output: 10 4 30
        Explanation: After deleting 20 from the linked list, we have remaining nodes as 10, 4 and 30.

## Constraints:
    1 <= N <= 103

## Time complexity : O(1), as we have direct access to the node to be deleted, we don't have to traverse the list.

## Space complexity : O(1), no auxiliary space is used to delete the node.

'''

from typing import List

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

    def deleteNode(self, number_of_nodes: int, value: List[int], node: ListNode) -> List[int]:
        if node == None:
            return None

        if node.next:
            node.val = node.next.val
            node.next = node.next.next

# driver code
solution = Solution()
l1 = ListNode(1)
l1.next = ListNode(2)
l1.next.next = ListNode(3)
l1.next.next.next = ListNode(4)
l1.next.next.next.next = ListNode(5)
solution.display(l1)
node = l1.next.next
solution.deleteNode(5, [1, 2, 3, 4, 5], node)
solution.display(l1)
