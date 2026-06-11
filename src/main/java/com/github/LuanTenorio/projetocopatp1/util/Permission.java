package com.github.luantenorio.projetocopatp1.util;

import com.github.luantenorio.projetocopatp1.users.UserSession;
import com.github.luantenorio.projetocopatp1.users.UserEntity;
import com.github.luantenorio.projetocopatp1.users.AdminEntity;
import com.github.luantenorio.projetocopatp1.users.OrganizerEntity;
import javafx.scene.Node;

public class Permission {

    public static void restrictToManagement(Node... nodes) {
        boolean hasAccess = hasManagementAccess();

        for (Node node : nodes) {
            if (node != null) {
                node.setVisible(hasAccess);
                node.setManaged(hasAccess);
            }
        }
    }


    public static boolean hasManagementAccess() {
        UserSession session = UserSession.getInstance();
        if (!session.isLoggedIn()) {
            return false;
        }

        UserEntity loggedUser = session.getLoggedUser();


        return loggedUser instanceof AdminEntity || loggedUser instanceof OrganizerEntity;
    }
}