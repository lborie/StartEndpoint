package net.kanithael.startendpoint.api;


import net.kanithael.startendpoint.model.Task;

import java.util.List;

/**
 * Task API
 * List of methods called by Endpoints
 */
public interface TaskAPI {

    /**
     * Insert a task in the datastore
     * Synchronous
     * @param task to insert
     * @return task valuated with an ID
     */
    public Task insertTask(Task task);

    /**
     * List the tasks in Datastore
     * @return list of tasks
     */
    public List<Task> listTasks();

    /**
     * Delete a task in the datastore
     * @param id the id to delete
     */
    public void deleteTask(String id);
}
