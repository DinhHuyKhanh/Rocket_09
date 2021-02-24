package entity.enumerate;

public enum PositionName {
    DEV("Dev"),TEST("Test"),ScrumMaster("ScrumMaster"),PM("PM");
    private String value;

    // constructor
    private PositionName(String value) {
        this.value = value;
    }

    // getValue
    public String getValue() {
        return value;
    }

    //
    public static PositionName of(String value){
        if(value == null){
            return null;
        }
        for (PositionName name : PositionName.values() ) {
            if(name.getValue().equals(value)){
                return name;
            }
        }
        return null;
    }
}
