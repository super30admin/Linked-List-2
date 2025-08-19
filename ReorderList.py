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
        # Step 1: Find mid
        slow = head
        fast = head
        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next

        # Step 2: Reverse the second half of list (after Mid)
        fast = self.reverse(slow.next) # calling the reverse function
        slow.next = None # slow is still linked to the next element, which needs to be broken

        # Step 3: Merge the two linked list

        while fast != None:
            temp = head.next
            head.next = fast # fast from step 1
            fast = fast.next
            head.next.next = temp
            head = temp

    def reverse(self,head: Optional[ListNode]) -> ListNode: 
        if head == None:
            return None
        prev = None
        curr = head
        fast = curr.next

        while fast != None:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        curr.next = prev # last element is linked reversed linked to the second last element
        
        return curr