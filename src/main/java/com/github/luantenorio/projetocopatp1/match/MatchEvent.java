package com.github.luantenorio.projetocopatp1.match;

import java.io.Serializable;

public class MatchEvent implements Serializable {
    String id;
    String minute;
    EventType type;
    String description;

    public MatchEvent (String id, String minute, EventType type, String description) {
        this.id = id;
        this.minute = minute;
        this.type = type;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getMinute() {
        return minute;
    }

    public EventType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }


}
