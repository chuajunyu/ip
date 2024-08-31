package garfield.tasks;

import garfield.exceptions.GarfieldException;

import java.util.ArrayList;

/**
 * The TaskList class represents a list of Tasks.
 * It provides methods to list out all the tasks in a format suitable for users to read,
 * methods to add and delete tasks, and to mark tasks as completed or incomplete.
 */
public class TaskList {

    ArrayList<Task> taskList;

    /**
     * Constructs a new empty TaskList.
     */
    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    /**
     * Constructs a TaskList and populates it with tasks from a specified
     * ArrayList of tasks.
     *
     * @param taskList ArrayList of task.Task objects.
     */
    public TaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    /**
     * Returns a string representation of all tasks in the TaskList,
     * with each task numbered sequentially.
     *
     * @return A string containing the list of tasks, each on a new line.
     */
    public String list() {
        StringBuilder listSummary = new StringBuilder();
        for (int i = 0; i < taskList.size(); i++) {
            listSummary.append((i + 1)).append(". ")
                    .append(taskList.get(i).toString()).append("\n");

        }
        return listSummary.toString();
    }

    /**
     * Returns a string representation of all tasks containing the specified
     * keyword in the TaskList, with each Task numbered sequentially.
     *
     * @return A string containing the list of tasks, each on a new line.
     */
    public String listKeywordTasks(String keyword) {
        int count = 0;
        StringBuilder result = new StringBuilder();
        for (Task task: this.taskList) {
            if (task.hasKeyword(keyword)) {
                count++;
                result.append(count).append(". ")
                        .append(task.toString()).append("\n");
            }
        }
        return result.toString();
    }

    /**
     * Checks if the TaskList is empty.
     *
     * @return {@code true} if the TaskList is empty; {@code false} otherwise.
     */
    public boolean isEmpty() {
        return taskList.isEmpty();
    }

    /**
     * Returns the number of tasks in the TaskList.
     *
     * @return The number of tasks in the TaskList.
     */
    public int size() {
        return taskList.size();
    }

    /**
     * Returns the underlying {@link ArrayList} of tasks.
     *
     * @return The {@link ArrayList} of tasks.
     */
    public ArrayList<Task> getArrayList() {
        return this.taskList;
    }

    /**
     * Adds a new task to the TaskList.
     *
     * @param task The task to be added.
     */
    public void add(Task task) {
        this.taskList.add(task);
    }

    /**
     * Deletes the task at the specified index from the TaskList.
     *
     * @param taskId The 1-based index of the task to be deleted.
     * @return A string representation of the deleted task.
     * @throws GarfieldException If the task at the specified index does not exist.
     */
    public String delete(int taskId) throws GarfieldException {
        Task task = this.get(taskId);
        taskList.remove(task);
        return task.toString();
    }

    /**
     * Marks the task at the specified index as done.
     *
     * @param taskId The 1-based index of the task to be marked as done.
     * @return A string representation of the task after marking it as done.
     * @throws GarfieldException If the task at the specified index does not exist.
     */
    public String mark(int taskId) throws GarfieldException {
        Task task = this.get(taskId);
        task.markAsDone();
        return task.toString();
    }

    /**
     * Marks the task at the specified index as not done.
     *
     * @param taskId The 1-based index of the task to be marked as not done.
     * @return A string representation of the task after marking it as not done.
     * @throws GarfieldException If the task at the specified index does not exist.
     */
    public String unmark(int taskId) throws GarfieldException {
        Task task = this.get(taskId);
        task.markAsUndone();
        return task.toString();
    }

    /**
     * Retrieves the task at the specified index from the TaskList.
     *
     * @param taskId The 1-based index of the task to retrieve.
     * @return The task at the specified index.
     * @throws GarfieldException If the task at the specified index does not exist.
     */
    private Task get(int taskId) throws GarfieldException {
        if (taskId > taskList.size()) {
            throw new GarfieldException("The task doesn't exist!");
        }

        return taskList.get(taskId - 1);
    }
}
