# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: ListNode) -> None:
        if head == None or head.next == None:
            return
        slow = head
        fast = head
        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next
        fast = self.reverseList(slow.next)
        slow.next = None
        slow = head
        
        while fast != None:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp
        
    def reverseList(self, head: ListNode) -> ListNode:
        if head == None or head.next == None:
            return head
        fast = head.next
        curr = head
        prev = None
        while fast != None:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        curr.next = prev
        return curr

# Time Complexity : O(n)
# Space Complexity : O(1)