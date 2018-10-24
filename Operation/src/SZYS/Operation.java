package SZYS;
import javafx.concurrent.Task;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Timer;
import javax.swing.*;

import static javafx.application.Platform.exit;

public class Operation extends JFrame{
    public static void main(String[] args)
    {
        login();
    }
    //定义全局的分数
    static int score=0;
    //定义全局的value结果0
    static float currValue;
    // 定义全局运算式的字符串
    static String currString;
    //定义全局时间
    static String currTime;
    //定义全局题目数
    static int currNums=0;

    /**答题界面**/
    static JLabel nameTest3=new JLabel("");
    public static void exercise()
    {
        JFrame f=new JFrame();
        f.setTitle("在线答题系统(保留两位小数)");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setVisible(true);
        //设置窗口的大小和位置
        f.setSize(600,500);
        f.setLocation(400,100);
        f.setLayout(null);
        JPanel pan1=new JPanel();
        JLabel name1=new JLabel("7/7=");
        pan1.add(name1);
        JTextField  nameTest1=new JTextField(15);
        nameTest1.setBounds(10, 10, 180, 100);
        //nameTest1.setPreferredSize(new Dimension(180,100));
        pan1.add(nameTest1);
        pan1.setBounds(10, 10, 200, 120);
        f.add(pan1);
        JPanel pan2=new JPanel();
        JLabel name2=new JLabel("请输入秒数：");
        pan2.add(name2);
        JTextField nameTest2=new JTextField(15);
        nameTest2.setBounds(300, 10, 180, 100);
       //	nameTest2.setPreferredSize(new Dimension(180,100));
        pan2.add(nameTest2);
        pan2.setBounds( 300,10, 200, 120);
        f.add(pan2);

        JPanel pan3=new JPanel();
        pan3.setLayout(null);

        nameTest3.setBounds(10, 60, 480, 200);
        nameTest3.setPreferredSize(new Dimension(300,100));
        pan3.add(nameTest3);
        pan3.setBounds( 10,60, 500, 220);
        f.add(pan3);
        JPanel pan4 = new JPanel();
        //	pan4.setLayout(null);
        JButton btnStart=new JButton("开始");
        btnStart.setBounds(30, 300,30, 30);
        btnStart.setPreferredSize(new Dimension(100,80));


        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Map<String, Float> map = new HashMap<String, Float>();
                map = operation();
                Set set = map.keySet();
                Iterator iter = set.iterator();
                String key = (String) iter.next();
                float value = map.get(key);
                if (btnStart.getText().equals("开始 1")) {
//                    currNums+=1;
//                    btnStart.setText("下一题");
//                    name1.setText(key);
//                    System.out.println("value:"+value);
//                    currValue=value;
//                    currString=key;
//                    map.clear();
                } else {
                    String ttime = nameTest2.getText();
                    int ttime3 =Integer.parseInt(ttime);
                    Timer timer = new Timer();// 实例化Timer类
                    timer.schedule(new TimerTask() {
                        public void run() {
                            nameTest3.setFont(new Font("宋体", Font.PLAIN, 20));
                            nameTest3.setText("你本次用时超过"+ttime3+"秒");
                        }
                    }, ttime3*1000);// 这里百毫秒
                    btnStart.setText("下一题");
                    currNums += 1;
                    if (currNums == 5) {
                        endTime();
                    }

                    name1.setText(key);
                    System.out.println("value:" + value);
                    currValue = value;
                    currString = key;
                    map.clear();
                    nameTest1.addKeyListener(new KeyAdapter() {
                        public void keyPressed(KeyEvent e) {
                            //按回车键执行相应操作;
                            if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                                String answerStr = nameTest1.getText();
                                float answer = Float.parseFloat(answerStr);
                                //判断正误，进行加分，并显示
                                System.out.println("answer:" + answer);
                                System.out.println("value:" + currValue);
                                if (answer == currValue) {
                                    score += 10;
                                    nameTest3.setFont(new Font("宋体", Font.PLAIN, 20));
                                    nameTest3.setText("本题为:" + currString + "" + currValue + " ||  您的回答正确 || 当前分数:" + score);
                                    nameTest1.setText("");
                                } else {
                                    nameTest3.setFont(new Font("宋体", Font.PLAIN, 20));
                                    nameTest3.setText("本题为:" + currString + "" + currValue + " ||  您的回答错误 || 当前分数:" + score);
                                }
                            }
                        }

                        ;
                    });
                }
            }
        });

        pan4.add(btnStart);
        pan4.setBounds(40, 350, 110, 90);
        f.add(pan4);
        JPanel pan5 = new JPanel();
        //	pan4.setLayout(null);
        JButton btnStart1=new JButton("计时");
        btnStart1.setBounds(30, 300,30, 30);
        btnStart1.setPreferredSize(new Dimension(100,80));
        btnStart1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(btnStart1.getText().equals("计时")){
                    btnStart1.setText("正在计时...");
                    nameTest3.setFont(new Font("宋体", Font.PLAIN, 20));
                    nameTest3.setText("              计时开始，请认真答题");
                    //获取当前时间
                    SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    currTime=df.format(new Date());
                }
            }
        });

        Timer timer = new Timer();// 实例化Timer类
        timer.schedule(new TimerTask() {
            public void run() {
                nameTest3.setFont(new Font("宋体", Font.PLAIN, 20));
                nameTest3.setText("你答题已经超过120秒！");
            }
        }, 120000);// 这里百毫秒


        pan5.add(btnStart1);
        pan5.setBounds(190, 350, 110, 90);
        f.add(pan5);
        JPanel pan6 = new JPanel();
        //	pan4.setLayout(null);
        JButton btnStart2=new JButton("结束");
        btnStart2.setBounds(30, 300,30, 30);
        btnStart2.setPreferredSize(new Dimension(100,80));
        btnStart2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //计算用时
               endTime();
            }
        });

        pan6.add(btnStart2);
        pan6.setBounds(340, 350, 110, 90);
        f.add(pan6);

        JPanel pan7 = new JPanel();
        JButton btnChengColor = new JButton("背景颜色");
        btnChengColor.setBounds(30, 300,30, 30);
        btnChengColor.setPreferredSize(new Dimension(100,80));
        btnChengColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color ch = JColorChooser.showDialog(f, "颜色选择器",
                        f.getBackground());

                if (ch != null) {
                    f.getContentPane().setBackground(ch);
                    pan1.setBackground(ch);
                    pan1.repaint();
                    pan2.setBackground(ch);
                    pan2.repaint();
                    pan3.setBackground(ch);
                    pan3.repaint();
                    pan4.setBackground(ch);
                    pan4.repaint();
                    pan5.setBackground(ch);
                    pan5.repaint();
                    pan6.setBackground(ch);
                    pan6.repaint();
                    f.getContentPane().repaint();
                }
            }
        });
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        pan7.add(btnChengColor);
        pan7.setBounds(470, 350, 110, 90);
        f.add(pan7);


    }


    /**生成四则运算**/
    public static Map<String,Float> operation()
    {
        Map<String,Float> map=new HashMap<String, Float>();
        String[] operators={"+","-","x","/"};
        int x=(int)(Math.random()*100);
        int y=(int)(Math.random()*100);
        int z=(int)(Math.random()*100);
        int index=(int)(Math.random()*4);
        int index1=(int)(Math.random()*4);
        while(index==4){
            index=(int)Math.random()*4;
        }
        String operator=operators[index];
        float result=0;
        if(operator.equals("+"))
        {
            while(index1==4){
                index1=(int)Math.random()*4;
            }

            String operator1=operators[index1];
            if(operator1.equals("+"))
            {
                String formula=(x+"")+operator+(""+y)+operator1+(""+z)+"=";
                result=x+y+z;
                map.put(formula, result);
            }
            else if (operator1.equals("-"))
            {
                String formula=(x+"")+operator+(""+y)+operator1+(""+z)+"=";
                result=x+y-z;
                map.put(formula, result);
            }
            else if (operator1.equals("x"))
            {
                String formula=(x+"")+operator+(""+y)+operator1+(""+z)+"=";
                result=x+y*z;
                map.put(formula, result);
            }
            else
            {
                String formula=("("+x+"")+operator+(""+y)+")"+operator1+(""+z)+"=";
                DecimalFormat df=new DecimalFormat("0.00");
                String nums=df.format((float)(x+y)/z);
                result=Float.parseFloat(nums);
                map.put(formula, result);
            }

        }
        else if(operator.equals("-"))
        {
            while(index1==4){
                index1=(int)Math.random()*4;
            }
            String operator1=operators[index1];
            if (operator1.equals("+"))
            {
                String formula=(x+"")+operator+(""+y)+operator1+(""+z)+"=";
                result=x-y+z;
                map.put(formula, result);
            }
            else if (operator1.equals("-"))
            {
                String formula=(x+"")+operator+(""+y)+operator1+(""+z)+"=";
                result=x-y-z;
                map.put(formula, result);
            }
            else if (operator1.equals("x"))
            {
                String formula=(+x+"")+operator+(""+y)+operator1+(""+z)+"=";
                result=x-y*z;
                map.put(formula, result);
            }
            else
            {
                String formula=("("+x+"")+operator+(""+y+")")+operator1+(""+z)+"=";
                DecimalFormat df=new DecimalFormat("0.00");
                String nums=df.format((float)(x-y)/z);
                result=Float.parseFloat(nums);
                map.put(formula, result);
            }

        }
        else if(operator.equals("x"))
        {
            while(index1==4){
                index1=(int)Math.random()*4;
            }
            String operator1=operators[index1];
            if (operator1.equals("+"))
            {
                String formula=(x+"")+operator+(""+y)+operator1+(""+z)+"=";
                result=x*y+z;
                map.put(formula, result);
            }
            else if(operator1.equals("-"))
            {
                String formula=(x+"")+operator+(""+y)+operator1+(""+z)+"=";
                result=x*y-z;
                map.put(formula, result);
            }
            else if (operator1.equals("x"))
            {
                String formula=(x+"")+operator+(""+y)+operator1+(""+z)+"=";
                result=x*y*z;
                map.put(formula, result);
            }
            else
            {
                String formula=(x+"")+operator+(""+y)+operator1+(""+z)+"=";
                DecimalFormat df=new DecimalFormat("0.00");
                String nums=df.format((float)x*y/z);
                result=Float.parseFloat(nums);
                map.put(formula, result);
            }

        }
        else
        {
            while(index1==4){
                index1=(int)Math.random()*4;
            }
            String operator1=operators[index1];
            if (operator1.equals("+"))
            {
                String formula=(x+"")+operator+(""+y)+operator1+(""+z)+"=";
                DecimalFormat df=new DecimalFormat("0.00");
                String nums=df.format((float)x/y+z);
                result=Float.parseFloat(nums);
                map.put(formula, result);
            }
            else if (operator.equals("-"))
            {
                String formula=(x+"")+operator+(""+y)+operator1+(""+z)+"=";
                DecimalFormat df=new DecimalFormat("0.00");
                String nums=df.format((float)x/y-z);
                result=Float.parseFloat(nums);
                map.put(formula, result);
            }
            else if (operator1.equals("x"))
            {
                String formula=(x+"")+operator+(""+y)+operator1+(""+z)+"=";
                DecimalFormat df=new DecimalFormat("0.00");
                String nums=df.format((float)x/y*z);
                result=Float.parseFloat(nums);
                map.put(formula, result);
            }
            else
            {
                String formula=(x+"")+operator+(""+y)+operator1+(""+z)+"=";
                DecimalFormat df=new DecimalFormat("0.00");
                String nums=df.format((float)x/y/z);
                result=Float.parseFloat(nums);
                map.put(formula, result);
            }

        }
        return map;
    }
    /**登录跳转方法**/
    public static  void login()
    {
        JFrame f=new JFrame();
        f.setTitle("系统登录界面");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setVisible(true);
        //设置窗口的大小和位置
        f.setSize(400,400);
        f.setLocation(420,120);
        Container con=f.getContentPane();//生成一个容器
        con.setLayout(new GridLayout(7,1));
        //生成一个新的版面
        JPanel pan1=new JPanel();
        JLabel title=new JLabel("欢迎登陆本系统");
        title.setFont(new Font("宋体",Font.BOLD, 20));
        pan1.add(title);
        con.add(pan1);
        //最上面的登陆文字
       //生成一个新的版面

        JPanel pan2=new JPanel();
        JLabel name=new JLabel("用户名");
        pan2.add(name);
        JTextField nameTest=new JTextField(15);
        pan2.add(nameTest);
        con.add(pan2);
        f.setSize(500,600);
        //用户名及其文本框放置在第二个版面上

        //生成一个新的版面
        JPanel pan3=new JPanel();
        JLabel pass = new JLabel("密码");
        pan3.add(pass);
        JPasswordField password=new JPasswordField(15);
        password.setEchoChar('*');
        pan3.add(password);
        con.add(pan3);
         //密码及其密码域放在第三个版面上
        // System.out.println(username+"   "+userPassword);
        JPanel pan4 = new JPanel();
        JButton b_log=new JButton("登陆");
        b_log.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //获取用户名和密码，进行校验
                String myUsername=nameTest.getText();
                String myPassword=password.getText();
                if(myUsername.equals("Operation")&&myPassword.equals("123")){
                    JOptionPane.showMessageDialog(null, "登陆成功!");
                    exercise();
                    //System.exit(0);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "账号或密码错误!");
                    nameTest.setText("");
                    password.setText("");
                }
            }
        });
        pan4.add(b_log);
        JButton b_exit=new JButton("退出");
        pan4.add(b_exit);
        con.add(pan4);
        f.setSize(500,650);
        //登陆和退出这两个按钮放在第四个版面上
        JPanel pan5 = new JPanel();
        con.add(pan5);
        JPanel pan6 = new JPanel();
        con.add(pan6);
        JPanel pan7 = new JPanel();
        con.add(pan7);
        //空白版面
    }

    public  static void endTime(){
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String endTime=df.format(new Date());
        try {
            long start =df.parse(currTime).getTime();
            long end=df.parse(endTime).getTime();
            int minutes = (int) ((end - start)/(1000 ));
            nameTest3.setFont(new Font("宋体", Font.PLAIN, 20));
            nameTest3.setText("时间:"+minutes+"秒  ||"+" 一共计算了"+currNums+"道题  ||  总得分:"+score);
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
    }
}