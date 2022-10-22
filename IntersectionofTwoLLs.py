# Using extra space

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        
        hashset = set()
        
        while headA is not None:
            hashset.add(headA)
            headA = headA.next
        
        while headB:
            if headB in hashset:
                return headB
            hashset.add(headB)
            headB = headB.next
            
        return None
    
    # This is solution using hashset
    # Time Complexity: O(m + n) where m and n are the length of the headA and headB respecively
    # Space Complexity: O(m + n)

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        
        len_a = 0
        len_b = 0
        
        curr = headA
        while curr:
            len_a += 1
            curr = curr.next
        
        curr = headB
        while curr:
            len_b += 1
            curr = curr.next
            
        while len_a > len_b:
            headA = headA.next
            len_a -= 1
            
        while len_b > len_a:
            headB = headB.next
            len_b -= 1
            
        while headA != headB:
            headA = headA.next
            headB = headB.next
        
        return headA
    
    # Not using extra space here
    # Space Complexity: O(1)
    # Time Complexity: O(m + n) for the worst case

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        
        p1 = headA
        p2 = headB
        
        while p1 != p2:
            if p1 == None:
                p1 = headB
            else:
                p1 = p1.next
            if p2 == None:
                p2 = headA
            else:
                p2 = p2.next
                
            
        return p1
    # More Intuitive approach
    # Space Complexity: O(1)
    # Time Complexity: O(m + n) for the worst case