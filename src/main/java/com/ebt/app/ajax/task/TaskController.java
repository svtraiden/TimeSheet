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
    private Task task = null;
    private ArrayList<Task> taskList = null;


    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    /**
     * Returns the list with all tasks from the DB
     * @return taskList
     */
    @RequestMapping(value = "task", method = RequestMethod.POST)
    public @ResponseBody ArrayList<Task> task() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("/taskconfig.xml");
        TaskDAO taskDAO = (TaskDAO)ctx.getBean("taskDAO");
        taskList = taskDAO.tasks();
        return taskList;
    }

    /**
     * This method returns only a single task
     * @param id
     * @return
     */
    @RequestMapping(value = "task/{id}",method = RequestMethod.GET)
    public @ResponseBody Task GetTask(@PathVariable int id) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/taskconfig.xml");
        TaskDAO taskDAO = (TaskDAO)ctx.getBean("taskDAO");
        task = taskDAO.findById(id);
        return task;
    }

    /**
     * Deletes a specific task from the database and returns the updated tasks list
     * @param id
     * @return
     */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public @ResponseBody ArrayList<Task> DeleteTask (@PathVariable int id) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/taskconfig.xml");
        TaskDAO taskDAO = (TaskDAO)ctx.getBean("taskDAO");
        taskDAO.delete(id);
        taskList=taskDAO.tasks();
        return taskList;
    }

    /**
     * Adds new task to the Database and returns the updated tasks list
     * @param task
     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody ArrayList<Task> addTask(@RequestBody Task task) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/taskconfig.xml");
        TaskDAO taskDAO = (TaskDAO) context.getBean("taskDAO");
        //add the task to the DB
        taskDAO.insert(task);
        //read all tasks from the DB
        taskList = taskDAO.tasks();
        return taskList;
    }

    /**
     * Updates a specific task with new data from the web form
     * @param task
     * @param id
     * @return
     */
    @RequestMapping(value = "update/{id}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody ArrayList<Task> updateTask(@RequestBody Task task, @PathVariable int id) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/taskconfig.xml");
        TaskDAO taskDAO = (TaskDAO) context.getBean("taskDAO");
        taskDAO.update(id, task);
        taskList = taskDAO.tasks();
        return taskList;
    }

}
