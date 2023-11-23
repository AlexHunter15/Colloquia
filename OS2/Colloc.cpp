#include <iostream>
#include <vector>
#include <thread>
#include <mutex>
#include <chrono>
#include <condition_variable>

// Размеры матриц
const int m = 3;
const int n = 3;
const int k = 3;

std::vector<std::vector<int>> A = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
std::vector<std::vector<int>> B = { {9, 8, 7}, {6, 5, 4}, {3, 2, 1} };
std::vector<std::vector<int>> C(m, std::vector<int>(k, 0));

std::mutex mtx;
std::condition_variable cv;
bool threads_finished = false;
int current_i = 0;
int current_j = 0;

void calculateMatrixProduct() {
    while (true) {
        std::unique_lock<std::mutex> lock(mtx);
        cv.wait(lock, [] { return threads_finished || current_i < m; });

        if (threads_finished) {
            return;
        }

        int i = current_i;
        int j = current_j;

        current_j++;
        if (current_j == k) {
            current_j = 0;
            current_i++;
        }

        lock.unlock();

        int sum = 0;
        if (i < m && j < k) {
            for (int x = 0; x < n; ++x) {
                sum += A[i][x] * B[x][j];
            }
            C[i][j] = sum;

            // Задержка в выполнении вычислений для имитации работы потока
            std::this_thread::sleep_for(std::chrono::milliseconds(100));
        }
    }
}

int main() {
    const int num_threads = 4; // Количество однотипных потоков

    std::vector<std::thread> threads;
    for (int i = 0; i < num_threads; ++i) {
        threads.emplace_back(calculateMatrixProduct);
    }

    for (std::thread& thread : threads) {
        thread.join();
    }

    // Вывод результата на экран
    for (const auto& row : C) {
        for (int val : row) {
            std::cout << val << " ";
        }
        std::cout << std::endl;
    }

    // Запись результата в файл-протокол

    return 0;
}
