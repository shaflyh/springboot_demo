package com.hand.train.po;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Student {
    private Long stuId;
    private String stuName;
    private String sex;
    private Date birthdate;
}
