import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIO {
    FileWriter writer;
        public ArrayList<String> readData(String path){
            ArrayList<String> data = new ArrayList<>();


            File file = new File(path);
            try {
                Scanner scan = new Scanner(file);
                scan.nextLine();//skip header
                while(scan.hasNextLine()){
                    String s = scan.nextLine();// "Egon , 20000"
                    data.add(s);
                }

            }catch(FileNotFoundException e){
                System.out.println(e.getMessage());

            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("der findes kun 2 værdier pr. række");
            }
 }


    public void saveGame(ArrayList<String> playerData, String path, String header) {
        {
            try {
                File file = new File(path);
                writer = new FileWriter(file);


                writer.write(header + "\n");


                for(String p : playerData) {
                    writer.write(p.toString() + "\n");

                }
                writer.close();
                 } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
