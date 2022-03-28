import java.util.*;
import java.io.*;

public class rsa {
    static int gcd(int m,int n)
    {
        while(n!=0)
        {
        int r=m%n;
        m=n;
        n=r;
        }
        return m;
    }

    public static void main(String [] args)
    {
        int p=0,q=0,e=0,d=0,phi=0,n=0;
        int numes[]=new int [100];
        int encrypt[]=new int [100];
        int decrypt[]=new int [100];
        int i,j,nofelen=0;
        String message;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the message");
        message=sc.nextLine();

        System.out.println("enter the value of p and q");
        p=sc.nextInt();
        q=sc.nextInt();

        n=p*q;
        phi=(p-1)*(q-1);

        for(i=2;i<phi;i++)
        {
            if(gcd(i,phi)==1)
            break;
        }
        e=i;
        for(i=2;i<phi;i++)
        {
            if((e*i-1)%phi==0)
            {
                break;
            }
        }
        d=i;
        for(i=0;i<message.length();i++)
        {
            char c=message.charAt(i);
            int a=(int)c;
            numes[i]=c-96;
        }
        nofelen=message.length();

        for(i=0;i<nofelen;i++)
        {
            encrypt[i]=1;
            for(j=0;j<e;j++)
            encrypt[i]=(encrypt[i]*numes[i])%n;
        }
        System.out.println("Encrpted message is ");
        for(i=0;i<nofelen;i++)
        {
        System.out.println(encrypt[i]);
        System.out.println((char)(encrypt[i]+96));
        }
        
        for(i=0;i<nofelen;i++)
        {
            decrypt[i]=1;
            for(j=0;j<d;j++)
            decrypt[i]=(decrypt[i]*encrypt[i])%n;
        }
        System.out.println("decrypt message is ");

        for(i=0;i<nofelen;i++)
            System.out.print((char)(decrypt[i]+96));

        return;
        
    }
    
}
