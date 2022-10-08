#Time Complexity : O(n)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
            c1 = 0
            c2 = 0

            cur1 = headA
            cur2 = headB

            while cur1:
                c1 += 1
                cur1 = cur1.next

            while cur2:
                c2 += 1
                cur2 = cur2.next

            cur1 = headA
            cur2 = headB

            diff = abs(c1-c2)

            if c1 > c2:
                while diff:
                    cur1 = cur1.next
                    diff -= 1

            else:
                while diff:
                    cur2 = cur2.next
                    diff -= 1

            while cur1:
                if cur1 == cur2: return cur1

                cur1 = cur1.next
                cur2 = cur2.next

            return None