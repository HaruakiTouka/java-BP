import org.jfree.data.xy.XYSeries;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Training {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        new MultiLayout();//从主页进入
    }

    BackP bp;
    XYSeries errorSeries ;
    public Training(dataStart t, String xunnunber) {
        errorSeries= new XYSeries("");
        int inx= Integer.parseInt(t.getX());
        int outy=Integer.parseInt(t.getY());
        bp= new BackP(4, 4, 2, 0.05);


        double[][] data = t.gettingin();
        double[][] dataout = t.gettingout();


        System.out.print("训练次数"+Integer.parseInt(xunnunber));
        for (int i = 0; i <Integer.parseInt(xunnunber); i++) {
            double error=0;
            for (int j = 0; j < data.length; j++) {
                bp.train(data[j], dataout[j]);
                error=error+bp.get_thiserror();
            }
            System.out.print("第"+i+"次训练error"+error);
            System.out.println();
            errorSeries.add(i,error);
        }
        System.out.println("训练完毕"+data[0][0]+" "+data[0][1]);

    }

    public XYSeries gettingReslut() {
        return errorSeries;
    }
}
