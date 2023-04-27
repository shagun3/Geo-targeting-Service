package GeoTargetingService;

import java.util.ArrayList;
import java.util.List;

public class Driver {

    public static void main(String[] args) {
        // Create a new targeting service
        TargetingService targetingService = new TargetingServiceImpl();

        List<String> whitelistedValues = new ArrayList<>();
        whitelistedValues.add("Karnataka");

        // Create a targeting
        String namespace = "location";
        TargetingRequest request = new TargetingRequest(TargetingType.STATE, whitelistedValues);
        String targetingId = targetingService.createTargeting(namespace, request);
        System.out.println("Created targeting with ID: " + targetingId);

        // Check if a user is within the targeting
        Location userLocationData = new Location("94101", "Bangalore", "Central Bangalore", "Karnataka");
        boolean isWithinTargeting = targetingService.checkTargeting(namespace, targetingId, userLocationData);
        System.out.println("User is within targeting: " + isWithinTargeting);

        whitelistedValues = new ArrayList<>();
        whitelistedValues.add("Bangalore");

        // Update the targeting
        TargetingRequest newRequest = new TargetingRequest(TargetingType.CITY, whitelistedValues);
        targetingService.updateTargeting(namespace, targetingId, newRequest);
        System.out.println("Updated targeting with ID: " + targetingId);

        // Delete the targeting
        targetingService.deleteTargeting(namespace, targetingId);
        System.out.println("Deleted targeting with ID: " + targetingId);
    }

}
