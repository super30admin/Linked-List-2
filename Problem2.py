#Time Complexity: O(n)
#Space Complexity: O(1)
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        fast = head
        slow = head
        
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
            
        curr = slow
        prev = None
        
        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
            
        point2 = prev
      
        point1 = head
       
        while point2.next:
            temp1 = point1.next
            temp2 = point2.next
            point1.next = point2
            point1 = temp1
            point2.next = temp1
            
            point2 = temp2
        
  