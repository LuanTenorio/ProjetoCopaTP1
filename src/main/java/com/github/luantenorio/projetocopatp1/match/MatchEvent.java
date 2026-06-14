package com.github.luantenorio.projetocopatp1.match;

import java.io.Serializable;

public record MatchEvent(String id, String minute, EventType type, String description) implements Serializable{}
