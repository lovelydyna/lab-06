# Lab 6 — Participation Exercise

This README contains a detailed task list and verification steps for the Lab 6 Participation Exercise.

Goal
------
Implement and test three methods in `CityList` and add Javadocs to the main source files (`CityList.java` and `City.java`). Finally, generate the Javadocs into `/app/javadocs`.

Quick checklist (high level)
- [ ] Implement `hasCity(City city)` in `CityList`
- [ ] Implement `delete(City city)` in `CityList`
- [ ] Implement `countCities()` in `CityList`
- [ ] Add Javadoc comments to `City.java` and `CityList.java` (all public methods and class-level docs)
- [ ] Add/update unit tests (in `test/java/.../CityListTest.java`) for the above methods
- [ ] Run unit tests: `./gradlew test` and ensure green
- [ ] Generate Javadocs to `/app/javadocs` and verify output

Detailed tasks and guidance
---------------------------

1) Implement methods in `CityList`

- hasCity(City city)
  - Description: Return true if the list contains an object equal to `city`.
  - Important: Correct equality depends on `City.equals(...)` and `City.hashCode()` implementation. If `City` currently only uses object identity, update `City.equals` and `hashCode` accordingly (compare name and province/state, or the fields that define identity in your project).
  - Contract:
    - Input: a non-null `City` reference (if null is passed, you may choose to return false or throw `NullPointerException` — document your choice in Javadoc).
    - Output: boolean — true if an equal city exists in the list, false otherwise.

- delete(City city)
  - Description: If `city` exists in the list (using equality), remove it and return (or void). If it does not exist, throw an exception.
  - Recommended exception: `IllegalArgumentException` or `NoSuchElementException` with a clear message like "City not found in list: <city>".
  - Contract:
    - Input: a non-null `City` reference.
    - Behaviour: remove the first matching city (or all matching entries depending on list semantics — pick one and document it). If not found, throw the chosen exception.

- countCities()
  - Description: Return the number of cities currently in the list.
  - Contract: returns an `int >= 0`.

Edge cases to consider
- Null city parameter (null). Decide whether to throw an NPE or return false in `hasCity`. Document it.
- Duplicate cities (two City objects that are equal) — decide whether `delete` removes only one occurrence or all occurrences. Document and test.
- Empty list behavior for `delete` and `countCities`.

2) Tests (JUnit5)

Place/modify tests in `src/test/java/com/example/lab_06/CityListTest.java`.

Suggested tests (use JUnit5 assertions):

- hasCity: happy path
  - Arrange: create a `CityList` and add a `City("Calgary", "AB")`.
  - Assert: `assertTrue(cityList.hasCity(new City("Calgary", "AB")))`.
  - Note: This will only pass if `City.equals` compares values, not object identity.

- delete: successful removal
  - Arrange: add `City("Edmonton", "AB")`.
  - Act: `cityList.delete(new City("Edmonton", "AB"));`
  - Assert: `assertFalse(cityList.hasCity(new City("Edmonton", "AB")));`
  - Assert: `assertEquals(originalCount - 1, cityList.countCities());`

- delete: throws when not present
  - Arrange: create an empty `CityList` or one without target city.
  - Assert: use `assertThrows(IllegalArgumentException.class, () -> cityList.delete(new City("Nowhere","XX")));`
  - See: https://howtodoinjava.com/junit5/expected-exception-example/

- countCities
  - Arrange: add a known number of cities.
  - Assert: `assertEquals(n, cityList.countCities());`

Test tips
- Use `assertThrows` for the exception test.
- Keep tests small and focused (one assertion behavior per test). You can assert both that the count changed and that `hasCity` returns false after deletion.

Example JUnit5 snippets

// hasCity example
// CityListTest.java
// ...existing imports...
// @Test
// public void hasCity_returnsTrueWhenCityPresent() {
//     CityList list = new CityList();
//     list.add(new City("Calgary", "AB"));
//     assertTrue(list.hasCity(new City("Calgary", "AB")));
// }

// delete exception example
// @Test
// public void delete_throwsWhenCityNotPresent() {
//     CityList list = new CityList();
//     assertThrows(IllegalArgumentException.class, () -> list.delete(new City("NoCity","XX")));
// }

3) Javadocs

- Add Javadoc comments to:
  - `City.java` — class-level description and comments for all public constructors/getters/setters and `equals`/`hashCode` if present.
  - `CityList.java` — class-level description and Javadocs for `hasCity`, `delete`, `countCities`, and any other public methods.

- Each Javadoc should describe:
  - A one-sentence summary.
  - Parameters (with `@param`).
  - Return value (with `@return`) where applicable.
  - Exceptions thrown (with `@throws`) and the conditions when they are thrown.

Generate Javadocs to `/app/javadocs`
- Option A — (preferred) if your project already supports a `javadoc` Gradle task
  - Run: `./gradlew javadoc`
  - Then copy or configure the output directory to `app/javadocs`.

- Option B — add a small Gradle task in `build.gradle.kts` (project root) to generate javadocs and place them at `app/javadocs`.
  - Example snippet (Kotlin DSL) to add to `build.gradle.kts`:

  // (Add this snippet to your root `build.gradle.kts` or the module's build file)
  // tasks.register<Javadoc>("generateAppJavadocs") {
  //     source = fileTree("src/main/java")
  //     classpath = files()
  //     destinationDir = file("app/javadocs")
  // }

  - Then run: `./gradlew generateAppJavadocs`

- If your project is Android and the simple `javadoc` task is not available, you can create a dedicated task that points to the Java sources as shown above or run the JDK `javadoc` tool manually and write output to `app/javadocs`.

4) Quality gates and verification

- Run unit tests:

```bash
./gradlew test
```

- Verify test coverage for the three methods in `CityListTest.java`.
- Generate Javadocs and inspect `/app/javadocs/index.html` in a browser.

Requirements coverage mapping (what will be marked Done when complete)
- Implement and test `hasCity` — Done when unit test passes and checks equality.
- Implement and test `delete` — Done when unit tests verify removal and a separate test verifies exception is thrown when city absent.
- Implement and test `countCities` — Done when unit test validates expected counts for a few scenarios.
- Javadocs added to `City.java` and `CityList.java` — Done when each public method and the classes have Javadoc comments.
- Javadocs generated to `/app/javadocs` — Done when `app/javadocs/index.html` exists and opens.

Extra (small, optional) improvements
- Add unit tests for `City.equals` and `hashCode` if they are not already tested (this prevents equality-related bugs).
- Add a small README section showing how to run a single JUnit test from command line (e.g., `./gradlew test --tests "com.example.lab_06.CityListTest.hasCity_returnsTrueWhenCityPresent"`).

Notes and assumptions
- Assumed testing framework: JUnit5 (your repo already contains tests under `src/test/java`).
- Assumed source layout: `src/main/java/...` and `src/test/java/...` as shown in the project tree.
- If you prefer a different exception type for `delete`, pick one consistently and document it in the Javadoc and tests.

If you want, I can also:
- Open or modify `CityList.java` and add the implementations and Javadocs directly.
- Update or add the unit tests in `CityListTest.java`.
- Add the Gradle task to generate `app/javadocs` and run it to produce the output.

Tell me which of the optional actions above you'd like me to take next and I'll implement them.
