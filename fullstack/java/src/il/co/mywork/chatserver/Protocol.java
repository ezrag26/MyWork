package il.co.mywork.chatserver;

public interface Protocol {
	String encode(String action, String content);
	String[] decode (String message);
}
