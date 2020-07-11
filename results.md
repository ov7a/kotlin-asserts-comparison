# Comparison results

## Requirements

1. Seamless integration with Kotlin and IntelliJ Idea.
2. A detailed message in case of assert failure.
3. Easy to write and easy to read.
4. Substring operations support.
5. Assert for exception-throwing block.
6. Collections support, including item absence and presence asserts and primitive arrays support. 
7. Assert negations (`isNotEqualTo`, `doesNotContain` and others).
8. Types should be derived for generics (or ignored).
9. Deep comparison of nested collections and containers instead of plain `equals` call. 

Each requirement gives 1, 0.5 or 0 to the total sum.

# Results

| Library | Integration | Detailed message | Obviousness | Substring | Exceptions | Collections | Negations | Deriving types | Complex structures | Total |
| ---------- | :-----: | :-----: | :-----: | :-----: | :-----: | :-----: | :-----: | :-----: | :-----: | :-----: |
| Kotest     |     ±      |        ±        |        +      |     +     |      +     |     +     |     +     |     no     |         -         |  6.0  |
| Kluent     |     ±      |        ±        |        +      |     +     |      +     |     +     |     +     |     no     |         -         |  6.0  |
| AssertJ    |     ±      |        +        |        ±      |     +     |      ±     |     +     |     +     |     no     |         ±         |  6.0  |
| Truth      |     ±      |        +        |        +      |     +     |      -     |     +     |     +     |     no     |         -         |  5.5  |
| Strikt     |     ±      |        ±        |        ±      |     +     |      +     |     +     |     +     |     no     |         -         |  5.5  |
| ScalaTest  |     ±      |        ±        |        ±      |     +     |      +     |     +     |     +     |     no     |         -         |  5.5  |
| HamKrest   |     ±      |        -        |        ±      |     +     |      +     |     ±     |     +     |     yes    |         -         |  5.5  |
| AssertK    |     ±      |        ±        |        ±      |     +     |      ±     |     +     |     +     |     no     |         -         |  5.0  |
| Atrium     |     ±      |        ±        |        ±      |     +     |      +     |     ±     |     +     |     no     |         -         |  5.0  |
| Hamсrest   |     ±      |        ±        |        ±      |     +     |      -     |     ±     |     +     |     yes    |         -         |  5.0  |
| JUnit      |     +      |        +        |        -      |     ±     |      +     |     -     |     ±     |   ignores  |         -         |  4.5  |
| kotlin.test|     +      |        ±        |        -      |     -     |      +     |     -     |     -     |     yes    |         -         |  3.5  |
| Expekt     |     ±      |        ±        |        -      |     +     |      -     |     ±     |     +     |     no     |         -         |  3.5  |
