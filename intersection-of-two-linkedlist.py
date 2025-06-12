"""
Time - O(m + n)
Space - O(1)
"""
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        lista = headA
        listb = headB

        while lista != listb:
            lista = lista.next if lista else headB
            listb = listb.next if listb else headA
        
        return listb