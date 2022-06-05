class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        
        def get_len( node ):
            len_ = 0 
            while  node:
                len_ += 1
                node = node.next
            return len_
    
        len_ll1 = get_len(headA)
        len_ll2 = get_len(headB)
        temp = None
        
        # print(" headA, headB.val ", headA.val, headB.val)
        
        if len_ll1 < len_ll2:
            temp = headA
            headA = headB
            headB = temp
        diff = abs( len_ll1 - len_ll2  )
        # print(" headA, headB.val ", headA.val, headB.val)
        # print("diff",diff)
        for i in range(diff):
            headA = headA.next
        # print(" headB, curr_A.val ", headB.val, curr_A.val)
        while headA != headB:
            headA = headA.next 
            headB = headB.next 
        return headB
        
