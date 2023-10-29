'''
1. 3 Steps: 1.  Find the middle of the linked list. 2. Reverse the second half of the linked list. 3. Merge the two linked lists.
2. Do not use recursion as we are looking for O(1) space complexity.

TC: O(n)
SC: O(1)
'''
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
        
        if not head or not head.next:
            return head
        
        slow = head
        fast = head

        # Find the middle of the linked list
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        
        if fast.next:
            slow = slow.next
        
        # Reverse the second half of the linked list
        def reverseList(head: Optional[ListNode]) -> ListNode:
            if head == None or head.next == None:
                return head
            
            prev = None
            cur = head
            fast = cur.next

            while fast:
                cur.next = prev
                prev = cur
                cur = fast
                fast = fast.next
            
            cur.next = prev
            return cur

        fast = reverseList(slow.next)

        # Make the last node of the first half point to None
        slow.next = None

        # Move the slow pointer to the head of the first half
        slow = head

        # Merge the two linked lists using a temp variable
        while fast: 
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp
            temp = slow.next

        