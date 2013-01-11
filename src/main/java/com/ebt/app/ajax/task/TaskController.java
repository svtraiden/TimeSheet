package com.ebt.app.ajax.task;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: svetoslav
 * Date: 1/9/13
 * Time: 12:30 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/task")
public class TaskController {

    //private List<Task> taskList = null;
    private Task task;

    @RequestMapping(method = RequestMethod.POST)
    public Task CreateTask() {

        task = new Task();

        return task;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/task")
    public @ResponseBody List<Task> GetTasksList() {

        List<Task> taskList = null;

        return taskList;
    }

    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public @ResponseBody Task GetTask(@PathVariable int id) {

        Task task = null;

        return task;
    }


}
