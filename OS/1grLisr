#include <iostream>
#include <stdexcept>

// Определение структуры для узла связного списка
template <typename T>
struct Node {
    T data;
    Node* next;

    Node(T value) : data(value), next(nullptr) {}
};

// Функция для разворота связного списка
template <typename T>
Node<T>* reverseLinkedList(Node<T>* head) {
    Node<T>* prev = nullptr;
    Node<T>* current = head;
    Node<T>* next = nullptr;

    while (current != nullptr) {
        next = current->next;
        current->next = prev;
        prev = current;
        current = next;
    }

    return prev; // Новая голова списка после разворота
}

// Функция для вывода связного списка
template <typename T>
void printLinkedList(Node<T>* head) {
    while (head != nullptr) {
        std::cout << head->data << " ";
        head = head->next;
    }
    std::cout << std::endl;
}

// Юнит-тесты с использованием Catch2
#define CATCH_CONFIG_MAIN
#include <catch2/catch.hpp>

TEST_CASE("Reverse linked list") {
    SECTION("Valid input") {
        Node<int>* head = new Node<int>(1);
        head->next = new Node<int>(2);
        head->next->next = new Node<int>(3);
        head->next->next->next = new Node<int>(4);

        REQUIRE(head->data == 1);
        REQUIRE(head->next->data == 2);
        REQUIRE(head->next->next->data == 3);
        REQUIRE(head->next->next->next->data == 4);

        Node<int>* reversedHead = reverseLinkedList(head);

        REQUIRE(reversedHead->data == 4);
        REQUIRE(reversedHead->next->data == 3);
        REQUIRE(reversedHead->next->next->data == 2);
        REQUIRE(reversedHead->next->next->next->data == 1);
    }

    SECTION("Empty input") {
        Node<int>* head = nullptr;
        REQUIRE(reverseLinkedList(head) == nullptr);
    }
}

int main(int argc, char* argv[]) {
    // Запуск юнит-тестов с использованием Catch2
    int result = Catch::Session().run(argc, argv);

    // Вывод результата выполнения тестов
    return (result < 0xff ? result : 0xff);
}
