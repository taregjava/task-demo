package com.finehome.TestFineHome.task2;

public class ClimbingStair {
    public static int climbStairs(int N){
        if ( N < 2 )
            return 1;
        else
            return climbStairs(N-1) + climbStairs(N-2);
    }

    public static void main(String args[])
    {
        int s = 44;

        System.out.println("Number of ways = " + climbStairs(s));
    }

}

