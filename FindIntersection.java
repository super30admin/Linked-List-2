

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class FindIntersection {

  public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

 public static void main(String[] args){

   ListNode headA = new ListNode(1);
   headA.next = new ListNode(2);
   headA.next.next = new ListNode(3);
   headA.next.next.next = new ListNode(4);

   ListNode intersect = new ListNode(5);
   intersect.next = new ListNode(6);
   intersect.next.next = new ListNode(7);

   ListNode headB = new ListNode(10);
   headB.next = new ListNode(9);
   headB.next.next = new ListNode(8);

   headA.next.next.next.next = intersect;
   headB.next.next.next = intersect;

   printList(headA);
   printList(headB);

   if(headA == null || headB == null) {
     System.out.println("NO Intersection point = ");
   }

        int countA = 0;
        int countB = 0;
        ListNode nodeA = headA;
        while(nodeA != null){
            countA++;
            nodeA = nodeA.next;
        }

        ListNode nodeB = headB;

        while(nodeB != null){
            countB++;
            nodeB = nodeB.next;
        }

        nodeB = headB;
        nodeA = headA;
        // start both at same point
        while(countB > countA){
            nodeB = nodeB.next;
            countB--;
        }

        while(countA > countB){
            nodeA = nodeA.next;
            countA--;
        }

        while(nodeA != nodeB){
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
    if(nodeA == null)    {
      System.out.println("NO Intersection point = ");
    }else{
      System.out.println("Intersection point = " + nodeA.val);
    }

 }

 private static void printList(ListNode node){
   ListNode temp = node;
   while(temp != null){
     System.out.print(temp.val + "->");
     temp = temp.next;
   }

   System.out.print("\n");
 }

}
