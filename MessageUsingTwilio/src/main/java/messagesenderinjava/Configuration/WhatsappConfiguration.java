package messagesenderinjava.Configuration;

import org.springframework.stereotype.Component;


@Component
public class WhatsappConfiguration {
	
	private String whatsappAuthToken = "  ";
    private String whatsappAccountSid = "";
	

	
	 
	public String getWhatsappAccountSid() {
		return whatsappAccountSid;
	}

	public String getwhatsappAuthToken() {
		return whatsappAuthToken;
	}
	 
}
