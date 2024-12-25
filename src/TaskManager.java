import java.util.Scanner;
    public class TaskManager {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            TaskList taskList = new TaskList("Мой список дел");
            System.out.println("Введите задачи (введите 'exit' для завершения ввода):");
            while (true) {
                String taskName = scanner.nextLine();
                if (taskName.equalsIgnoreCase("exit"))
                    break;
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

