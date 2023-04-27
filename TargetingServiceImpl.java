package GeoTargetingService;

import java.util.*;

public class TargetingServiceImpl implements TargetingService{

    private Map<String, List<Targeting>> namespaceTargetingsMap;

    public TargetingServiceImpl() {
        namespaceTargetingsMap = new HashMap<>();
    }

    public String createTargeting(String namespace, TargetingRequest request) {
        if (namespace == null || request == null) {
            throw new IllegalArgumentException("Namespace and request must not be null.");
        }

        TargetingType type = request.getType();
        List<String> whitelistedValues = request.getWhitelistedValues();

        // Create new targeting
        Targeting targeting = new Targeting(
                UUID.randomUUID().toString(),
                namespace,
                type,
                whitelistedValues
        );

        // Add targeting to the namespace targetings map
        List<Targeting> namespaceTargetings = namespaceTargetingsMap.getOrDefault(namespace, new ArrayList<>());
        namespaceTargetings.add(targeting);
        namespaceTargetingsMap.put(namespace, namespaceTargetings);

        // Return the targeting ID
        return targeting.getTargetingId();
    }

    public boolean checkTargeting(String namespace, String targetingId, Location userLocationData) {
        if (namespace == null || targetingId == null || userLocationData == null) {
            throw new IllegalArgumentException("Namespace, targeting ID, and user location data must not be null.");
        }

        // Get the list of targetings for the given namespace
        List<Targeting> targetings = namespaceTargetingsMap.getOrDefault(namespace, new ArrayList<>());

        // Find the targeting with the given ID
        for (Targeting targeting : targetings) {
            if (targeting.getTargetingId().equals(targetingId)) {
                // Check if the user location data satisfies the targeting
                return checkTargetingSatisfied(targeting, userLocationData);
            }
        }

        // If no targeting found with the given ID, return false
        return false;
    }

    public List<String> checkAllTargeting(String namespace, Location userLocationData) {
        if (namespace == null || userLocationData == null) {
            throw new IllegalArgumentException("Namespace and user location data must not be null.");
        }

        List<String> satisfiedTargetings = new ArrayList<>();

        // Get the list of targetings for the given namespace
        List<Targeting> targetings = namespaceTargetingsMap.getOrDefault(namespace, new ArrayList<>());

        // Check if the user location data satisfies each targeting and add the targeting ID to the result list
        for (Targeting targeting : targetings) {
            if (checkTargetingSatisfied(targeting, userLocationData)) {
                satisfiedTargetings.add(targeting.getTargetingId());
            }
        }

        return satisfiedTargetings;
    }

    public List<Targeting> getTargeting(String namespace) {
        if (namespace == null) {
            throw new IllegalArgumentException("Namespace must not be null.");
        }

        // Get the list of targetings for the given namespace
        List<Targeting> targetings = namespaceTargetingsMap.getOrDefault(namespace, new ArrayList<>());

        return targetings;
    }

    public void updateTargeting(String namespace, String targetingId, TargetingRequest request) {
        try {
            if (namespace == null || targetingId == null || request == null) {
                throw new IllegalArgumentException("Namespace, TargetingId and TargetingRequest data must not be null.");
            }
            // Get the list of targetings for the given namespace
            List<Targeting> targetings = namespaceTargetingsMap.getOrDefault(namespace, new ArrayList<>());

            // Find the targeting with the given ID and update it with the new request
            for (Targeting targeting : targetings) {
                if (targeting.getTargetingId().equals(targetingId)) {
                    targeting.setType(request.getType());
                    targeting.setWhitelistedValues(request.getWhitelistedValues());
                    break;
                }
            }

            // Update the namespace targetings map
            namespaceTargetingsMap.put(namespace, targetings);
        } catch (Exception e) {
            // Log the exception
            System.err.println("An error occurred while updating the targeting: " + e.getMessage());
        }
    }

    public void deleteTargeting(String namespace, String targetingId) {
        try {
            if (namespace == null || targetingId == null) {
                throw new IllegalArgumentException("Namespace and TargetingId data must not be null.");
            }
            // Get the list of targetings for the given namespace
            List<Targeting> targetings = namespaceTargetingsMap.getOrDefault(namespace, new ArrayList<>());

            // Find the targeting with the given ID and remove it from the list
            targetings.removeIf(t -> t.getTargetingId().equals(targetingId));

            // Update the namespace targetings map
            namespaceTargetingsMap.put(namespace, targetings);
        } catch (Exception e) {
            // Log the exception
            System.err.println("An error occurred while updating the targeting: " + e.getMessage());
        }
    }

    public boolean checkTargetingSatisfied(Targeting targeting, Location userLocationData) {
        TargetingType type = targeting.getType();
        List<String> whitelistedValues = targeting.getWhitelistedValues();

        switch (type) {
            case STATE:
                return whitelistedValues.contains(userLocationData.getState());

            case DISTRICT:
                return whitelistedValues.contains(userLocationData.getDistrict());

            case CITY:
                return whitelistedValues.contains(userLocationData.getCity());

            case PINCODE:
                return whitelistedValues.contains(userLocationData.getPincode());

            default:
                throw new IllegalArgumentException("Invalid targeting type: " + type);
        }
    }

}
