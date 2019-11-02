# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

#Wrong answer on leetcode
#Time Complexity - More than O(n) since I am creating a queue and traversing through queue again
#Space complexity - O(n) as I am creating a queue


class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head == None or head.next == None:
            return None
        queue = []
        pointer = head
        while pointer != None:
            queue.append(pointer.val)
        pointer = head
        while queue != None:
            pointer.val = queue.pop(0)
            pointer = pointer.next
            pointer.val = queue.pop()
            pointer = pointer.next
        return head