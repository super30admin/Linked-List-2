# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        slow = head
        fast = head
        while(fast and fast.next):
            slow = slow.next
            fast = fast.next.next
        second = slow.next
        slow.next = None

        reversedHead = self.reverseList(second)

        fast = reversedHead
        slow = head

        while(fast):
            temp_slow = slow.next
            slow.next = fast
            temp_fast = fast.next
            fast.next = temp_slow
            slow = temp_slow
            fast = temp_fast


    def reverseList(self, slow):


        prev= None

        while(slow):
            temp =slow.next
            slow.next = prev
            prev = slow
            slow = temp

        return prev

        while(prev!=None):
            print(prev.val)
            prev=prev.next

