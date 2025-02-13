package improved;


import java.util.HashMap;
import java.util.Map;

public class LetterFactory {

    private Map<String, Letter> letterMap = new HashMap<String, Letter>();

    public Letter createLetter(String key){
        Letter letter = letterMap.get(key);
        if(letter == null){
            letter = new Letter(key);
            letterMap.put(key,letter);
        }
        System.out.println(letterMap);
        return letterMap.get(key);
    }

}
