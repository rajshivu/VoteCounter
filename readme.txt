#Components used in this problem

VotingApp Class:

This class is the main entry point of the Spring Boot application. It is annotated with @SpringBootApplication to enable auto-configuration and component scanning.

Controller:

Annotated with @RestController, it handles incoming HTTP requests. Contains methods for different API endpoints related to candidate management and voting.

API Endpoints:

/entercandidate: Accepts a candidate name as a parameter, initializes their vote count to 0, and saves it.

/castvote: Accepts a candidate name as a parameter, increments their vote count, and returns the updated count.

/countvote: Accepts a candidate name as a parameter and returns the latest vote count for that candidate.

/listvote: Returns a JSON representation of all candidates and their respective vote counts.

/getwinner: Returns the name of the candidate with the highest number of votes. Handles tie scenarios and provides appropriate messages.

Dependencies:

The project uses Spring Boot dependencies, including spring-boot-starter-web for web-related functionality and spring-boot-starter-test for testing
