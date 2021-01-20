# Created by Aashish Adhikari at 6:36 PM 1/19/2021

'''
Time Complexity:
O(l)

Space Complexity:
O(l)

'''

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: None Do not return anything, modify head in-place instead.
        """

        if head is not None:

            # find midpoint
            slow = head
            fast = head

            while fast.next is not None and fast.next.next is not None:

                slow = slow.next
                fast = fast.next.next

            # slow is the mid node of the linked list


            head2 = slow.next
            slow.next = None

            # reverse the linked list that starts from head2
            prev = None
            while head2 is not None:

                nextnode = head2.next
                head2.next = prev
                prev = head2
                head2 = nextnode

            # prev is the new head for the second linked list that has been reversed.
            head2 = prev

            # Before merging, validating that the mid point and reversal were correct by printing the values.
            #         while head is not None:
            #             print(head.val)
            #             head = head.next

            #         while prev is not None:
            #             print(prev.val)
            #             prev = prev.next


            # merge the two linked lists



            while head2 is not None:
                # why until head2 is not None? Visualize for 1,2,3 and 5,4 and you'll understand.

                temp1 = head.next
                head.next = head2
                head = temp1

                temp2 = head2.next
                head2.next = temp1
                head2 = temp2


