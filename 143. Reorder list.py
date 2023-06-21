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
        if head is None or head.next is None:
            return None
        slow = head
        fast = head

        while fast.next !=None and fast.next.next !=None:
            slow = slow.next
            fast = fast.next.next
        
        fast = self.reverse(slow.next) #we did fast = reverse() because fast would be pointing at head of reveresed linked list
        slow.next =None
        slow = head
        #Merge the linked lists
        while(fast!=None):
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next=temp
            slow = temp

    def reverse(self,head:[ListNode]):
        prev = None
        curr = head
        fast = head.next
        while(fast!=None):
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        curr.next = prev
        return curr
