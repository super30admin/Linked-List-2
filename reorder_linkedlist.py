################## Iterative solution
# Time complexity: O(n)
# Space complexity: O(1)
# Worked on leetcode: yes
# Firstly, we split the list to 2 halves using slow and fast pointer approach, where slow moves by 1x and fast moves by 2x speed,
# till fast reaches null. Then we reverse the 2nd half of the list. Further, we combine the first half and reversed second half lists.
# This way, we reorder the entire list.

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class Linkedlist:
    def __init__(self):
        self.head = None

    # this pushes new node at the beginning of the list
    def push(self, new_data):
        new_node = Node(new_data) # first create a node
        new_node.next = self.head
        self.head = new_node


    def printlist(self):
        temp = self.head
        while (temp):
            print(temp.data, end = " ")
            temp = temp.next


    def reverse(self, head) -> None:
        prev = None
        curr_ptr = head
        next_ptr = head

        while (next_ptr != None):
            next_ptr = curr_ptr.next
            curr_ptr.next = prev
            prev = curr_ptr
            if next_ptr != None:
                curr_ptr = next_ptr

        return curr_ptr


    def reorder(self):
        if self.head == None or self.head.next == None:
            return self.head

        # first split the linkedlist into 2 halves
        slow = self.head
        fast = self.head

        while (fast != None and fast.next != None):
            slow = slow.next
            fast = fast.next.next

        # create 2 lists
        second_ptr = slow.next
        slow.next = None
        first_ptr = self.head

        # reverse the 2nd list
        second_ptr = self.reverse(second_ptr)

        # re-arrange 2 lists
        while (first_ptr != None and second_ptr != None):
            print(second_ptr)

            next_first_ptr = first_ptr.next
            next_second_ptr = second_ptr.next

            first_ptr.next = second_ptr
            second_ptr.next = next_first_ptr

            first_ptr = next_first_ptr
            second_ptr = next_second_ptr

        return self.head






llist = Linkedlist()
llist.push(5)
llist.push(4)
llist.push(3)
llist.push(2)
llist.push(1)
llist.printlist()
reverse = llist.reorder()
print("Reordered linked list")
llist.printlist()



