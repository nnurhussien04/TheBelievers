package com.example.TheBeliever.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reminder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String reminder;
}
