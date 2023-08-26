# Problem4  (https://leetcode.com/problems/intersection-of-two-linked-lists/)
# // Time Complexity : O(m + n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach
def getIntersectionNode(headA, headB):
    # taking curr ptr
    curr = headA
    # taking 2 variables for length of A and B LL
    lengthA = lengthB = 0
    # iterating over the LL to find length of LL-A
    while curr:
        curr = curr.next
        lengthA += 1

    curr = headB
    # iterating over the LL to find length of LL-B
    while curr:
        curr = curr.next
        lengthB += 1

    # Bringing the 2 head equal distance from meeting point
    while lengthA > lengthB:
        headA = headA.next
        lengthA -= 1

    while lengthB > lengthA:
        headB = headB.next
        lengthB -= 1

    # finding the meeting point
    while (headA != headB):
        headA = headA.next
        headB = headB.next

    return headA
