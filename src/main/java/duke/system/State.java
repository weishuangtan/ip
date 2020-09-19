package duke.system;

/** Different states for the chat bot */
public class State {

    protected boolean isRunning;

    public State () {
        isRunning = true;
    }

    public boolean getState () {
        return isRunning;
    }

    public void exit(){
        isRunning = false;
    }
}
