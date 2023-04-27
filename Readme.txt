GeoTargetingService Package
The GeoTargetingService package contains the TargetingServiceImpl class that implements the TargetingService interface. This package provides functionality to create, update, delete and check targetings for a given namespace and user location data.


TargetingServiceImpl
The TargetingServiceImpl class implements the TargetingService interface and provides the following methods:

createTargeting(String namespace, TargetingRequest request): Creates a new targeting for the given namespace and returns the ID of the created targeting. The TargetingRequest parameter specifies the type of targeting and the list of whitelisted values for the targeting.
checkTargeting(String namespace, String targetingId, Location userLocationData): Checks whether the given user location data satisfies the targeting with the given ID for the given namespace.
checkAllTargeting(String namespace, Location userLocationData): Checks whether the given user location data satisfies all targetings for the given namespace.
getTargeting(String namespace): Returns a list of all targetings for the given namespace.
updateTargeting(String namespace, String targetingId, TargetingRequest request): Updates the targeting with the given ID for the given namespace with the new TargetingRequest data.
deleteTargeting(String namespace, String targetingId): Deletes the targeting with the given ID for the given namespace.


Targeting
The Targeting class represents a targeting and contains the following attributes:

targetingId: The ID of the targeting.
namespace: The namespace of the targeting.
type: The type of the targeting (STATE, DISTRICT, CITY, or PINCODE).
whitelistedValues: The list of whitelisted values for the targeting.


TargetingRequest
The TargetingRequest class represents a request to create or update a targeting and contains the following attributes:

type: The type of the targeting (STATE, DISTRICT, CITY, or PINCODE).
whitelistedValues: The list of whitelisted values for the targeting.


TargetingServiceImplTest
This is a unit test file for the GeoTargetingService package. The file contains tests for the TargetingServiceImpl class, which provides methods for creating, updating, and deleting targeting rules, as well as checking if a user's location satisfies a targeting rule.

The tests cover the following methods:

testCreateTargeting(): Tests the creation of a targeting rule and ensures that a valid targeting ID is returned.
testCheckTargeting(): Tests the check of whether a user's location satisfies a targeting rule.
testCheckAllTargeting(): Tests the check of all targeting rules for a given namespace and user's location, and ensures that the list of satisfied targeting IDs is returned.
testGetTargeting(): Tests the retrieval of all targeting rules for a given namespace and ensures that the list is not empty.
testUpdateTargeting(): Tests the updating of a targeting rule and ensures that the updated targeting rule matches the new values.
testDeleteTargeting(): Tests the deletion of a targeting rule and ensures that the list of targeting rules is empty after deletion.
The @Before annotation is used to set up a TargetingServiceImpl instance and a Location object for use in the tests. The static org.junit.Assert.* import is used to provide assertion methods for the tests.

Overall, this test file ensures that the TargetingServiceImpl class is functioning correctly and as expected.