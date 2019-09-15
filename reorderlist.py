# leetcode: accepted
# no doubts
# time complexity: o(n)
# explaintation:  find the middle node of the linkedlist using two pointers(fast and slow) and

# after finding the middle node, make the sedcond half as a separate linkedlist by taking head2 as the head os the scecond linked list and then make slow.next=Null

# reverse the  second linked list from the middle node to the end of the linkedlist.
# Now there are two head1 and head2, taeke n1 and n2 which are respective nexts of head1 and head2. make head1.next=head2 and update head1=n1 and head2.next=n2 and keep going

# youtube link: https://www.youtube.com/watch?v=9Dh24T-FfDE&feature=youtu.be


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        slow = head
        fast = head
        if head == None or head.next == None:
            return None
        if head is not None:
            while (fast != None and fast.next != None):
                slow = slow.next
                fast = fast.next.next

        temp = slow.next
        slow.next = None
        prev = None
        curr = temp
        n = None
        while (curr != None):
            n = curr.next
            curr.next = prev
            prev = curr
            curr = n
        head2 = prev
        while (head2 != None):
            n1 = head.next
            head.next = head2
            head = n1
            n2 = head2.next
            head2.next = n1
            head2 = n2





