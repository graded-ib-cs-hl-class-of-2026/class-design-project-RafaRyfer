public class App {
    private Deck myFlashcard;
    private Printer printer = new Printer();

    /**
     * Where the program begins
     */
    public void start(){
        startMessage();
        myFlashcard = readFlashcard(pickFlashcard());

        doFlashcards();
    }

    public void startMessage(){
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

    public String pickFlashcard(){
        String m = printer.input().toLowerCase() + ".txt";
        return m;                        
    }

    public Deck readFlashcard(String filename){
        Deck m = new Deck();
        String card = "";
        try {
            printer.openFile(filename);
            while (printer.fileHasNextLine()){
                card = printer.getNextLine();
                int i = card.indexOf(" - ");
                if (i == -1) break;
                String q = card.substring(0, i);
                String l = card.substring(i+3);
                m.addWord(q);
                m.addDefinition(l);
            }
            
        } catch (Exception e) {
            printer.output(e.toString());
        }
        
        return m;
    }
 
    public int chooseMode(){
        int n = 0;
        printer.output("Select a mode of study");
        printer.output("(Please type the mode of the subject as listed below)");
        printer.output("1. Guess word"); 
        printer.output("2. Guess definition"); 
        printer.output("3. Mix");
        String answer = printer.input();
        if (answer.equals("Guess word")){
            
        }
        return n;
    }

    public void doFlashcards(){
        for (int i = 0; i < myFlashcard.getNumDefinitions(); i++){
            printer.output(myFlashcard.getDefinition(i));
        }
    }
    public static void main(String[] args) throws Exception {
       new App().start();
    }
}
