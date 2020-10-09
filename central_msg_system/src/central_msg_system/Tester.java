package central_msg_system;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tester extends Subject{
	
	public Tester() {
			
	}
	public void addTopics(Subject o, String[] topic) {
		Subscribers.put(o, topic);
	}
	
	public void show_suscriptions(Subject o) {
		System.out.println("\n The ID user: " + o  + " is subscribed to:");
		 for(String s:Subscribers.get(o)){
	            System.out.println(s);
	        }
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

	public static void main(String[] args) {
		
		// Topics followed by the observers
		String[] observer1_topics = {"Sports", "Economy", "Science", "Politics"};
		String[] observer2_topics = {"Sports", "Politics", "Weather"};
		String[] observer3_topics = {"Culture", "Forniture", "Science"};
		String[] observer4_topics = {"Forniture", "Economy", "Culture"};
		
		Subject publisher = new Subject();
		
		//Create the objects and the subscriptions to the topics
		//Then Print the unique ID for the object and the list of topics that follows
		Subject user = new Tester();
		user.addTopics(user, observer1_topics);
		user.show_suscriptions(user);
		
		Subject user2 = new Tester();
		user2.addTopics(user2, observer2_topics);
		user2.show_suscriptions(user2);
		
		Subject user3 = new Tester();
		user3.addTopics(user3, observer3_topics);
		user3.show_suscriptions(user3);
		
		Subject user4 = new Tester();
		user4.addTopics(user4, observer4_topics);
		user4.show_suscriptions(user4);
		
		// Object that post the messages to the topics 
		publisher.set_value("Sports", "Michael Phelps back from retirement ... again");
		publisher.set_value("Science", "Elon Musk space-ship arrives to Jupyter");
		publisher.set_value("Food", "The mexican food is declared the best in the world"); //No one is subscribed to this topic
		
		// You can remove one or more topics from each user
		// The hash maps is sync with the modified topics 
		String[] user4_remove = {"Forniture", "Culture"};
		user4.removeTopics(user4, user4_remove);
		
	}
}
