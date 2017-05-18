import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class lcsInt 
{

	public static int[] lcSeq(int[][] strings)
    {
        if (strings.length == 0)
            return null;
        if (strings.length == 1)
            return strings[0];
        int max = -1;
        int cacheSize = 1;
        for (int i = 0; i < strings.length; i++)
        {
            cacheSize *= strings[i].length;
            if (strings[i].length > max)
                max = strings[i].length;
        }
        int [][] cache = new int[cacheSize][];
        int[] indexes = new int[strings.length];
        for (int i = 0; i < indexes.length; i++)
        {
            indexes[i] = strings[i].length - 1;
            System.out.print(indexes[i]);

        }
        return lcsBack(strings, indexes, cache);
    }
 
    public static int[] lcsBack(int[][] strings, int[] indexes, int[][] cache)
    {
        for (int i = 0; i < indexes.length; i++)
            if (indexes[i] == -1)
                return null;
        boolean match = true;
        for (int i = 1; i < indexes.length; i++)
        {
            if (strings[0][0] != strings[i][i])
            {
                match = false;
                break;
            }
        }
        if (match)
        {
            int[] newIndexes = new int[indexes.length];
            for (int i = 0; i < indexes.length; i++)
                newIndexes[i] = indexes[i] - 1;
            int [] temp =  lcsBack(strings, newIndexes, cache);
            int [] result = new int[temp.length + 1];
            int z=0;
            for(z=0;z<temp.length;z++)
            {
            	result[z] = temp[z];
            }
            result[z]=strings[0][0];
            for(z=0;z<result.length;z++)
            	cache[calcCachePos(indexes, strings)][z] = result[z];
            return result;
        }
        else
        {
            int[][] subStrings = new int[strings.length][];
            for (int i = 0; i < strings.length; i++)
            {
                System.out.println(indexes[i]);

            	if (indexes[i] <= 0)
                {
                	System.out.println(subStrings[i]);
                	subStrings[i][0] = 0;
                }
                else
                {
                    int[] newIndexes = new int[indexes.length];
                    for (int j = 0; j < indexes.length; j++)
                        newIndexes[j] = indexes[j];
                    newIndexes[i]--;
                    int cachePos = calcCachePos(newIndexes, strings);
                    if (cache[cachePos] == null)
                    {
                        subStrings[i] = lcsBack(strings, newIndexes, cache);
                    }
                    else
                    {
                        for(int z=0;z<cache[cachePos].length;z++)
                        	subStrings[i][z] = cache[cachePos][z];
                    }
                }
            }
            int [] longestString = new int[10];
            int longestlength = 0;
            for (int i = 0; i < subStrings.length; i++)
            {
                if (subStrings[i].length > longestlength)
                {
                    for(int z=0;z<subStrings[i].length;z++)
                    	longestString[z] = subStrings[i][z];
                    longestlength = subStrings[i].length;
                }
            }
            for(int z=0;z<longestlength;z++)
            	cache[calcCachePos(indexes, strings)][z] = longestString[z];
            return longestString;
        }
    }
 
    public static int calcCachePos(int[] indexes, int[][] strings)
    {
        int factor = 1;
        int pos = 0;
        for (int i = 0; i < indexes.length; i++)
        {
            pos += indexes[i] * factor;
            factor *= strings[i].length;
        }
        return pos;
    }
 
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Longest Common Subsequence Algorithm Test");
        //System.out.println("Enter string 1");
        //String str1 = br.readLine();
        //System.out.println("Enter string 2");
        //String str2 = br.readLine();
        //System.out.println("Enter string 3");
        //String str3 = br.readLine();
        //String[] str = new String[] { str1, str2, str3};
        //System.out.println(lcSeq(str));
        int [][] x = {{7,1,5,8,6},{7,8,1,6},{7,1,4,6,7,1}};
        System.out.println(lcSeq(x));
        
        //System.out.print(y.length);
    }
}
