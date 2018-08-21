/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prospaceconverter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author Billy
 */
public class FileHandler {

    public FileHandler() {
    }
    
    public String readTextFileIntergalactic(String currentString){
        String value = "";
        try {

            File f = new File("rules.txt");

            BufferedReader b = new BufferedReader(new FileReader(f));

            String readLine = "";
            while ((readLine = b.readLine()) != null) {
                if(readLine.contains(currentString+" is ")){
                    String [] def = readLine.split(" is ");
                    String variable = def[0];
                    value = def[1];
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
    
    public String readTextFileCredits(String currentString){
        String value = "";
        try {

            File f = new File("rules.txt");

            BufferedReader b = new BufferedReader(new FileReader(f));

            String readLine = "";
            while ((readLine = b.readLine()) != null) {
                if(readLine.contains("credits") && readLine.contains("1") && readLine.contains(" = ") && readLine.contains(currentString)){
                    String [] def = readLine.split(" = ");
                    String variable = def[0];
                    value = def[1];
                    String [] splitVar = variable.split(" ");
                    String [] splitVal = value.split(" ");
                    value = splitVal[0];
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
    
    public void createNewFile() throws IOException{
            File file = new File("rules.txt");

            // if file doesnt exists, then create it
//            if (!file.exists()) {
//                    file.createNewFile();
//            }else{
                file.delete();
                file.createNewFile();
//            }
    }
    
    public void doAppendToFile(String data){
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            File file = new File("rules.txt");

            // if file doesnt exists, then create it
//            if (!file.exists()) {
//                    file.createNewFile();
//            }else{
//                file.delete();
//                file.createNewFile();
//            }

            // true = append file
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write(data);
            if(data.contains("credits")){
                String [] def = data.split(" is ");
                String variable = def[0];
                String value = def[1];
                String [] splitVar = variable.split(" ");
                String [] splitVal = value.split(" ");
                String [] newsplitVar = Arrays.copyOf(splitVar, splitVar.length - 1);
                StringBuilder builder = new StringBuilder();
                for(String s : newsplitVar) {
                    builder.append(s+" ");
                }
                String str = builder.toString().trim();
                converterService conv = new converterService();
                String strNum = conv.convertIntergalacticToRoman(str);
                double oneIs = Double.parseDouble(splitVal[0])/Double.parseDouble(strNum);
                bw.write("1 "+splitVar[splitVar.length-1]+" = "+oneIs+" credits\n");
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                        bw.close();

                if (fw != null)
                        fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
