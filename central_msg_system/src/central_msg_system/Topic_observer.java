package central_msg_system;

import java.util.ArrayList;

public class Topic_observer implements MyObserver{
	
	protected  String topic_obs;
	
	public Topic_observer(){}
	
	public void update(ArrayList<Object> users, String topic, String message)
	{	
		System.out.println( "\n The users:" );
		System.out.println( users );
		System.out.println("Are Susbscribed to: " + topic );
		System.out.println("And received the message: ");
		System.out.println(message + '\n');
	}

}