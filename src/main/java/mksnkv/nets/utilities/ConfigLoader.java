package mksnkv.nets.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class ConfigLoader {

    private static ConfigLoader loader;

    private ConfigLoader() {
    }

    public static ConfigLoader getInstance() {
        if (loader == null) {
            loader = new ConfigLoader();
        }
        return loader;
    }

    public DataConfig getDataObject(String path) {
        Properties properties = new Properties();
        DataConfig data = new DataConfig();
        try (Reader stream = new InputStreamReader(new FileInputStream(path),
            StandardCharsets.UTF_8)) {
            properties.load(stream);
            data.setCpusNumber(Integer.parseInt(
                (String) properties.get("cpusNumber")
            ));
            data.setRamsNumber(Integer.parseInt(
                (String) properties.get("ramsNumber")
            ));
            data.setGpusNumber(Integer.parseInt(
                (String) properties.get("gpusNumber")
            ));
            data.setPsusNumber(Integer.parseInt(
                (String) properties.get("psusNumber")
            ));
            data.setDisksNumber(Integer.parseInt(
                (String) properties.get("disksNumber")
            ));
            data.setCasesNumber(Integer.parseInt((String)
                properties.get("casesNumber")
            ));
            data.setMotherboardsNumber(Integer.parseInt(
                (String) properties.get("motherboardsNumber")
            ));
            data.setConfigurationsNumber(Integer.parseInt(
                (String) properties.get("configurationsNumber")
            ));
            data.setCpuVendorsNumber(Integer.parseInt(
                (String) properties.get("cpuVendorsNumber")
            ));
            data.setGpuVendorsNumber(Integer.parseInt(
                (String) properties.get("gpuVendorsNumber")
            ));
            data.setPsuVendorsNumber(Integer.parseInt(
                (String) properties.get("psuVendorsNumber")
            ));
            data.setRamVendorsNumber(Integer.parseInt(
                (String) properties.get("ramVendorsNumber")
            ));
            data.setRamVersionsNumber(Integer.parseInt(
                (String) properties.get("ramVersionsNumber")
            ));
            data.setRamFreqsNumber(Integer.parseInt(
                (String) properties.get("ramFreqsNumber")
            ));
            data.setMotherboardVendorsNumber(Integer.parseInt(
                (String) properties.get("motherboardVendorsNumber")
            ));
            data.setDiskVendorsNumber(Integer.parseInt(
                (String) properties.get("diskVendorsNumber")
            ));
            data.setSocketsNumber(Integer.parseInt(
                (String) properties.get("socketsNumber")
            ));
            data.setVideoInterfacesNumber(Integer.parseInt(
                (String) properties.get("videoInterfacesNumber")
            ));
            data.setDiskInterfacesNumber(Integer.parseInt(
                (String) properties.get("diskInterfacesNumber")
            ));
            data.setOrdersNumber(Integer.parseInt(
                (String) properties.get("ordersNumber")
            ));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

}
