# Game of Life

![Kotlin CI with Gradle](https://github.com/nelkinda/gameoflife-kotlin/workflows/Kotlin%20CI%20with%20Gradle/badge.svg)
![Kotlin CI with Maven](https://github.com/nelkinda/gameoflife-kotlin/workflows/Kotlin%20CI%20with%20Maven/badge.svg)

This is an example implementation of Conway's Game of Life in **Kotlin**.
The primary focus of the implementation is cleanliness, not performance.
It serves as a lose guideline for Nelkinda Coderetreat facilitators.

## Rules of Conway's Game of Life
> The universe of the _Game of Life_ is an infinite, two-dimensional orthogonal grid of square cells.
> Each cell is in one of two possible states:
> * Alive aka populated
> * Dead aka unpopulated
> 
> Every cell interacts with its eight neighbors.
> The neighbors are the cells that are horizontally, vertically, or diagonally adjacent.
> At each step in time, the following transitions occur:
> 1. Underpopulation: Any live cell with fewer than 2 live neighbors dies.
> 1. Survival: Any live cell with 2 or 3 live neighbors survives on to the next generation.
> 1. Overpopulation Any live cell with more than 3 live neighbors dies.
> 1. Reproduction (birth): Any dead cell with exactly 3 live neighbors becomes a live cell.

— [Conway's Game of Life - Wikipedia](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life)

## Activities (aka Constraints)
This implementation of Game of Life follows the following activities and constraints:
* Behavior Driven Development.
* Test-Driven Development.
* Immutable objects only.
  Only pure functions.
* No variable reassignments (except for the Parser).
* Short functions only.
  Most functions are expression functions.
  Exception: The Parser is big.
* Domain-Specific Language:
  The symbol names are taken from the problem domain.
  A point, for example, is constructed with `P(x, y)` instead of `Point(x, y)`.
  That makes the code shorter and easier to read.
* Functional Core, Imperative Shell:
  The code is purely functional.
  The imperative shell is so far out that it's in the test only.
  The Parser implementation is imperative, but its interface and observable behavior are functional.

## Quality
Note: This has been copied from [gameoflife-java](https://github.com/nelkinda/gameoflife-java) and not changed to Kotlin yet.
Jacoco and Pitest do not work yet.

### Testing, Mutation Test Coverage
- The acceptance tests are written using BDD in Gherkin and executed via Cucumber.
- The unit tests are written and executed with JUnit 5.
  Regular code coverage is measured using JaCoCo which reports 100% lines and condition coverage.

### SonarQube
- The project has a SonarQube analysis.
  The project has the best possible rating imaginable:
  0 bugs, 0 vulnerabilities, 0 security hotspots, 0 debt, 0 code smells, 100% coverage, 0.0% duplications, 0 duplicated blocks.

![SonarQube report](src/doc/images/GameOfLife_Sonar.png)
The lack of coverage in the Pitest report is due to a coverage bug around enums.

## References
- [Coderetreat](https://www.coderetreat.org/)
- [Conway's Game of Life - Wikipedia](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life)

## Questions/Contact
* [E-Mail: events@nelkinda.com](mailto:events@nelkinda.com)
* [Nelkinda Website](https://nelkinda.com/)
* [Nelkinda Events](https://nelkinda.com/events/)
* [Twitter (Nelkinda)](https://twitter.com/nelkinda)
* [Twitter (Christian Hujer)](https://twitter.com/christianhujer)
* [Facebook](https://www.facebook.com/nelkinda/)
* [LinkedIn](https://www.linkedin.com/company/nelkinda/)
