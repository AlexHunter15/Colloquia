#include "Colloc1.cpp" // Предполагаемый заголовочный файл для класса Operation
#include <gtest/gtest.h>

// Тестирование выполнения операции сложения
TEST(OperationTest, AdditionTest) {
    Addition addition;
    std::vector<float> numbers = { 2.0f, 3.0f, 5.0f };
    float expected_result = 10.0f; // Ожидаемый результат: 2 + 3 + 5 = 10
    float result = addition.perform(numbers);
    EXPECT_FLOAT_EQ(expected_result, result);
}

// Тестирование выполнения операции умножения
TEST(OperationTest, MultiplicationTest) {
    Multiplication multiplication;
    std::vector<float> numbers = { 2.0f, 3.0f, 5.0f };
    float expected_result = 30.0f; // Ожидаемый результат: 2 * 3 * 5 = 30
    float result = multiplication.perform(numbers);
    EXPECT_FLOAT_EQ(expected_result, result);
}

// Тестирование выполнения операции суммы квадратов
TEST(OperationTest, SumOfSquaresTest) {
    SumOfSquares sumOfSquares;
    std::vector<float> numbers = { 2.0f, 3.0f, 5.0f };
    float expected_result = 38.0f; // Ожидаемый результат: 2^2 + 3^2 + 5^2 = 4 + 9 + 25 = 38
    float result = sumOfSquares.perform(numbers);
    EXPECT_FLOAT_EQ(expected_result, result);
}

int main(int argc, char* argv[]) {
    ::testing::InitGoogleTest(&argc, argv);
    return RUN_ALL_TESTS();
}
