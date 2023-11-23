#include "gtest/gtest.h"
#include "Colloc.cpp" // ���������� ������������ ���� � ������������� ������� ��� ��������� ������

TEST(MatrixMultiplicationTest, MultiplicationTest) {
    std::vector<std::vector<int>> A = { {1, 2}, {3, 4} };
    std::vector<std::vector<int>> B = { {5, 6}, {7, 8} };

    std::vector<std::vector<int>> expected_result = { {19, 22}, {43, 50} };
    std::vector<std::vector<int>> result(m, std::vector<int>(k, 0));

    // ��������� ��������� ������
    matrixMultiplication(A, B, result);

    // ���������, ��� ���������� ��������� ������������� ����������
    for (int i = 0; i < m; ++i) {
        for (int j = 0; j < k; ++j) {
            EXPECT_EQ(expected_result[i][j], result[i][j]);
        }
    }
}
