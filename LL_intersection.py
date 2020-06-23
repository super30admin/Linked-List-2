# Time Complexity : Add - O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. Calculate Length of both the LL
2. The idea is to use two pointers headA, and headB, the position of of the bigger LL is adjusted, such that
   the its pointer is poistion at same level as the smaller LL

3. This is achieved by the moving the larger list's pointer by difference of the lengths of the 2 LL
'''
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        
        
        if headA is None or headB is None:
            return None
        
        lenA = 0
        lenB = 0
        
        current = headA
        while current:
            lenA += 1
            current = current.next
            
        current = headB
        while current:
            lenB += 1
            current = current.next
        
        if lenA >= lenB:
            slow = headB
            fast = headA
        else:
            slow = headA
            fast = headB
            
        
        count = 0
        while count < abs(lenB - lenA):
            
            count += 1
            fast = fast.next
        
        print (fast.val)
        while fast and slow and fast != slow:
            
            slow = slow.next
            fast = fast.next
        
        return fast
                    
        