import java.util.Deque;
import java.util.LinkedList;


//Idea: add all element except head into dqueue and iterate again over dqueue till it gets empty. while removing element from dqueue maintain counter.
//if counter value divisble by 2 then remove element which is inserted first otherwise remove element which is inserted last.And assing that element after head.
//keep repeating the process till queue beocme empty
//Time complexity : O(n)

//Space complexity : O(1)

//run on leetcode :yes
//any problem faced:no


public class ReorderLinkedList {
	//ListNode class
	public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
    
        public static void reorderList(ListNode head) {
            
        	//dqueue initializing
            Deque<ListNode> dqueue = new LinkedList<>();
            if(head ==null || head.next ==null) return;
            ListNode temp = head.next;
            
            //inserting element into dqueue except head.
            while(temp!=null)  {
                dqueue.offer(temp);
                temp = temp.next;
            }
            int count =1;
            ListNode prev = head;
             ListNode next ;
             //remove first element from dqueue if counter is divible by 2 otherwise remove last element. name it as next
             //prev is head element.
             //assigning prev next element as next.
             
            while(!dqueue.isEmpty()){
                if(count%2 ==0){
                     next = dqueue.pollFirst(); //remove element which is inserted first
                }else{
                      next = dqueue.pollLast();//remove element which is inserted last
                }
                prev.next = next;   
                prev = next;
                count++;   //increase counter
            }
            
            prev.next =null;
        }
        // prints content of double linked list 
        static void printList(ListNode node) { 
            while (node != null) { 
                System.out.print(node.val + " "); 
                node = node.next; 
            } 
        }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(85); 
        head.next = new ListNode(15); 
        head.next.next = new ListNode(4); 
        head.next.next.next = new ListNode(20); 
        
        reorderList(head);
        System.out.println("reordered linked list "); 
        printList(head); 
	}

}
