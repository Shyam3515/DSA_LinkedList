package linkedList;

import linkedList.SinglyLL.Node;

public class middleElement {
	static SinglyLL sl=new SinglyLL();

	void findMiddleElement() { // Naive Approach
		 if(sl.head==null)
	        System.out.println("LL Empty..");
		 else 
		 {
			int Totalcount = sl.length();
			int currIndex=0;
		    linkedList.SinglyLL.Node temp= sl.head;
		    System.out.println("count: "+Totalcount);
			while(currIndex!=Totalcount/2) {
				System.out.println("CurrINdex: "+currIndex);
				temp=temp.next;
				currIndex++;
			}
		 System.out.println("The middle1 Element is: "+temp.data);
		 }	
	}
	
	void findMiddle_betterApproach() { //Efficient Approach
        if(sl.head==null)
        	System.out.println("LL Empty..");
        else {
        	Node slow = sl.head;
            Node fast = sl.head;
         while(fast!=null && fast.next!=null ) {
        	 fast=fast.next.next;
        	 slow=slow.next;        	
         }
         System.out.println("The Middle Element is: "+ slow.data);
        }
	}
	
	public static void main(String[] args) {
		middleElement m= new middleElement();
		sl.insert(11);
		sl.insert(12);
		sl.insert(13);
		sl.insert(15);
		sl.print();
		System.out.println();

		m.findMiddleElement();
		m.findMiddle_betterApproach();
	}
}