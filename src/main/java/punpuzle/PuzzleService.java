/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punpuzle;

import java.util.ArrayList;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author cdominguez
 */
@Service
public class PuzzleService {
    
    public PuzzleService(){
    }
    
    public ArrayList<String> getSuggestions(String word, int offset, String max){
        
        RestTemplate requestTemplate = new RestTemplate();
        String toSearch = word.replace(word.substring(word.length()-offset), "");
                
        ResponseEntity<List<Word>> wordsResponse = requestTemplate.exchange("https://api.datamuse.com/words?sp=*"+toSearch+"*&max="+max,
            HttpMethod.GET, null, new ParameterizedTypeReference<List<Word>>() {});
        List<Word> words = wordsResponse.getBody();
        ArrayList<String> final_result = new ArrayList<>();
        for (int i = 0; i < words.size(); i++){
            String aWord = words.get(i).getWord();
            if ((!aWord.toLowerCase().contains(toSearch.toLowerCase()+"-")) && (!aWord.toLowerCase().contains("-"+toSearch.toLowerCase()))) 
                if (aWord.toLowerCase().contains(toSearch.toLowerCase()))
                    if (!final_result.contains(aWord))
                        final_result.add(aWord.replaceFirst(toSearch, word.toUpperCase()));
        }
        
        return final_result;
        
    }
    
}