package bank.util;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;

public class NetworkUtil {
	//reader, writer, socket ´Ý±â static ¸Þ¼Òµå.
	public static void close(Reader reader, Writer writer, Socket socket) throws IOException {
		if(reader!=null)reader.close();
		if(writer!=null)writer.close();
		if(socket!=null)socket.close();
	}
}
