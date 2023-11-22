# O(N) -- O(1)
class Solution:
    def reverseAndGetHead(self, head):
        prev = None
        curr = head
        nextNode = None

        while curr:
            nextNode = curr.next
            curr.next = prev

            prev = curr
            curr = nextNode
        return prev

    def breakMidAndGetHead(self, head):
        slow = head
        fast = head.next

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        
        #Break at Middle
        secondHead = slow.next 
        slow.next = None

        return secondHead

    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if not head.next or not head.next.next:
            return head
        head1 = head
        #Break Middle & get the 2nd head
        head2 = self.breakMidAndGetHead(head1)

        #Reverse Head2 and get new Head2
        head2 = self.reverseAndGetHead(head2)

        #Two pointer - way of joining the two nodes
        resultHead = head1

        while head1 and head2:
            nextHead1 = head1.next
            nextHead2 = head2.next

            head1.next = head2
            head2.next = nextHead1

            head1 = nextHead1
            head2 = nextHead2
    
        return resultHead