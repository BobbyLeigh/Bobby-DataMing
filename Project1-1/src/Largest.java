public class Largest {
static int[] a={2,1,5,3,4};
public static void main(String args[])
{
long start=System.currentTimeMillis();
int largest=getLargestElement(a,0);
System.out.println(largest);
long end=System.currentTimeMillis();
System.out.println("Execution Time : "+(end-start));
}
private static int getLargestElement(int[] a,int position)
{
if(position == a.length-1)
return a[position];
else
return Math.max(a[position], getLargestElement(a, position+1));
}
  
}
