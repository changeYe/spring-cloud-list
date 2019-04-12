package com.ytq.test.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.BaseInputStream;
import net.lingala.zip4j.io.ZipInputStream;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.unzip.UnzipUtil;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * yuantongqin
 * 2019/3/25
 */
public class Tools {


    static Logger logger = LoggerFactory.getLogger(Tools.class);
    public static Map<String, byte[]> uncompress(InputStream inputStream) throws IOException {

        java.util.zip.ZipInputStream zis = new java.util.zip.ZipInputStream(inputStream);
        Map<String, byte[]> map = new HashMap<>();
        ZipEntry ze = null;

        while (true) {
            ze = zis.getNextEntry();
            if(ze != null){
                String name = ze.getName();
                if(name == null||name.contains("__MACOSX")||ze.isDirectory()){
                    continue;
                }
                long size = ze.getSize();
                byte[] extra = ze.getExtra();
                long compressedSize = ze.getCompressedSize();
                logger.info(name+"==name=="+size+"==size=="+compressedSize+"==compressedSize==extra="+extra.length);

            }else{
                break;
            }
            //            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//            byte[] buffer = new byte[10240];
//            int length = -1;
//            while ((length = zis.read(buffer, 0, buffer.length)) > -1) {
//                byteArrayOutputStream.write(buffer, 0, length);
//            }
//            map.put(name, byteArrayOutputStream.toByteArray());
//            byteArrayOutputStream.close();
        }
        zis.close();
        return map;
    }

}
