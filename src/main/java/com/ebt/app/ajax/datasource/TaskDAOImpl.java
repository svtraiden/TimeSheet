package com.ebt.app.ajax.datasource;

import com.ebt.app.ajax.task.Task;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: svetoslav
 * Date: 1/24/13
 * Time: 2:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class TaskDAOImpl implements TaskDAO {

    private JdbcTemplate jdbcTemplate;


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    public void insert(Task task) {
        String sql = "insert into timesheetRecords (task, started, completed, mon, tue, wed, thu, fri, sat, sun) " +
                "values (?,?,?,?,?,?,?,?,?,?)";
        Object[] taskParams = new Object[]{task.getTaskName(), task.getStarted(), task.getCompleted(),
                        task.getMondayHours(), task.getTuesdayHours(), task.getWednesdayHours(),
                        task.getThursdayHours(), task.getFridayHours(), task.getSaturdayHours(),
                        task.getSundayHours()};

        this.getJdbcTemplate().update(sql, taskParams);

        System.out.println("The Task was successfully Created... ");

    }

    public void update(int pk, Task task) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void delete(int pk) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public ArrayList<Task> tasks() {



        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Task findById(int pk) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
