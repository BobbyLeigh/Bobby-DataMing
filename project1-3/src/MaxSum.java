import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class MaxSum {
   public static void main(String args[]) {
       Scanner in = new Scanner(System.in);
       int n;
       double num;
       System.out.print("Enter size of list : ");
       n = in.nextInt();
//declaring ArrayList with initial size n
ArrayList<Double> list = new ArrayList<Double>(n);
System.out.print("Enter elements of list\n");
for(int i=0;i<n;i++) {
   num = in.nextDouble();
   list.add(num);
}
in.close();
System.out.println("maximum contigious sum = "+maxContigiousSum(list));
   }
  
   public static double maxContigiousSum(ArrayList<Double> a){
double [] DP = new double[a.size()+1];
DP[0] = 0;

for (int j = 1; j <DP.length ; j++) {
DP[j] = maximum(DP[j-1]+a.get(j-1),a.get(j-1));
}
double max = DP[0];
for (int j = 1; j <DP.length ; j++) {
if(max<DP[j])
max = DP[j];
}

return max;
}

   public static double maximum(double a, double b) {
      
       return a>b ? a: b;
   }
}