package com.github.luantenorio.projetocopatp1.util;

import javafx.scene.control.TextField;

public class TimeTextField extends TextField {
    @Override
    public void replaceText(int start, int end, String text) {
        if (start > 4 || !validate(text)) return;
        super.replaceText(start, end, text);
    }

    // checa se o novo horario pode ser inserido
    protected static boolean validate(String text){
        return text.matches("[0-9|:]*");
    }

    public boolean isValid(){
        String text = this.getText();
        if (text == null) return false;
        if (text.isBlank()) return false;

        String[] time = text.split(":");
        if (time.length != 2) return false;

        int hours, minutes;
        try{
            hours = Integer.parseInt(time[0]);
            minutes = Integer.parseInt(time[1]);
        } catch (Exception e) {
            return false;
        }

        return (hours < 24 && hours >= 0) && (minutes < 60 && minutes >= 0);
    }

    public int getHour(){
        if (!this.isValid()) return 0;
        try{
            return Integer.parseInt(this.getText().split(":")[0]);
        } catch (Exception ignored){
            return 0;
        }
    }

    public int getMinute(){
        if (!this.isValid()) return 0;
        try{
            return Integer.parseInt(this.getText().split(":")[1]);
        } catch (Exception ignored){
            return 0;
        }
    }
}
