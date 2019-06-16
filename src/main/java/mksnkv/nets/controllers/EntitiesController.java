package mksnkv.nets.controllers;

import lombok.AllArgsConstructor;
import mksnkv.nets.entities.GpuVendors;
import mksnkv.nets.repos.*;
import mksnkv.nets.utilities.ConfigLoader;
import mksnkv.nets.utilities.DataConfig;
import mksnkv.nets.utilities.Generator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class EntitiesController {

    private final ItemsRepo itemsRepo;
    private final CpuVendorsRepo cpuVendorsRepo;
    private final GpuVendorsRepo gpuVendorsRepo;
    private final RamVendorsRepo ramVendorsRepo;
    private final RamVersionsRepo ramVersionsRepo;
    private final RamFreqsRepo ramFreqsRepo;
    private final PsuVendorsRepo psuVendorsRepo;
    private final DiskVendorsRepo diskVendorsRepo;
    private final DiskInterfacesRepo diskInterfacesRepo;
    private final SocketsRepo socketsRepo;
    private final VideoInterfacesRepo videoInterfacesRepo;
    private final MotherboardsRepo motherboardsRepo;
    private final MotherboardVendorsRepo motherboardVendorsRepo;
    private final CpusRepo cpusRepo;
    private final GpusRepo gpusRepo;
    private final PsusRepo psusRepo;
    private final RamsRepo ramsRepo;
    private final CasesRepo casesRepo;
    private final DisksRepo disksRepo;
    private final ConfigurationsRepo configurationsRepo;
    private final OrdersRepo ordersRepo;

    //List<Items> itemsList;

/*    @Scheduled(fixedDelay = 5)
    void refreshItems() {
        itemsList = itemsRepo.findAll();
    }*/

    @GetMapping("/items")
    public String listItems(Model model) {
        model.addAttribute("items", itemsRepo.findAll());
        model.addAttribute("count", itemsRepo.findAll().size());
        return "table";
    }

    @GetMapping("/cpus")
    public long listCpus() {
        return cpusRepo.count();
    }

    @GetMapping("/gpuvendors")
    public List<GpuVendors> listGpuVendors() {
        return gpuVendorsRepo.findAll();
    }

    @RequestMapping(value = {"/", "/home"},  method = RequestMethod.GET)
    public String homePage(){
        return "home";
    }

    @RequestMapping(value = "/generatorPage", method = RequestMethod.GET)
    public String generatorPage(){
        return "generator";
    }

    @RequestMapping(value = "/generator")
    public void generateV(@RequestParam int cpuVendorsNumber,
                   @RequestParam int gpuVendorsNumber,
                   @RequestParam int ramVendorsNumber,
                   @RequestParam int ramVersionsNumber,
                   @RequestParam int ramFreqsNumber,
                   @RequestParam int psuVendorsNumber,
                   @RequestParam int diskVendorsNumber,
                   @RequestParam int diskInterfacesNumber,
                   @RequestParam int socketsNumber,
                   @RequestParam int videoInterfacesNumber,
                   @RequestParam int motherboardsNumber,
                   @RequestParam int motherboardVendorsNumber,
                   @RequestParam int cpusNumber,
                   @RequestParam int gpusNumber,
                   @RequestParam int psusNumber,
                   @RequestParam int ramsNumber,
                   @RequestParam int casesNumber,
                   @RequestParam int disksNumber,
                   @RequestParam int configurationsNumber,
                   @RequestParam int ordersNumber) {
        Generator generator = new Generator(itemsRepo,
            cpuVendorsRepo,
            gpuVendorsRepo,
            ramVendorsRepo,
            ramVersionsRepo,
            ramFreqsRepo,
            psuVendorsRepo,
            diskVendorsRepo,
            diskInterfacesRepo,
            socketsRepo,
            videoInterfacesRepo,
            motherboardsRepo,
            motherboardVendorsRepo,
            cpusRepo,
            gpusRepo,
            psusRepo,
            ramsRepo,
            casesRepo,
            disksRepo,
            configurationsRepo,
            ordersRepo,
            cpusNumber,
            ramsNumber,
            gpusNumber,
            psusNumber,
            disksNumber,
            casesNumber,
            motherboardsNumber,
            configurationsNumber,
            cpuVendorsNumber,
            gpuVendorsNumber,
            psuVendorsNumber,
            ramVendorsNumber,
            ramVersionsNumber,
            ramFreqsNumber,
            motherboardVendorsNumber,
            diskVendorsNumber,
            socketsNumber,
            videoInterfacesNumber,
            diskInterfacesNumber,
            ordersNumber
        );
        generator.generate();
    }

    public void generate() {
        DataConfig config = ConfigLoader.getInstance().getDataObject("/home/mksnkv/dev/nets/src/main/resources/config.properties");
        Generator generator = new Generator(itemsRepo,
            cpuVendorsRepo,
            gpuVendorsRepo,
            ramVendorsRepo,
            ramVersionsRepo,
            ramFreqsRepo,
            psuVendorsRepo,
            diskVendorsRepo,
            diskInterfacesRepo,
            socketsRepo,
            videoInterfacesRepo,
            motherboardsRepo,
            motherboardVendorsRepo,
            cpusRepo,
            gpusRepo,
            psusRepo,
            ramsRepo,
            casesRepo,
            disksRepo,
            configurationsRepo,
            ordersRepo,
            config
        );
        generator.generate();
    }

}
