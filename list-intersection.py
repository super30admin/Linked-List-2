# Time Complexity: O(m+n)
# Space Complexity: O(1)
# Approach: 
# - Get the length of both lists.
# - Move the head of longer list to the index of head of shorter list.
# - Advance both head pointers till they meet at the intersection point.
class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        # Find length of both lists
        lenA = self.get_length(headA)
        lenB = self.get_length(headB)
        
        while lenA < lenB:
            headB = headB.next
            lenB -= 1
        
        while lenB < lenA:
            headA = headA.next
            lenA -= 1
        
        while headA != headB:
            headA = headA.next
            headB = headB.next
            
        return headA
        
    def get_length(self, head):
        i = 0
        curr = head
        while curr:
            curr = curr.next
            i += 1
        return i