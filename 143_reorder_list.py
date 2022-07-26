'''
## Problem 143: Reorder list.

## Author: Neha Doiphode
## Date:   07-23-2022

## Description
    You are given the head of a singly linked-list.
    The list can be represented as: L0 → L1 → … → Ln - 1 → Ln

    Reorder the list to be on the following form: L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

    You may not modify the values in the list's nodes. Only nodes themselves may be changed.

## Examples:
    Example 1:
        Input: head = [1,2,3,4]
        Output: [1,4,2,3]

    Example 2:
        Input: head = [1,2,3,4,5]
        Output: [1,5,2,4,3]

## Constraints:
    The number of nodes in the list is in the range [1, 5 * 104].
    1 <= Node.val <= 1000

## Time complexity: O(n), where n is number of nodes in the linked list.

## Space complexity: O(1), since no auxiliary space is used.

'''

from typing import List, Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def get_input():
    print("Enter the list of integers to be added to the linked list(with spaces): ", end = "")
    inp = input()
    inp = [int(val) for val in inp.split()]

    head = None
    last = None
    for val in inp:
        if head == None:
            head = ListNode(val)
            last = head
        else:
            last.next = ListNode(val)
            last = last.next
    print()
    return head, inp

class Solution:
    def display(self, head):
        temp = head
        while temp.next:
            print(f"{temp.val} -> ", end = "")
            temp = temp.next
        print(f"{temp.val}")
        print()

    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head == None:
            return head

        # Step 1: Get to the mid point of the list
        #         Two pointer technique is used for this.
        dummy = ListNode(-1)
        dummy.next = head
        slow = fast = dummy

        while fast != None and fast.next != None:
            slow = slow.next
            fast = fast.next.next

        # Step 2: Reverse the linked list
        previous = None
        current = slow.next
        slow.next = None

        while current:
            nxt = current.next
            current.next = previous
            previous = current
            current = nxt

        # Step 3: Reorder list
        l1 = head
        l2 = previous
        while l1 and l2:
            temp = l1.next
            l1.next = l2
            l2 = l2.next
            l1.next.next = temp
            l1 = temp

        if l2:
            l1.next = l2

        return dummy.next

# driver code
solution = Solution()
head, inp = get_input()
print("Original input list: ", end = "")
solution.display(head)
print()
head = solution.reorderList(head)
print("Output reordered list: ", end = "")
solution.display(head)
print()
