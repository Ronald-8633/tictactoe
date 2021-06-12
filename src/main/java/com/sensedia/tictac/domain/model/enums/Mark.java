package com.sensedia.tictac.domain.model.enums;

public enum Mark {
    X,
    Y;

    public static boolean contains(String value) {

        for (Mark mark : Mark.values()) {
            if (mark.name().equals(value)) {
                return true;
            }
        }

        return false;
    }
}
