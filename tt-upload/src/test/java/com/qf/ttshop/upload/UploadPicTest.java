package com.qf.ttshop.upload;

import com.qf.ttshop.common.util.FtpUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//public class UploadPicTest {
//    @Test
//    public void testFTPClient() throws IOException {
//        //创建FTP客户端
//        FTPClient ftpClient = new FTPClient();
//        //创建连接 等价于ftp 47.100.101.116
//        ftpClient.connect("47.100.101.116",21);
//        //登录
//        ftpClient.login("ftpuser", "zwzwzwzw");
//        //文件输入流
//        FileInputStream fis = new FileInputStream(new File("D:\\Documents\\Desktop\\picture\\03.jpg"));
//        //设置图片上传参数(1 设置上传后的位置 2 类型：二进制)
//        ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");
//        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
//        //上传文件
//        boolean b = ftpClient.storeFile("hello.jpg", fis);
//        System.out.println(b);
//        //关闭资源
//        fis.close();
//        ftpClient.logout();
//    }
//
//    @Test
//    public void testFTPUtils() throws Exception {
//        FileInputStream fis = new FileInputStream(new File("D:\\Documents\\Desktop\\picture\\03.jpg"));
//        boolean b = FtpUtils.uploadFile("47.100.101.116", 21, "ftpuser", "zwzwzwzw",
//                "/home/ftpuser/www/images", "/2017/12/3", "hello2.jpg", fis);
//        System.out.println(b);
//    }
//}
