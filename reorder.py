# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

#TC: O(n)
#SC: O(1)
class Solution:
    def reorderList(self, head) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head == None or head.next == None:
            return
        slow = head
        fast = head
        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next
        
        def reversedList(head):
            prev = None
            curr = head
            fast1 = head.next
            while fast1 != None:
                curr.next = prev
                prev = curr
                curr = fast1
                fast1 = fast1.next
            curr.next = prev
            return curr

        fast = reversedList(slow.next)
        slow.next = None
        slow = head
        
        while fast != None:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp 

