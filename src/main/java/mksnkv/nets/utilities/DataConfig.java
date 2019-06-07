package mksnkv.nets.utilities;

import lombok.Getter;
import lombok.Setter;

public class DataConfig {

    @Getter
    @Setter
    private int cpusNumber;

    @Getter
    @Setter
    private int ramsNumber;

    @Getter
    @Setter
    private int gpusNumber;

    @Getter
    @Setter
    private int psusNumber;

    @Getter
    @Setter
    private int disksNumber;

    @Getter
    @Setter
    private int casesNumber;

    @Getter
    @Setter
    private int motherboardsNumber;

    @Getter
    @Setter
    private int configurationsNumber;

    @Getter
    @Setter
    private int cpuVendorsNumber;

    @Getter
    @Setter
    private int gpuVendorsNumber;

    @Getter
    @Setter
    private int psuVendorsNumber;

    @Getter
    @Setter
    private int ramVendorsNumber;

    @Getter
    @Setter
    private int ramVersionsNumber;

    @Getter
    @Setter
    private int ramFreqsNumber;

    @Getter
    @Setter
    private int motherboardVendorsNumber;

    @Getter
    @Setter
    private int diskVendorsNumber;

    @Getter
    @Setter
    private int socketsNumber;
    @Getter
    @Setter
    private int videoInterfacesNumber;

    @Getter
    @Setter
    private int diskInterfacesNumber;

    @Getter
    @Setter
    private int ordersNumber;

    /*
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        // reading the user input
        cpusNumber = Integer.valueOf(request.getParameter("cpusNumber"));
        ramsNumber = Integer.valueOf(request.getParameter("ramsNumber"));
        gpusNumber = Integer.valueOf(request.getParameter("gpusNumber"));
        psusNumber = Integer.valueOf(request.getParameter("psusNumber"));
        disksNumber = Integer.valueOf(request.getParameter("disksNumber"));
        casesNumber = Integer.valueOf(request.getParameter("casesNumber"));
        motherboardsNumber = Integer.valueOf(request.getParameter("motherboardsNumber"));
        configurationsNumber = Integer.valueOf(request.getParameter("configurationsNumber"));
        cpuVendorsNumber = Integer.valueOf(request.getParameter("cpuVendorsNumber"));
        gpuVendorsNumber = Integer.valueOf(request.getParameter("gpuVendorsNumber"));
        psuVendorsNumber = Integer.valueOf(request.getParameter("psuVendorsNumber"));
        ramVendorsNumber = Integer.valueOf(request.getParameter("ramVendorsNumber"));
        ramVersionsNumber = Integer.valueOf(request.getParameter("ramVersionsNumber"));
        ramFreqsNumber = Integer.valueOf(request.getParameter("ramFreqsNumber"));
        motherboardVendorsNumber = Integer.valueOf(request.getParameter("motherboardVendorsNumber"));
        diskVendorsNumber = Integer.valueOf(request.getParameter("diskVendorsNumber"));
        socketsNumber = Integer.valueOf(request.getParameter("socketsNumber"));
        videoInterfacesNumber = Integer.valueOf(request.getParameter("videoInterfacesNumber"));
        diskInterfacesNumber = Integer.valueOf(request.getParameter("diskInterfacesNumber"));
        ordersNumber = Integer.valueOf(request.getParameter("ordersNumber"));
        System.out.println(ordersNumber);
    }
     */
}
