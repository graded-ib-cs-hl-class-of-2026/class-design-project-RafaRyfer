public class Deck {
    private String[] words = new String[100];
    private String[] definitions = new String[100];
    private int numWords = 0;
    private int numDefinitions = 0;


    public void addWord(String q) {
        words[numWords] = q;
        numWords++;
    }

    public void addDefinition(String a) {
        definitions[numDefinitions] = a;
        numDefinitions++;
    }

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

    public int getNumWords(){
        return numWords;
    }

    public int getNumDefinitions(){
        return numDefinitions;
    }

    public String getWord(int i){
        String m = words[i];
        return m;
    }

    public String getDefinition(int i){  
        String m = definitions[i];
        return m;
    }
}
