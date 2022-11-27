import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import java.io.Serial;


public class MultiLayout extends JFrame {
    @Serial
    private static final long serialVersionUID = 1L;

    // 定义组件
//    JPanel jp1, jp2;
//    JButton jb1, jb2, jb3, jb4, jb5, jb6;

    public static void main(String[] args) {
        new MultiLayout();
    }
    JLabel label1;
    JLabel labelwein;
    JLabel labelweiout;
    JLabel labelceng;
    JTextField tfin;
    JTextField tfout;
    JTextField tfceng;
    JButton bt1;



    public MultiLayout() {
        this.setVisible(true);
        this.setSize(280, 220);
        this.setVisible(true);
        this.setLocation(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label1 = new JLabel("参数设置界面");
        labelwein = new JLabel("输入维度");
        labelweiout = new JLabel("输出维度");
        labelceng = new JLabel("隐藏层层数");
        tfin = new JTextField();
        tfout = new JTextField();
        tfceng = new JTextField();
//        rb1 = new JRadioButton("记住密码");
//        rb2 = new JRadioButton("自动登陆");
        bt1 = new JButton("模型创建");

        // 为指定的 Container 创建 GroupLayout
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);

        // 创建GroupLayout的竖直连续组，，越先加入的ParallelGroup，优先级级别越高。
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        // 添加间隔
        hGroup.addGap(5);
        hGroup.addGroup(layout.createParallelGroup().addComponent(labelwein).addComponent(labelweiout).addComponent(labelceng));
        hGroup.addGap(5);
        hGroup.addGroup(layout.createParallelGroup().addComponent(label1).addComponent(tfin).addComponent(tfout).addComponent(tfceng).addComponent(bt1));
        hGroup.addGap(5);
        // 设置水平分组
        layout.setHorizontalGroup(hGroup);

        // 创建GroupLayout的横向连续组，，越先加入的ParallelGroup，优先级级别越高。
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGap(10);
        vGroup.addGroup(layout.createParallelGroup().addComponent(label1));
        vGroup.addGap(10);
        vGroup.addGroup(layout.createParallelGroup().addComponent(labelwein).addComponent(tfin));
        vGroup.addGap(5);
        vGroup.addGroup(layout.createParallelGroup().addComponent(labelweiout).addComponent(tfout));
        vGroup.addGap(5);
        vGroup.addGroup(layout.createParallelGroup().addComponent(labelceng).addComponent(tfceng));
        vGroup.addGap(5);
//        vGroup.addGroup(layout.createParallelGroup().addComponent(rb1));
//        vGroup.addGroup(layout.createParallelGroup().addComponent(rb2));
        vGroup.addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(bt1));
        vGroup.addGap(10);
        // 设置垂直组
        layout.setVerticalGroup(vGroup);

        //添加点击事件监听器（你可以使用任何其他监听，看你想在什么情况下创建新的窗口了）
        //单击按钮执行的方法
        bt1.addActionListener(e -> {
            String ceng =tfceng.getText().trim();
            String inputwei=tfin.getText().trim();
            String outputwei =tfout.getText().trim();
            closeThis();
//创建新的窗口
            Modle frame;
            frame = new Modle(ceng,inputwei,outputwei);
//设置在屏幕的位置
            frame.setLocation(100,50);
// 窗体大小
            frame.setSize(1000,880);
// 显示窗体
            frame.setVisible(true);
        });
    }

    private void closeThis() {
        this.dispose();
    }
}

