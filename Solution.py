'''
PROBLEM 1

TIME COMPLEXITY: O(Number of nodes)
SPACE COMPLEXITY: O(N)

- use DFS to add elements on the extreme left of the root, when next is called, pop the item from stack and apply DFS on right child of item 
- For hasNext, return False if size of stack is zero otherwise return True
- For DFS function, keep adding the left child in stack until you reach None

'''


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    
    def __init__(self, root: TreeNode):
        self.stack=[]
        # stack.append(root)
        self.dfs(root)

    def next(self) -> int:
        """
        @return the next smallest number
        """
        nextE=self.stack.pop()
        self.dfs(nextE.right)
        return nextE.val
    
        
        

    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        return len(self.stack)!=0        
    
    def dfs(self,root):
        while(root!=None):
            self.stack.append(root)
            root=root.left

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next


'''
PROBLEM 2

TIME COMPLEXITY: O(N)
SPACE COMPLEXITY: O(1)

- find the mid point of the linked list
- reverse the second half of the list and make them two separate linked lists
- merge the two linked lists by linking node of first linkedlist to node of second linked list

'''
class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head==None or head.next==None:
            return head
        slow=head
        fast=head
        
        while(fast.next!=None and fast.next.next!=None):
            fast=fast.next.next
            slow=slow.next
            
        head2=self.reverse(slow.next)
        slow.next=None
        
        # print(head)
        # print(head2)
        while(head!=None and head2!=None):
            temp=head.next
            head.next=head2
            head2=head2.next
            head.next.next=temp
            head=temp
        
        
        
    def reverse(self,root):
        prev=None
        current=root
        fast=root.next
        
        while(fast!=None):
            current.next=prev
            prev=current
            current=fast
            fast=fast.next
        current.next=prev
        
        return current



'''
PROBLEM 3

TIME COMPLEXITY: O(N)
SPACE COMPLEXITY: O(1)

- get the length of two linked lsits
- move the head equal to the difference of lengths on linked list that has greater length, so that both linked lists have same number of nodes from the back
- move both the head until they point to the same node
- return either of heads

'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        temp1=headA
        temp2=headB
        lenA=0
        lenB=0
        
        while(temp1!=None):
            temp1=temp1.next
            lenA+=1
            
        while(temp2!=None):
            temp2=temp2.next
            lenB+=1
        
        while lenA>lenB:
            headA=headA.next
            lenA-=1
        
        while lenB>lenA:
            headB=headB.next
            lenB-=1
        
        while(headA!=headB):
            headA=headA.next
            headB=headB.next
        
        return headA
            