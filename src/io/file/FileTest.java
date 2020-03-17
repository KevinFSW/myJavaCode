package io.file;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest {

    /**
     * 打印x个缩进
     * @param x
     */
    private void printXTab(int x){
        for (int i = 0; i < x; i++) {
            System.out.print("    ");
        }
    }

    /**
     * 遍历给定路径
     * @param folder
     * @param deep 自己定义的深度，递归开始的时候指定为0，每进入一个文件夹加1
     */
    public void enterFolder(File folder, int deep){
        if(folder == null){
            return;
        }

        for (File f : folder.listFiles()) {
            printXTab(deep);//缩进一下好看而已
            System.out.println(f.getName());//打印当前成员的名字（也就是文件名或者文件夹名）
            if(f.listFiles() != null && f.listFiles().length != 0){
                this.enterFolder(f, deep+1);//遍历到一个文件夹，继续递归
            }
        }
    }

    /**
     * 遍历给定路径删除
     * @param folder
     */
    public void deletFolder(File folder){
        if(folder == null){
            return;
        }

        for (File f : folder.listFiles()) {
            if(f.listFiles() != null && f.listFiles().length != 0){
                this.deletFolder(f);//遍历到一个文件夹，继续递归
            }
            f.delete();//如果f是文件或者空文件夹，这里删除，如果f是文件夹且非空，会先递归进去删除里面的文件，再出来删除文件夹
        }
    }


    public static void main(String[] args) {
        String filePath = ".//src//io//file//aaa//";// src//io//file//test.txt路径不区分大小写
        File file = new File(filePath);
        FileTest test = new FileTest();
        //test.enterFolder(file, 0);
        test.deletFolder(file);
        file.delete();
/*
        file.delete();//不能删除非空文件夹

        if(!file.exists()){
            try {
                if(file.createNewFile()){
                    System.out.println("create success!");
                    
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                System.out.println("create failed!");
            }
        }
        System.out.println(file.exists());
        System.out.println(file.canExecute());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println(file.length());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = simpleDateFormat.format(new Date(file.lastModified()));
        System.out.println(s);
        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());

        // file.createNewFile();//肯定会创建文件，即使路径看起来是文件夹
        // file.mkdir();//肯定会创建文件夹，即使路径看起来是文件
        // file.mkdirs();//肯定会创建文件夹，即使路径看起来是文件

        System.out.println(file.getParent());
        System.out.println(file.getParentFile().getParent());
        for (String string : file.list()) {
            System.out.print(string + "; ");
        }
        System.out.println();
        for (File lf : file.listFiles()) {
            System.out.print(lf.getName() + "; ");
        }
        System.out.println();
*/
    }
}