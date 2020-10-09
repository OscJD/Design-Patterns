package central_msg_system;

import java.util.ArrayList;

public interface MyObserver {
    void update(ArrayList<Object> user, String topic, String message);
}
