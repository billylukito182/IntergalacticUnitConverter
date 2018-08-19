/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prospaceconverter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Billy
 */
public class ProspaceConverter {
    
    public static void main(String[] args) {
        converterService service = new converterService();
//        int romanToNumber = service.convertRomanToNumber("MCMIII");
//        if(romanToNumber != 0){
//            System.out.println("romanToNumber = "+romanToNumber);
//        }else{
//            System.out.println("romanToNumber = INVALID VALUE");
//        }
//        List<String> resultList = new ArrayList<String>();
//        String numberToRoman = service.convertNumberToRoman(1903, '?', resultList);
//        System.out.println("numberToRoman = "+numberToRoman);
        
        //glob prok (4) Silver is 34 Credits = 1 Silver is 8.5 Credits
        //glob prok (4) Gold is 57800 Credits = 1 Gold is 14450 Credits
        //pish pish (20)Iron is 3910 Credits = 1 Iron is 195.5 Credits
        String query = "";
        
        query = "how much is pish tegj glob glob ?";
        System.out.println(service.convertQuery(query));
        
        query = "how many Credits is glob prok Silver ?";
        System.out.println(service.convertQuery(query));
        
        query = "how many Credits is glob prok Gold ?";
        System.out.println(service.convertQuery(query));
        
        query = "how many Credits is glob prok Iron ?";
        System.out.println(service.convertQuery(query));
        
        query = "how much wood could a woodchuck chuck if a woodchuck could chuck wood ?";
        System.out.println(service.convertQuery(query));
        
    }
    
    
    
}
