# Time Complexity :Extra_space= O(N), Inplace= O(N)
# Space Complexity :Extra_space= O(N), Inplace= O(1)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach
    # for Extra_space() traverse through the array and store all elements in an array, 
    # then go through half of the array and insert new nodes in the list, make the last nodes reached None

    # for inplace() break the list into two halves, such that we have the latter part in reverse order, 
    # then merge them going through both of them. 


class Solution:

    def Extra_space(self, head):
        temp=head
        a=[]
        while(temp):
            a.append(temp.val)
            temp=temp.next
        i=0
        j=len(a)-1
        temp=head
        while(i<j):
            new_node=TreeNode(a[j])
            new_node.next=temp.next
            temp.next=new_node
            temp=new_node.next
            i+=1
            j-=1
        if(len(a)%2):
            temp.next=None
        else:
            new_node.next=None
    
    def inplace(self, head):
        slow=head
        fast=head
        while(fast.next and fast.next.next):
            slow= slow.next
            fast=fast.next.next
        fast=slow.next
        slow.next=None
        prev=None
        temp=fast

        while(temp):
            f=temp.next
            temp.next=prev
            prev=temp
            temp=f

        fast=prev
        slow=head
        inserted=None
        while(slow and fast):
            inserted=slow.next
            slow.next=fast
            fast=fast.next
            slow.next.next=inserted
            slow=inserted

    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        # self.Extra_space(head)
        self.inplace(head)
