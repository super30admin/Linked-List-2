#intersection of nodes

# // Time Complexity : O(N)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no



def getIntersectionNode(self, headA, headB):
        lena=0
        lenb=0
        a=headA
        b=headB
        while(a):                                           #find the lengths of the first and second linkedlist
            lena+=1
            a=a.next
        while(b):
            lenb+=1
            b=b.next
        while(lena>lenb):                                   #one you find the length, decrease the length of the longer one by the difference between the two
            lena-=1
            headA=headA.next
        while(lenb>lena):
            lenb-=1
            headB=headB.next
        while(headA and headB):                             #after they are both of the same length, keep iterating until they equal each other, if not return None
            if(headA==headB):
                return headA
            headA=headA.next
            headB=headB.next
        return None