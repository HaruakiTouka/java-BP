//extends JTable
public class dataStart {
    private String xnum0;
    private String ynum0;
    private int[][] dataint;

    public static void main(String[] args) {
            new MultiLayout();//从主页进入
        }
    public String[][] data;
    public double[][] num;
    public double[][] inx;
    public double[][] outy;

    public dataStart(String xnum,String ynum) {
        int i1 = Integer.parseInt(xnum) + Integer.parseInt(ynum);
        xnum0=xnum;
        ynum0=ynum;
        data=new String[100][i1];
        num=new double[100][i1];
        inx=new double[100][Integer.parseInt(xnum)];
        outy=new double[100][Integer.parseInt(ynum)];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                if (j<Integer.parseInt(xnum)){
                    num[i][j]= Math.random()*10;
                    inx[i][j]= Double.parseDouble(String.format("%.2f",num[i][j]));
                }
                else {
                    for (int k = 0; k < Integer.parseInt(xnum); k++) {
                        num[i][j]+=Math.pow(num[i][k],j-Integer.parseInt(xnum)+1);
                    }
                    outy[i][j-Integer.parseInt(xnum)]= Double.parseDouble(String.format("%.2f",num[i][j]));
                }
                data[i][j]= String.format("%.2f",num[i][j]);
                System.out.print(" "+data[i][j]);
            }
            System.out.println();
        }
    }
    public String[][] gettingdata() {
            return this.data;
        }
    public double[][] gettingin() {
        return this.inx;
    }
    public double[][] gettingout() {
        return this.outy;
    }
    public void switchData(dataStart t0) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                this.data[i][j]=t0.data[i][j];
                if (j<Integer.parseInt(xnum0)){
                    inx[i][j]= Double.parseDouble(t0.data[i][j]);
                }
                else {
                    outy[i][j-Integer.parseInt(xnum0)]= Double.parseDouble(t0.data[i][j]);
                }

            }
        }
    }
    public String getX() {
        return this.xnum0;
    }
    public String getY() {
        return this.ynum0;
    }
}
