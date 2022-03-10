import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;
 
public class SmsService {
	public static void sendSms(final String mobileNumber, final String messageContent) {
		try {
			// Construct data
			String apiKey = "apikey=" + "VOWGkKqRqRI-ohnrdSpdP9RsPjw4CAAleZxKLzOBYo";
			String message = "&message=" + messageContent;
			String sender = "&sender=" + "TXTLCL";
			String numbers = "&numbers=" + "91" + mobileNumber;
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			
			
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
	
		}
	}
}