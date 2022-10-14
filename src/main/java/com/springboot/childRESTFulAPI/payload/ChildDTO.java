package com.springboot.childRESTFulAPI.payload;

import com.springboot.childRESTFulAPI.model.MaritalStatus;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class ChildDTO {

    private long id;

    // name should not be null  or empty
    // name should have at least 2 characters
    @NotEmpty
    @Size(min = 3, message = "child name should have at least 3 characters")
    private String name;
    @NotEmpty
    private String placeOfBirth;
    @NotEmpty
    private int registrationNumber;
    @NotEmpty
    private Date dateOfBirth;
    @NotEmpty
    private String gender;
    @NotEmpty
    private int weight;
    @NotEmpty
    private String mothersName;
    @NotEmpty
    private int ageOfMother;
    @NotEmpty
    private String occupation;
    @NotEmpty
    private MaritalStatus maritalStatus;
}
