class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head is None or head.next is None:
            return head
        
        slow = head
        fast = head
        
        
        # Getting the mid element
        # fast.next for odd length case whhile next.next is for the even length case
        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next
            
        # reversing the list after mid
        fast = self.reverse_list(slow.next) # The linked list after mid
        slow.next = None # Splitted the list into two
        
        
    
            
        # Now merging the two lists that we get
        # In case of 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
        # list 1: 1 -> 2 -> 3 -> 4
        # list 2: 7 -> 6 -> 5 (reversed linked list after mid)
        # Merging both now
        
        slow = head
        temp = slow.next
        
        while fast != None:
            
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp
            if temp != None:
                temp = temp.next
                
        
        
    def reverse_list(self,head):
        
        prev = None
        curr = head
        fast = head.next
        
        while fast != None:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
            
        curr.next = prev # reversing the last element because loop ended before it did
        return curr
    
    # Time Complexity: O(n)
    # Space Complexity: O(1)