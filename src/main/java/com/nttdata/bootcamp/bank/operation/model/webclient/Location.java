package com.nttdata.bootcamp.bank.operation.model.webclient;

public class Location {

    private String id;
    private String codeLocation;
    private String name;
    private String description;

    private String state;
    private String codeLocationType;
    private String codeUbigeo;
    private String codeEmployee;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodeLocation() {
        return codeLocation;
    }

    public void setCodeLocation(String codeLocation) {
        this.codeLocation = codeLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCodeLocationType() {
        return codeLocationType;
    }

    public void setCodeLocationType(String codeLocationType) {
        this.codeLocationType = codeLocationType;
    }

    public String getCodeUbigeo() {
        return codeUbigeo;
    }

    public void setCodeUbigeo(String codeUbigeo) {
        this.codeUbigeo = codeUbigeo;
    }

    public String getCodeEmployee() {
        return codeEmployee;
    }

    public void setCodeEmployee(String codeEmployee) {
        this.codeEmployee = codeEmployee;
    }
}
