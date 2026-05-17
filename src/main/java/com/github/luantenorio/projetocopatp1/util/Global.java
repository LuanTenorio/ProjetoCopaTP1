package com.github.luantenorio.projetocopatp1.util;

import com.github.luantenorio.projetocopatp1.users.AccessLevel;

public class Global {
    private static AccessLevel accessLevel = AccessLevel.ADMIN;


    public static AccessLevel getAccessLevel() {
        return accessLevel;
    }

    public static void setAccessLevel(AccessLevel access) {
        accessLevel = access;
    }
}
