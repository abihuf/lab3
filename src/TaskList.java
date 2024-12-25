import java.util.ArrayList;
import java.util.List;

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


