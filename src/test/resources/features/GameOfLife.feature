Feature: Conway's Game of Life

  Rules of Conway's Game of Life
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

  Scenario: Empty universe
    Given the following universe:
    """
    """
    Then the next generation MUST be:
    """
    """

  Scenario: Single cell universe
    Given the following universe:
    """
    *
    """
    Then the next generation MUST be:
    """
    """

  Scenario: Block
    Given the following universe:
    """
    **
    **
    """
    Then the next generation MUST be:
    """
    **
    **
    """

  Scenario: Blinker
    Given the following universe:
    """
    .*
    .*
    .*
    """
    Then the next generation MUST be:
    """

    ***

    """
    Then the next generation MUST be:
    """
    .*
    .*
    .*
    """

  Scenario: Glider
    Given the following universe:
    """
    .*
    ..*
    ***
    """
    Then the next generation MUST be:
    """

    *.*
    .**
    .*
    """
    Then the next generation MUST be:
    """

    ..*
    *.*
    .**
    """
    Then the next generation MUST be:
    """

    .*
    ..**
    .**
    """
    Then the next generation MUST be:
    """

    ..*
    ...*
    .***
    """
