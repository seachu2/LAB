import java.util.*;
import java.lang.*;


public class leakeybucket{

public static void main(String []args)
{
  int i;
  int a[]=new int[20];
  int buck_rem=0,buck_cap=4,rate=3,recv,send;
  System.out.println("enter the number of packet");
  Scanner sc=new Scanner(System.in);
  int n=sc.nextInt();

  System.out.println("enter the packet:");
  for(i=1;i<=n;i++)
  a[i]=sc.nextInt();

  System.out.println("clock\tpacket_size\taccept\tsent\tremaning");

  for(i=1;i<=n;i++)
  {
      if(a[i]!=0)
      {
          if(buck_rem+a[i]>buck_cap)
          recv=-1;
          else
          {
              recv=a[i];
              buck_rem +=a[i];
          }
      }
      else
      recv=0;

      if(buck_rem!=0)
      {
          if(buck_rem<rate)
          {
              send=buck_rem;
              buck_rem=0;
          }
          else
          {
              send=rate;
              buck_rem=buck_rem-rate;

          }
      }
      else
      send=0;

      if(recv==-1)
      System.out.println(i+"\t\t"+a[i]+"\tdropped\t"+send+"\t"+buck_rem);
      else
      System.out.println(i+"\t\t"+a[i]+"\t"+recv+"\t"+send+"\t"+buck_rem);
  }
}
}