package com.example.shell.outpatienthealthcare.model;

import java.io.Serializable;


    public class User implements Serializable {

        private int userId;
        private String email;
        private String name;
        private String password;
        private String phoneNumber;
        private int age;
        private float weight;
        private float height;
        private String gender;

        public int getUserId() {
        return userId;
    }
        public void setUserId(int userId) {
        this.userId = userId;
    }
        public String getEmail() {
        return email;
    }
        public void setEmail(String email) {
        this.email = email;
    }
        public String getName() {
        return name;
    }
        public void setName(String name) {
        this.name = name;
    }
        public String getPassword() {
        return password;
    }
        public void setPassword(String password) {
        this.password = password;
    }
        public String getPhoneNumber() {
        return phoneNumber;
    }
        public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
        public int getAge() {
        return age;
    }
        public void setAge(int age) {
        this.age = age;
    }

        public float getWeight() {
        return weight;
    }
        public void setWeight(float weight) {
        this.weight = weight;
    }
        public float getHeight() {
        return height;
    }
        public void setHeight(float height) {
        this.height = height;
    }

        public String getGender() {
        return gender;
    }
        public void setGender(String gender) {
        this.gender = gender;
    }

    }


