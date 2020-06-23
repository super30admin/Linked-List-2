# Time Complexity : O(n), where n is max length of listA or listB
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Your code here along with comments explaining your approach
class Solution(object):
    # This problem will be solved by making the length of the lists equivalent
    # by moving adjusting the length of the bigger list and then a linear
    # traversal of both the lists simultaneously will give the intersection.
    def getIntersectionNode(self, headA, headB):
        # edge case
        if not headA or not headB:
            return None
        # get length of list A
        lenA, curr = 0, headA
        while curr != None:
            lenA += 1
            curr = curr.next
        # get length of list B
        lenB, curr = 0, headB
        while curr != None:
            lenB += 1
            curr = curr.next
        # make lists equidistant
        # if listA bigger in length
        while lenA > lenB:
            headA = headA.next
            lenA -= 1
        # if listB bigger in length
        while lenB > lenA:
            headB = headB.next
            lenB -= 1
        # find intersection
        while headA != headB:
            headA = headA.next
            headB = headB.next
        # both will have the same value
        return headA
