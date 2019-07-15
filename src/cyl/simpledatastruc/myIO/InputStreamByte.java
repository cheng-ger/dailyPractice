package cyl.simpledatastruc.myIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-07-15
 */
public class InputStreamByte {

    public static void main(String[] args){
//		input();
//		 fileinput();
//		output();
//		io();
        copy();
    }

    public static void copy(){
        String path = "F:" + File.separator + "IO流" + File.separator + "image.jpg";

        String repath = "F:" + File.separator + "IO流" + File.separator + "imageCopy.jpg";

        InputStream  in = null;

        OutputStream out = null;

        try {
            in = new FileInputStream(path);

            out = new FileOutputStream(repath);

            byte[] by = new byte[1024];

            int totalByte = in.available();

            int loop = totalByte % by.length == 0 ? totalByte / by.length : (totalByte / by.length +1)  ;

            int count = 0;

            int result = -2;

            while((result = in.read(by)) != -1){
                count++;
                if(count == loop){
                    by = change(by);
                    out.write(by);
                }else{
                    out.write(by);
                }
            }
            out.flush();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    //
                    e.printStackTrace();
                }
            }
        }
    }

    public static void io(){
        String path = "F:"+ File.separator  + "IO流" + File.separator +"test.txt";

        String repath = "F:"+ File.separator  + "IO流" + File.separator +"我的中国心.txt";

        InputStream in = null;

        OutputStream out = null;

        try {
            in = new FileInputStream(path);

            out = new FileOutputStream(repath);

            byte[] by = new byte[666];

            int result = -1;

            try {
                while((result = in.read(by)) != -1){
                    if(by[by.length-1] ==0){
                        by = change(by);
                        out.write(by);
                    }else{
                        out.write(by);
                    }
                }
                out.flush();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }



    }

    public static void fileinput(){
        String path = "F:"+ File.separator  + "IO流" + File.separator +"test.txt";
        FileInputStream in = null;

        try {
            in = new FileInputStream(path);
            byte[] b = new byte[666];
            int result = -1;
            try {
                while((result = in.read(b)) != -1){
                    String str = new String(b);
                    System.out.println(str);
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
    public static void fileinput2(){
        String path = "F:"+ File.separator  + "IO流" + File.separator +"test.txt";
        FileInputStream in = null;

        try {
            in = new FileInputStream(path);
//			byte[] b = new byte[666];
            int result = -1;
            try {
                while((result = in.read()) != -1){
//					String str = new String(b);
                    System.out.println((char)result);
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    public static void input(){
        String path = "F:"+ File.separator  + "IO流" + File.separator +"test.txt";

        InputStream in = null;

        try {
            in =new FileInputStream(path);

            byte[] by = new byte[666];
            int result = -1;
            String temp = "";
            try {
                while( (result= in.read(by)) != -1 ){
                    if(by[by.length-1] == 0){
                        by = change(by);
                        String save = new String(by);
                        temp= temp + save;
                    }else{
                        String save = new String(by);
                        temp= temp + save;
                    }

                }
                System.out.println(temp);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    public static void output(){
        String path = "F:"+ File.separator + "IO流" + File.separator + "test.txt";

        OutputStream out = null;

        try {
            out =new FileOutputStream(path,true);

            String str = "我的世界，我的2017年11月8日17:56:28";

            try {
                out.write(str.getBytes());

                out.flush();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
    public static byte[] change (byte[] by){
        if(by == null){
            return null ;
        }
        int index = -1;
        for(int i = 0 ; i < by.length ; i++){
            if(by[i] == 0){
                index = i;
                break;
            }
        }

        if(index == -1){
            return by;
        }

        byte[] b = new byte[index];
        for(int i = 0 ; i < b.length ; i++){
            b[i] = by[i];
        }
        return b;
    }
}
