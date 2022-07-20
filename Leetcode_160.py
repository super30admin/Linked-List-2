# Time Complexity: O(n)
# Space Complexity: O(1)


def getIntersectionNode(self, headA, headB):
        
        h1 = headA
        h2 = headB
        
        while h1 != h2:
            if not h1:
                h1 = headB
            else:
                h1 = h1.next
            
            if not h2:
                h2 = headA
            else:
                h2 = h2.next
                
        return h1