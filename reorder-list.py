# Time O(n)
# Space O(1)
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        # Find middle
        slow = head
        fast = head
        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next
        
        # Divide list by Removing link between midlle and next elem 
        temp = slow.next
        slow.next = None
        # Reverse from middle onwards
        fast = self.reverseList(temp)
        slow = head

        # Merge two halfs
        while fast != None:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp

        return head


    def reverseList(self, slow: Optional[ListNode]) -> Optional[ListNode]:
        prev = None
        curr = slow
        while curr != None:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        return prev

