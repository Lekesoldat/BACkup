## Project structure

This repository contains the entire BACkup project. The tech stack is the following:

### Root

- [Node](https://nodejs.org/en/) to bootstrap the project.
  - [Concurrently](https://www.npmjs.com/package/concurrently) to start the backend and frontend with the same command.
  - [wait-on](https://www.npmjs.com/package/wait-on) to delay the frontend start.

### Frontend:

- [React.js](https://reactjs.org)
  - [Reach Router](https://reach.tech/router)
  - [Styled Components](https://www.styled-components.com)
- [ESLint](https://eslint.org/) for code quality.
- [Jest](https://jestjs.io/) for testing and code coverage.

### Backend:

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Retrofit](https://square.github.io/retrofit/)
- [JUnit](https://junit.org/junit5/) for testing.
- [Jacoco](https://www.eclemma.org/jacoco/) for code coverage.
- [SpotBugs](https://spotbugs.github.io/) for finding bugs.
- [CheckStyle](https://checkstyle.sourceforge.io) for code quality.

---

## Running the project bootstrapped:

When running the application, data is generated and stored via the REST api. The output can be located in `/backend/out/profiles/` after the app has ran for the first time.

### Install dependencies

```zsh
$ npm install
```

### Run the project

```zsh
$ npm start
```

### Test the frontend

```zsh
$ npm run test-frontend
```

### Test the backend

```zsh
$ npm run test-backend
```

---

## Running the project manually

### Start the backend first.

```zsh
$ cd backend
$ gradle run
```

### Start the frontend second, in a new terminal window/tab.

```zsh
$ cd frontend
$ npm install # Install dependencies first time.
$ npm run start
```

---

## Building the project:

### Build backend

```zsh
$ cd backend
$ gradle build
```

### Build frontend

```zsh
$ cd frontend
$ npm run build
```

---

## Testing and results.

There are tests for both the frontend and the backend.

### Backend

Tests are found at `{modulename}/src/test`. For analysis purposes we're using the following technologies:

- `Jacoco` for code coverage.
- `Checkstyle` to adhere the Google coding standards.
- `Spotbugs` to find bugs.

The test results are stored within each module at `{modulename}/build/reports`.

**NB!**  
The testing of the REST-api is both done in the API-tests, aswell as the SERVER-tests as they are dependant on eachother.

### Running the tests:

```zsh
$ gradle test
```

### Frontend

The tests are found at `frontend/src/tests`. For analysis purposes we're using the following technologies.

- `Istanbul` for code coverage. This is integrated in JEST.
- `ESLint` for code quality.
- `JEST` for testing the JavaScript.

### Running the tests:

```zsh
$ npm run test
```

The test render a code coverage-report in the terminal. You can also access this report manually at `/coverage/`. We suggest opening the HTML-file located at `/coverage/lcov-report/`.

---

# Welcome to our Blood Alcohol Concentration Calculator, BACkup!

Using this application, you can accurately estimate your BAC at any given time. The user can register relevant health stats, and input how many units she/he has consumed over any given time. The health stats include weight and gender, as well as the persons name. The program results with an interface displaying your current BAC.

Every user is welcomed by our profile page. There one can select a profile, if already created, or create a new one. Once the profile is loaded or created, it's time to register your drinks. The trackerpage takes the input from the user and calculates the users BAC.

---

# Diagrams

## Package Diagram

![Frontend Package Diagram](./resources/img/new_packagedia_frontend.png)
![Backend Package Diagram](./resources/img/new_packagedia_backend.png)

---

## Class Diagram

![API](./resources/img/klassedia_core.png)
![API Service](./resources/img/klassedia_api_services.png)
![CORE](./resources/img/klassedia_api_services.png)
![JSON](./resources/img/klassedia_json.png)
![SERVER](./resources/img/klassedia_server.png)
![SERVER Controller](./resources/img/klassedia_server_controller.png)

---

## Sequence Diagram

Adding a unit on a user.
![SEQUENCE](./resources/img/Sekvensdiagram.png)
