package mksnkv.nets.controller;

import mksnkv.nets.exceptions.NotFoundException;
import mksnkv.nets.utilities.Utilities;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

;

@RestController
@RequestMapping("service")
public class ServiceController {

    private List<Map<String, String>> messages = new ArrayList<Map<String, String>>() {{
        add(new HashMap<String, String>() {{
            put("version", Utilities.getVersion());
        }});
        add(new HashMap<String, String>() {{
            try {
                put("devices", InetAddress.getLocalHost().getHostAddress());
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }});
    }};

    @GetMapping("version")
    public Map<String, String> getCurrentVersion() {
        return messages.stream()
                .filter(message -> message.containsKey("version"))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @GetMapping("{version}/devices")
    @ResponseStatus(value = HttpStatus.OK)
    public Map<String, String> getListOfDevices(@PathVariable String version) {
        return messages.stream()
                .filter(message -> message.get("id").equals("devices"))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    private List<String> foundHosts(String subnet) {
        int timeout = 1000;
        List<String> hosts = new ArrayList<>();
        for (int addressTail = 1; addressTail < 255; addressTail++) {
            String host = subnet + "." + addressTail;
            try {
                if (InetAddress.getByName(host).isReachable(timeout)) {
                    hosts.add(host);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return hosts;
    }
}
