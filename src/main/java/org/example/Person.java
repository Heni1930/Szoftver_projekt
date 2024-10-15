

package org.example;

public class Person {
    private String username;
    private String password;
    private int neptunId;
    private String name;
    private Faculties faculty;

    public Person(String username, String password, int neptunId, String name, Faculties faculty) {
        this.username = username;
        this.password = password;
        this.neptunId = neptunId;
        this.name = name;
        this.faculty = faculty;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNeptunId() {
        return neptunId;
    }

    public void setNeptunId(int neptunId) {
        this.neptunId = neptunId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Faculties getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculties faculty) {
        this.faculty = faculty;
    }
}

