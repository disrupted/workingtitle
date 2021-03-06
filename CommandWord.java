/**
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 * <p>
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */

public enum CommandWord {
    GO("go"),

    LOOK("look"),
    
    USE("use"),

    TAKE("take"),
    
    INVENTORY("inventory"),
    
    DROP("drop"),
    
    BACK("back"),

    QUIT("quit"),

    HELP("help"), 

    UNKNOWN("unknown");
    private String word;

    /**
     * Constructor - initialise the command words.
     */
    private CommandWord(String word) {
        this.word = word;
    }

    public static String getCommandWords()
    {
        String output = "";
        for (CommandWord command : CommandWord.values())
        {
            if (command != UNKNOWN) // don't include UNKNOWN in list of valid user commands
            {
                output += command + " ";
            }
        }
        output = output.substring(0, output.length() - 1);
        return output.toLowerCase();
    }

    public String getWord() {
        return word;
    }

    public static CommandWord getForWord(String word){

        for (CommandWord cw : values()) {
            if (cw.getWord().equals(word))
                return cw;
        }
        return UNKNOWN;
    }

    /**
     * Check whether a given String is a valid command word.
     *
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public static boolean isCommand(String aString) {

        for (CommandWord cw : values()) {
            if (cw.getWord().equals(aString))
                return true;
        }

        // if we get here, the string was not found in the commands
        return false;
    }

}
