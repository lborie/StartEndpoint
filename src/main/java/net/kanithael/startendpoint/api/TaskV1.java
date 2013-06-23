package net.kanithael.startendpoint.api;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import net.kanithael.startendpoint.dao.GenericDao;
import net.kanithael.startendpoint.model.Task;

import javax.inject.Named;
import java.util.List;

/**
 * Api to manage a Task list
 */
@Api(
        name = "task",
        version = "v1"
)
public class TaskV1 {

    private static final GenericDao<Task> taskDao = new GenericDao<Task>(Task.class);

    @ApiMethod(
            name = "task.list",
            path = "tasks",
            httpMethod = HttpMethod.GET
    )
    public List<Task> listTasks(){
        return taskDao.getEntities();
    }

    @ApiMethod(
            name = "task.insert",
            path = "insert",
            httpMethod = HttpMethod.POST
    )
    public Task insertTask(Task task){
        taskDao.insertEntity(task);
        return task;
    }

    @ApiMethod(
            name = "task.delete",
            path = "delete/{id}",
            httpMethod = HttpMethod.DELETE
    )
    public void deleteTask(@Named("id") String id){
        taskDao.deleteEntity(Long.valueOf(id));
    }
}
