package com.example.TheBeliever.controller;

import com.example.TheBeliever.model.Reminder;
import com.example.TheBeliever.service.TheBelieverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/TheBeliever")
public class TheBelieverController {

    @Autowired
    TheBelieverService theBelieverService;

    @GetMapping("prayer_times")
    public ResponseEntity<?> getPrayerTimes(){
        return new ResponseEntity<>(theBelieverService.getPrayerTimes(), HttpStatus.OK);
    }

    @GetMapping("reminder")
    public ResponseEntity<?> getReminders(){
        return new ResponseEntity<>(theBelieverService.getAllReminders(),HttpStatus.OK);
    }

    @PostMapping("reminder")
    public ResponseEntity<?> addReminders(@RequestBody Reminder reminder){
        return new ResponseEntity<>(theBelieverService.addReminders(reminder),HttpStatus.CREATED);
    }

    @GetMapping("quran")
    public ResponseEntity<?> chapterQuran(){
        return new ResponseEntity<>(theBelieverService.getQuranAPI(),HttpStatus.OK);
    }

    @GetMapping("prayer_times/{date}")
    public ResponseEntity<?> chapterQuran(@PathVariable String date){
        return new ResponseEntity<>(theBelieverService.getPrayerTimes(date),HttpStatus.OK);
    }









}
