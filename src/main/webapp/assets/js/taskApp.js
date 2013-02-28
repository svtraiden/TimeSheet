/**
 * Created with IntelliJ IDEA.
 * User: svetoslav
 * Date: 1/14/13
 * Time: 10:07 AM
 * To change this template use File | Settings | File Templates.
 */



$(document).ready(function(){

//    function TimeSheetRecord(record) {
//        var self = this;
//
//        self.record = ko.observable(record);
//    }

    function Task (data) {
        this.taskName = ko.observable(data.taskName);
        this.taskStarted = ko.observable(data.taskStarted);
        this.taskCompleted = ko.observable(data.taskCompleted);
        this.mondayHours = ko.observable(data.mondayHours);
        this.tuesdayHours = ko.observable(data.tuesdayHours);
        this.wednesdayHours = ko.observable(data.wednesdayHours);
        this.thursdayHours = ko.observable(data.thursdayHours);
        this.fridayHours = ko.observable(data.fridayHours);
        this.saturdayHours = ko.observable(data.saturdayHours);
        this.sundayHours = ko.observable(data.sundayHours);
    }

    function TimesheetViewModel(){
        var self = this;
        self.timesheetRecords = ko.observableArray([
//          empty array
        ]);

//        //editable data
//        self.records = ko.observableArray([
//
//        ]);

        $.getJSON("/api/task", function(allData){
            var mappedTasks = allData;
            self.timesheetRecords(mappedTasks);
        });

        //actions
        self.removeTask = function(task) {
            var taskId = self.timesheetRecords.indexOf(task);
            $.getJSON("/api/delete/"+taskId, function(allData){
                var mappedTasks = allData;
                self.timesheetRecords.removeAll();
                self.timesheetRecords(mappedTasks);
            });
            //self.timesheetRecords.remove(task);
        }

        self.addNewTask = function() {
            var task = new Task({taskName: this.taskName, started: this.started,
                                completed: this.completed, mondayHours: this.mondayHours,
                                tuesdayHours: this.tuesdayHours, wednesdayHours: this.wednesdayHours,
                                thursdayHours: this.thursdayHours, fridayHours: this.fridayHours,
                                saturdayHours: this.saturdayHours, sundayHours: this.sundayHours
                            });



            //sending the task object to the server to be added into the db
            //and updating the list if the response is a list with tasks.
            //display an error message of the response is null
            /*$.post('/api/add', task, function(data){
                self.timesheetRecords(data);
            })*/

            console.log(task.taskName);

        }

    }




    ko.applyBindings(new TimesheetViewModel());

});
