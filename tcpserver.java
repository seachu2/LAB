import java.net.*;
import java.io.*;
public class tcpserver {
    public static void main(String [] args)throws Exception
    {
        ServerSocket sersock= new ServerSocket(3000);
        System.out.println("server is ready for conection");
        Socket sock=sersock.accept();
        System.out.println("start chatting");

        InputStream istream=sock.getInputStream();
        BufferedReader fileread=new BufferedReader(new InputStreamReader(istream));

        String fname=fileread.readLine();

        BufferedReader contentread=new BufferedReader(new FileReader(fname));
        OutputStream ostream=sock.getOutputStream();
        PrintWriter pwrite=new PrintWriter(ostream,true);

        String str;
        while((str=contentread.readLine())!=null)
            pwrite.print(str);

        contentread.close();
        pwrite.close();
        fileread.close();
        sock.close();
        sersock.close();
    }   
}
