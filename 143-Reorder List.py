#check This
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        curr = head
        queu = deque([])
        while curr:
            queu.append(curr)
            curr = curr.next
        
        head = queu.popleft()
        curr = head
        valFront = False 
        while queu:
            if valFront:
                temporary = queu.popleft()
            else:
                temporary = queu.pop()
            valFront = not valFront
            curr.next = temporary 
            curr = curr.next 
		## remoember to remove the last node's next pointer to avoid cycle
        curr.next = None 
        
# T.C => O(N) Since we traverse through whole list
# S.C => O(N) s=usning stack from start to end
#approach => Here we define curr as head, and defining dequeue.
#appending all the values in the queu. poping all the left value and setting valFront as False.
#traversing throug the queu and storing all the temporary value in popleft and creating a node. just iterating in same way to get make the result