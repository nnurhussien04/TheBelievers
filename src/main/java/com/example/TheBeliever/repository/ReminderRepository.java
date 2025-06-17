package com.example.TheBeliever.repository;

import com.example.TheBeliever.model.Reminder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReminderRepository extends CrudRepository<Reminder,Long> {

}
