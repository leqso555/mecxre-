import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankMedium implements Medium {
    Map<String, String> users = new HashMap<>();

    @Override
    public void write(String client, String data)  {
        users.put(client,data);
    }
    @Override
    public String read(String data) {
        return users.get(data);
    }

    @Override
    public List<String> read() {
        return new ArrayList<>(users.keySet());

    }
}
