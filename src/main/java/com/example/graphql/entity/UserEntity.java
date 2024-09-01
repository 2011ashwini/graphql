package com.example.graphql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserEntity {

    private String firstName;
    private String lastName;
    @Id
    private String userId;
    private String loggedInTime;
    private String loggedOutTime;
}
