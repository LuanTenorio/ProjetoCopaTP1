package com.github.luantenorio.projetocopatp1.util;

import javafx.scene.control.TextField;

public class TimeTextField extends TextField {
    @Override
    public void replaceText(int start, int end, String text) {
        if ((text.length() > (end - start) && this.getText().length() >= 5) || !validate(text)) return;
        super.replaceText(start, end, text);
    }

    // checa se o novo horario pode ser inserido
    protected static boolean validate(String text){
        return text.matches("[0-9|:]*");
    }

    public boolean isInvalid(){
        String text = this.getText();
        if (text == null) return true;
        if (text.isBlank()) return true;

        String[] time = text.split(":");
        if (time.length != 2) return true;

        int hours, minutes;
        try{
            hours = Integer.parseInt(time[0]);
            minutes = Integer.parseInt(time[1]);
        } catch (Exception e) {
            return true;
        }

        return (hours >= 24 || hours < 0) || (minutes >= 60 || minutes < 0);
    }

    public int getHour(){
        if (this.isInvalid()) return 0;
        try{
            return Integer.parseInt(this.getText().split(":")[0]);
        } catch (Exception ignored){
            return 0;
        }
    }

    public int getMinute(){
        if (this.isInvalid()) return 0;
        try{
            return Integer.parseInt(this.getText().split(":")[1]);
        } catch (Exception ignored){
            return 0;
        }
    }
}
