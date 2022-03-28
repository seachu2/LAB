import java.net.*;
import java.io.*;
public class tcpclient
{

    public static void main(String []args)throws Exception
    {
        Socket sock=new Socket("127.1.0.0",4000);
        System.out.println("enter the file name:");
        BufferedReader keyread= new BufferedReader(new InputStreamReader(System.in));
        String fname= keyread.readLine();

        OutputStream ostream=sock.getOutputStream();
        PrintWriter pwrite=new PrintWriter(ostream,true);
        pwrite.print(fname);

        InputStream istream=sock.getInputStream();
        BufferedReader socketread=new BufferedReader(new InputStreamReader(istream));
        String str;
        while((str=socketread.readLine())!=null)
            System.out.println(str);

        pwrite.close();
        socketread.close();
        keyread.close();
    }
}