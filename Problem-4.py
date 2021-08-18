# Intersection of Two Linked Lists
 
# Time Complexity : O(max(M, N))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : N/A


# Your code here along with comments explaining your approach
def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
    if not headA or not headB: 
        return False

    l1, l2 = headA, headB

    # Iterate through each of the lists
    while l1 or l2:            

        # As you reach the end of any one of the list
        # Start iterating through the other one 
        if not l1: 
            l1 = headB
        if not l2: 
            l2 = headA
            
        # Similar to finding the start of Linked List Cycle, you'll reach the point where l1 == l2
        if l1 == l2:
            return l1
        
        l1 = l1.next
        l2 = l2.next
        
    return None