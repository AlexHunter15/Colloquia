# Java - базовые задачи для КР

## ООП

### Задача #1

Напишите класс `BaseConverter` для конвертации из градусов по Цельсию в Кельвины, Фаренгейты и другие единицы измерения. У класса должен быть метод `convert`, выполняющий конвертацию. Также необходимо реализовать фабричный метод с базовой поддержкой локали, например:

```java
Locale locale = Locale.getDefault();
String[] fahrenheitCountries = {"BS", "US", "BZ", "KY", "PW"}; Код необходимо покрыть Unit-тестами.
```
### Задача #2: StringBuilder с операцией undo
Напишите свой класс StringBuilder с поддержкой операции undo. Делегируйте все методы стандартному StringBuilder, а в собственном классе храните список всех операций для выполнения undo. Используйте шаблон "Команда". Код необходимо покрыть Unit-тестами.

### Задача #3: StringBuilder с возможностью оповещения
Напишите свой класс StringBuilder с возможностью оповещения других объектов (слушателей) об изменении своего состояния. Делегируйте все методы стандартному StringBuilder, реализуйте шаблон проектирования "Наблюдатель". Код необходимо покрыть Unit-тестами.

### Задача #4: Метод filter
Напишите метод filter, который принимает на вход массив любого типа и реализацию интерфейса Filter с методом apply(Object o), чтобы убрать из массива лишнее. Рассмотрите альтернативную реализацию на базе Generics. Код необходимо покрыть Unit-тестами.

### Задача #5: Метод fill
Напишите метод fill, который принимает массив объектов и реализацию интерфейса Function. Метод fill должен заполнить массив, получая новое значение по индексу с помощью реализации интерфейса Function. Код необходимо покрыть Unit-тестами.

## Многопоточность
### Задача #1: Состояние потока
Выведите состояние потока перед его запуском, после запуска и во время выполнения, учитывая TIMED_WAITING, WAITING и BLOCKED.

### Задача #2: Производитель-потребитель
Реализуйте два потока - производителя и потребителя, разделяющих общий буфер данных с ограниченным размером. Код должен регулировать ожидание потребителя, если буфер пуст, и ожидание производителя, если буфер заполнен.

### Задача #3: Аннотация Repeat
Создайте свою аннотацию Repeat с целочисленным параметром. Расширьте класс ThreadPoolExecutor и переопределите метод execute, чтобы метод run экземпляра Runnable с аннотацией Repeat выполнялся заданное количество раз. Код необходимо покрыть Unit-тестами.
