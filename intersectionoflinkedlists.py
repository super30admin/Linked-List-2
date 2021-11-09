# Time Complexity :O(n+m) 
# Space Complexity :O(m)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this : No
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
#         O(N+M)--->TC
# SC--->O(M)
        list1 = set()
        root1 = headA
        root2 = headB
        while root1 :
            list1.add(root1)
            root1 = headA.next
            headA = root1 
        while root2 :
            if root2 in list1 :
                return root2
            else :
                root2 = headB.next
                headB = root2
        return root2