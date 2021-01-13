package org.ut.rmes.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.ut.rmes.entity.Remind;
import org.ut.rmes.service.ReminderService;

import java.util.*;

@RestController
public class RemindController {

    @Autowired
    private ReminderService service;

    @RequestMapping(value = "/reminders", method = RequestMethod.GET)
    public @ResponseBody
    List<Remind> getAllReminders() {
        return service.getAll();
    }

    @RequestMapping(value = "/reminder/get", method = RequestMethod.GET)
    @ResponseBody
    public Remind getRemind() {
        Remind remind = new Remind();
        remind.setId(1);
        remind.setRemindDate(new Date());
        remind.setTitle("My First remind");
        return remind;
    }

    @RequestMapping(value = "/reminder/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Remind getReminder(@PathVariable("id") long remindID) {
        return service.getByID(remindID);
    }

    @RequestMapping(value = "/reminders", method = RequestMethod.POST)
    public @ResponseBody
    Remind setReminder(@RequestBody Remind remind) {
        System.out.println("reminder Object: " + remind);
        return service.save(remind);
    }

    @RequestMapping(value = "/reminder/{id}", method = RequestMethod.PATCH)
    public @ResponseBody
    Remind setReminder(@PathVariable("id") long remindID, @RequestBody Remind remind) {
        remind.setId(remindID);
        return service.save(remind);
    }

    @RequestMapping(value = "/reminders/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Map delete(@PathVariable long id) {
        Map<String, String> o = new HashMap<>();
        try {
            service.remove(id);
            o.put("code", "200");
            o.put("message", "success");
        } catch (Exception exception) {
            o.put("code", "400");
            o.put("message", exception.getMessage());
        }
        return Collections.singletonMap("response", o);
    }
}
