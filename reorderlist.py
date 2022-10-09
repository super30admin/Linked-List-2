#time complexity:o(n)
#space complexity:o(1)
#passed all cases on LeetCode:yes
#difficulty faced:-
# comments:in the code
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: 'Optional[ListNode]') -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        # ----------------------------------------------
		# Save linked list in array
		
        if not head:
            return None
        
        #first find the middle:
        
        slow, fast = head,head
        
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            
        mid = slow
        
      #reverse the 2nd half:
    
        prev,cur = None,mid

        while cur:
            temp = cur
            cur = cur.next
            temp.next = prev
            prev = temp
        head_of_second_rev = prev   

        # Update link between first half and reversed second half
        first, second = head, head_of_second_rev

        while second.next:

                next_hop = first.next
                first.next = second
                first = next_hop

                next_hop = second.next
                second.next = first
                second = next_hop