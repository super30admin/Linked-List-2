"""
Time complexity: O(n)
Space complexity: O(1)
Approach:
1.Calculate the length of listA and listB.
2. Calculate the diff of the length of the two linked lists
3. iterate a pointer of the longer list to the node at the diff position.
4. point the other pointer to the start of the second list.
5. iterate both pointers together till they are equal or either one of them becomes null.
6. if pointers are equal then it is the point of intersection. return this node
7. else return None since both the nodes do not intersect.
"""
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        #if head of either lists is none return none
        if headA == None or headB == None:
            return None
        else:
            # assign iterating pointers to the start of both lists
            iterA, iterB = headA, headB
            sizeA, sizeB = 0, 0
            # calculate the size of first list
            while (iterA):
                iterA = iterA.next
                sizeA += 1
            # calculate the size of second list
            while (iterB):
                iterB = iterB.next
                sizeB += 1
            #find the larger list and iterate the pointer of that list to diff poisition of that list.
            if (sizeA > sizeB):
                diff = sizeA - sizeB
                iterA = headA
                while (diff):
                    iterA = iterA.next
                    diff -= 1
                iterB = headB
            else:
                diff = sizeB - sizeA
                if (diff == 0):
                    iterA = headA
                    iterB = headB
                else:
                    iterB = headB
                    while (diff):
                        iterB = iterB.next
                        diff -= 1
                iterA = headA

            #whlie both pointers to the list are not None increment the pointers and if they are equal
            #return that node. else when either one reaches none return none since there is no intersection.

            while (iterA != None and iterB != None):
                if iterA == iterB:
                    return iterA
                iterA = iterA.next
                iterB = iterB.next

            return None