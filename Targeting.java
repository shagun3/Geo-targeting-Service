package GeoTargetingService;

import java.util.List;

public class Targeting {
    private String targetingId;
    private String namespace;
    private TargetingType type;
    private List<String> whitelistedValues;

    public Targeting(String targetingId, String namespace, TargetingType type, List<String> whitelistedValues) {
        this.targetingId = targetingId;
        this.namespace = namespace;
        this.type = type;
        this.whitelistedValues = whitelistedValues;
    }

    public String getTargetingId() {
        return targetingId;
    }

    public void setTargetingId(String targetingId) {
        this.targetingId = targetingId;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
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
