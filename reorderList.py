# // Time Complexity :O(n) for traversal,reverse and merge(3n/2)
# // Space Complexity :O(1) no extra space 
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Merge Function did not work with 1 Temp variable. Reverse function works best with Temp inside the loop.


# // Your code here along with comments explaining your approach
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        slow = head
        fast = head
        # TRAVERSE the LL to find midpoint
        while fast != None and fast.next != None:
            slow = slow.next
            fast = fast.next.next
        
        # slow is on mid; We break the conenction and reverse the list
        fast = self.reverse(slow.next)  
        slow.next = None                    

        #MERGE the 2 LL; Take 2 temps(MAIN FUNCTION)
        slow = head
        while fast != None and slow != None:
            temp1 = slow.next
            temp2 = fast.next
            slow.next = fast
            fast.next = temp1
            slow = temp1                    # new slow
            fast = temp2                    # new fast

    #the REVERSE function reverses from the current Node
    def reverse(self,head):
        if not head: return None

        prev = None
        curr = head

        while curr != None:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        return prev
