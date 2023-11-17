Описание через призму инкапсуляции:
State — это поведенческий паттерн, который позволяет объекту изменять свое поведение при изменении его внутреннего
состояния. Он использует инкапсуляцию, чтобы представить каждое состояние объекта в виде отдельного класса, 
а затем делегирует выполнение задач соответствующему классу состояния. Клиенты взаимодействуют с контекстом 
объекта через общий интерфейс, не зная о деталях реализации конкретных состояний.

Пример использования на практике:

cpp
Copy code
#include <iostream>

// Интерфейс для состояний
class State {
public:
    virtual void handle() = 0;
};

// Конкретное состояние A
class ConcreteStateA : public State {
public:
    void handle() override {
        std::cout << "Handling state A." << std::endl;
    }
};

// Конкретное состояние B
class ConcreteStateB : public State {
public:
    void handle() override {
        std::cout << "Handling state B." << std::endl;
    }
};

// Контекст, в котором происходит изменение состояний
class Context {
private:
    State* currentState;

public:
    Context(State* initialState) : currentState(initialState) {}

    void setState(State* newState) {
        currentState = newState;
    }

    void request() {
        currentState->handle();
    }
};

int main() {
    ConcreteStateA stateA;
    ConcreteStateB stateB;

    Context context(&stateA);

    // Переключение контекста на состояние B
    context.setState(&stateB);
    context.request();  // Обработка состояния B

    return 0;
}
В этом примере каждое состояние представлено отдельным классом, а объект Context делегирует выполнение задач соответствующим 
классам состояний через общий интерфейс State.
