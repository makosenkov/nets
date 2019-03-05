package mksnkv.nets.utilities;

import java.util.Random;

public class Utilities {

    private static final String version = generateVersion();

    public static String getVersion() {
        return version;
    }

    private static String generateVersion(){
        String[] versions = {"v1", "v1.1", "v2", "v3"};
        Random random = new Random();
        return versions[random.nextInt(4)];
    }
}
