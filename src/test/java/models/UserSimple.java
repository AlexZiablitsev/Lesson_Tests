package models;

import lombok.*;

@Data
@ToString(exclude = "id")
@Builder
public class UserSimple {
    final String firstName;
    String lastName;
    String email;
    boolean isActive;
    int age;
    int id;
    String userName;
    String password;
}
