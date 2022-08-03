package com.stefanini.onlinecatalog.activemq;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadXML {
    File file;
    public ReadXML() {

        this.file = new File("MarshallerStore.xml");
    }
    public ReadXML(String fileName) {

        this.file = new File(fileName);
    }

    public String readXMLfileByLine(){
        StringBuilder stringBuilderData = new StringBuilder();
        try {
            Scanner content = new Scanner(this.file);
            while (content.hasNextLine()) {
                stringBuilderData.append(content.nextLine()+"\n");
            }
            content.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return stringBuilderData.toString();
    }

}
