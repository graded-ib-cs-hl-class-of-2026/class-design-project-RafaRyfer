import java.util.Scanner;
import java.io.*;

public class Printer {

    Scanner in = new Scanner(System.in);
    private Scanner fileInput;
    private File file;

    /**
     * Opens a text file.
     * @param filename
     * @throws FileNotFoundException
     */
    public void openFile (String filename) throws FileNotFoundException{
        file = new File(filename);
        fileInput = new Scanner(file);
    }

    /**
     * Closes a text file.
     */
    public void closeFile() {
        fileInput.close();
        file = null;
        fileInput = null;
    }


    /**
     * Checks if the text file has a next line.
     * @return boolean stating if the file has a next line
     */
    public boolean fileHasNextLine() {
        if (fileInput == null) {
            return false;
        }else {
            return fileInput.hasNextLine();
        }
    }

    /**
     * Given that the text file has another line. This method returns that line.
     * @return Next line in the file as a String
     */
    public String getNextLine() {
        if (fileHasNextLine()){
            return fileInput.nextLine();
        }else {
            return "";
        }
    }
    
    /**
     * Prints a string to the console
     * @param s
     */
    public void output(String s){
        System.out.println(s);
    }

    /**
     * Saves user input into a string. If the user inputs "end study", the program closes.
     * @return User input as a string
     */
    public String input(){
        String m = in.nextLine();
        if (m.toLowerCase().equals("end study")){
            output("");
            output("Thanks for using Flashcards!");
            System.exit(0);
        }
        return m;
    }

}
