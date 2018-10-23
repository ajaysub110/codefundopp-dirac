package com.example.ajays.dirac.Choice;

import java.io.Serializable;

public class ChoiceModel implements Serializable {
    String description;
    String choice_name;

    public ChoiceModel(){}

    public ChoiceModel(String choice_name,String description){
        this.choice_name = choice_name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getChoice_name() {
        return choice_name;
    }

    public void setChoice_name(String choice_name) {
        this.choice_name = choice_name;
    }
}
