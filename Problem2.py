#Time Complexity: O(n) for both
#Space Complexity: O(1), O(n) for solution queue
#LeetCode: Yes

from collections import deque


class Node:
    def __init__(self,data):
        self.data = data
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = None
        self.tail = None


    def append(self,data):
        new_node = Node(data)
        temp = self.head
        if self.head is None:
            self.head = new_node
            return
        while(temp):
            temp = temp.next
        temp.next = new_node

    def reoderList_usingQueue(self):
        q = deque()
        temp  = self.head 
        while(temp):
            temp = temp.next
            if temp is None:
                break;
            q.append(temp)
        
        while q:
            if self.head:
                temp = q.pop()
                self.head.next = temp
                self.head = self.head.next
            
            if self.head and q:
                temp = q.leftpop()
                self.head.next = temp
                self.head = self.head.next


    def reoderList(self):
        slow, fast = self.head, self.head

        #Find Middle Point
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next

        #Reverse Second List, breaking into two lists
        prev, cur = None, slow.next
        slow.next = None
        while cur:
            tmp = cur.next
            cur.next = prev
            cur = tmp
            prev = cur
        
        #Merge first and Second Half
        first_head,second_head = self.head, prev
        while second_head:
            tmp1, tmp2 = first_head.next, second_head.next
            first_head.next = second_head
            second_head.next = tmp1
            first_head,second_head = tmp1, tmp2
        


