//package com.ytq.test.service.file;
//
///**
// * @author yuantongqin
// * 2019/4/12
// */
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.nio.ByteBuffer;
//import java.nio.channels.FileChannel;
//import java.util.LinkedList;
//import java.util.List;
//
///**
// * 压缩文件上传，并且解压缩后放到服务器响应目录下，
// * 为什么不直接放压缩包，因为别人看一次，需要解压缩一次，也很浪费系统资源
// *
// * @author xie
// * @version 1.0
// * @Date 2017/5/27
// */
//@Service
//public class FileService {
//
//    @Autowired
//    ZipUtils zipUtils;
//
//    /**
//     * 默认上传zip压缩格式
//     * @param file 上传的文件
//     * @return 上传的结果UploadResponse对象
//     * @throws IOException
//     */
//    public FileHandleResponse uploadFileZip(MultipartFile file, String fileName) throws IOException {
//        FileHandleResponse fileHandleResponse;
//        try {
//            fileHandleResponse = zipUtils.unZipFiles(zipUtils.getZipDir(), fileName, file);
//            return fileHandleResponse;
//        } catch (Exception e) {
//            // 请求失败时打印的异常的信息
//            fileHandleResponse = new FileHandleResponse();
//            fileHandleResponse.setSuccess(0);
//            fileHandleResponse.setMessage("服务器异常！");
//            return fileHandleResponse;
//        }
//    }
//
//    /**
//     *  下载压缩后的项目文件
//     *
//     * @param filePath 项目路径
//     * @return 文件处理结果实体，其中url表示项目压缩后的路径
//     * @throws IOException
//     */
//    public FileHandleResponse downloadFileZip(String filePath) throws IOException {
//        FileHandleResponse fileHandleResponse;
//        try {
//            fileHandleResponse = zipUtils.zipFiles(filePath);
//            return fileHandleResponse;
//        } catch (Exception e) {
//            // 请求失败时打印的异常的信息
//            fileHandleResponse = new FileHandleResponse();
//            fileHandleResponse.setSuccess(0);
//            fileHandleResponse.setMessage("服务器异常！");
//            return fileHandleResponse;
//        }
//    }
//
//    /**
//     *  返回某一结点（即文件夹）的下一级所有子节点，注意这里输入的不是具体文件或者不存在的路径，是已经判定存在的文件夹路径，
//     *  如果是请求具体文件或者不存在的路径，在上一层controller层就应该将文件内容读取并返回或者返回错误信息
//     *
//     * @param filePath 项目路径
//     * @param relativePath 节点相比项目路径的相对路径，比如项目路径：
//     *                     C:/home/myblog/project/dccb182a7ded477483362ce46be1eb5c/123/
//     *                     那么节点路径src/main/java/表示
//     *                     C:/home/myblog/project/dccb182a7ded477483362ce46be1eb5c/123/src/main/java/
//     *                     但是由于files[i].getName()只会获得abc这样的单层目录名或者abc.java这样的文件名，因此我们要设置下一级的相对路径为;
//     *                     relativePath+files[i].getName()(如果是路径，还要包含/)
//     *
//     * @return 所有子节点的列表
//     * @throws IOException
//     */
//    public List<JstreeNode> getAllChildrenNode(String filePath,String relativePath) throws IOException {
//        File file = new File(filePath+relativePath);
//        List<JstreeNode> list = new LinkedList<>();
//        try {
//            //对于文件夹，我们要遍历它的下一级子节点
//            File[] files = file.listFiles();
//            JstreeNode jstreeNode;
//            for (int i = 0; i < files.length; i++) {
//                //目录
//                if (files[i].isDirectory()) {
//                    jstreeNode = new JstreeNode();
//                    jstreeNode.setId(relativePath+files[i].getName() + "/");
//                    jstreeNode.setText(files[i].getName());
//                    jstreeNode.setHasChildren(true);
//                    jstreeNode.setType(0);
//                    list.add(jstreeNode);
//                }
//                //文件
//                else {
//                    jstreeNode = new JstreeNode();
//                    jstreeNode.setId(relativePath+files[i].getName());
//                    jstreeNode.setText(files[i].getName());
//                    jstreeNode.setHasChildren(false);
//                    jstreeNode.setType(1);
//                    list.add(jstreeNode);
//                }
//            }
//            return list;
//        } catch (Exception e) {
//            // 请求失败时打印的异常的信息
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    /**
//     * NIO方式读取file文件为byte[]
//     *
//     * @param filename 文件名，要求包含文件绝对路径
//     * @return 文件的byte[]形式
//     * @throws IOException
//     */
//    public byte[] toByteArray(String filename) throws IOException {
//        File file = new File(filename);
//        /*
//        Java NIO中的FileChannel是一个连接到文件的通道。可以通过文件通道读写文件。FileChannel无法设置为非阻塞模式，它总是运行在阻塞模式下。
//        在使用FileChannel之前，必须先打开它。但是，我们无法直接打开一个FileChannel，需要通过使用一个InputStream、OutputStream或RandomAccessFile来获取一个FileChannel实例。
//        FileChannel实例的size()方法将返回该实例所关联文件的大小。
//         */
//        FileChannel channel = null;
//        FileInputStream fileInputStream = null;
//        try {
//            fileInputStream = new FileInputStream(file);
//            channel = fileInputStream.getChannel();
//            //所分配的ByteBuffer的容量
//            ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());
//            /*
//            FileChannel.read()方法。该方法将数据从FileChannel读取到Buffer中。read()方法返回的int值表示了有多少字节被读到了Buffer中。
//            如果返回-1，表示到了文件末尾。
//             */
//            while ((channel.read(byteBuffer)) > 0) {
//                // do nothing
//                // System.out.println("reading");
//            }
//            return byteBuffer.array();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                channel.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                fileInputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return null;
//    }
//}
