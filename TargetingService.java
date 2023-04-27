package GeoTargetingService;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface TargetingService {
    String createTargeting(String namespace, TargetingRequest request);
    boolean checkTargeting(String namespace, String targetingID, Location userLocationData);
    List<String> checkAllTargeting(String namespace, Location userLocationData);
    List<Targeting> getTargeting(String namespace);
    void updateTargeting(String namespace, String targetingID, TargetingRequest request);
    void deleteTargeting(String namespace, String targetingID);
}
