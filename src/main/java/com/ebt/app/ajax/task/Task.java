package com.ebt.app.ajax.task;

import org.springframework.core.style.ToStringCreator;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: svetoslav
 * Date: 1/9/13
 * Time: 12:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class Task {
    private String taskId;
    private String taskName;
    private Date started;
    private Date completed;
    private int mondayHours;
    private int tuesdayHours;
    private int wednesdayHours;
    private int thursdayHours;
    private int fridayHours;
    private int saturdayHours;
    private int sundayHours;

    public Task(String name) {
        taskId = null;
        taskName=name;
        started = new Date();
        completed = new Date();
        mondayHours = 0;
        tuesdayHours = 0;
        wednesdayHours = 0;
        thursdayHours = 0;
        fridayHours = 0;
        saturdayHours = 0;
        sundayHours = 0;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getStarted() {
        return started;
    }

    public void setStarted(Date started) {
        this.started = started;
    }

    public Date getCompleted() {
        return completed;
    }

    public void setCompleted(Date completed) {
        this.completed = completed;
    }

    public int getMondayHours() {
        return mondayHours;
    }

    public void setMondayHours(int mondayHours) {
        this.mondayHours = mondayHours;
    }

    public int getTuesdayHours() {
        return tuesdayHours;
    }

    public void setTuesdayHours(int tuesdayHours) {
        this.tuesdayHours = tuesdayHours;
    }

    public int getWednesdayHours() {
        return wednesdayHours;
    }

    public void setWednesdayHours(int wednesdayHours) {
        this.wednesdayHours = wednesdayHours;
    }

    public int getThursdayHours() {
        return thursdayHours;
    }

    public void setThursdayHours(int thursdayHours) {
        this.thursdayHours = thursdayHours;
    }

    public int getFridayHours() {
        return fridayHours;
    }

    public void setFridayHours(int fridayHours) {
        this.fridayHours = fridayHours;
    }

    public int getSaturdayHours() {
        return saturdayHours;
    }

    public void setSaturdayHours(int saturdayHours) {
        this.saturdayHours = saturdayHours;
    }

    public int getSundayHours() {
        return sundayHours;
    }

    public void setSundayHours(int sundayHours) {
        this.sundayHours = sundayHours;
    }

    public int getTotalWeekHours() {

        return getMondayHours()+getTuesdayHours()+getWednesdayHours()+getThursdayHours()+
                getFridayHours()+getSaturdayHours()+getSundayHours();

    }

    public String toString() {
        return new ToStringCreator(this).append("Task: \""+getTaskName()+"\", Started: \""+ getStarted()+
                "\", Completed: \""+getCompleted()+"\", Mon: \""+getMondayHours()+"\", Tue: \""+getTuesdayHours()+
                "\", Wed: \""+getWednesdayHours()+"\", Thu: \""+getThursdayHours()+"\", Fri: \""+getFridayHours()+
                "\", Sat: \""+getSundayHours()+"\", Sun: \""+getSundayHours()).toString();
    }

}
