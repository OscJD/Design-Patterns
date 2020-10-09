package central_msg_system;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class Subject{
	protected static Subject global_ptr = null;
	// The register of followed topics is organized with a hash map
	protected static Map<Object, String[]> Subscribers = new HashMap<Object, String[]>();
	
	// Singleton pattern Instantiation
	public static Subject Instance() {
        if (global_ptr==null) global_ptr=new Subject();
        return global_ptr;
    }
	
	public Subject() {}
	
	public void set_value(String topic, String msg)
	{
		Observers_to_notify(topic, msg);
	}
	
	public void Observers_to_notify(String topic, String msg)
	{
		ArrayList<Object> to_notify = new ArrayList<>();
		
		for (Entry<Object, String[]> entry : Subscribers.entrySet()) {
			for(String s:Subscribers.get(entry.getKey())){
	            if(s == topic){
	            	to_notify.add(entry.getKey());
	            } 
	        }
		}
		MyObserver set_msg = new Topic_observer();
		set_msg.update(to_notify, topic, msg);
	}
         
	
	public void removeTopics(Subject o, String[] topics) {
		
		String[] entry = Subscribers.get(o);
		
		List<String> list = new ArrayList<String>(Arrays.asList(entry));
		for(String topic:topics) {
		list.removeAll(Arrays.asList(topic));
		entry = list.toArray(new String[0]);
		}
		
		Subscribers.put(o, entry);
		show_suscriptions(o);
	}

	public void addTopics(Object o, String[] topic) {
		
		Subscribers.put(o, topic);	
		
	}
	
	public void show_suscriptions(Object o) {
		
		System.out.println("\n The ID user: " + o + " is subscribed to:");
		 for(String s:Subscribers.get(o)){
	            System.out.println(s);
	        }
	}
	

}
