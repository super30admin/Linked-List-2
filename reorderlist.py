# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

#Accepted on leetcode
#Time Complexity - O(n) as we are traversing through every node
#Space complexity - O(1) as we are simply creating two pointers

class Solution(object):
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: None Do not return anything, modify head in-place instead.
        """
        def reverse_list(head):
            if head == None:
                return None
            prev = None
            current = head
            next = head.next
            while next != None:
                current.next = prev
                prev = current
                current = next
                next = current.next
            current.next = prev
            return current
        if head == None or head.next == None:
            return None
        slow = head
        fast = head
        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next
        fast = reverse_list(slow.next)
        slow.next = None
        slow = head
        while slow != None and fast != None:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp
        return head