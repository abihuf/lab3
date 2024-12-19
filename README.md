## Отчет по лабораторной работе № 3
#### № группы: `ПМ-2402`

#### Выполнила: `Белова Полина Сергеевна`

#### Вариант: `3`

### Cодержание:

- [Постановка задачи](#1-постановка-задачи)
- [Входные и выходные данные](#2-входные-и-выходные-данные)
- [Выбор структуры данных](#3-выбор-структуры-данных)
- [Алгоритм](#4-алгоритм)
- [Программа](#5-программа)
- [Анализ правильности решения](#6-анализ-правильности-решения)
  
#### 1. Постановка задачи
Целью млей программы является создание функционала для управления списком дел, который позволяет пользователю добавлять, удалять и изменять статус задач. Программа должна обеспечивать возможность вывода полного списка задач, а также фильтрации по выполненным и невыполненным задачам. Кроме того, требуется реализовать статистику по задачам, включая общее количество, количество выполненных и невыполненных задач, а также процент выполнения.

#### 2. Входные и выходные данные
- **Входные данные:**
  - Название задачи (строка) для добавления в список.
  - Порядковый номер задачи (целое число) для изменения статуса или удаления.
  - Статус задачи (выполнено/невыполнено) при изменении.
  
- **Выходные данные:**
  - Полный список задач с их статусами.
  - Список только невыполненных или выполненных задач.
  - Статистика по задачам, включая общее количество, количество выполненных и невыполненных задач, а также процент выполнения.

#### 3. Выбор структуры данных
Для реализации программы была выбрана структура данных `ArrayList`, которая позволяет динамически управлять списком задач. 

#### 4. Алгоритм
1. **Создание класса `Task`**:

### Класс `Task`
Класс `Task` представляет отдельную задачу в списке дел. 

#### Свойства:
- `name`: название задачи (строка).
- `completed`: статус выполнения задачи (логическое значение, где `true` означает, что задача выполнена, а `false` — что нет).

#### Методы:
- **Конструктор**: `public Task(String name)` — инициализирует задачу с заданным именем и устанавливает статус выполнения по умолчанию в `false`.
- `getName()`: возвращает название задачи.
- `isCompleted()`: возвращает статус выполнения задачи.
- `markAsCompleted()`: устанавливает статус выполнения задачи в `true`.
- `toString()`: переопределяет метод `toString()` для удобного отображения статуса задачи. Возвращает строку с обозначением выполненности задачи (например, "[x] «Сходить в магазин»" для выполненной задачи).

2. **Создание класса `TaskList`**:
   - Хранит список задач в виде `ArrayList<Task>`.
   - Реализует методы для:
     - Добавления новой задачи.
     - Удаления задачи по номеру или названию.
     - Изменения статуса задачи по номеру или названию.
     - Вывода полного списка задач, а также списков выполненных и невыполненных задач.
     - Подсчета общего количества задач, выполненных и невыполненных задач.
     - Вычисления процента выполнения задач.
     - Отображения статистики по задачам.

### 2. Класс `TaskList`

#### Свойства:
- `name`: название списка задач (строка).
- `tasks`: список задач, реализованный с помощью `ArrayList<Task>`.

#### Методы:
- **Конструктор**: `public TaskList(String name)` — создает новый список задач с заданным именем и инициализирует пустой список задач.
- `displayTaskList()`: выводит полный список задач.
- `displayNotCompletedTasks()`: выводит только невыполненные задачи.
- `displayCompletedTasks()`: выводит только выполненные задачи.
- `taskExists(String taskName)`: проверяет, существует ли задача с заданным именем.
- `addTask(String taskName)`: добавляет новую задачу в список, если задача с таким названием еще не существует.
- `markTaskAsCompletedByNumber(int taskNumber)`: отмечает задачу как выполненную по её номеру в списке.
- `markTaskAsCompletedByName(String taskName)`: отмечает задачу как выполненную по её названию.
- `getTaskNumberByName(String taskName)`: возвращает номер задачи по её названию (или -1, если задача не найдена).
- `removeTaskByNumber(int taskNumber)`: удаляет задачу по её номеру.
- `removeTaskByName(String taskName)`: удаляет задачу по её названию.
- `getTotalTaskCount()`: возвращает общее количество задач в списке.
- `getCompletedTaskCount()`: возвращает количество выполненных задач.
- `getNotCompletedTaskCount()`: возвращает количество невыполненных задач.
- `calculateCompletionPercentage()`: вычисляет процент выполненных задач.
- `displayTaskStatistics()`: выводит статистику по задачам, включая общее количество, количество выполненных и невыполненных задач, а также процент выполнения.

3. **Создание класса `TaskManager`**:
   - Реализует основной метод `main`, который демонстрирует функционал программы.
   - Создает экземпляр `TaskList`, добавляет задачи, изменяет их статус и выводит результаты.

#### Методы:
- `main(String[] args)`: 
  - Создает экземпляр `TaskList` с именем "Мой список дел".
  - Добавляет задачи в список (например, "Сходить в магазин" и "Написать отчет").
  - Отмечает первую задачу как выполненную.
  - Выводит полный список задач, статистику по задачам, список невыполненных задач и список выполненных задач.
 
    ### 5. Программа

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Task {
        private String name;
        private boolean completed;

        public Task(String name) {
            this.name = name;
            this.completed = false;
        }

        public String getName() {
            return name;
        }

        public boolean isCompleted() {
            return completed;
        }

        public void markAsCompleted() {
            this.completed = true;
        }

        @Override
        public String toString() {
            if (completed)
                return ("[x] " + "«" + name + "»");
            else
                return ("[ ] " + "«" + name + "»");
        }
    }

    class TaskList {
        private String name;
        private List<Task> tasks;

        public TaskList(String name) {
            this.name = name;
            this.tasks = new ArrayList<>();
        }

        public void displayTaskList() {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println("(" + (i + 1) + ") " + tasks.get(i));
            }
        }

        public void displayNotCompletedTasks() {
            for (int i = 0; i < tasks.size(); i++) {
                if (!tasks.get(i).isCompleted()) {
                    System.out.println("(" + (i + 1) + ") " + tasks.get(i));
                }
            }
        }

        public void displayCompletedTasks() {
            for (int i = 0; i < tasks.size(); i++) {
                if (tasks.get(i).isCompleted()) {
                    System.out.println("(" + (i + 1) + ") " + tasks.get(i));
                }
            }
        }


        private boolean taskExists(String taskName) {
            for (Task task : tasks) {
                if (task.getName() == taskName) {
                    return true;
                }
            }
            return false;
        }


        public void addTask(String taskName) {
            if (!taskExists(taskName)) {
                tasks.add(new Task(taskName));
            }
        }

        public void markTaskAsCompletedByNumber(int taskNumber) {
            if (taskNumber > 0 && taskNumber <= tasks.size()) {
                tasks.get(taskNumber - 1).markAsCompleted();
            }
        }

        public void markTaskAsCompletedByName(String taskName) {
            for (Task task : tasks) {
                if (task.getName() == taskName) {
                    task.markAsCompleted();
                    break;
                }
            }
        }

        public int getTaskNumberByName(String taskName) {
            for (int i = 0; i < tasks.size(); i++) {
                if (tasks.get(i).getName() == taskName) {
                    return i + 1;
                }
            }
            return -1; // Если задача не найдена
        }

        public void removeTaskByNumber(int taskNumber) {
            if (taskNumber > 0 && taskNumber <= tasks.size()) {
                tasks.remove(taskNumber - 1);
            }
        }

        public void removeTaskByName(String taskName) {
            tasks.removeIf(task -> task.getName() == taskName);
        }

        public int getTotalTaskCount() {
            return tasks.size();
        }

        public int getCompletedTaskCount() {
            int count = 0;
            for (Task task : tasks) {
                if (task.isCompleted()) {
                    count++;
                }
            }
            return count;
        }

        public int getNotCompletedTaskCount() {
            return getTotalTaskCount() - getCompletedTaskCount();
        }

        public double calculateCompletionPercentage() {
            int total = getTotalTaskCount();
            if (total == 0) {
                return 0.0;
            }
            return (getCompletedTaskCount() / (double) total) * 100;
        }

        public void displayTaskStatistics() {
            int total = getTotalTaskCount();
            int completed = getCompletedTaskCount();
            int not_completed = getNotCompletedTaskCount();
            double completionPercentage = calculateCompletionPercentage();

            System.out.println("Всего дел: " + total + ", Выполненных: " + completed + ", Невыполненных: " + not_completed +
                    ", Процент выполнения: " + String.format("%.2f", completionPercentage) + "%");
        }
    }


    public class TaskManager {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            TaskList taskList = new TaskList("Мой список дел");
            System.out.println("Введите задачи (введите 'exit' для завершения ввода):");
            while (true) {
                String taskName = scanner.nextLine();
                if (taskName.equalsIgnoreCase("exit")) {
                    break;
                }
                taskList.addTask(taskName);
            }

            System.out.println("Введите номера выполненных задач (введите 'exit' для завершения ввода):");
            while (true) {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("exit"))
                    break;
                else {
                    int taskNumber = Integer.parseInt(input);
                    taskList.markTaskAsCompletedByNumber(taskNumber);
                }
            }

                System.out.println("Полный список дел:");
                taskList.displayTaskList();

                System.out.println("\nСтатистика по делам:");
                taskList.displayTaskStatistics();

                System.out.println("\nСписок невыполненных дел:");
                taskList.displayNotCompletedTasks();

                System.out.println("\nСписок выполненных дел:");
                taskList.displayCompletedTasks();
            }
        }

'''
