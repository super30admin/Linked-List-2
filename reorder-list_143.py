#Approach2: find mid point reverse other half list and then start one by one node from head and reversed list
#Time Complexity O(N) One pass for traversing Linklist for storing it in stack and traversing half stack and half link list
#Space Complexity O(1)
#It successfully runs on the leetcode

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
          
        if head is None: return
        #find mid point 
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            
        prev = None
        cur = slow
        #reverse the halflist from midpoint
        while cur:
            cur.next, prev, cur = prev,  cur, cur.next
        
        #first list is head and second is mid right half reversed list             
        first = head
        second = prev
        
        #one node from both till there is a node in reversed list
        while second.next:
            first.next, first = second, first.next
            second.next, second = first, second.next



#Approach1: find mid point reverse other half list and then start one by one node from head and reversed list
# so for reversing use of stack
# store all list node pointers to stack and then
# use one node from head and set next to stack and continue doing it till mid point (half length of stack)

#Time Complexity O(N) + O(N) One pass for traversing Linklist for storing it in stack and traversing half stack and half link list
#Space Complexity O(N) for storing nodes into linklist
#It successfully runs on the leetcode

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
    
        """

        stack = []
        cur = head
        while cur:
            stack.append(cur)
            cur= cur.next  
        cur= head
        for i in range(len(stack)//2):
            temp = cur.next
            cur.next = stack.pop()
            cur = cur.next
            cur.next = temp
            cur = cur.next          
        
        cur.next = None