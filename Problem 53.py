"""
Time complexity: O(n)
Space complexity: O(n)
Approach: Maintain a hashmap of all positions and nodes at those positions.
        let low = 0 and high = len of linked list
        whlie low < = high: append low to linked list and then append high.
        increment low and decrement high in each linked list.

"""
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        #if there are lest than 3 nodes return none
        if head == None or head.next == None or head.next.next == None:
            return head
        else:

            size = 0
            hashmap = dict()
            temp = head

            #populate the hashmap with (positon: nodes) and calculate the size

            while (temp):
                hashmap[size] = temp
                nex = temp.next
                temp.next = None
                temp = nex
                size += 1

            dummy, current = None, None
            low, high = 0, size - 1
            #link alternate nodes from start and end and increment low and high

            while (low <= high):

                if dummy == None:
                    dummy = hashmap[low]
                    current = dummy
                    low += 1

                    current.next = hashmap[high]
                    current = current.next
                    high -= 1
                else:
                    if low == high:
                        current.next = hashmap[low]
                        current = current.next
                        current.next = None
                        low += 1
                    else:
                        current.next = hashmap[low]
                        low += 1
                        current = current.next
                        current.next = hashmap[high]
                        high -= 1
                        current = current.next