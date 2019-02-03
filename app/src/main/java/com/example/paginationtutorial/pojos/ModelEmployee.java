package com.example.paginationtutorial.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelEmployee {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("employee_name")
    @Expose
    private String employeeName;

    @SerializedName("employee_salary")
    @Expose
    private String employeeSalary;

    @SerializedName("employee_age")
    @Expose
    private String employeeAge;

    @SerializedName("profile_image")
    @Expose
    private String profileImage;

    public ModelEmployee(String id, String employeeName, String employeeSalary, String employeeAge, String profileImage) {
        setId(id);
        setEmployeeName(employeeName);
        setEmployeeSalary(employeeSalary);
        setEmployeeAge(employeeAge);
        setProfileImage(profileImage);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(String employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(String employeeAge) {
        this.employeeAge = employeeAge;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
}
