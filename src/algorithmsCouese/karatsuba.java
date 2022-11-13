package algorithmsCouese;

public class karatsuba {
	
	public static String minus(String x,String y) {
		String sum="";
		int lenmax = Math.max(x.length(), y.length());
		int lenmin = Math.min(x.length(), y.length());
		String shiftdif = "0".repeat(lenmax-lenmin);
		if (x.length() > y.length()) {
			y = shiftdif + y;
		}
		else if (x.length() < y.length()) {
			x = shiftdif + x;
		}
		int index =0;
		for (int i=lenmax-1;i>=0;i--) {
			
			int xi = x.charAt(i) - '0';
			int yi = y.charAt(i) - '0';
			int xy = 0;
			if(index ==1) {
				xy = xi-yi-1;
				if (xy <0) {
					index =1;
					xy=10+xy;
					sum = Integer.toString(xy) + sum;
					index =1;
				}
				else {
					sum = Integer.toString(xy) + sum;
					index=0;
				}
				
			}
			else {
				xy = xi-yi;
				if (xy <0) {
					index =1;
					xy=10+xy;
					sum = Integer.toString(xy) + sum;
					index =1;
				}
				else {
					sum = Integer.toString(xy) + sum;
					index=0;
				}
			}
		}
		return sum;
	}
		
	
	public static String added(String x,String y) {
		String sum="";
		int lenmax = Math.max(x.length(), y.length());
		int lenmin = Math.min(x.length(), y.length());
		String shiftdif = "0".repeat(lenmax-lenmin);
		if (x.length() > y.length()) {
			y = shiftdif + y;
		}
		else if (x.length() < y.length()) {
			x = shiftdif + x;
		}
		int index =0;
		for (int i=lenmax-1;i>=0;i--) {
			
			int xi = x.charAt(i) - '0';
			int yi = y.charAt(i) - '0';
			int xy = 0;
			if(index ==1) {
				xy = xi+yi+1;
				sum = Integer.toString((xy)%10) + sum;
			}
			else {
				xy = xi+yi;
				sum = Integer.toString((xy)%10) + sum;
			}
			if (xy >=10) {
				index =1;
				if (i==0) {
					sum = Integer.toString(1) + sum;
				}
			}
			else {
				index=0;
			}
		}
		return sum;
	}
	
	
	public static String[] fixlength(String x,String y) {
		
		int lenmax = Math.max(x.length(), y.length());
		int lenx = x.length();
		int leny = y.length();
		int sq = 2;
		while(lenmax > sq ) {
			sq = sq*2;
		}
		int len = sq;
		String shiftx = "0".repeat(len-lenx);
		String shifty = "0".repeat(len-leny);
		y = shifty + y;
		x = shiftx + x;
		return new String[] {x,y};
	}
	public static String multiply(String x,String y) {
		if (x.length()==1 || y.length()==0) {
			int xi =Integer.parseInt(x);
			int yi =Integer.parseInt(y);
			return Integer.toString(xi*yi);
		}
		
		String a ="",b="",c="",d="";
		String ac ="",bd="",abcd="",ad_bc="";
		String shiftac ="",shiftadbc="";

		String[] xynew = fixlength(x,y);
		x = xynew[0];
		y = xynew[1];
		int len = x.length();
		int mid = len/2;
		
		for (int i=0;i<x.length();i++) {
			if(i<mid) {
				a = a + x.charAt(i);
				c = c + y.charAt(i);
				shiftac = shiftac + "00";
				shiftadbc = shiftadbc + "0";
			}
			else {
				b = b + x.charAt(i);
				d = d + y.charAt(i);
			}
		}
		ac = multiply(a,c);

		bd = multiply(b,d);

		abcd = multiply(added(a,b),added(c,d));
		ad_bc = minus(minus(abcd,ac),bd);
		
		System.out.println("X is :" + x);  
		System.out.println("Y is :" + y); 
		

		
		if(len <=8) {

			int aint = Integer.parseInt(a);
			int bint = Integer.parseInt(b);
			int cint = Integer.parseInt(c);
			int dint = Integer.parseInt(d);
			
			int acint = aint*cint;
			int dbint = bint*dint;
			int abcdint = (aint+bint)*(cint+dint);
			int ad_bcint = abcdint-dbint-acint;
			System.out.println("ac is :" + ac); 
			System.out.println("ac is check:" + acint); 
			System.out.println("bd is :" + bd); 
			System.out.println("bd is check:" + dbint); 
			System.out.println("abcd is :" + abcd); 
			System.out.println("abcd is check:" + abcdint); 
			System.out.println("ad_bc is :" + ad_bc);
			System.out.println("ad_bc is check:" + ad_bcint); 
			
		}


		String op1v = ac+shiftac;
		String op2v = bd;
		String op3v = ad_bc+shiftadbc;
		String add12 = added(op1v,op2v);
		String add123 = added(add12,op3v);
		
		return add123;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x = "3141592653589793238462643383279502884197169399375105820974944592";
		String y = "2718281828459045235360287471352662497757247093699959574966967627"; 
//		String x = "1236123612361236";
//		String y = "1230123012301230"; 		
		multiply(x,y);
		System.out.println("ANS is :" + multiply(x,y)); 
	}

}
