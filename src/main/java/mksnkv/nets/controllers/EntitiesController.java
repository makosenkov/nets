package mksnkv.nets.controllers;

import lombok.AllArgsConstructor;
import mksnkv.nets.entities.Cpus;
import mksnkv.nets.entities.Items;
import mksnkv.nets.entities.Rams;
import mksnkv.nets.repos.*;
import mksnkv.nets.utilities.Generator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
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
    private final SocketsRepo socketsRepo;
    private final VideoInterfacesRepo videoInterfacesRepo;
    private final MotherboardsRepo motherboardsRepo;
    private final CpusRepo cpusRepo;
    private final GpusRepo gpusRepo;
    private final PsusRepo psusRepo;
    private final RamsRepo ramsRepo;
    private final CasesRepo casesRepo;
    private final DisksRepo disksRepo;
    private final ConfigurationsRepo configurationsRepo;
    private final OrdersRepo ordersRepo;


    @GetMapping("/items")
    public List<Items> listItems() {
        return itemsRepo.findAll();
    }

    @GetMapping("/cpus")
    public List<Cpus> listCpus() {
        return cpusRepo.findAll();
    }

    @GetMapping("/generator")
    public List<Rams> listRams() {
        generate();
        return ramsRepo.findAll();
    }

    private void generate() {
        Generator generator = new Generator(itemsRepo,
            cpuVendorsRepo,
            gpuVendorsRepo,
            ramVendorsRepo,
            ramVersionsRepo,
            ramFreqsRepo,
            psuVendorsRepo,
            diskVendorsRepo,
            socketsRepo,
            videoInterfacesRepo,
            motherboardsRepo,
            cpusRepo,
            gpusRepo,
            psusRepo,
            ramsRepo,
            casesRepo,
            disksRepo,
            configurationsRepo,
            ordersRepo,
            10,
            11,
            10,
            12,
            12,
            12,
            12,
            12,
            1,
            1,
            1,
            1,
            15,
            15,
            15,
            1,
            1,
            1,
            2,
            2,
            2
        );
        generator.generate();
    }

}
