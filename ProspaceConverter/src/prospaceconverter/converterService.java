/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prospaceconverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Billy
 */
public class converterService {
    int number = 0;
    public converterService() {
    }
    
    public String convertNumberToRoman(int number, char checkChar, List<String> resultList){
        
        this.number = number;
        
        if((this.number >= RomanIntEnum.M.getValue() || checkChar == RomanCharEnum.M.getValue()) && this.number > 0){
            if(this.number < RomanIntEnum.M.getValue()){
                resultList.add(RomanCharEnum.C.getValue()+""+RomanCharEnum.M.getValue());
                this.number -= RomanIntEnum.M.getValue()-RomanIntEnum.C.getValue();
            }else{
                int result = this.number / RomanIntEnum.M.getValue();
                for (int i=0; i<result; i++) {
                    resultList.add(RomanCharEnum.M.getValue()+"");
                    this.number -= RomanIntEnum.M.getValue();
                }
            }
        }
        if((this.number >= RomanIntEnum.D.getValue() || checkChar == RomanCharEnum.D.getValue()) && this.number > 0){
            if(this.number < RomanIntEnum.D.getValue()){
                resultList.add(RomanCharEnum.L.getValue()+""+RomanCharEnum.D.getValue());
                this.number -= RomanIntEnum.D.getValue()-RomanIntEnum.L.getValue();
            }else{
                int result = this.number / RomanIntEnum.D.getValue();
                if(result > 3){
                    this.number = rollbackNumber(this.number, RomanCharEnum.D.getValue(), resultList);
                    convertNumberToRoman(this.number, RomanCharEnum.D.getValue(), resultList);
                }else{
                    for (int i=0; i<result; i++) {
                        resultList.add(RomanCharEnum.D.getValue()+"");
                        this.number -= RomanIntEnum.D.getValue();
                    }
                }
            }
        }
        if((this.number >= RomanIntEnum.C.getValue() || checkChar == RomanCharEnum.C.getValue()) && this.number > 0){
            if(this.number < RomanIntEnum.C.getValue()){
                resultList.add(RomanCharEnum.X.getValue()+""+RomanCharEnum.C.getValue());
                this.number -= RomanIntEnum.C.getValue()-RomanIntEnum.X.getValue();
            }else{
                int result = this.number / RomanIntEnum.C.getValue();
                if(result > 3){
                    this.number = rollbackNumber(this.number, RomanCharEnum.C.getValue(), resultList);
                    convertNumberToRoman(this.number, RomanCharEnum.M.getValue(),resultList);
                }else{
                    for (int i=0; i<result; i++) {
                        resultList.add(RomanCharEnum.C.getValue()+"");
                        this.number -= RomanIntEnum.C.getValue();
                    }
                }
            }
        }
        if((this.number >= RomanIntEnum.L.getValue() || checkChar == RomanCharEnum.L.getValue()) && this.number > 0){
            if(this.number < RomanIntEnum.L.getValue()){
                resultList.add(RomanCharEnum.V.getValue()+""+RomanCharEnum.L.getValue());
                this.number -= RomanIntEnum.L.getValue()-RomanIntEnum.V.getValue();
            }else{
                int result = this.number / RomanIntEnum.L.getValue();
                if(result > 3){
                    this.number = rollbackNumber(this.number, RomanCharEnum.L.getValue(), resultList);
                    convertNumberToRoman(this.number, RomanCharEnum.D.getValue(), resultList);
                }else{
                    for (int i=0; i<result; i++) {
                        resultList.add(RomanCharEnum.L.getValue()+"");
                        this.number -= RomanIntEnum.L.getValue();
                    }
                }
            }
        }
        if((this.number >= RomanIntEnum.X.getValue() || checkChar == RomanCharEnum.X.getValue()) && this.number > 0){
            if(this.number < RomanIntEnum.X.getValue()){
                resultList.add(RomanCharEnum.I.getValue()+""+RomanCharEnum.X.getValue());
                this.number -= RomanIntEnum.X.getValue()-RomanIntEnum.I.getValue();
            }else{
            int result = this.number / RomanIntEnum.X.getValue();
            if(result > 3){
                this.number = rollbackNumber(this.number, RomanCharEnum.X.getValue(), resultList);
                convertNumberToRoman(this.number, RomanCharEnum.C.getValue(), resultList);
            }else{
                for (int i=0; i<result; i++) {
                        resultList.add(RomanCharEnum.X.getValue()+"");
                        this.number -= RomanIntEnum.X.getValue();
                    }
                }
            }
        }
        if((this.number >= RomanIntEnum.V.getValue() || checkChar == RomanCharEnum.V.getValue()) && this.number > 0){
            int result = this.number / RomanIntEnum.V.getValue();
            if(result > 3){
                this.number = rollbackNumber(this.number, RomanCharEnum.V.getValue(), resultList);
                convertNumberToRoman(this.number, RomanCharEnum.L.getValue(), resultList);
            }else{
                for (int i=0; i<result; i++) {
                    resultList.add(RomanCharEnum.V.getValue()+"");
                    this.number -= RomanIntEnum.V.getValue();
                }
            }
        }
        if((this.number >= RomanIntEnum.I.getValue() || checkChar == RomanCharEnum.I.getValue()) && this.number > 0){
            int result = this.number / RomanIntEnum.I.getValue();
            if(result > 3){
                this.number = rollbackNumber(this.number, RomanCharEnum.I.getValue(), resultList);
                convertNumberToRoman(this.number, RomanCharEnum.X.getValue(), resultList);
            }else{
                for (int i=0; i<result; i++) {
                    resultList.add(RomanCharEnum.I.getValue()+"");
                    this.number -= RomanIntEnum.I.getValue();
                }
            }
        }
        
        if(this.number == 0){
            String resultString = "";
            for (String item : resultList) {
                resultString += item;
                
            }
            return resultString;
        }else{
            return null;
        }
    }
    
    public int rollbackNumber(int number, char currentChar, List<String> resultList){
        
        if(currentChar == RomanCharEnum.D.getValue()){
            number += RomanIntEnum.M.getValue();
        }else if(currentChar == RomanCharEnum.C.getValue()){
            number += RomanIntEnum.D.getValue();
        }else if(currentChar == RomanCharEnum.L.getValue()){
            number += RomanIntEnum.C.getValue();
        }else if(currentChar == RomanCharEnum.X.getValue()){
            number += RomanIntEnum.L.getValue();
        }else if(currentChar == RomanCharEnum.V.getValue()){
            number += RomanIntEnum.X.getValue();
        }else if(currentChar == RomanCharEnum.I.getValue()){
            number += RomanIntEnum.V.getValue();
        }
        resultList.remove(resultList.size()-1);
        
        return number;
    }
    
    public int convertRomanToNumber(String romanValue){
        
        char[] item = romanValue.toCharArray();
        int totalValue = 0;
        int appearInRow = 1;
        for (int i=0; i<item.length; i++) {
            char currentChar = item[i];
            char prevChar = 0;
            
            int charToInt = convertCharToInt(currentChar);
            int prevCharToInt = 0;
            if(i!=0){
                prevChar = item[i-1];
                prevCharToInt = convertCharToInt(prevChar);
            }
            
            if(charToInt!=0){
                if(prevCharToInt>=charToInt || prevCharToInt==0){
                    if(prevCharToInt==charToInt)
                        appearInRow++;
                    else
                        appearInRow = 1;
                    if(appearInRow > 3) return 0;
                    totalValue += charToInt;
                }else{
                    boolean checkSubstraction = checkSubstractionRules(prevChar, currentChar);
                    if(checkSubstraction == true){
                        totalValue -= prevCharToInt;
                        int tempValue = charToInt - prevCharToInt;
                        totalValue += tempValue;
                    }else{
                        return 0;
                    }
                }
            }else{
                return 0;
            }
        }
        
        return totalValue;
    }
    
    public boolean checkSubstractionRules(char first, char second){
        
        if((first==RomanCharEnum.I.getValue() && second==RomanCharEnum.V.getValue()) || (first==RomanCharEnum.I.getValue() && second==RomanCharEnum.X.getValue())) return true;
        else if((first==RomanCharEnum.X.getValue() && second==RomanCharEnum.L.getValue()) || (first==RomanCharEnum.X.getValue() && second==RomanCharEnum.C.getValue())) return true;
        else if((first==RomanCharEnum.C.getValue() && second==RomanCharEnum.D.getValue()) || (first==RomanCharEnum.C.getValue() && second==RomanCharEnum.M.getValue())) return true;
        else if((first==RomanCharEnum.V.getValue() && second==RomanCharEnum.L.getValue()) || (first==RomanCharEnum.V.getValue() && second==RomanCharEnum.D.getValue()) || (first==RomanCharEnum.L.getValue() && second==RomanCharEnum.D.getValue())) return false;
        else return false;
        
    }
    
    public int convertCharToInt(char character){
        switch (character) {
            case 'I':  return RomanIntEnum.I.getValue();
            case 'V':  return RomanIntEnum.V.getValue();
            case 'X':  return RomanIntEnum.X.getValue();
            case 'L':  return RomanIntEnum.L.getValue();
            case 'C':  return RomanIntEnum.C.getValue();
            case 'D':  return RomanIntEnum.D.getValue();
            case 'M':  return RomanIntEnum.M.getValue();
            default: return 0;
        }
    }
    
    public char convertStringToRoman(String intergalacticString){
        switch (intergalacticString) {
            case "glob":  return RomanCharEnum.I.getValue();
            case "prok":  return RomanCharEnum.V.getValue();
            case "pish":  return RomanCharEnum.X.getValue();
            case "tegj":  return RomanCharEnum.L.getValue();
            default: return '!';
        }
    }
    
    public double convertStringToCredits(String intergalacticString){
        switch (intergalacticString) {
            case "silver":  return 8.5;
            case "gold":  return 14450;
            case "iron":  return 195.5;
            default: return 0;
        }
    }
    
    public String convertIntergalacticToRoman(String intergalactic){
        String roman = "";
        String[] item = intergalactic.split(" ", -1);
        
        for (String currentString : item) {
            char stringtoChar = convertStringToRoman(currentString);
            roman += stringtoChar;
        }
        if(roman.contains("!")){
            return "ERR";
        }else{
            return ""+convertRomanToNumber(roman);
        }
    }
    
    public String convertQuery(String query){
        String result = "";
        query = query.toLowerCase();
        query = query.replaceAll("\\?", "");
        
        if(query.contains("how much is")){
            query = query.replaceAll("how much is", "");
            result = query.trim()+" is "+convertIntergalacticToRoman(query.trim());
                
            if(result.contains("ERR")){
                result = "I have no idea what you are talking about";
            }
        }else if(query.contains("how many credits is")){
            query = query.replaceAll("how many credits is", "");
            String [] arQuery = query.split(" ");
            String last = arQuery[arQuery.length-1];
            
            double credits = convertStringToCredits(last);
            result = "I have no idea what you are talking about";
            
            if(credits>0){
                String galacticNum = query.replace(last, "").trim();
                String galacticValue = ""+convertIntergalacticToRoman(galacticNum);
                
                if(!galacticValue.contains("ERR")){
                    double calculate = credits * Double.parseDouble(galacticValue);
                    result = galacticNum +" "+last+" is "+ calculate + " credits";
                }
            }
        }else{
            result = "I have no idea what you are talking about";
        }
        
        return result;
    }
}
