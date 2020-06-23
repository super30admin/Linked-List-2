# Time Complexity : Add - O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. Break the LL from mid
2. Reverse the 2nd half of LL
3. Merge it using two pointers
'''
class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head is None:
            return
        
        slow = head
        fast = head
        
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        
        #slow pointer holds the middle - verify it
        # print (slow.val)
        #we got middle reset Fast to middle      
        fast = slow.next
        slow.next = None
        
        #Reverse the LL from fast pointer onwards ie. the second half
        if fast:
            prev = None
            forward = fast.next
        else:
            return
        
        while fast:
            fast.next = prev
            prev = fast
            fast = forward
            if forward:
                forward = forward.next
        
        #Now we have reversed the second half, prev hold the start pointer of reversed LL
        #reset fast to prev
        
        fast = prev
        #reset slow to head
        slow = head
        #And begin merging
        while fast:            
            temp = fast
            fast = fast.next
            
            temp.next = slow.next
            slow.next = temp
            slow = slow.next.next
        