# The REST-server and its controller(s) is located in this folder.

The REST-server handles POST requets for storage of user data, and GET requests for fetching user data. `RestServer.java` (in `/src/main/java/server/`) is the main class of the server, and is the one that starts it. The `PersistenceController.java` (in `/src/main/java/server/controllers`) defines the endpoints of the REST-api.

Our tests are located in the test-folder of this module. (`src/test`).
