import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class countingSort {
	public static int[] Sort(int[] a, int k) 
	{
        int c[] = new int[k];
        for (int i = 0; i < a.length; i++)
            c[a[i]]++;
        for (int i = 1; i < k; i++)
            c[i] += c[i-1];
        int b[] = new int[a.length];
        for (int i = a.length-1; i >= 0; i--)
            b[--c[a[i]]] = a[i];
        return b;
    }
	
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		long [] time = new long[90]; 
		long startTime=0;
		for(int l=0;l<70;l++)
		{
			
			
			String fileName = "inputFiles/inputReverseSorted"+l+".txt";
			FileInputStream in = null;
			String outputFile = "outputFiles/countingSortOutReverseSortedInput"+l+".txt";
			Writer wr = new FileWriter(outputFile);
		    try {
		         in = new FileInputStream(fileName);	//argument 0 will be name of input file
		         //out = new FileOutputStream("insertionSortOut.txt");
		         int c;
		         int count=0;
		         String tempStr="";char ch;		
		         String number="";
		         while ((c = in.read()) != -1)
		         {
		        	 ch=(char)c;
		        	 if(ch == ',')
		        	 {
		        		 count++;
		        		 //System.out.println(tempStr);	 
		        	 }
	        		 tempStr = tempStr+""+ch;
		        	 
		        	 	
		         }
		         count=count+2;
	        	 //System.out.print(tempStr); 
	        	 int [] list = new int[count];
	        	 int i=0;
	        	 for(int j=0;j<tempStr.length();j++)
	        	 {
	        		 if(tempStr.charAt(j)==',')
	        		 {
	        			 list[i++]=Integer.parseInt(number);
	        			 number="";
	        		 }
	        		 else
	        			 number=number + ""+tempStr.charAt(j);
	        	 }
				 list[i++]=Integer.parseInt(number);
				 startTime = System.currentTimeMillis();
				 //System.out.println(list[count-1]);
				 list=Sort(list,count);
	        	 for(int k=0;k<count;k++)
	        	 {
	        		 wr.write(String.valueOf(list[k])+" ");
	        	 }  
		    }
		    catch(IOException e)
		    {
		    	e.printStackTrace();			//Exception handling if any problems with input file
		    }
		    finally
		    {
		         if (in != null) 
		         {
		            in.close();				//closing input file
		            wr.close();				//closing output file
		         }
		         
			
	
		    }
		    long endTime   = System.currentTimeMillis();
		    long totalTime = endTime - startTime;
		    time[l]=totalTime;
		    System.out.println(time[l]);
		}
	}

}
