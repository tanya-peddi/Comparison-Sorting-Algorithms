
public class lcsnumbers {
	// These are "constants" which indicate a direction in the backtracking array.
		private static final int NEITHER     = 0;
		private static final int UP          = 1;
		private static final int LEFT        = 2;
		private static final int UP_LEFT_AND_RIGHT = 3;
		private static final int RIGHT = 4;

		public static int[] LCSAlgorithm(int[] a, int[] b, int[] c) {
			int n = a.length;
			int m = b.length;
			int l = c.length;
			int S[][][] = new int[n+1][m+1][l+1];
			int R[][][] = new int[n+1][m+1][l+1];
			int ii, jj, kk;

			// It is important to use <=, not <.  The next two for-loops are initialization
			System.out.println("YAYA");
			for(ii = 0; ii <= n; ++ii) 
			{
				for(jj=0;jj<=m;++jj)
				{
					S[ii][0][0] = 0;
					R[ii][0][0] = UP;
				}
			}
			System.out.println("YAYA2");
			for(jj = 0; jj <= m; ++jj) 
			{
				for(kk=0;kk<=l;++kk)
				{
					S[0][jj][0] = 0;
					R[0][jj][0] = LEFT;
				}
			}
			System.out.println("YAYA3");
			for(kk = 0; kk <= l; ++kk) {
				for(ii=0;ii<=n;++ii)
				{
					S[0][0][kk] = 0;
					R[0][0][kk] = RIGHT;
				}
			}
			System.out.println("YAYA4");

			// This is the main dynamic programming loop that computes the score and
			// backtracking arrays.
			
			for (int ii = n - 1; i >= 0; ii--)
	        {
	            for (int jj = m - 1; jj >= 0; jj--)
	            {
	            	for(int kk=l-1;kk>=0;kk--)
	            	{
	                if (a[ii-1] == b[jj-1] && b[jj-1]==c[kk-1] && a[ii-1] == c[kk-1])
	                	S[ii][jj][kk] = S[ii-1][jj-1][kk-1] + 1;
	                else 
	                    arr[i][j] = Math.max(arr[i + 1][j], arr[i][j + 1]);
	            	}
	            }
	        }/*
			for(ii = 1; ii <= n; ++ii) 
			{
				for(jj = 1; jj <= m; ++jj) 
				{ 
					for(kk=1;kk<=l;++kk)
					{
		
						if( a[ii-1] == b[jj-1] && b[jj-1]==c[kk-1] && a[ii-1] == c[kk-1] ) {
							S[ii][jj][kk] = S[ii-1][jj-1][kk-1] + 1;
							R[ii][jj][kk] = UP_LEFT_AND_RIGHT;
						}
	
						else {
							S[ii][jj][kk] = S[ii-1][jj-1][kk-1] + 0;
							R[ii][jj][kk] = NEITHER;
						}
	
						if( S[ii-1][jj][kk] >= S[ii][jj][kk] ) {	
							S[ii][jj][kk] = S[ii-1][jj][kk];
							R[ii][jj][kk] = UP;
						}
	
						if( S[ii][jj-1][kk] >= S[ii][jj][kk] ) {
							S[ii][jj][kk] = S[ii][jj-1][kk];
							R[ii][jj][kk] = LEFT;
						}
						
						if( S[ii][jj][kk-1] >= S[ii][jj][kk-1] ) {
							S[ii][jj][kk] = S[ii][jj][kk-1];
							R[ii][jj][kk] = RIGHT;
						}
					}
				}
			}*/
			
			for(int i=0;i<l;i++)
			{
				for(int j=0;j<m;j++)
				{
					for(int k=0;k<n;k++)
					{
						System.out.print(R[k][j][i]+" ");
					}
					System.out.print("\n");
				}
				System.out.print("\n");
			}

			// The length of the longest substring is S[n][m]
			ii = n; 
			jj = m;
			kk = l;
			int pos = S[ii][jj][kk] - 1;
			int lcs[] = new int[ pos+1 ];
/*			System.out.println(R[5][4][6]);
			// Trace the backtracking matrix.
			if( R[ii][jj][kk] == RIGHT ) {
				System.out.println("YAYA6");
			}
			while( ii > 0 || jj > 0 || kk>0) 
			{
				//System.out.println("YAYA");
				if( R[ii][jj][kk] == UP_LEFT_AND_RIGHT ) {
					ii--;
					jj--;
					kk--;
					lcs[pos--] = a[ii];
					System.out.println("YAYA6");
				}
		
				else if( R[ii][jj][kk] == UP ) {
					ii--;
					//System.out.println("YAYA");
				}
				else if( R[ii][jj][kk] == LEFT ) {
					jj--;
				}
				else if( R[ii][jj][kk] == RIGHT ) {
					kk--;
				}
			}
			System.out.println("YAYA7");*/
			return lcs;
		}

		public static void main(String args[]) {
			try {
				int [] x= {7,1,5,8,6};
				int [] y= {7,8,1,6};
				int [] z= {7,1,4,6,7,1};
				int s[] = LCSAlgorithm(x, y, z);
				for(int i=0;i<s.length;i++)
					System.out.println(s[i]);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
}
