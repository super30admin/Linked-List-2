"""
Time: O(m+n)
Space: O(1)
Leet: Accepted
Problems: Had a tough time understanding the merging technique. Had to refer solutions.
"""


class Solution(object):
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: None Do not return anything, modify head in-place instead.
        """
        if not head:
            return None
        #Find middle of list and split the list into two
        slow = head
        fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        mid = slow.next
        slow.next = None

        #Reverse the second list
        curr = mid
        prev = None
        nex = None
        while curr:
            nex = curr.next
            curr.next = prev
            prev = curr
            curr = nex


        second = prev #start of second list(now reversed)

        #Merging the two lists
        first = head
        temp = head #temp is used to access element whose next is to be changed
        first = first.next #element which is to be next of next
        while second:
            temp.next = second #point to required element
            second = second.next #move pointer ahead. This element will be next of next
            temp = temp.next #this element is next
            #Used to put next.next in variable 'first' as decided
            #Used to bring previous next.next to next for next iteration
            if first:
                first,second = second,first
        return head
