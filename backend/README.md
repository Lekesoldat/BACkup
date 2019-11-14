## Backend structure

The modules core, REST-api and REST-server are structured in the following way:

- The domain- and persistence-logic is located in the [core](https://gitlab.stud.idi.ntnu.no/it1901/gr1927/gr1927/tree/master/backend/core) module.
- The REST-api service is located in the [api](https://gitlab.stud.idi.ntnu.no/it1901/gr1927/gr1927/tree/master/backend/api) module.
- The REST-server and it's controllers are located in the [server](https://gitlab.stud.idi.ntnu.no/it1901/gr1927/gr1927/tree/master/backend/server) module.

When running the application, data is generated and stored via the REST api. The output can be located in `out/profiles/` after the app has ran for the first time.

---

## Available tasks

Running the project:

```zsh
$ gradle run
```

Building the project:

```zsh
$ gradle build
```

Testing the project:

```zsh
$ gradle test
```

---

## Available HTTP methods and URI list

| HTTP Method | URI path               | Description                                    |
| :---------: | :--------------------- | ---------------------------------------------- |
|     GET     | /                      | A greeting for testing purposes.               |
|     GET     | /api/users             | Retrieve all registered users.                 |
|     GET     | /api/users/:id         | Retrieve a user with a specific ID.            |
|   ------    | ------                 | ------                                         |
|    POST     | /api/users/:id/drink   | Add drink on user with a specific ID.          |
|    POST     | /api/users/:id/session | Create and add a new drinking session on user. |
|    POST     | /api/users             | Store the user provided in body.               |
