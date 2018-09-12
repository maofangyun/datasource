package com.mfy.leetcode;

public class GreatCommonDivisor {
	public int gcd(int n1, int n2){
		if(n1 == n2)
			return n1;
		if(n1<n2)
			return gcd(n2, n1);
		else {
			if(!((n1&1) == 1) && !((n2&1) == 1))
				return gcd(n1>>1, n2>>1)<<1;
			if(!((n1&1) == 1) && ((n2&1) == 1))
				return gcd(n1>>1, n2);
			if(((n1&1) == 1) && !((n2&1) == 1))
				return gcd(n1, n2>>1);
			return gcd(n1-n2, n2);
		}
	}
	
	public static void main(String[] args) {
		GreatCommonDivisor gcd = new GreatCommonDivisor();
		System.out.println(gcd.gcd(30, 50));
	}
}
