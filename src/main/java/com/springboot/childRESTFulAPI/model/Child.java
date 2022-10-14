
 /*
  * Author     : birichani.code
  * Date         : 14/10/22  16:41
  * Project Name : childrenRESTfulAPI
  * */


 package com.springboot.childRESTFulAPI.model;

 import lombok.AllArgsConstructor;
 import lombok.Getter;
 import lombok.NoArgsConstructor;
 import lombok.Setter;

 import javax.persistence.*;
 import java.util.Date;

 @Getter
 @Setter
 @AllArgsConstructor

 @Entity
 @Table(
         name = "child", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})}
 )

 public class Child {

  @Id
  @GeneratedValue(
          strategy = GenerationType.IDENTITY
  )
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;
  @Column(name = "placeOfBirth", nullable = false)
  private String placeOfBirth;
  @Column(name = "registrationNumber", nullable = false)
  private int registrationNumber;
  @Column(name = "dateOfBirth", nullable = false)
  private Date dateOfBirth;
  @Column(name = "gender", nullable = false)
  private String gender;
  @Column(name = "weight", nullable = false)
  private int weight;
  @Column(name = "mothersName", nullable = false)
  private String mothersName;
  @Column(name = "ageOfMother", nullable = false)
  private int ageOfMother;
  @Column(name = "occupation", nullable = false)
  private String occupation;


  private MaritalStatus maritalStatus;

  public Child() {
  }
 }
