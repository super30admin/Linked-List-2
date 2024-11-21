# // Time Complexity :O(n) 
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach
# We will use 2 pointers, when they finish first traversal
# we will initialize them again from opposite pointer start

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        

        slow = headA            #pointerA 
        fast = headB            #pointerB

        while slow != fast:         # while they are not onm the same node
            if slow != None:        # not end
                slow = slow.next
            else:
                slow = headB        # restart from other end
            
            if fast != None:
                fast = fast.next
            else:
                fast = headA        # restart from other end
        
        return slow