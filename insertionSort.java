import java.io.*;		//To use File IO

public class insertionSort {

	public static void Sort(int[] input){
        
        int temp;
        for (int i = 1; i < input.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(input[j] < input[j-1]){
                    temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                }
            }
        }
    }

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		
		long [] time = new long[90]; 
		for(int l=0;l<70;l++)
		{
			
			long startTime = System.currentTimeMillis();
			String fileName = "inputFiles/inputReverseSorted"+l+".txt";
			FileInputStream in = null;
			String outputFile = "outputFiles/insertionSortOutReverseSortedInput"+l+".txt";
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
		         count++;
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
				 //System.out.println(list[count-1]);
				 Sort(list);
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
