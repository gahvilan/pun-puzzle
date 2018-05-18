package punpuzle;

import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController("/api")
public class PuzzleController {
   
    private PuzzleService aPuzzle;

    @RequestMapping("/search")
    public ResponseEntity<ArrayList<String>> searchWord(@RequestParam(name="word", required=true, defaultValue="world") String word, 
                             @RequestParam(name="offset", required=false, defaultValue="1") String offset,
                             @RequestParam(name="max", required=false, defaultValue="100") String max) throws JSONException{
        aPuzzle = new PuzzleService();
        ArrayList<String> wordList = aPuzzle.getSuggestions(word, Integer.parseInt(offset), max);
        return new ResponseEntity<ArrayList<String>>(wordList, HttpStatus.OK);
    }

}