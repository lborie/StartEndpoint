package net.kanithael.startendpoint.api;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import junit.framework.Assert;
import net.kanithael.startendpoint.api.impl.TaskV1;
import net.kanithael.startendpoint.model.Task;
import org.junit.*;

import java.util.List;

/**
 * Testing the API class
 */
public class TaskV1Test {

    private final static LocalServiceTestHelper helper =
            new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

    private final static TaskAPI taskAPI = new TaskV1();

    @Before
    public void setUp() {
        helper.setUp();
    }

    @After
    public void tearDown() {
        helper.tearDown();
    }

    @Test
    public void testInsertTask() throws Exception {
        final Task taskInserted = insertTaskByDefault();
        Assert.assertNotNull(taskInserted.getId());
    }

    @Test
    public void testListTasks() throws Exception {
        insertTaskByDefault();
        List<Task> tasks = taskAPI.listTasks();
        Assert.assertEquals(1, tasks.size());
    }

    @Test
    public void testDeleteTask() throws Exception {
        insertTaskByDefault();
        List<Task> tasks = taskAPI.listTasks();
        Assert.assertEquals(1, tasks.size());
        Task firstTask = tasks.get(0);
        taskAPI.deleteTask(firstTask.getId().toString());
        Thread.sleep(300);
        Assert.assertEquals(0, taskAPI.listTasks().size());
    }

    private Task insertTaskByDefault() throws Exception {
        return taskAPI.insertTask(new Task("task 1"));
    }
}
