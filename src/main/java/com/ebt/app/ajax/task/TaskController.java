package com.ebt.app.ajax.task;

import com.ebt.app.ajax.datasource.TaskDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


/**
 * Created with IntelliJ IDEA.
 * User: svetoslav
 * Date: 1/9/13
 * Time: 12:30 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/", method = RequestMethod.GET)
public class TaskController {

    //private List<Task> taskList = null;
    private Task task;
    private ArrayList<Task> taskList = new ArrayList<Task>(){{add(new Task("Task 01")); add(new Task("Task 02"));
        add(new Task("Task 03"));
        add(new Task("Task 04")); add(new Task("Task 05"));}};




    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        //System.out.println("test");
        return "index";
    }

//    @RequestMapping(method = RequestMethod.POST)
//    public Task CreateTask() {
//        //TODO: creating tasks from JSON...
//        task = new Task();
//
//        return task;
//    }

    @RequestMapping(value = "task", method = RequestMethod.POST)
    public @ResponseBody ArrayList<Task> task() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("/taskconfig.xml");
        TaskDAO taskDAO = (TaskDAO)ctx.getBean("taskDAO");

        for (Task curTask : taskList) {
            Task task = new Task(curTask.getTaskName());

            taskDAO.insert(task);
        }

        return taskList;
    }

    @RequestMapping(value = "task/{id}",method = RequestMethod.GET)
    public @ResponseBody Task GetTask(@PathVariable int id) {



        return task;
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public @ResponseBody ArrayList<Task> DeleteTask (@PathVariable int id) {
        taskList.remove((int)id);
        return taskList;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody ArrayList<Task> addTask(@RequestBody Task task) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/taskconfig.xml");
        TaskDAO taskDAO = (TaskDAO) context.getBean("taskDAO");
        /*
        need to grab the object from json request and add it to the db, then return the updated list
        or to handle a db connection exception.
         */
        //add the task to the DB
        taskDAO.insert(task);
        //read all tasks from the DB
        ArrayList<Task> tasksList = taskDAO.tasks();



        return tasksList;
    }

}
