//package GeoTargetingService;
//
//import static org.junit.Assert.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//
//
//public class TargetingServiceImplTest {
//
//    private TargetingService targetingService;
//
//    private Location userLocationData;
//
//    @Before
//    public void setUp() {
//        targetingService = new TargetingServiceImpl();
//        userLocationData = new Location("Pincode1", "City1", "District1", "State1");
//    }
//
//    @Test
//    public void testCreateTargeting() {
//        String namespace = "TestNamespace";
//        TargetingRequest targetingRequest = new TargetingRequest(TargetingType.STATE, List.of("State1"));
//
//        String targetingId = targetingService.createTargeting(namespace, targetingRequest);
//
//        assertNotNull(targetingId);
//        assertTrue(!targetingId.isEmpty());
//        assertTrue(targetingService.getTargeting(namespace).stream().anyMatch(t -> t.getTargetingId().equals(targetingId)));
//    }
//
//    @Test
//    public void testCheckTargeting() {
//        String namespace = "TestNamespace";
//        TargetingRequest targetingRequest = new TargetingRequest(TargetingType.DISTRICT, List.of("District1"));
//        String targetingId = targetingService.createTargeting(namespace, targetingRequest);
//
//        boolean targetingSatisfied = targetingService.checkTargeting(namespace, targetingId, userLocationData);
//
//        assertTrue(targetingSatisfied);
//    }
//
//    @Test
//    public void testCheckAllTargeting() {
//        String namespace = "TestNamespace";
//        TargetingRequest targetingRequest1 = new TargetingRequest(TargetingType.STATE, List.of("State1"));
//        TargetingRequest targetingRequest2 = new TargetingRequest(TargetingType.DISTRICT, List.of("District1"));
//        String targetingId1 = targetingService.createTargeting(namespace, targetingRequest1);
//        String targetingId2 = targetingService.createTargeting(namespace, targetingRequest2);
//
//        List<String> satisfiedTargetings = targetingService.checkAllTargeting(namespace, userLocationData);
//
//        assertTrue(satisfiedTargetings.contains(targetingId1));
//        assertTrue(satisfiedTargetings.contains(targetingId2));
//    }
//
//    @Test
//    public void testGetTargeting() {
//        String namespace = "TestNamespace";
//        TargetingRequest targetingRequest = new TargetingRequest(TargetingType.CITY, List.of("City1"));
//        String targetingId = targetingService.createTargeting(namespace, targetingRequest);
//
//        List<Targeting> targetings = targetingService.getTargeting(namespace);
//
//        assertNotNull(targetings);
//        assertTrue(!targetings.isEmpty());
//        assertTrue(targetings.stream().anyMatch(t -> t.getTargetingId().equals(targetingId)));
//    }
//
//    @Test
//    public void testUpdateTargeting() {
//        String namespace = "TestNamespace";
//        TargetingRequest targetingRequest1 = new TargetingRequest(TargetingType.STATE, List.of("State1"));
//        TargetingRequest targetingRequest2 = new TargetingRequest(TargetingType.DISTRICT, List.of("District1"));
//        String targetingId = targetingService.createTargeting(namespace, targetingRequest1);
//
//        targetingService.updateTargeting(namespace, targetingId, targetingRequest2);
//
//        Targeting targeting = targetingService.getTargeting(namespace).stream().filter(t -> t.getTargetingId().equals(targetingId)).findFirst().orElse(null);
//
//        assertNotNull(targeting);
//        assertEquals(targetingRequest2.getType(), targeting.getType());
//        assertEquals(targetingRequest2.getWhitelistedValues(), targeting.getWhitelistedValues());
//    }
//
//    @Test
//    public void testDeleteTargeting() {
//        String namespace = "TestNamespace";
//        TargetingRequest targetingRequest = new TargetingRequest(TargetingType.STATE, List.of("State1"));
//        String targetingId = targetingService.createTargeting(namespace, targetingRequest);
//
//        targetingService.deleteTargeting(namespace, targetingId);
//
//        List<Targeting> targetings = targetingService.getTargeting(namespace);
//        assertTrue(targetings.isEmpty());
//    }
//}
//
//
//
