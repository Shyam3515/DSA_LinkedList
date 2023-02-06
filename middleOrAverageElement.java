package linkedList;

public class middleOrAverageElement {
	SinglyLL s= new SinglyLL();
	static class Node {
		int data;
		Node next;
		
		Node (int data){
			this.data=data;
			next = null;
		}
	}
	
	void insert(int data) {
		s.insert(data); 
	}

	int length() {
		int count=0;
		linkedList.SinglyLL.Node temp=s.head;
		while(temp!=null) {
			count=count+1;
			temp=temp.next;
		}
		return count;
	}
	
	float findAverage() {// Find Average of given linked list
		linkedList.SinglyLL.Node temp=s.head;
		int currIndex=0;
		float data=0.f;
		if(length()==1) {
			return (float)temp.data;
		}
		else if(length()==2) {
			data = (float)(temp.data+temp.next.data)/2;
			return data;
		} else if(length()%2!=0)
			while(currIndex!=length()/2) {
				temp=temp.next;
				currIndex++;
				data =temp.data;
			}
		else {
			while(currIndex!=(length()/2)-1) {
				temp=temp.next;
				currIndex++;
				data= (float)(temp.data+temp.next.data)/2;
			}
		}
		return data;
	}
	
	public static void main(String[] args) {
		middleOrAverageElement avg =new middleOrAverageElement();
		avg.insert(1);
		avg.insert(2);
		//avg.insert(3);
		//avg.insert(4);
		avg.insert(5);
		System.out.println("The middle Element is: "+avg.findAverage());		
	}
}
