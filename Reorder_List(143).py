# Time Complexity: O(N)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# Here we reverse the 2nd half of the LinkedList and and then traverse from their heads using 3 pointers
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head == None or head.next == None:
            return head
        # revI = self.getMidModified(head)
        slow = head
        fast = head
        # Here we use this since we need to get the first middle element in the LL
        # in our previous approach we would get the 2nd middle element
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        second = self.revL(slow.next)
        # to make 2 lists
        slow.next = None
        prev = head
        curr = second
        ahead = head
        while curr!=None:
            ahead = ahead.next
            prev.next = curr
            curr = curr.next
            prev.next.next = ahead
            prev = ahead
            # ahead = ahead.next
        return

    def revL(self,head):
        if head==None or head.next==None:
            return head
        prev = None
        curr = head
        ahead = head.next
        while curr:
            curr.next = prev
            prev = curr
            curr = ahead
            if curr==None:
                break
            ahead = ahead.next
        return prev

    # First Approach
# class Solution:
#     def reorderList(self, head: Optional[ListNode]) -> None:
#         """
#         Do not return anything, modify head in-place instead.
#         """
#         if head == None or head.next == None:
#             return head
#         revI = self.getMidModified(head)
#         prev = revI.next
#         revI.next = None
#         revI = prev
#         second = self.revL(revI)
#         prev = head
#         curr = second
#         ahead = head.next
#         while curr!=None:
#             prev.next = curr
#             prev = curr
#             curr = curr.next
#             prev.next = ahead
#             if ahead==None:
#                 prev.next = curr
#                 break
#             prev = ahead
#             ahead = ahead.next
#         return

#     def getMidModified(self,head):
#         slow = head
#         fast = head.next
#         while fast and fast.next:
#             # slow = slow.next
#             fast = fast.next.next
#             if fast==None:
#                 break
#             slow = slow.next
#         return slow

#     def revL(self,head):
#         prev = None
#         curr = head
#         ahead = head.next
#         while curr:
#             curr.next = prev
#             prev = curr
#             curr = ahead
#             if curr==None:
#                 break
#             ahead = ahead.next
#         return prev