# time complexity is o(n), where n is the size of the input
# space complexity is o(1)
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
        if(not head or head.next == None):
            return head
            
        slow = head
        fast = head
        while(fast.next != None and fast.next.next != None):
            slow = slow.next
            fast = fast.next.next
        curr = slow.next
        # print(curr)
        slow.next = None
        prev = None
        fast = curr.next
        while(fast != None):
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        curr.next = prev
        # print(curr)
        slow = head
        while(curr != None):
            temp = slow.next
            slow.next = curr
            curr = curr.next
            slow.next.next = temp
            slow = temp
        return head
            