public class ClassroomController {
    private final DeviceRegistry reg;

    public ClassroomController(DeviceRegistry reg) { this.reg = reg; }

    public void startClass() {
        Connectable pj = reg.getFirstOfCapability(Connectable.class);
        ((Powerable)pj).powerOn();
        pj.connectInput("HDMI-1");

        reg.getFirstOfCapability(Dimmable.class).setBrightness(60);

        reg.getFirstOfCapability(Climatizable.class).setTemperatureC(24);

        Attendable scan = reg.getFirstOfCapability(Attendable.class);
        System.out.println("Attendance scanned: present=" + scan.scanAttendance());
    }

    public void endClass() {
        System.out.println("Shutdown sequence:");
        ((Powerable)reg.getFirstOfCapability(Connectable.class)).powerOff();
        ((Powerable)reg.getFirstOfCapability(Dimmable.class)).powerOff();
        ((Powerable)reg.getFirstOfCapability(Climatizable.class)).powerOff();
    }
}