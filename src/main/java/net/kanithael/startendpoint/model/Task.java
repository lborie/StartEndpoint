package net.kanithael.startendpoint.model;

import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: kanithael
 * Date: 16/06/13
 * Time: 10:19
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Cache
public class Task {
    @Id
    private Long id;

    private String name;
    private String content;
    private Date deadLine;

    private Task(){}

    public Task(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }
}
