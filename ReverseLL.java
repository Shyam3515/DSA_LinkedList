/*
 * Link : https://www.geeksforgeeks.org/reverse-a-linked-list/
 * Question : Given pointer to the head node of a linked list, the task is to reverse the linked list. 
              We need to reverse the list by changing the links between nodes.
   Examples           
	    Input: Head of following linked list 
		1->2->3->4->NULL 
		Output: Linked list should be changed to, 
		4->3->2->1->NULL
		
		Input: Head of following linked list 
		1->2->3->4->5->NULL 
		Output: Linked list should be changed to, 
		5->4->3->2->1->NULL     

 * Iterative Method 
	1)Initialize three pointers prev as NULL, curr as head and next as NULL.
	2)Iterate through the linked list. In loop, do following. 
	// Before changing next of current, 
	// store next node 
	3)next = curr->next
	// Now change next of current 
	// This is where actual reversing happens 
	4)curr->next = prev 
	// Move prev and curr one step forward 
	5)prev = curr 
	  curr = next	
	  
 * Time Complexity: O(n) 
   Space Complexity: O(1)	  
   	       
 */
package linkedList;

public class ReverseLL {
	static Node head;
	static class Node {
		int data;
		Node next;
		
		Node (int data){
			this.data=data;
			next = null;
		}
	}
	
	linkedList.SinglyLL.Node reverse(linkedList.SinglyLL.Node head) {
		linkedList.SinglyLL.Node prev = null;
        linkedList.SinglyLL.Node current = head;
        linkedList.SinglyLL.Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        System.out.println("p:"+prev.data);// Ans:5
        return prev;
		
	}
	void printList(linkedList.SinglyLL.Node new_head)
    {
		while (new_head != null) {
            System.out.print(new_head.data + " ");
            new_head = new_head.next;
        }
    }

	public static void main(String[] args) {
		
		SinglyLL s = new SinglyLL();
		s.insert(1);
		s.insert(2);
		s.insert(3);
		s.insert(4);
		s.insert(5);
		System.out.println("The Original linked list is:");
		s.print();
		System.out.println();

		ReverseLL r= new ReverseLL();
		linkedList.SinglyLL.Node new_head = r.reverse(s.head);// here we will pass 1st node 
		                                     // so, as each node interconnected, everything is
		                                      //taken in while loop.
		System.out.println();
	    System.out.println("Reversed linked list ");
	    r.printList(new_head);

	    
	    linkedList.SinglyLL.Node temp=s.head;
		while(temp!=null && new_head!=null) {// Traverse to last position
			// Prints data that is present in temp.
	    	if(temp.data==new_head.data) {
	    		temp=temp.next;
	    		new_head=new_head.next;
	    	}
	    	else {
	    		System.out.print(temp.data +" ");
	    	}
		}
		
	}	
}
