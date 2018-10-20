package com.example.ajays.dirac.Choice;

import java.io.Serializable;

public class ChoiceModel implements Serializable {
    String time_of_last;
    String text_of_last;
    String choice_name;

    public ChoiceModel(){}

    public ChoiceModel(String choice_name,String time_of_last, String text_of_last){
        this.choice_name = choice_name;
        this.time_of_last = time_of_last;
        this.text_of_last = text_of_last;
    }

    public String getChoice_name() {
        return choice_name;
    }

    public void setChoice_name(String choice_name) {
        this.choice_name = choice_name;
    }

    public String getTime_of_last() {
        return time_of_last;
    }

    public void setTime_of_last(String time_of_last) {
        this.time_of_last = time_of_last;
    }

    public String getText_of_last() {
        return text_of_last;
    }

    public void setText_of_last(String text_of_last) {
        this.text_of_last = text_of_last;
    }
}
