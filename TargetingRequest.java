package GeoTargetingService;


import java.util.List;

public class TargetingRequest {
    private TargetingType type;
    private List<String> whitelistedValues;

    public TargetingRequest(TargetingType type, List<String> whitelistedValues) {
        this.type = type;
        this.whitelistedValues = whitelistedValues;
    }

    public TargetingType getType() {
        return type;
    }

    public void setType(TargetingType type) {
        this.type = type;
    }

    public List<String> getWhitelistedValues() {
        return whitelistedValues;
    }

    public void setWhitelistedValues(List<String> whitelistedValues) {
        this.whitelistedValues = whitelistedValues;
    }
}
