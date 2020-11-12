# The easy way to solve this problem is to first find the mid of list, then reverse the other list, then merge them
#Time Complexity: O(n)
#Space Complexity: O(1)
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reorderList(self, head: ListNode) -> None:
        slow = head
        fast = head
        while fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next.next
        p1 = None
        p2 = slow
        while p2 is not None:
            temp = p2.next
            p2.next = p1
            p1 = p2
            p2 = temp
        p3 = head
        p4 = p1
        while p4.next:
            temp1 = p3.next
            p3.next = p4
            p3 = temp1
            temp1 = p4.next
            p4.next = p3
            p4 = temp1

    def printList(self,head):
        if head is None:
            return
        temp = head
        while temp is not None:
            print(temp.val)
            temp = temp.next


        
n1 = ListNode(1)
n2 = ListNode(2)
n3 = ListNode(3)
n4 = ListNode(4)
n1.next = n2
n2.next = n3
n3.next = n4
s = Solution()
s.reorderList(n1)
s.printList(n1)