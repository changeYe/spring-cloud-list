package com.ytq.test.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * yuantongqin
 * 2019/3/25
 */
public class Tools1 {

    static Logger logger = LoggerFactory.getLogger(Tools1.class);
    public  void ss() {
        String src="/Users/guanguan/Downloads/h_h-20170215.zip";
//        String target ="/Users/guanguan/Downloads/gg/";

        java.util.zip.ZipFile zipFile;//创建ZipInputStream对象
        try {
            //FileInputStream 代表压缩文件的输入流;
            zipFile = new java.util.zip.ZipFile(src);

            // 实例化对象，指明要进行解压的文件
            Enumeration<? extends ZipEntry> entries = zipFile.entries(); // 获取下一个ZipEntry,获取zipfile里面的每一个zipentry实例

            while (entries.hasMoreElements()){
                ZipEntry  entry=entries.nextElement();
                String comment = entry.getComment();
                long compressedSize = entry.getCompressedSize();
                byte[] bytes = entry.getExtra();
                String name = entry.getName();
                long size = entry.getSize();

                logger.info(bytes.length+"==length==name="+name+"=size="+size+"==compressedSize==="+compressedSize);
//
//                File entryDestination = new File(target, entry.getName());
//                if (entry.isDirectory()) {
//                    entryDestination.mkdirs();
//                } else {
//                    entryDestination.getParentFile().mkdirs();
//                    InputStream in = zipFile.getInputStream(entry);
//                    OutputStream out = new FileOutputStream(entryDestination);
//                    IOUtils.copy(in, out);
//                    IOUtils.closeQuietly(in);
//                    out.close();
//                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
