package com.ebt.app.ajax.datasource;

import com.ebt.app.ajax.task.Task;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: svetoslav
 * Date: 1/24/13
 * Time: 2:27 PM
 * To change this template use File | Settings | File Templates.
 */
public interface TaskDAO {
    public void insert(Task task);
    public void update(int pk, Task task);
    public void delete (int pk);
    public ArrayList<Task> tasks ();
    public Task findById (int pk);

}
