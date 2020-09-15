  
// Time Complexity : O(N) n is the length of the bigger linked lidt   
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach: finding length of both linked lists and changinging the start points of lists accordingly



# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        
        if headA == None or headB == None:
            return None
        
        temp1 = headA
        temp2 = headB
        
        c1 = 0
        c2 = 0
        while temp1 != None:
            c1 += 1
            temp1 = temp1.next
        while temp2 != None:
            c2 += 1
            temp2 = temp2.next
            
        if c1<c2:
            diff = c2-c1
            for i in range(0, diff):
                headB = headB.next
        else:
            diff = c1-c2
            for i in range(0, diff):
                headA = headA.next
        
        while headA != None:
            if headA == headB:
                return headA
            headA = headA.next
            headB = headB.next
        
        return None
