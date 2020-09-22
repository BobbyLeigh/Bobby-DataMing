import java.util.Scanner;
public class Fibno {
static int a,b,i,c,n;
void iterativeFib(int n)
{
a=0;b=1;
  
System.out.println(a+" "+b);
for(i=2;i<n;i++)
{
c=a+b;
System.out.println(" "+c);
a=b;
b=c;
}
}
public static int recursiveFib(int n)
{
if(n==1 || n==2)
{
return 1;
}

return recursiveFib(n-1)+recursiveFib(n-2);
}
public static void main(String args[])
{
Scanner s=new Scanner(System.in);
System.out.println("Enter the range");
n=s.nextInt();
Fibno fn=new Fibno();
System.out.println("Iterative Fib Series\n");
fn.iterativeFib(n);
System.out.println("Recursive Fib Series\n");
for(int i=1;i<n;i++)
System.out.println(recursiveFib(i)+" ");
}
  
}