/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package murach.data;

import java.io.*;
import java.util.*;
import murach.business.*;

/**
 *
 * @author Andrew Montgomery
 */
public class TechSupportIO {
    
    public static ArrayList<TechSupport> getTechSupport(String filepath) {
        ArrayList<TechSupport> techs = new ArrayList<TechSupport>();
        try {
            File file = new File(filepath);
            BufferedReader in = new BufferedReader(
                                new FileReader(file));

            String line = in.readLine();
            while (line != null) {
//                Each line in file is read, data separated by semicolon
                StringTokenizer t = new StringTokenizer(line, ";");
                String name = t.nextToken();
                String email = t.nextToken();
                String phone = t.nextToken();
                TechSupport s = new TechSupport();
                s.setName(name);
                s.setEmail(email);
                s.setPhone(phone);
//                Add new TechSupport object to ArrayList techs
                techs.add(s);
                line = in.readLine();
            }
            in.close();
            return techs;
        } catch (IOException e) {
            System.err.println(e);
            return null;
        }
    }
    
}
