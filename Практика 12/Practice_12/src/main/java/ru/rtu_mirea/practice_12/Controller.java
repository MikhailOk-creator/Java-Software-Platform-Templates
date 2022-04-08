package ru.rtu_mirea.practice_12;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.*;

import java.io.IOException;
import java.io.FileReader;

@Component
public class Controller {
    File file;
    @Value("${inputname}")
    String file1;
    @Value("${outputname}")
    String file2;

    @PostConstruct
    public void read() throws IOException{
        file = new File(file1);
        String str = "";
        if(!file.exists()) {
            str = "null";
        }
        else {
            FileReader fr = new FileReader(file1);
            int i;
            while ((i=fr.read()) != -1) {
                str += ((char) i);
            }
            fr.close();
            str = Integer.toString(str.hashCode());
        }
        File out = new File(file2);
        if (out.exists()) {
            FileWriter fw = new FileWriter(file2, false);
            fw.write(str);
            fw.flush();
        }
    }

    @PreDestroy
    public void delete(){
        file = new File(file1);
        file.delete();
    }
}
