import java.util.*;

class Priority_Queue 
{
 
 int size = 100;			//Initialize the size of the Queue
 int A[]=new int[size];		//Initialize the Queue array
 int head = -1;				//Initialize the head of the Queue
 int tail = 0;				//Initialize the tail of the Queue


	void insert(int a)		//Method for insert an element into Queue
	{	
		 if(head<size)		//If head not reached to Queue size,
		 
		 {	
			head++;			//head index will increase
			swap(a);		//call the method for sort the input value
		 }	 
	}	
	
	void swap(int b)
	{
		int temp = head;	
		for(int i=tail;i<= head;i++)	/*element inserted in the proper position 
										to maintain the order*/
		{
			if(b < A[i])				/*When checking order,
										if the elemnt is not match order*/
			{
				temp = i;
				break;
				
			}
		}
		
		for(int j = head;j > temp;j--)	//Other elemnts index are increase by 1
		{
			A[j] = A[j-1];
			
		}
		
		A[temp] = b;					//New element insert to the order
		
	} 
	
	void remove()						//Method for reduce the front of Queue
	{	
		 if(tail <= head)				//If values exist in Queue
		 {	
			tail++;						//tail value will increase
		 }		 
	}
 
	void maximizeArraySum(int k)		//Method for find the maximized sum of the array	
	{ 
	 
		while((k != 0) && (A[tail] != 0))	/*loop the steps, relative to the k value
												or tail value not equal to zero*/									
		{ 	
			int t = -A[tail];
			System.out.print("\n\n" + A[tail] + " value replaced by "+ t +" value");  
			remove();
			insert(t) ;				//insert new changed value of tail
			
									//change the index of tail 
		 
			System.out.print("\nUpdated Queue array \t: ");  
			display();						
			 
			k--;		 
		}
	 System.out.println("\nThe maximize array sum = "+ arraySum());  //get the sum of updated array
		 						
	} 
	 
	int arraySum()					//Method for get array sum
	{
		int sum = 0;
		for(int j = head;j>= tail; j--)
		{
			sum+=A[j];
		}
		return sum;
		
	}
	
	void display()					//Method for display the array
	{
		System.out.print(" {" ); 
		for(int i =tail; i<=head; i++)
		{
			System.out.print("  " + A[i] );
		}
			System.out.print(" }" ); 
	} 
	
}	
	
class Q1 
{
 public static void main(String[] args)
		 {			 
			 Priority_Queue pq = new Priority_Queue();
			 
			 pq.insert(-2);
			 pq.insert(8);
			 pq.insert(1);
			 pq.insert(4);
			 pq.insert(-1);
			 pq.insert(6);
			 System.out.print("Priority Queue \t\t: " ); 
			 pq.display();
			 
			 pq.maximizeArraySum(3); 			//Input K
			 
		 }
}