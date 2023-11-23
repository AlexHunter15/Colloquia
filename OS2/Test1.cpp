#include "Colloc1.cpp" // Ïðåäïîëàãàåìûé çàãîëîâî÷íûé ôàéë äëÿ êëàññà Operation
#include <gtest/gtest.h>

// Òåñòèðîâàíèå âûïîëíåíèÿ îïåðàöèè ñëîæåíèÿ
TEST(OperationTest, AdditionTest) {
    Addition addition;
    std::vector<float> numbers = { 2.0f, 3.0f, 5.0f };
    float expected_result = 10.0f; // Îæèäàåìûé ðåçóëüòàò: 2 + 3 + 5 = 10
    float result = addition.perform(numbers);
    EXPECT_FLOAT_EQ(expected_result, result);
}

// Òåñòèðîâàíèå âûïîëíåíèÿ îïåðàöèè óìíîæåíèÿ
TEST(OperationTest, MultiplicationTest) {
    Multiplication multiplication;
    std::vector<float> numbers = { 2.0f, 3.0f, 5.0f };
    float expected_result = 30.0f; // Îæèäàåìûé ðåçóëüòàò: 2 * 3 * 5 = 30
    float result = multiplication.perform(numbers);
    EXPECT_FLOAT_EQ(expected_result, result);
}

// Òåñòèðîâàíèå âûïîëíåíèÿ îïåðàöèè ñóììû êâàäðàòîâ
TEST(OperationTest, SumOfSquaresTest) {
    SumOfSquares sumOfSquares;
    std::vector<float> numbers = { 2.0f, 3.0f, 5.0f };
    float expected_result = 38.0f; // Îæèäàåìûé ðåçóëüòàò: 2^2 + 3^2 + 5^2 = 4 + 9 + 25 = 38
    float result = sumOfSquares.perform(numbers);
    EXPECT_FLOAT_EQ(expected_result, result);
}

int main(int argc, char* argv[]) {
    ::testing::InitGoogleTest(&argc, argv);
    return RUN_ALL_TESTS();
}
