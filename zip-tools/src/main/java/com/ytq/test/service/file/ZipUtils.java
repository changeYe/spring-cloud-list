//package com.ytq.test.service.file;
//
///**
// * @author yuantongqin
// * 2019/4/12
// */
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.*;
//import java.util.UUID;
//import java.util.zip.ZipEntry;
//import java.util.zip.ZipInputStream;
//import java.util.zip.ZipOutputStream;
//
///**
// * 文件或者文件夹的压缩和解压缩，详细看java核心技术卷II，P27，
// * 注意，如果是更新项目，要将原来文件夹及文件夹中的内容全部删除，重新生成UUID及文件夹，在这里由于没有到数据库，就不执行这一步了
// *
// * @author xie
// * @version 1.0
// * @Date 2017/5/30
// */
//@Service
//public class ZipUtils {
//
//    /** 头像图片的放置路径*/
//    @Value("${zipPath.home}")
//    private String ZipDir;
//
//    /**
//     * 获得图片存储路径
//     * @return
//     */
//    public String getZipDir(){
//        return ZipDir;
//    }
//
//    /**
//     * 压缩文件-由于out要在递归外调用，所以封装一个方法
//     * 压缩后的压缩文件的路径和命名，比如 File zipFile = new File("C:/home/myblog/project/32位UUID/test.zip")，
//     *                 但注意解压缩后的文件夹的名字与压缩文件的名字不一定相同，test.zip只是压缩包的名字，
//     *                 在这里我们将test.zip设为fileName.zip，放在32位UUID目录下面，和解压后的项目相同层次，
//     *                 下载完成后也不删除，防止多人下载，服务器每次都要压缩文件
//     *
//     * @param filePath 要压缩的项目的路径
//     * @throws IOException
//     * @return FileHandleResponse 表示压缩结果实体对象
//     */
//    public static FileHandleResponse zipFiles(String filePath) throws IOException{
//        FileHandleResponse fileHandleResponse = new FileHandleResponse();
//
//        //将压缩文件和原项目放到相同目录下，并且相同命名，除了压缩文件以.zip结尾,但注意filePath以/结尾，要处理一下
//        File zipFile = new File(filePath.substring(0,filePath.length()-1)+".zip");
//        File noZipFile = new File(filePath);
//        if(zipFile.exists()){
//            fileHandleResponse.setMessage("压缩文件存在");
//        }else if(!noZipFile.exists()){
//            fileHandleResponse.setSuccess(0);
//            fileHandleResponse.setMessage("请求文件夹或文件不存在！");
//            return fileHandleResponse;
//        }else{
//            try {
//                //创建一个将压缩数据写出到指定的OutputStream的ZipOutputStream
//                ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFile));
//                zipFiles(zipOutputStream, "", noZipFile);
//                zipOutputStream.close();
//                System.out.println("*****************压缩完毕*******************");
//                fileHandleResponse.setMessage("压缩成功");
//            } catch (Exception e) {
//                fileHandleResponse.setSuccess(0);
//                fileHandleResponse.setMessage("服务器异常");
//                e.printStackTrace();
//                return fileHandleResponse;
//            }
//        }
//        fileHandleResponse.setSuccess(1);
//        fileHandleResponse.setUrl(zipFile.getAbsolutePath());
//        return fileHandleResponse;
//    }
//
//    /**
//     * 压缩文件，
//     * 如果是目录，则对目录里的文件重新调用ZipFiles方法，一级目录一级目录的压缩
//     *
//     * @param zipOutputStream 压缩文件输出流
//     * @param fileParentPath 压缩文件的上级目录
//     * @param srcFiles 要压缩的文件，可以压缩1到多个文件，通过写数组的方式或者一个个写到参数列表里面
//     */
//    public static void zipFiles(ZipOutputStream zipOutputStream,String fileParentPath,File... srcFiles){
//        //将目录中的1个或者多个\置换为/，因为在windows目录下，以\或者\\为文件目录分隔符，linux却是/
//        if(fileParentPath!=""){
//            fileParentPath = fileParentPath.replaceAll("\\+", "/");
//            if(!fileParentPath.endsWith("/")){
//                fileParentPath+="/";
//            }
//        }
//        byte[] bytes = new byte[4096];
//        try {
//            /*
//            希望放入zip文件的每一项，都应该创建一个ZipEntry对象，然后将文件名传递给ZipEntry的构造器，它将设置文件日期，解压缩方法等参数，
//            并且需要调用putNextEntry方法来开始写出新文件，并将文件数据放松到zip流中，当完成时，需要调用closeEntry方法。所有文件都重复这一过程。
//             */
//
//            for(int i=0;i<srcFiles.length;i++){
//                //对于目录，递归
//                if(srcFiles[i].isDirectory()){
//                    File[] files = srcFiles[i].listFiles();
//                    String srcPath = srcFiles[i].getName();
//                    srcPath = srcPath.replaceAll("\\+", "/");
//                    if(!srcPath.endsWith("/")){
//                        srcPath+="/";
//                    }
//                    zipOutputStream.putNextEntry(new ZipEntry(fileParentPath+srcPath));
//                    zipFiles(zipOutputStream,fileParentPath+srcPath,files);
//                }
//                //对于文件，发送到ZIP流中，利用4KB的缓冲区，可以考虑使用BufferedInputStream()流过滤器
//                else{
//                    FileInputStream fileInputStream = new FileInputStream(srcFiles[i]);
//                    zipOutputStream.putNextEntry(new ZipEntry(fileParentPath + srcFiles[i].getName()));
//                    int len;
//                    while((len=fileInputStream.read(bytes))>0){
//                        zipOutputStream.write(bytes,0,len);
//                    }
//                    zipOutputStream.closeEntry();
//                    fileInputStream.close();
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 解压文件到指定目录
//     * @param unZipPath 解压路径，比如C:\\home\\myblog\\project\\
//     * @param fileName 解压后的文件名，一般命名为项目名，强制要求用户输入，并且保证不为空，
//     *                 fileName的上层目录为一个随机生成的32位UUID，以保证项目名重复的依然可以保存到服务器
//     * @param multipartFile 上传压缩文件
//     *
//     * @return FileHandleResponse 表示上传结果实体对象
//     */
//    @SuppressWarnings("rawtypes")
//    public static FileHandleResponse unZipFiles(String unZipPath, String fileName, MultipartFile multipartFile)throws IOException{
//        FileHandleResponse fileHandleResponse = new FileHandleResponse();
//
//        String unZipRealPath = unZipPath +UUID.randomUUID().toString().replaceAll("-", "")+ "/"+fileName + "/";
//        //如果保存解压缩文件的目录不存在，则进行创建，并且解压缩后的文件总是放在以fileName命名的文件夹下
//        File unZipFile = new File(unZipRealPath);
//        if (!unZipFile.exists()) {
//            unZipFile.mkdirs();
//        }
//        //ZipInputStream用来读取压缩文件的输入流
//        ZipInputStream zipInputStream = new ZipInputStream(multipartFile.getInputStream());
//        //压缩文档中每一个项为一个zipEntry对象，可以通过getNextEntry方法获得，zipEntry可以是文件，也可以是路径，比如abc/test/路径下
//        ZipEntry zipEntry;
//        try {
//            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
//                String zipEntryName = zipEntry.getName();
//                //将目录中的1个或者多个\置换为/，因为在windows目录下，以\或者\\为文件目录分隔符，linux却是/
//                String outPath = (unZipRealPath + zipEntryName).replaceAll("\\+", "/");
//                //判断所要添加的文件所在路径或者
//                // 所要添加的路径是否存在,不存在则创建文件路径
//                File file = new File(outPath.substring(0, outPath.lastIndexOf('/')));
//                if (!file.exists()) {
//                    file.mkdirs();
//                }
//                //判断文件全路径是否为文件夹,如果是,在上面三行已经创建,不需要解压
//                if (new File(outPath).isDirectory()) {
//                    continue;
//                }
//
//                OutputStream outputStream = new FileOutputStream(outPath);
//                byte[] bytes = new byte[4096];
//                int len;
//                //当read的返回值为-1，表示碰到当前项的结尾，而不是碰到zip文件的末尾
//                while ((len = zipInputStream.read(bytes)) > 0) {
//                    outputStream.write(bytes, 0, len);
//                }
//                outputStream.close();
//                //必须调用closeEntry()方法来读入下一项
//                zipInputStream.closeEntry();
//            }
//            zipInputStream.close();
//            fileHandleResponse.setSuccess(1);
//            fileHandleResponse.setMessage("解压完毕");
//            fileHandleResponse.setUrl((unZipRealPath).replaceAll("\\+", "/"));
//            System.out.println("******************解压完毕********************");
//
//        } catch (Exception e) {
//            fileHandleResponse.setSuccess(0);
//            fileHandleResponse.setMessage("服务器异常");
//            e.printStackTrace();
//            return fileHandleResponse;
//        }
//        return fileHandleResponse;
//    }
//}