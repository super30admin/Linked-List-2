# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# Step 1. Calculate the Mid
# Step 2. Reverse the second half
# Step 3.Merge the two list
# Step 4.Break connection 
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        # Step 1 ------ Calculate the mid------------------
        slow = head
        fast = head
        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next
        
        # Step 2: Reverse the second half
        fast = self.reverse(slow.next)
        slow.next = None # Step4 Breakconnectiom

        # Step 3: Merge
        slow = head
        while fast != None:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp

    def reverse(self, head: Optional[ListNode]) -> ListNode:
        if head == None or head.next == None:
            return head
        
        prev = None
        curr = head
        
        while curr != None:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        return prev
            


        
        