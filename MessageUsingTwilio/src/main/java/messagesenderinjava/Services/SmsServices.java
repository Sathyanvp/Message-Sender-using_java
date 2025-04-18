package messagesenderinjava.Services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import messagesenderinjava.Configuration.SMSConfiguration;

@Service
public class SmsServices {

	private SMSConfiguration configsms;
	
	public ResponseEntity<String> sendMessage(String toPhoneNumber, String fromPhoneNumber, String text) {
		// TODO Auto-generated method stub
		Twilio.init(configsms.getACCOUNT_SID(), configsms.getAUTH_TOKEN());
		 try {
	            Message message = Message.creator(
	                    new PhoneNumber(toPhoneNumber),
	                    new PhoneNumber(fromPhoneNumber),
	                   text)
	                    .create();
	            return ResponseEntity.ok("SMS message sent successfully."+message.getSid());
//	            System.out.println("SMS sent successfully! SID: " + message.getSid());

	        } catch (com.twilio.exception.ApiException e) {
//	            System.err.println("Error sending SMS: " + e.getMessage());
//	            e.printStackTrace(); 
	            return ResponseEntity.internalServerError().body("Error sending message: " + e.getMessage());
	        }

	}

}
