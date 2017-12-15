package sysinfo;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;

public class SysInfo {

    public static String getSystemInfo(){
        String res = "";
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();

        res += si.getOperatingSystem() + " | ";
        res += hal.getProcessor() + " | ";
        res += hal.getProcessor().getPhysicalProcessorCount() + " physical CPU(s)" + "; ";
        res += hal.getProcessor().getLogicalProcessorCount() + " logical CPU(s)";

        return res;
    }

}
