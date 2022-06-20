# Time Complexity : O(m+n)
# Space Complexity : O(1);
# Any problem you faced while coding this : No
#
#

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


# deleting node 5 without having reference to head of the linked list.
class Solution:
    def deleteNode(self, currNode):
        currNode.val = currNode.next.val
        prev = currNode
        currNode = currNode.next
        prev.next = currNode.next

    def printList(self):
        temp = check
        while temp:
            print(temp.val, end=" ")
            temp = temp.next


check = ListNode(1)
check.next = ListNode(2)
check.next.next = ListNode(3)
check.next.next.next = ListNode(4)
check.next.next.next.next = ListNode(5)
check.next.next.next.next.next = ListNode(6)
check.next.next.next.next.next.next = ListNode(7)
check.next.next.next.next.next.next.next = ListNode(8)
Solution().deleteNode(check.next.next.next.next)
Solution().printList()
