public class App {
    private Deck myFlashcard;
    private Printer printer = new Printer();

    /**
     * Where the program begins
     */
    public void start() {
        boolean replay = true;
        while (replay){
            startMessage();
            boolean read = false;
            while (!read){
                myFlashcard = readFlashcard(pickFlashcard());
                if (myFlashcard.getNumWords() > 0) read = true;
            }
            doFlashcards();
            replay = replay();
        }
    }

    public void startMessage() {
        printer.output("");
        printer.output("Welcome to Flash Cards!");
        printer.output("Please follow the instructions below to begin your study session.");
        printer.output("If at any point you want to end your study session, please type “End study”");
        printer.output("");
        printer.output("Please pick a subject to study");
        printer.output("(Please type the name of the subject as listed below)");
        printer.output("1. Econ");
        printer.output("2. Bio");
    }

    public String pickFlashcard() {
        String m = printer.input().toLowerCase() + ".txt";
        return m;
    }

    public Deck readFlashcard(String filename) {
        Deck m = new Deck();
        String card = "";
            try {
                printer.openFile(filename);
                while (printer.fileHasNextLine()) {
                    card = printer.getNextLine();
                    int i = card.indexOf(" - ");
                    if (i == -1)
                        break;
                    String q = card.substring(0, i);
                    String l = card.substring(i + 3);
                    m.addWord(q);
                    m.addDefinition(l);
                }
            } catch (Exception e) {
                printer.output("");
                printer.output(e.toString());
                printer.output("Please try again - file did not exist");

            }

        return m;
    }

    public int chooseMode() {
        printer.output("");
        printer.output("Select a mode of study");
        printer.output("(Please type the mode of the subject as listed below)");
        printer.output("1. Guess word");
        printer.output("2. Guess definition");
        printer.output("3. Mix");
        printer.output("");
        String answer = printer.input().toLowerCase();
        printer.output("");
        if (answer.equals("guess word")) {
            return 1;
        } else if (answer.equals("guess definition")) {
            return 2;
        } else if (answer.equals("mix")) {
            return 3;
        } else {
            return -1;
        }
    }

    public void doFlashcards() {
        myFlashcard.shuffleDeck();
        int mode = chooseMode();
        while (mode == -1) {
            printer.output("Please select a valid mode");
            mode = chooseMode();
        }  
        if (mode == 1){
            for (int i = 0; i < myFlashcard.getNumDefinitions(); i++) {
                printer.output(myFlashcard.getDefinition(i));
                printer.output("Please press ENTER to reveal the word");
                printer.input();
                printer.output(myFlashcard.getWord(i));
                printer.output("");
            }
        } else if (mode == 2) {
            for (int i = 0; i < myFlashcard.getNumWords(); i++) {
                printer.output(myFlashcard.getWord(i));
                printer.output("Please press ENTER to reveal the definition");
                printer.input();
                printer.output(myFlashcard.getDefinition(i));
                printer.output("");
            }
        } else if (mode == 3){
            for (int i = 0; i < myFlashcard.getNumWords(); i++) {
                int random = (int)(Math.random()*2);
                if (random == 0){
                    printer.output(myFlashcard.getWord(i));
                    printer.output("Please press ENTER to reveal the definition");
                    printer.input();
                    printer.output(myFlashcard.getDefinition(i));
                    printer.output("");
                } else if (random == 1){
                    printer.output(myFlashcard.getDefinition(i));
                    printer.output("Please press ENTER to reveal the word");
                    printer.input();
                    printer.output(myFlashcard.getWord(i));
                    printer.output("");
                }
            }
        }

    }

    public boolean replay(){
        boolean valid = false;
        while (!valid){
            printer.output("");
            printer.output("Would you like to play again?");
            printer.output("(Please type \"Yes\" or \"No\")");
            String replay = printer.input();
            if (replay.toLowerCase().equals("yes")){
                valid = true;
                return true;
            } else if (replay.toLowerCase().equals("no")){
                printer.output("");
                printer.output("Thanks for using Flashcards!");
                valid = true;
                return false;
            } else {
                printer.output("");
                printer.output("Answer not valid");
                valid = false;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        new App().start();
    }
}
