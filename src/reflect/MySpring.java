package reflect;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;

public class MySpring {

    private File file = null;
    private BufferedReader br = null;
    private Integer parameterNumInFile = 0;

    public MySpring() {
        this.parameterNumInFile = 0;
    }

    public MySpring(File file) {
        this.file = file;
        this.parameterNumInFile = getParameterNumInFile();
    }

    private boolean initBufferReader() {
        if (this.br != null) {
            return true;
        }

        if (this.file == null) {
            return false;
        }

        try {
            this.br = new BufferedReader(new FileReader(this.file));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }

        return true;
    }

    private Object[] initParameterOfConstructor(Constructor<?> constructor) throws Exception {
        int parameterCount = constructor.getParameterCount();
        Parameter[] parameters = constructor.getParameters();
        // 创建Object素组，在调用构造方法的时候要用到
        Object[] objects = new Object[parameterCount];
        String[] strings = null;
        // 如果配置了文件，从文件中拿参数
        if (initBufferReader()) {
            String readStr = this.br.readLine();
            if(readStr != null){
                strings = readStr.split(",");
                if (strings == null || strings.length != parameterCount) {
                    // 文件内的参数跟需要的对不上
                    strings = null;
                }
            }
        }
        if (strings == null) {
            // 没有指定预定的参数，生成默认参数
            strings = new String[parameterCount];
            for (int i = 0; i < strings.length; i++) {
                strings[i] = new String("0");
            }
        }
        // 把参数放到Object数组中
        for (int i = 0; i < parameterCount; i++) {
            ///////////////// 获取参数的类型////////////获取该类型的构造方法/////////创建一个该类型的对象
            objects[i] = parameters[i].getType().getConstructor(String.class).newInstance(strings[i]);
        }

        return objects;
    }

    private Integer getParameterNumInFile() {
        if(initBufferReader()){
            int num = 0;
            try {
                num = this.br.readLine().split(",").length;
                this.br.close();
                this.br = null;
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                num = 0;
            }
            return num;
        }

        return 0;
    }

    public Object getBeanObject(String className) {
        Object obj = null;
        try {
            // 根据类名获取Class
            Class<?> clazz = Class.forName(className);
            try {
                // 获取类的构造方法
                Constructor<?>[] constructors = clazz.getConstructors();
                if (constructors.length == 1) { // 只有一个构造方法
                    try {
                        // 获取构造方法的参数个数
                        int parameterCount = constructors[0].getParameterCount();
                        if (parameterCount == 0) {
                            // 没有参数直接创建对象
                            obj = constructors[0].newInstance();
                        } else {
                            // 需要参数，获取参数列表
                            Object[] objects = initParameterOfConstructor(constructors[0]);
                            // 创建对象
                            obj = constructors[0].newInstance(objects);
                        }
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } else {
                    for (Constructor<?> constructor : constructors) {
                        try {
                            if (this.file != null) {
                                if(this.parameterNumInFile != constructor.getParameterCount()){
                                    continue;
                                }
                                // 需要参数，获取参数列表
                                Object[] objects = initParameterOfConstructor(constructor);
                                // 创建对象
                                obj = constructor.newInstance(objects);
                                break;
                            }
                            else if(constructor.getParameterCount() == 0){
                                obj = constructor.newInstance();
                                break;
                            }
                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                            break;
                        }
                    }
                }
            } catch (SecurityException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return obj;
    }
}
