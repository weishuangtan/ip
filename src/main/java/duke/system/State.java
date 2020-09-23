package duke.system;

/**
 * Stores the different running states of the chat bot
 */
public class State {

    protected boolean isRunning;

    public State () {
        isRunning = true;
    }

    /**
     * Returns the running state of the chat bot
     *
     * @return true or false value on running state
     */
    public boolean getState () {
        return isRunning;
    }

    /**
     * Changes the running state of the chat bot
     */
    public void exit(){
        isRunning = false;
    }
}
