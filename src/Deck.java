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
