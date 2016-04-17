package org.luksze;

public class SimpleJavaObject {
    private boolean actionPerformed;

    public void actionPerformed() {
        actionPerformed = true;
    }

    public boolean operationIsSuccessful() {
        return actionPerformed;
    }
}
