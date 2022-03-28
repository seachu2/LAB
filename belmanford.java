import java.util.*;
public class belmanford{
    private int D[];
    private int n;
    public static final int max_value=999;

    public belmanford(int n)
    {
        this.n=n;
        D=new int[n+1];
    }

    void shortest(int s,int a[][])
    {
        int i,j,k;
        for(i=1;i<=n;i++)
            D[i]=max_value;
        D[s]=0;

        for(k=1;k<=n-1;k++)
        {
            for(i=1;i<=n;i++)
            {
                for(j=1;j<=n;j++)
                {
                    if(D[j]>D[i]+a[i][j])
                        D[j]=D[i]+a[i][j];
                }
            }
        }
        for(i=1;i<=n;i++)
            {
                for(j=1;j<=n;j++)
                {
                    if(D[j]>D[i]+a[i][j])
                    {
                        System.out.println("the graph contain -ve edge");
                        return;
                    }
                }
            }
            for(i=1;i<=n;i++)
            {
                System.out.println("ditance of source "+s+" to "+i+" is "+D[i]);
            }
    }

    public static void main(String [] args)
    {
        int n,i,j;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the number of value");
        n=sc.nextInt();
        int a[][]=new int [n+1][n+1];

        System.out.println("enter the weighted matrix:");
        for(i=1;i<=n;i++)
        {
            for(j=1;j<=n;j++)
            {
                a[i][j]=sc.nextInt();
                if(i==j)
                {
                    a[i][j]=0;
                    continue;
                }
                if(a[i][j]==0)
                {
                    a[i][j]=max_value;
                }
            }
        }

        System.out.println("enter the source vertex:");
        int s=sc.nextInt();
        belmanford b=new belmanford(n);
        b.shortest(s, a);
        sc.close();
    }
}


//5
//0 0 5 0 0
//0 0 0 -1 0
//0 -2 0 4 3
//0 0 0 0 3
//0 0 0 0 0

