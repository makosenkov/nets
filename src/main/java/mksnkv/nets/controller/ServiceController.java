package mksnkv.nets.controller;

import mksnkv.nets.exceptions.NotFoundException;
import mksnkv.nets.utilities.Utilities;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.*;

@RestController
@RequestMapping("service")
public class ServiceController {

    private List<Map<String,String>> messages = new ArrayList<Map<String,String>>() {{
        add(new HashMap<String,String>() {{put("id", "version"); put("text", Utilities.getVersion()); }});
        add(new HashMap<String,String>() {{put("id", "interfaces"); put("text", foundInterfaces().toString()); }});
    }};

    private List<Map<String,String>> errors = new ArrayList<Map<String,String>>() {{
        add(new HashMap<String,String>() {{put("id", "error"); put("text", "element not found"); }});
        add(new HashMap<String,String>() {{put("id", "message"); put("text", "error message"); }});
        add(new HashMap<String,String>() {{put("id", "interfaces"); put("text", "interface not found"); }});
    }};

    @GetMapping("version")
    public String getCurrentVersion() {
        return "{version:" + Utilities.getVersion() + "}";
    }

    @GetMapping(":{version}/interfaces")
    @ResponseStatus(value = HttpStatus.OK)
    public Map<String, String> getListOfInterfaces(@PathVariable String version) {
        return messages.stream()
                .filter(message -> message.get("id").equals("interfaces"))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    private List<String> foundInterfaces(){
        Enumeration<NetworkInterface> interfaces = null;
        try {
            interfaces = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e){
            e.printStackTrace();
        }
        List<String> listInterfaces = new ArrayList<>();
        if (interfaces != null) {
            for (NetworkInterface element : Collections.list(interfaces)) {
                listInterfaces.add(element.getDisplayName());
            }
        }
        else throw new NotFoundException();
        return listInterfaces;
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    private Map<String, String> sendErrorMessage(String type) {
        return messages.stream()
                .filter(error -> error.get("id").equals(type))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }
}
