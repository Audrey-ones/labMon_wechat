package com.sery.labmon.testUtil;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by LuDan on 2018/4/19 10:17
 */
public class SocketService {
    //搭建服务器端
    public static void main(String[] args)throws IOException{
        //创建一个服务端Socket
        SocketService socketService = new SocketService();
        socketService.onServer();
    }

    public void onServer(){
        try {
            ServerSocket server = null;
            try {
                //指定绑定的端口，并监听此端口，创建一个ServerSocket在端口5209监听客户请求
                server = new ServerSocket(5209);
                System.out.println("服务器启动成功！");
            }catch (Exception e){
                //出错，打印出错信息
                System.out.println("没有启动监听："+ e);
            }

            Socket socket = null;
            try {
                //调用accept()方法开始监听，等待客户端的连接
                //使用accept()阻塞等待客户请求，有客户
                //请求到来则产生一个Socket对象，并继续执行
                socket = server.accept();
            }catch (Exception e){
                //出错，打印出错信息
                System.out.println("Error" + e);
            }

            //获取输入流，并读取客户端信息
            String line;
            //由Socket对象得到输入流，并构造相应的BufferedReader对象
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //由Socket对象得到输出流，并构造PrintWriter对象
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            //由系统标准输入设备构造BufferedReader对象
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //String patientInfo = patientService.getPatientList().toString();
            //BufferedReader br = new BufferedReader(new InputStreamReader(patientInfo.getBytes()));
            //在标准输出上打印从客户端读入的字符串
            System.out.println("Client:"+in.readLine());
            //从标准输入读入一字符串
            //获取输出流，响应客户端的请求
            line=br.readLine();
            //如果该字符串为 "end"，则停止循环
            while (!line.equals("end")){
                //向客户端输出该字符串
                writer.println(line);
                //刷新输出流，使Client马上收到该字符串
                writer.flush();
                //在系统标准输出上打印读入的字符串
                System.out.println("Server："+line);
                //从Client读入一字符串，并打印到标准输出上
                System.out.println("Client："+in.readLine());
                //从系统标准输入读入一字符串
                line = br.readLine();
            }//继续循环

            //关闭资源
            writer.close();//关闭socket输出流
            in.close();//关闭socket输入流
            socket.close();//关闭socket
            server.close();//关闭ServerSocket
        }catch (Exception e){
            System.out.println("Error："+e);
        }
    }
}
