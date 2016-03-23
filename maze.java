import java.util.*;
import java.io.*; 
public class maze
{

	public static void main(String args[]) throws FileNotFoundException
	{
		
		 int[][] matrix= new int[15][5];

	
		 try
			{
			BufferedReader f1= new BufferedReader(new FileReader("CreateMaze.txt"));
			Scanner in =new Scanner(f1);
			//String row;
				//int[][] matrix= new int[15][5];
			int[] l1= new int[5];
			
			String line = null;
			int i=0;
			while((line = f1.readLine())!=null)
			{
				int j=0;
				int k=0;
				int g=0;
				//row=in.nextLine();
				String h[]=line.split(" ");
				//System.out.println(line);
				while(j<5 )
				{
				
					matrix[i][j]=Integer.parseInt(h[g++]);
					j=j+1;
					//k=k+2;
				}
				i=i+1;
			}
			/*for(int z=0;z<15;z++)
			{
				for(int j=0;j<5;j++)
				{
					System.out.print(matrix[z][j]+" ");
				}
				System.out.println();
			}*/
			
		 BufferedReader f2= new BufferedReader(new FileReader("TraverseMaze.txt"));
		Scanner on =new Scanner(f2);
		
		BufferedWriter writer = 
			    new BufferedWriter(new FileWriter("Destinations.txt"));
	

		int currentRoom=0;
		String line1 = null;
		while((line1 = f2.readLine())!=null)
		{

			int y=0;
			int hh=1;
			String[] kk=line1.split(" ");
			int roomNumber=Integer.parseInt(kk[y++]);
			int jj=kk.length;
			boolean flag=true;
			while(hh<jj)
			{
				hh++;
				
				int n=Integer.parseInt(kk[y++]);
				
				currentRoom=matrix[roomNumber-1][n+1];
				if(currentRoom!=0)
					roomNumber=currentRoom;
				
			}
			
			String str = Integer.toString(roomNumber);
			writer.write(str);
			writer.newLine();

		}
		
		
		writer.close();
	    }
	    catch(Exception E)
		{
		System.out.println("Exception raised");
		}

}
}