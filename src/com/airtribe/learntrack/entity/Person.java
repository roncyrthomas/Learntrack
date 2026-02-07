    package com.airtribe.learntrack.entity;

    public abstract class Person {
        protected final int id;
        protected String firstName;
        protected String lastName;
        protected String email;

        public Person(int id, String firstName, String lastName, String email) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        }

        public final int getId(){return id;}
        public String getFirstName(){return firstName;}
        public String getLastName(){return lastName;}
        public String getEmail(){return email;}

        public void setFirstName(String firstName) {
            if (firstName == null || firstName.isBlank()) {
                throw new IllegalArgumentException("First name cannot be empty");
            }
            this.firstName = firstName;
        }
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
        public void setEmail(String email) {
                if (email == null || !email.contains("@")) {
                    throw new IllegalArgumentException("Email is invalid");
                }
                this.email = email;
        }

        public String getDisplayName() {
            String fn = firstName != null ? firstName : "";
            String ln = lastName != null ? lastName : "";
            return fn + " " + ln;
        }

    }
