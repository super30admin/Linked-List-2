#Time Complexity: O(N)
#Space Complexity: O(1)

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        if not head or not head.next:
            return
        
        # Step 1: Find the middle of the linked list
        slow = head
        fast = head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        
        # Step 2: Reverse the second half of the linked list
        second_half = self.reverseList(slow.next)
        slow.next = None
        
        # Step 3: Merge the two halves
        first_half = head
        while second_half:
            temp1 = first_half.next
            temp2 = second_half.next
            first_half.next = second_half
            second_half.next = temp1
            first_half = temp1
            second_half = temp2

    def reverseList(self, head: Optional[ListNode]) -> ListNode:
        if not head or not head.next:
            return head
        prev = None
        curr = head
        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        return prev
