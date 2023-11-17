#include <iostream>
#include <stdexcept>
#include <string>
#include <cmath>

// Функция для определения, является ли число палиндромом
bool isPalindrome(int num) {
    if (num < 0) {
        throw std::invalid_argument("Отрицательные числа не могут быть палиндромами");
    }

    // Преобразование числа в строку для сравнения символов
    std::string numStr = std::to_string(num);

    // Индексы для сравнения символов
    int start = 0;
    int end = numStr.length() - 1;

    while (start < end) {
        if (numStr[start] != numStr[end]) {
            return false; // Не палиндром
        }
        ++start;
        --end;
    }

    return true; // Палиндром
}

// Юнит-тесты с использованием Catch2
#define CATCH_CONFIG_MAIN
#include <catch2/catch.hpp>

TEST_CASE("Check if a number is a palindrome") {
    SECTION("Valid input") {
        REQUIRE(isPalindrome(121) == true);
        REQUIRE(isPalindrome(1221) == true);
        REQUIRE(isPalindrome(12321) == true);
        REQUIRE(isPalindrome(1234321) == true);
        REQUIRE(isPalindrome(0) == true);
    }

    SECTION("Invalid input") {
        REQUIRE_THROWS_AS(isPalindrome(-121), std::invalid_argument);
    }
}

int main(int argc, char* argv[]) {
    // Запуск юнит-тестов с использованием Catch2
    int result = Catch::Session().run(argc, argv);

    // Вывод результата выполнения тестов
    return (result < 0xff ? result : 0xff);
}
