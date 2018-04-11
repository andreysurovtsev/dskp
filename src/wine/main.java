
package wine;

import java.io.FileNotFoundException;

public class main {
      public static void main(String[] args) throws FileNotFoundException {
         DataSet train = new DataSet("wine.txt");
         // System.out.println(train.taskOutputString);
         System.out.println(train.getMean(1)[0]);
         System.out.println(train.getStd(1)[0]);
         
    }
}
