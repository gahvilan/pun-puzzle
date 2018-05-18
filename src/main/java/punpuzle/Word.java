/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punpuzle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 *
 * @author cdominguez
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Word {
    
    private String word;
    private Double score;
    
    public Word() {
    }
    
    public void setWord(String aWord){
        this.word = aWord;
    }
    
    public String getWord(){
        return this.word;
    }
    
    public void setScore(Double aScore){
        this.score = aScore;
    }
    
    public Double getScore(){
        return this.score;
    }
    
}
