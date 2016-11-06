// http://www.spoj.com/problems/TOE2/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Stack;
import java.util.StringTokenizer;
class TOE2 {
	//...................... Global Variables .......................//
	static BitSet prime;             // used in seive generation
	// true = not prime     and false = prime
	
	//...................... Global Variables .......................//
	
	
	
	
	
	//===================  PROBLEM SOLVING COMES HERE ===== START  ====================//
	
    void solve() throws IOException, Exception {
   
    	while(true){
    		String str =" "+ in.next();
    		if(str.equals(" end"))
    			return;
    		int cx=0;
    		int co=0;
    		boolean flag = false;
    		int win_o = 0;
    		int win_x = 0;
    		
    		for(int i=0;i<str.length();i++){
    			if(str.charAt(i) == 'X')
    				cx++;
    			else if(str.charAt(i)=='O')
    				co++;
    		}
    	
    		
    			if(cx ==5 && co==4)      // case when no one win the game and there is no dot present
    				flag = true;
    			
    			for(int i=1;i<=3;i++){
    				if(str.charAt(i) == str.charAt(i+3) && str.charAt(i+3)==str.charAt(i+6) && str.charAt(i) != '.'){
    					if(str.charAt(i)=='O')
    						win_o++;
    					else
    						win_x++;
    				}
    			}
    			
    			for(int i=1;i<=9;i +=3){
    				if(str.charAt(i) == str.charAt(i+1) && str.charAt(i+1)==str.charAt(i+2) && str.charAt(i) != '.'){
    					if(str.charAt(i)=='O')
    						win_o++;
    					else
    						win_x++;
    				}
    			}
    			
    			if(str.charAt(1) == str.charAt(5) && str.charAt(5)==str.charAt(9) && str.charAt(1) != '.'){
    				if(str.charAt(1)=='O')
						win_o++;
					else
						win_x++;
				}
    			
    			if(str.charAt(3) == str.charAt(5) && str.charAt(5)==str.charAt(7) && str.charAt(3) != '.'){
    				if(str.charAt(3)=='O')
						win_o++;
					else
						win_x++;
				}	
    		
    		
    		if((win_o==1 && (win_x==1 || win_x==2)) || win_o>1 || win_x>2 || co > cx || cx > co+1 || (win_x==1 && cx==co) || (win_o==1 && co != cx))
    			out.println("invalid");
    		else if(win_o==1)
    			out.println("valid");
    		else if(win_x==1 || win_x==2 || flag)
    			out.println("valid");
    		else
    			out.println("invalid");
    			
    		
    	}// end of while
   
    }
   

    //===================  PROBLEM SOLVING COMES HERE ===== END ======================//
    
    
    
    
    
    
    public static void main(String[] args) throws FileNotFoundException, IOException, Exception {
    	
    	//--------------------------------- Console I/O ------------------------------//
    	   in = new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
           out = new PrintWriter(System.out);
    	//--------------------------------- Console I/O ------------------------------//
    	
    	
    	//--------------------------------- File I/O ---------------------------------//
        //   in = new FastScanner(new BufferedReader(new FileReader("input.txt")));
        //   out = new PrintWriter(new FileWriter("output.txt"));
        //--------------------------------- File I/O ---------------------------------//
        long start = System.nanoTime();
        new TOE2().solve();
        long stop = System.nanoTime();
      //  System.out.println("Time taken(msec) : "+ (stop-start)/1000000);
        out.close();
    }
    
    
    
    
    
    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Useful Methods START ~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    
    
    	
    
	    double fact(double n){
			if(n==0||n==1)return 1;
			else return(n*fact(n-1));
		}
	    
		double nCr(double n,double r) {
			if(n==r)
				return 1;
			else
				return (fact(n)/(fact(r)*fact(n-r)));
		}
		
	// REverse a String
		String reverse(String s) {
			return new StringBuilder(s).reverse().toString();
		}
    
    //Modular Exponentiation
	    public static long modPow(long base,long power, long m)   // with mod
	    {  // long m = (long) 1e9+7;
	    	long  result = 1;
	    	if(power==0)  return 1;
	    	if(power==1)  return base;
	    	while(power>0)
	    	{
	    	    if(power%2==1)
	    	        result = (result * base) % m;
	    	    power = power >> 1;     // divide by 2
	    	    base = (base * base) % m;
	    	}
	    	return result;
	    } 
	    
	    public static long pow(long base,long power)              // without mod
	    { 
	    	long  result = 1;
	    	if(power==0)  return 1;
	    	if(power==1)  return base;
	    	while(power>0)
	    	{
	    	    if(power%2==1)
	    	        result = result * base;
	    	    power = power >> 1;     // divide by 2
	    	    base = base * base;
	    	}
	    	return result;
	    } 
	 // END Modular Exponentiation 
	    
	    
	 // GCD && LCM 
		public static long gcd(long a ,long b){ return b == 0 ? a : gcd(b , a % b); }
		public static long lcm(long a , long b){ return a*(b/gcd(a, b)); }   
		
	 // Count Number of One's in any number
		public static int countOnes(long n){ int count = 0;
			while(n>0){
				n = n & (n-1);
				count++;
			} return count; }
	
	//Pair Compare
		static class Pair implements Comparable<Pair>
		{
			int a,b;
			Pair (int a,int b)
			{
				this.a=a;
				this.b=b;
			}
		 
			public int compareTo(Pair o) {
				// TODO Auto-generated method stub
				if(this.a!=o.a)
				    return Integer.compare(this.a,o.a);
				else
					return Integer.compare(this.b, o.b);
				//return 0;
			}
			public boolean equals(Object o) {
		        if (o instanceof Pair) {
		            Pair p = (Pair)o;
		            return p.a == a && p.b == b;
		        }
		        return false;
		    }
		    public int hashCode() {
		        return new Integer(a).hashCode() * 31 + new Integer(b).hashCode();
		    }
		    
		} 
		
		
		
	 // Sieve of erothenese
		 public static void sieve(int UB){
			//ar = new ArrayList();
			  prime = new BitSet(UB+1);
			  prime.set(0);
			  prime.set(1);
			  for(int i = 2; i*i <= UB; i++){
				if(prime.get(i) == false){
					for(int j = i*i ; j <= UB ; j += i)
						prime.set(j);
				}
			  }
				/* for(int i = 2; i <= UB; i++){
				      if(!bs[i])ar.add(i);
				}*/
		 }
		 // usage hint : if prime.get(i)  == false    then  i is prime
    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Useful Methods END ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

		 
		 
		 
		 
    static FastScanner in;
    static PrintWriter out;

    static class FastScanner {
        BufferedReader in;
        StringTokenizer st;

        public FastScanner(BufferedReader in) {
            this.in = in;
        }

        public String nextToken() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(in.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() { return Integer.parseInt(nextToken()); }
        public long nextLong() { return Long.parseLong(nextToken()); }
        public double nextDouble() { return Double.parseDouble(nextToken()); }
        public BigInteger BigInteger()throws Exception { return new BigInteger(nextToken()); }
        public String next() throws IOException { return nextToken(); }
        public String nextLine() throws IOException { return in.readLine(); }
        
        public int[] readIntArray(int n) {
            int[] ret = new int[n];
            for (int i = 0; i < n; i++) {
                ret[i] = nextInt();
            }
            return ret;
        }
        
        public void printIntArray(int ar[],int n) {
            for (int i = 0; i < n; i++) {
                System.out.print(ar[i] +" ");
            }System.out.println();
        }
        
    }
}
