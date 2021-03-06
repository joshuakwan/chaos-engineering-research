package se.kth.chaos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChaosControllerTest {
    public static void main(String[] args) {
        ChaosController controller = new ChaosController("controller/src/main/resources/chaosconfig.properties");
        controller.updateTargetPid(5584);

//        controller.attachChaosMonkey();
        List<String[]> registeredTCinfo = controller.readTcInfoFromFile("C:/development/chaosagent/controller/evaluation_v2/chaosMonkey.csv");
        Map<String, String> memcachedKV = new HashMap<String, String>();
        for (int i = 1; i < registeredTCinfo.size(); i++) {
            String[] tc = registeredTCinfo.get(i);
            String key = String.format("%s,%s,%s", tc[0], tc[1], tc[2]);
            memcachedKV.put(key, "analyze");
        }

        controller.updateMode(memcachedKV, 0);

    }
}