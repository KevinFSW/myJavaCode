package io.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest {

    /**
     * 打印x个缩进
     * 
     * @param x
     */
    private void printXTab(int x) {
        for (int i = 0; i < x; i++) {
            System.out.print("    ");
        }
    }

    /**
     * 遍历给定路径
     * 
     * @param folder
     * @param deep   自己定义的深度，递归开始的时候指定为0，每进入一个文件夹加1
     */
    public void enterFolder(File folder, int deep) {
        if (folder == null) {
            return;
        }

        for (File f : folder.listFiles()) {
            printXTab(deep);// 缩进一下好看而已
            System.out.println(f.getName());// 打印当前成员的名字（也就是文件名或者文件夹名）
            if (f.listFiles() != null && f.listFiles().length != 0) {
                this.enterFolder(f, deep + 1);// 遍历到一个文件夹，继续递归
            }
        }
    }

    /**
     * 遍历给定路径删除
     * 
     * @param folder
     */
    public void deletFolder(File folder) {
        if (folder == null) {
            return;
        }

        for (File f : folder.listFiles()) {
            if (f.listFiles() != null && f.listFiles().length != 0) {
                this.deletFolder(f);// 遍历到一个文件夹，继续递归
            }
            f.delete();// 如果f是文件或者空文件夹，这里删除，如果f是文件夹且非空，会先递归进去删除里面的文件，再出来删除文件夹
        }
    }

    /**
     * 读取文件
     * @param f File
     */
    public void readFileByte(File f) {
        FileInputStream fi = null;
        try {
            fi = new FileInputStream(f);
            int r;
            byte[] b = new byte[8];
            r = fi.read(b);
            while(r != -1){
                System.out.print(new String(b, 0, r));
                // System.out.println(fi.available());//获取流管道内数据的余量
                r = fi.read(b);
            }
            System.out.println();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally{
            try {
                fi.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }

    /**
     * 写文件 FileOutputStream
     * @param f File
     * @param s String
     * @param append
     * @return
     */
    public boolean writerFile(File f, String s, boolean append){
        FileOutputStream fo = null;
        try {
            fo = new FileOutputStream(f, append);
            fo.write(s.getBytes());
            fo.flush();
            return true;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                fo.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        return false;
    }

    /**
     * 文件复制
     * @param source
     * @param destination
     * @param force 简单的强制复制
     * @return
     */
    public Boolean fileCopy(String source, String destination, boolean force){
        File s = new File(source);
        File d = new File(destination);
        FileInputStream fi = null;
        FileOutputStream fo = null;
        if(d.exists()){
            if(force){
                d.delete();
            }
            else{
                return false;
            }
        }
        try {
            fi = new FileInputStream(s);
            fo = new FileOutputStream(d, true);
            byte[] buffer = new byte[16];

            int rlen = fi.read(buffer);
            while (rlen != -1) {
                fo.write(buffer, 0, rlen);
                rlen = fi.read(buffer);
            }

            fo.flush();

            return true;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                fi.close();
                fo.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return false;
    }

    /**
     * 文件复制
     * @param source
     * @param destination
     * @param force
     * @return
     */
    public Boolean fileCopy(File source, File destination, boolean force){
        FileInputStream fi = null;
        FileOutputStream fo = null;
        if(destination.exists()){
            if(force){
                destination.delete();
            }
            else{
                return false;
            }
        }
        try {
            fi = new FileInputStream(source);
            fo = new FileOutputStream(destination, true);
            byte[] buffer = new byte[16];

            int rlen = fi.read(buffer);
            while (rlen != -1) {
                fo.write(buffer, 0, rlen);
                rlen = fi.read(buffer);
            }

            fo.flush();

            return true;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                fi.close();
                fo.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return false;
    }

    /**
     * 文件加密
     * @param filePath
     * @param key
     * @return
     */
    public boolean encryptFile(String filePath, byte key){
        File file = new File(filePath);
        File fileTemp = null;
        FileInputStream fi = null;
        FileOutputStream fo = null;
        boolean ret = false;
        try {
            fileTemp = File.createTempFile("prefix", "txt");
            fo = new FileOutputStream(fileTemp);
            fi = new FileInputStream(file);
            fo.write((byte)(key >>> 4));
            fo.write((byte)(key << 4));
            fo.write(key);
            int rlen = fi.read();
            while(rlen != -1){
                fo.write(rlen^key);
                rlen = fi.read();
            }
            fo.flush();
            fo.close();
            fi.close();
            ret = true;
            return this.fileCopy(fileTemp, file, true);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if(ret == false){
                try {
                    fi.close();
                    fo.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            fileTemp.delete();
        }

        return false;
    }

    /**
     * 文件解密
     * @param filePath
     * @param key
     * @return
     */
    public boolean decryptFile(String filePath, byte key){
        File file = new File(filePath);
        File fileTemp = null;
        FileInputStream fi = null;
        FileOutputStream fo = null;
        boolean ret = false;
        try {
            fileTemp = File.createTempFile("prefix", "txt");
            fo = new FileOutputStream(fileTemp);
            fi = new FileInputStream(file);
            int a = fi.read();
            int b = fi.read();
            int c = fi.read();
            if(!((byte)a == (byte)(key >>> 4) && (byte)b == (byte)(key << 4) && (byte)c == key)){
                return false;
            }
            int rlen = fi.read();
            while(rlen != -1){
                fo.write(rlen^key);
                rlen = fi.read();
            }
            fo.flush();
            fo.close();
            fi.close();
            ret = true;
            return this.fileCopy(fileTemp, file, true);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if(ret == false){
                try {
                    fi.close();
                    fo.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            fileTemp.delete();
        }

        return false;
    }


    public static void main(String[] args) {
        // String filePath = ".//src//io//file//test.txt";// src//io//file//test.txt路径不区分大小写
        // File file = new File(filePath);
        FileTest test = new FileTest();
        // System.out.println(test.writerFile(file, "你好ccccc", false));
        // test.readFileByte(file);
        // System.out.println(test.fileCopy(".//src//io//file//test.txt", ".//src//io//file//testc.txt", true));
        // test.encryptFile(".//src//io//file//testc.txt", (byte)0xf2);
        test.decryptFile(".//src//io//file//testc.txt", (byte)0xf2);
        // test.enterFolder(file, 0);
        // test.deletFolder(file);
        // file.delete();
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