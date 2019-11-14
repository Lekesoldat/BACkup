# The REST-API Service is located in this folder.

Our data is stored and fetched with a REST-api.
The testing of the REST-api is both done in the API-tests, aswell as the SERVER-tests as they are dependant on eachother.

### API

The `Api.java` (in `/src/main/java/backend/api/`) configures retrofit with its GSON-factory, and supplies the PersitenceService. (Which uses @POST and @GET)
We have opted to test the constructor and persistence in a test-folder in this module. (Although in another directory, `/src/test`)
