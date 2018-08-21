/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prospaceconverter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Billy
 */
public class ProspaceConverter {
    
    public static void main(String[] args) throws IOException{
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
        
//        File yourFile = new File("rules.txt");
//        yourFile.createNewFile(); // if file already exists will do nothing 
//        FileOutputStream oFile = new FileOutputStream(yourFile, false); 
//        oFile.
        
        FileHandler fileHandler = new FileHandler();
        fileHandler.createNewFile();
        
        String query = "";
        
        query = "glob is I";
        service.convertQuery(query);
        query = "prok is V";
        service.convertQuery(query);
        query = "pish is X";
        service.convertQuery(query);
        query = "tegj is L";
        service.convertQuery(query);
        query = "glob glob Silver is 34 Credits";
        service.convertQuery(query);
        query = "glob prok Gold is 57800 Credits";
        service.convertQuery(query);
        query = "pish pish Iron is 3910 Credits";
        service.convertQuery(query);
        
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
