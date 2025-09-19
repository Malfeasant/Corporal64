package us.malfeasant.corporal64.control;

public enum Speed {
    STEP("Single Step"), LINE("Video Line"), FRAME("Video Frame"),
    REAL("Realtime"), FAST("Unhindered");

    Speed(String mt) {
        menuText = mt;
    }

    public final String menuText;
}
