package cyl.simpledatastruc.myIO;

import java.io.*;
import java.util.Date;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-07-15
 */
public class FileIOUtil {


    public static void main(String[] args) throws Exception {
       // fileOpr();
       // jugFileExists();
        // inputStreamByte();
       // outputStreamByte();
        // inOutputStreamByte();
//        dataOutputStreamByte();
        //dataInputStreamByte();
//        inputStreamReader();
//        outputStreamReader();
//        outputStreamReader2();
//        bufferWriter();
        bufferReader();

    }


    public static void fileOpr() {
        String path="D:" + File.separator + "www" ;    //指定文件所在的目录
        File f=new File(path);    //建立File变量,并设定由f变量引用
        System.out.println("文件信息如下：");
        System.out.println("============================================");
        System.out.println("文件长度："+f.length()+"字节");
        System.out.println("文件或者目录："+(f.isFile()?"是文件":"不是文件"));
        System.out.println("文件或者目录："+(f.isDirectory()?"是目录":"不是目录"));
        System.out.println("是否可读："+(f.canRead()?"可读取":"不可读取"));
        System.out.println("是否可写："+(f.canWrite()?"可写入":"不可写入"));
        System.out.println("是否隐藏："+(f.isHidden()?"是隐藏文件":"不是隐藏文件"));
        System.out.println("最后修改日期："+new Date(f.lastModified()));
        System.out.println("文件名称："+f.getName());
        System.out.println("文件路径："+f.getPath());
        System.out.println("绝对路径："+f.getAbsolutePath());

    }

    public static void jugFileExists() throws IOException {
        String path="D:" + File.separator + "wwww" + File.separator + "test" ;
        File fDir = new File(path );
        if(!fDir.exists()){
            fDir.mkdirs();
        }

        String fileName = "c.txt";

        File f = new File(path , fileName);

        if(f.exists()){
            f.delete();
        }

        f.createNewFile();


    }


    //用字节流读取
    public static void  inputStreamByte() throws  Exception {

        String path="D:" + File.separator + "wwww" + File.separator + "test" + File.separator + "c.txt" ;

        InputStream in = new FileInputStream(path);

        byte[] bytes = new byte[1024];
        StringBuffer stringBuffer = new StringBuffer();
        //int result  = -2;
        while ( in.read(bytes) != -1) {
            String str = new String(bytes);
            System.out.println(str);
        }
        in.close();
    }

    //用字节流输出
    public static void outputStreamByte() throws Exception {
        String path="D:" + File.separator + "wwww" + File.separator + "test" + File.separator + "d.txt" ;
        OutputStream out = new FileOutputStream(path, true);

        out.write("d.txt".getBytes());
        out.write("\r\n".getBytes());  //此处为换行
        out.close();
    }

    //用字节流输入输出（复制） 可用与任何方式
    public static void inOutputStreamByte() throws Exception {
        String path="D:" + File.separator + "wwww" + File.separator + "test" + File.separator + "d.txt" ;
        String repath="D:" + File.separator + "wwww" + File.separator + "test" + File.separator + "e.txt" ;
        InputStream in = new FileInputStream(path);
        OutputStream out = new FileOutputStream(repath,false);

        int totalByte = in.available();

        int loop = totalByte % 1024 == 0 ? totalByte / 1024 : totalByte / 1024 + 1;

        int count = 0;
        byte[] bytes = new byte[1024];

        while( ( in.read(bytes) ) != -1 ){
            count++;
            if(count == loop){
                int len = totalByte - 1024 * (count - 1);

                byte[] by = new byte[len];

                for(int i = 0 ; i < len ; i++){
                    by[i] = bytes[i];
                }

                out.write(by);
            }else{
                out.write(bytes);
               // out.write("\r\n".getBytes());
            }

        }
        out.close();
    }


    //字节流输入（）
    public  static  void dataOutputStreamByte() throws Exception {
        String path="D:" + File.separator + "wwww" + File.separator + "test" + File.separator + "f.txt" ;

        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(path));

        dataOutputStream.writeUTF("哈哈");

        dataOutputStream.close();

    }

    //字节流输入 //只能一个字节一个字节读
    public  static  void dataInputStreamByte() throws Exception {

        String path="D:" + File.separator + "wwww" + File.separator + "test" + File.separator + "f.txt" ;


        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(path));

        System.out.println(dataInputStream.readUTF());
    }

    //字符流输入
    public static void inputStreamReader() throws Exception {
        String path="D:" + File.separator + "wwww" + File.separator + "test" + File.separator + "g.txt" ;

       InputStreamReader inputStreamReader = new  InputStreamReader(new FileInputStream(path));

        char[] chars = new char[1024];


        while (inputStreamReader.read(chars) != -1) {
            String str = new String(chars);
            System.out.println(str);
        }

        inputStreamReader.close();
    }




    //字符流输出
    public static void outputStreamReader() throws Exception {
        String path="D:" + File.separator + "wwww" + File.separator + "test" + File.separator + "g.txt" ;
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(path));

       out.write("程远亮");
       out.flush();
       out.close();

    }

    //字符流输出
    public static void outputStreamReader2() throws Exception {
        String path="D:" + File.separator + "wwww" + File.separator + "test" + File.separator + "h.txt" ;
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(path));

        out.write("aaaa".getBytes());
        out.flush();
        out.close();

    }

    //用bufferReader 用这种方式
    public  static void bufferWriter() throws  Exception{
        String path="D:" + File.separator + "wwww" + File.separator + "test" + File.separator + "num.txt" ;
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)));
        bufferedWriter.write("1");
        bufferedWriter.newLine();
        bufferedWriter.write("10");

        bufferedWriter.flush();
        bufferedWriter.close();
    }

    //用bufferReader
    public  static void bufferReader() throws Exception{

        String path="D:" + File.separator + "wwww" + File.separator + "test" + File.separator + "num.txt" ;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));

        String str = null;
        /*while( (str = bufferedReader.readLine() ) != null ){
            //System.out.println(str);
            //System.out.println(bufferedReader.readLine());
        }*/


        //如果没空一行有数据的话
        do{
            System.out.println(bufferedReader.readLine());
        }while(( bufferedReader.readLine() ) != null);
        bufferedReader.close();
    }



    private static void selectSort(int[] ints) {

        for (int i = 0; i < ints.length ; i++) {

            int minIndex = -1;
            for (int j = i; j < ints.length ; j++) {
                if(ints[minIndex] > ints[j]){
                    minIndex = j;
                }
            }

            if(minIndex != -1){
                int temp = ints[i];

                ints[i] =ints[minIndex];

                ints[minIndex] =temp;
            }

        }
    }


    private static void insertSort(int[] ints){
        int temp;
        for (int i = 1; i < ints.length; i++) {

            for (int j = 0; j < i; j++) {
                if(ints[i]  < ints[j]){
                    temp = ints[i];
                    ints[i] = ints[j];
                    ints[j] = temp;

                }
            }
        }
    }

}
