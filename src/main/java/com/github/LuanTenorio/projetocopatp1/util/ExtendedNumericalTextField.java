package com.github.luantenorio.projetocopatp1.util;

import javafx.scene.control.TextField;

public class ExtendedNumericalTextField extends TextField {
    @Override
    public void replaceText(int start, int end, String text) {
        if (validate(text)) super.replaceText(start, end, text);
    }

    // checa se conforma pode ser inserido
    protected static boolean validate(String text){
        return text.matches("[0-9|:\\-+'.]*");
    }
}
