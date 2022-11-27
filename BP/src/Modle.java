import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.io.Serial;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Modle extends JFrame {
    @Serial
    private static final long serialVersionUID = 1L;
//    private static final int NUM1 = 3;
//    private static final int NUM2 = 100;

    public static void main(String[] args) {
        new MultiLayout();//从主页进入
    }

    public Modle(String ceng,String inputwei,String outputwe) {
        GridBagConstraints gbc = new GridBagConstraints();

        //JFrame jf = new JFrame("测试窗口");
        this.setVisible(true);
        this.setSize(1000,800);
        this.setVisible(true);
        this.setLocation(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        setTitle("BP神经网络拟合函数");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //主菜单实例化
        JPanel mainpanel=new JPanel();
        JButton btdata = new JButton("生成数据");
        JButton btinput = new JButton("开始训练");
        JLabel labelmain=new JLabel("初始生成数据为");
        JLabel labelmain1=new JLabel("input=3，output=2维");
        JLabel labelmain2=new JLabel("点击生成数据后重新生成数据。");
        JLabel labeltimes=new JLabel("训练次数");
//        JRadioButton leiji = new JRadioButton("累计误差校正");
//        JRadioButton guanxing = new JRadioButton("惯性校正法");
        ButtonGroup buttonGroup = new ButtonGroup();
//        buttonGroup.add(leiji);
//        buttonGroup.add(guanxing);
//        Container contentPane = this.getContentPane();
//        contentPane.add(leiji,BorderLayout.NORTH);
//        contentPane.add(guanxing,BorderLayout.CENTER);
        JTextField tf= new JTextField("",1);
        tf.setPreferredSize(new Dimension (5,1));
        GroupLayout layout = new GroupLayout(mainpanel);
        mainpanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        //创建GroupLayout的竖直连续组，，越先加入的ParallelGroup，优先级级别越高。
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        // 添加间隔.addComponent(leiji).addComponent(guanxing)
        hGroup.addGap(5);
        hGroup.addGroup(layout.createParallelGroup().addComponent(labelmain).addComponent(labelmain1).addComponent(labelmain2).addComponent(labeltimes).addComponent(btdata));
        hGroup.addGap(5);
//        hGroup.addGroup(layout.createParallelGroup().addComponent(labelmain).addComponent(contentPane).addComponent(labeltimes).addComponent(btdata));
//        hGroup.addGap(5);
        hGroup.addGroup(layout.createParallelGroup().addComponent(tf).addComponent(btinput));
        hGroup.addGap(5);
        // 设置水平分组
        layout.setHorizontalGroup(hGroup);
        // 创建GroupLayout的横向连续组，，越先加入的ParallelGroup，优先级级别越高。
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGap(10);
//
        vGroup.addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(labelmain));
        vGroup.addGap(10);
        vGroup.addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(labelmain1));
        vGroup.addGap(10);
        vGroup.addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(labelmain2));
        vGroup.addGap(10);
//        vGroup.addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(contentPane));
//        .addComponent(leiji)
        vGroup.addGroup(layout.createParallelGroup(Alignment.TRAILING));
        vGroup.addGap(10);
//        .addComponent(guanxing)
        vGroup.addGroup(layout.createParallelGroup(Alignment.TRAILING));
        vGroup.addGap(10);
        vGroup.addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(labeltimes).addComponent(tf));
        vGroup.addGap(10);
        vGroup.addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(btdata).addComponent(btinput));
        vGroup.addGap(10);
        // 设置垂直组
        layout.setVerticalGroup(vGroup);


        //图示panel
        JPanel showpanel=new JPanel();
        XYSeriesCollection dataset0 = new XYSeriesCollection();
        XYSeries series0 = new XYSeries("");
        series0.add(0,0);
        dataset0.addSeries(series0);
        JFreeChart chart0 = ChartFactory.createXYLineChart(
                "error函数",
                "训练次数",
                "error",
                dataset0,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
        ChartPanel chartPanel = new ChartPanel(chart0);;
        showpanel.add(chartPanel);


        //数据展示panel
        JPanel datapanel=new JPanel();
        String[] name={"x0","x1","x2","y0","y1"};
        dataStart t= new dataStart(inputwei,outputwe);
        JTable table=new JTable(t.gettingdata(),name);
        JScrollPane sp=new JScrollPane(table);
        datapanel.add(sp);



        //训练结果panel


        gbc.gridx = 0;//起始点列
        gbc.gridy = 0;//起始点行
        gbc.fill = GridBagConstraints.CENTER;//自动充满全部界面
        gbc.gridwidth = 1;//组件宽度
        gbc.weightx = 1;//分布宽度
        gbc.weighty = 1;//分布高度
        this.add(mainpanel, gbc);
        gbc.gridx = 1;//起始点列
        gbc.gridy = 0;//起始点行
        this.add(datapanel, gbc);
//        gbc.gridx = 1;//起始点列
//        gbc.gridy = 1;//起始点行
//        this.add(showpanel, gbc);

        btdata.addActionListener(e -> {
            int i1 = Integer.parseInt(inputwei) + Integer.parseInt(outputwe);
            String[] name0=new String[i1];
            int j=0;
            for (int i = 0; i < i1; i++) {
                if (i <Integer.parseInt(inputwei)) {
                    name0[i]="x"+String.valueOf(i);
                }else{
                    name0[i]="y"+String.valueOf(j);
                    j++;
                }
            }

            dataStart t0=new dataStart(inputwei,outputwe);
            t.switchData(t0);
            JTable table1=new JTable(t.gettingdata(),name0);
            sp.setViewportView(table1);


        });
        btinput.addActionListener(e -> {
            String xunnuber =tf.getText().trim();
            Training reslut;

            reslut = new Training(t,xunnuber);
            System.out.println("训练qishi"+t.gettingdata()[0][0]+" "+t.gettingdata()[0][1]);

//            PanelLoss loss=new PanelLoss(reslut.gettingReslut());
            XYSeries series = reslut.gettingReslut();
            XYSeriesCollection dataset = new XYSeriesCollection();
            dataset.addSeries(series);
            JFreeChart chart = ChartFactory.createXYLineChart(
                    "error Fuction",
                    "Iterms",
                    "error",
                    dataset,
                    PlotOrientation.VERTICAL,
                    true,
                    true,
                    false
            );
            chartPanel.setChart(chart);
            JFrame frameshow = new JFrame();
//设置在屏幕的位置
            frameshow.setLocation(100,50);
// 窗体大小
            frameshow.setSize(1000,880);
// 显示窗体
            frameshow.setVisible(true);
            frameshow.add(chartPanel);
            frameshow.setTitle("Line chart");
            frameshow.setLocationRelativeTo(null);
//            frameshow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            XYPlot plot = chart.getXYPlot();
//            XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
//            renderer.setSeriesPaint(0, Color.RED);
//            renderer.setSeriesStroke(0, new BasicStroke(2.0f));
//            plot.setRenderer(renderer);
//            plot.setBackgroundPaint(Color.white);
//            plot.setRangeGridlinesVisible(true);
//            plot.setRangeGridlinePaint(Color.BLACK);
//
//            plot.setDomainGridlinesVisible(true);
//            plot.setDomainGridlinePaint(Color.BLACK);
//            chart.getLegend().setFrame(BlockBorder.NONE);
//            LineChartEx ex = new LineChartEx();
//            ex.setVisible(true);
            //showpanel.add(plot);


        });
//            String xunnuber =tf.getText().trim();
//
//            String input[][]=jPanel.getInput(heng,zong);//tf.getText().trim();
//            for(int i=0;i<input.length;i++) {
//                System.out.print("第"+i+"行");
//                for (int j = 0; j < input[0].length; j++) {
//                    System.out.print(input[i][j] + " ");
//                }
//                System.out.println();
//            }
//            Training train= new Training(input);
//            String inputxun[][]=jPanelxun.getInput(xun,zong);//tf.getText().trim();
//            for(int i=0;i<inputxun.length;i++) {
//                System.out.print("第"+i+"行");
//                for (int j = 0; j < inputxun[0].length; j++) {
//                    System.out.print(inputxun[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.print(input[0][0] + " ");
//            PanelTesting test= new PanelTesting(train,inputxun);
//            for(int i=0;i<test.getreslut().length;i++) {
//                System.out.print("第"+i+"行结果");
//                for (int j = 0; j < test.getreslut()[0].length; j++) {
//                    System.out.print(test.getreslut()[i][j] + " ");
//                }
//                System.out.println();
//            }
//            jPanelshow.changeshow(test.getreslut());
//        });
    }
}
