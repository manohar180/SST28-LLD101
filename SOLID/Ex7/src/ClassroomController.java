public class ClassroomController {
    private final DeviceRegistry reg;

    public ClassroomController(DeviceRegistry reg) { this.reg = reg; }

    public void startClass() {
        // Projector
        Connectable pj = reg.getFirstOfCapability(Connectable.class);
        ((Powerable)pj).powerOn();
        pj.connectInput("HDMI-1");

        // Lights
        reg.getFirstOfCapability(Dimmable.class).setBrightness(60);

        // AC
        reg.getFirstOfCapability(Climatizable.class).setTemperatureC(24);

        // Scanner
        Attendable scan = reg.getFirstOfCapability(Attendable.class);
        System.out.println("Attendance scanned: present=" + scan.scanAttendance());
    }

    public void endClass() {
        System.out.println("Shutdown sequence:");
        // Note: We loop through things that can be powered off
        // Or specifically target them as requested in the original logic:
        ((Powerable)reg.getFirstOfCapability(Connectable.class)).powerOff(); // Projector
        ((Powerable)reg.getFirstOfCapability(Dimmable.class)).powerOff();    // Lights
        ((Powerable)reg.getFirstOfCapability(Climatizable.class)).powerOff(); // AC
    }
}