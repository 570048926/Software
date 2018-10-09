package SZYS;

import java.util.Scanner;
import java.util.Random;

public class Calculate {
    public static void main(String[] args) {
        int totalCnt = 0; //总题数
        int cnt = 0;      //当前已完成的题数，用来做循环的判断
        int rightCnt = 0; //做正确的题数
        int errorCnt = 0;  //做错误的题数
        int num;
        System.out.print("请输入你要做的题数：");
        Scanner input = new Scanner(System.in);
        totalCnt = input.nextInt();
        while (cnt < totalCnt) {
            int x=(int)(Math.random()*100);
            int y=(int)(Math.random()*100);
            int z=(int)(Math.random()*100);
            String result;

            switch ((int)(Math.random()*4))
            {
                case 0: //+
                   switch ((int)(Math.random()*4)){
                        case 0: //+
                            System.out.println(x+"+"+y+"+"+z+"=");
                            result = input.nextLine();
                            while(result.length() == 0 ||result.equals('\n') || result.equals('\r')){
                                result = input.nextLine();
                            }
                            num=Integer.parseInt(result);
                            if (num == (x+y+z) )
                            {
                                rightCnt ++;
                                System.out.println("答案正确！" );
                            }
                            else
                            {
                                errorCnt ++;
                                System.out.println("答案错误！正确答案为："+(x+y+z) );
                            }
                            break;
                        case 1: //-
                            System.out.println(x+"+"+y+"-"+z+"=");
                            result = input.nextLine();
                            while(result.length() == 0 ||result.equals('\n') || result.equals('\r')){
                                result = input.nextLine();
                            }
                            num=Integer.parseInt(result);
                            if (num == (x+y-z) )
                            {
                                rightCnt ++;
                                System.out.println("答案正确！" );
                            }
                            else
                            {
                                errorCnt ++;
                                System.out.println("答案错误！正确答案为："+(x+y-z) );
                            }
                            break;
                        case 2: //*
                            System.out.println(x+"+"+y+"*"+z+"=");
                            result = input.nextLine();
                            while(result.length() == 0 ||result.equals('\n') || result.equals('\r')){
                                result = input.nextLine();
                            }
                            num=Integer.parseInt(result);
                            if (num == (x+y*z) )
                            {
                                rightCnt ++;
                                System.out.println("答案正确！" );
                            }
                            else
                            {
                                errorCnt ++;
                                System.out.println("答案错误！正确答案为："+(x+y*z) );
                            }
                            break;
                        case 3: // /
                            System.out.println(x+"+"+y+"/"+z+"=");
                            result = input.nextLine();
                            while(result.length() == 0 ||result.equals('\n') || result.equals('\r')){
                                result = input.nextLine();
                            }
                            num=Integer.parseInt(result);
                            if (num == (x+y/z) )
                            {
                                rightCnt ++;
                                System.out.println("答案正确！" );
                            }
                            else
                            {
                                errorCnt ++;
                                System.out.println("答案错误！正确答案为："+(x+y/z) );
                            }
                            break;
                    }

                    break;
                case 1:
                    if(x<y)
                    {
                        int temp=x;
                        x=y;
                        y=temp;
                    }
                    switch ((int)(Math.random()*4)){
                        case 0: //+
                            System.out.println(x+"-"+y+"+"+z+"=");
                            result = input.nextLine();
                            while(result.length() == 0 ||result.equals('\n') || result.equals('\r')){
                                result = input.nextLine();
                            }
                            num=Integer.parseInt(result);
                            if (num == (x-y+z) )
                            {
                                rightCnt ++;
                                System.out.println("答案正确！" );
                            }
                            else
                            {
                                errorCnt ++;
                                System.out.println("答案错误！正确答案为："+(x-y+z) );
                            }
                            break;
                        case 1://-
                            int k = x-y;
                           if (k<z)
                            {
                                int temp=(x-y);
                                k=z;
                                z=temp;
                            }
                            System.out.println(x+"-"+y+"-"+z+"=");
                            result = input.nextLine();
                            while(result.length() == 0 ||result.equals('\n') || result.equals('\r')){
                                result = input.nextLine();
                            }
                            num=Integer.parseInt(result);
                            if (num == (x-y)-z )
                            {
                                rightCnt ++;
                                System.out.println("答案正确！" );
                            }
                            else
                            {
                                errorCnt ++;
                                System.out.println("答案错误！正确答案为："+(x-y-z) );
                            }
                            break;
                        case 2://*
                            System.out.println(x+"-"+y+"*"+z+"=");
                            result = input.nextLine();
                            while(result.length() == 0 ||result.equals('\n') || result.equals('\r')){
                                result = input.nextLine();
                            }
                            num=Integer.parseInt(result);
                            if (num == (x-y*z) )
                            {
                                rightCnt ++;
                                System.out.println("答案正确！" );
                            }
                            else
                            {
                                errorCnt ++;
                                System.out.println("答案错误！正确答案为："+(x-y*z) );
                            }
                            break;
                        case 3:// /
                            System.out.println(x+"-"+y+"/"+z+"=");
                            result = input.nextLine();
                            while(result.length() == 0 ||result.equals('\n') || result.equals('\r')){
                                result = input.nextLine();
                            }
                            num=Integer.parseInt(result);
                            if (num == (x-y/z) )
                            {
                                rightCnt ++;
                                System.out.println("答案正确！" );
                            }
                            else
                            {
                                errorCnt ++;
                                System.out.println("答案错误！正确答案为："+(x-y/z) );
                            }
                            break;
                    }
                    break;
                case 2:
                    switch ((int)(Math.random()*4))
                    {
                        case 0:
                            System.out.println(x+"*"+y+"+"+z+"=");
                            result = input.nextLine();
                            while(result.length() == 0 ||result.equals('\n') || result.equals('\r')){
                                result = input.nextLine();
                            }
                            num=Integer.parseInt(result);
                            if (num == (x*y+z) )
                            {
                                rightCnt ++;
                                System.out.println("答案正确！" );
                            }
                            else
                            {
                                errorCnt ++;
                                System.out.println("答案错误！正确答案为："+(x*y+z) );
                            }
                            break;
                        case 1:
                            System.out.println(x+"*"+y+"-"+z+"=");
                            result = input.nextLine();
                            while(result.length() == 0 ||result.equals('\n') || result.equals('\r')){
                                result = input.nextLine();
                            }
                            num=Integer.parseInt(result);
                            if (num == (x*y-z) )
                            {
                                rightCnt ++;
                                System.out.println("答案正确！" );
                            }
                            else
                            {
                                errorCnt ++;
                                System.out.println("答案错误！正确答案为："+(x*y-z) );
                            }
                            break;
                        case 2:
                            System.out.println(x+"*"+y+"*"+z+"=");
                            result = input.nextLine();
                            while(result.length() == 0 ||result.equals('\n') || result.equals('\r')){
                                result = input.nextLine();
                            }
                            num=Integer.parseInt(result);
                            if (num == (x*y*z) )
                            {
                                rightCnt ++;
                                System.out.println("答案正确！" );
                            }
                            else
                            {
                                errorCnt ++;
                                System.out.println("答案错误！正确答案为："+(x*y*z) );
                            }
                            break;
                        case 3:
                            System.out.println(x+"*"+y+"/"+z+"=");
                            result = input.nextLine();
                            while(result.length() == 0 ||result.equals('\n') || result.equals('\r')){
                                result = input.nextLine();
                            }
                            num=Integer.parseInt(result);
                            if (num == (x*y/z) )
                            {
                                rightCnt ++;
                                System.out.println("答案正确！" );
                            }
                            else
                            {
                                errorCnt ++;
                                System.out.println("答案错误！正确答案为："+(x*y/z) );
                            }
                            break;
                    }
                    break;
                case 3:
                    switch ((int)(Math.random()*4))
                    {
                        case 0:
                            while(y==0)
                                y= (int)(Math.random()*100);
                            System.out.println(x+"/"+y+"+"+z+"=");
                            result = input.nextLine();
                            while(result.length() == 0 ||result.equals('\n') || result.equals('\r')){
                                result = input.nextLine();
                            }
                            num=Integer.parseInt(result);
                            if (num == (x/y+z) )
                            {
                                rightCnt ++;
                                System.out.println("答案正确！" );
                            }
                            else
                            {
                                errorCnt ++;
                                System.out.println("答案错误！正确答案为："+(x/y+z) );
                            }
                            break;
                        case 1:
                            while(y==0)
                                y= (int)(Math.random()*100);
                            System.out.println(x+"/"+y+"-"+z+"=");
                            result = input.nextLine();
                            while(result.length() == 0 ||result.equals('\n') || result.equals('\r')){
                                result = input.nextLine();
                            }
                            num=Integer.parseInt(result);
                            if (num == (x/y-z) )
                            {
                                rightCnt ++;
                                System.out.println("答案正确！" );
                            }
                            else
                            {
                                errorCnt ++;
                                System.out.println("答案错误！正确答案为："+(x/y-z) );
                            }
                            break;
                        case 2:
                            while(y==0)
                                y= (int)(Math.random()*100);
                            System.out.println(x+"/"+y+"*"+z+"=");
                            result = input.nextLine();
                            while(result.length() == 0 ||result.equals('\n') || result.equals('\r')){
                                result = input.nextLine();
                            }
                            num=Integer.parseInt(result);
                            if (num == (x/y*z) )
                            {
                                rightCnt ++;
                                System.out.println("答案正确！" );
                            }
                            else
                            {
                                errorCnt ++;
                                System.out.println("答案错误！正确答案为："+(x/y*z) );
                            }
                            break;
                        case 3:
                            while(y==0)
                            {
                                y= (int)(Math.random()*100);
                            }
                            while (z==0)
                            {
                                z = (int)(Math.random()*100);
                            }
                            System.out.println(x+"/"+y+"/"+z+"=");
                            result = input.nextLine();
                            while(result.length() == 0 ||result.equals('\n') || result.equals('\r')){
                                result = input.nextLine();
                            }
                            num=Integer.parseInt(result);
                            if (num == (x/y/z) )
                            {
                                rightCnt ++;
                                System.out.println("答案正确！" );
                            }
                            else
                            {
                                errorCnt ++;
                                System.out.println("答案错误！正确答案为："+(x/y/z) );
                            }
                            break;
                    }
                    break;
            }
            cnt++;
        }
        System.out.println("共"+totalCnt+"题,答对："+rightCnt+"题,答错:"+errorCnt+"题！" );
        System.out.print("你的正确率为："+((float)rightCnt/(float)totalCnt)*100+"%,错误率为："+((float)errorCnt/(float)totalCnt)*100+"%");

    }
}