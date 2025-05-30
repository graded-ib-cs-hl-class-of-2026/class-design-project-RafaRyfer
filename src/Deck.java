public class Deck {
    private String[] words = new String[100];
    private String[] definitions = new String[100];
    private int numWords = 0;
    private int numDefinitions = 0;

    /**
     * Takes the words from the text file and saves them to an array. 
     * @param q
     */
    public void addWord(String q) {
        words[numWords] = q;
        numWords++;
    }
    /**
     * Takes the definitions from the text file and saves them to an array. 
     * @param a
     */
    public void addDefinition(String a) {
        definitions[numDefinitions] = a;
        numDefinitions++;
    }

    /**
     * Shuffles the word and defintion arrays into a random order using a Fisher-Yates suffle
     */
    public void shuffleDeck(){
        int n = numWords;
        for (int i = n-1; i>1 ; i--){
            int j = (int)(Math.random()*(i+1));
            String s = words[i];
            words[i] = words[j];
            words[j] = s;
            String p = definitions[i];
            definitions[i] = definitions[j];
            definitions[j] = p;
        }
    }

    /**
     * Gets the number of words in a text file.
     * @return int 
     */
    public int getNumWords(){
        return numWords;
    }

    /**
     * Gets the number of definitions in a text file.
     * @return int 
     */
    public int getNumDefinitions(){
        return numDefinitions;
    }

    /**
     * Gets the word from the words[] array at index i.
     * @param i
     * @return word at index i
     */
    public String getWord(int i){
        String m = words[i];
        return m;
    }

    /**
     * Gets the definition from the definitions[] array at index i.
     * @param i
     * @return definition at index i
     */
    public String getDefinition(int i){  
        String m = definitions[i];
        return m;
    }
}
