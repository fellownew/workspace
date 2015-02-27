package consoleChat.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;

public class NetworkUtil {

	/**
	 * Byte계열 Stream과 Socket을 close하는 메소드.
	 * @param input
	 * @param coutpu
	 * @param socket
	 * @throws IOException
	 */
	public static void close(InputStream input,OutputStream output, Socket socket) throws IOException {
		if(input!=null)input.close();
		if(output!=null)output.close();
		if(socket!=null)socket.close();
	}

	/**
	 * Character계열 Stream과 Socket을 close하는 메소드.
	 * @param reader
	 * @param writer
	 * @param socket
	 * @throws IOException
	 */
	public static void close(Reader reader, Writer writer, Socket socket) throws IOException {
		if(reader!=null)reader.close();
		if(writer!=null)writer.close();
		if(socket!=null)socket.close();
	}
}