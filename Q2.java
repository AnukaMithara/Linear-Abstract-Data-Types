import java.util.*;

class Node
{
	 int data ;						//Node value
     Node nextAddr;					//Next Node address
     Node( int index )				//For get node value
      {
           data = index;
      }
}

class CircularLinkedList
{
	Node a;
	Node b;
	void list(int n)					//Method create the linked list
	{	
       	Node nd = new Node(1);			//Make first node
        Node current = nd;				//Assign current node for update
        for(int i = 2; i <= n; i++)		//Loop for make the linked list
        {
            current.nextAddr = new Node(i);
            current = current.nextAddr;
        }
        current.nextAddr = nd;			//For circular linked list
          
        a = nd;
		b = nd;
	}
	
	void josephusProblem (int m)		//Method for sloving Josephus Problem
	{		
        System.out.print("\nThe people who committed suicide: " );
        while(a.nextAddr != a) 			//Loop for getting who suicide
        {
            
            int count = 1;
            
            while(count != m)			// Find the suicde one (node)
            {
                b = a;
                a = a.nextAddr;
                count++;
            }
            System.out.print(a.data + " ");	//Display the node
            
            // Remove node m
            b.nextAddr = a.nextAddr;
            a = b.nextAddr;
        }
        System.out.println ("\nThe position to be alive: " + a.data);	//The remaining person/node
	}		
}


public class Q2 {   
    public static void main(String args[])
    {
		CircularLinkedList cll = new CircularLinkedList();	//Create a new object in CircularLinkedList class
		Scanner sc = new Scanner(System.in);				//Create a new object in Scanner class
		
		System.out.println("\t\t Josephus problem ");
		System.out.print("Number of people in group : ");	//Get user input for n value
		int n = sc.nextInt();
		
		System.out.print("The counting off number is : ");	//Get user input for mth value
		int m = sc.nextInt();
			
			//Call the methods for get output
		cll.list(n);										
		cll.josephusProblem (m);
    }
}
