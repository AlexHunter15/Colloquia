#include <iostream>
#include <vector>
#include <stdexcept>

// Функция для генерации первых n чисел Фибоначчи
std::vector<int> generateFibonacci(int n) {
    if (n <= 0) {
        throw std::invalid_argument("n должно быть натуральным числом больше 0");
    }

    std::vector<int> fibonacciNumbers;
    fibonacciNumbers.reserve(n);

    fibonacciNumbers.push_back(0);

    if (n == 1) {
        return fibonacciNumbers;
    }

    fibonacciNumbers.push_back(1);

    for (int i = 2; i < n; ++i) {
        int nextFibonacci = fibonacciNumbers[i - 1] + fibonacciNumbers[i - 2];
        fibonacciNumbers.push_back(nextFibonacci);
    }

    return fibonacciNumbers;
}

// Юнит-тесты с использованием Catch2
#define CATCH_CONFIG_MAIN
#include <catch2/catch.hpp>

TEST_CASE("Generate Fibonacci sequence") {
    SECTION("Valid input") {
        REQUIRE(generateFibonacci(0).empty());
        REQUIRE(generateFibonacci(1) == std::vector<int>{0});
        REQUIRE(generateFibonacci(2) == std::vector<int>{0, 1});
        REQUIRE(generateFibonacci(5) == std::vector<int>{0, 1, 1, 2, 3});
    }

    SECTION("Invalid input") {
        REQUIRE_THROWS_AS(generateFibonacci(-1), std::invalid_argument);
        REQUIRE_THROWS_AS(generateFibonacci(0), std::invalid_argument);
    }
}

int main(int argc, char* argv[]) {
    // Запуск юнит-тестов с использованием Catch2
    int result = Catch::Session().run(argc, argv);

    // Вывод результата выполнения тестов
    return (result < 0xff ? result : 0xff);
}
