    }
        
       while(true)
       {
                    if(lena>lenb)
                {
                    headA=headA.next;
                    lena--;
                        continue;
                }
                else if(lena<lenb)
                {
                    headB = headB.next;
                    lenb--;
                    continue;
                }
           else
           {
               break;
           }
       }
            while(headA!=headB)
            {
                
                
                    headA = headA.next;
                    headB= headB.next;
                
            }
        
        return headA;
      
        
    }
}
