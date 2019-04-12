//package com.ytq.test.service.file;
//
///**
// * @author yuantongqin
// * 2019/4/12
// */
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.*;
//import java.util.List;
//
///**
// * 实现项目zip压缩包的上传，自动解压，解压后的预览，包括文本和字符串，项目的压缩下载，
// * 由于java.util.zip包不支持汉字的问题，在项目压缩包内请勿包含中文文件名，但是在页面中的项目名可以起名为中文，
// * 可以用org.apache.tools.zip压缩/解压缩zip文件,解决中文乱码问题。
// *
// * @author xie
// * @version 1.0
// * @Date 2017/5/26
// */
//@Controller
//public class FileController {
//    @Autowired
//    FileService fileService;
//
//    /**
//     * 主页
//     * @return
//     */
//    @RequestMapping(path = {"/"}, method = {RequestMethod.GET, RequestMethod.POST})
//    public String index() {
//        return "upload_zip";
//    }
//
//    /**
//     * 上传压缩zip项目文件
//     * @param file zip压缩文件
//     * @param fileName 项目的命名，我们将解压缩的文件放到以项目名命名的文件夹内，为了保证项目名重复的也可以上传，项目名文件夹外部还有一个32位UUID命名的文件夹，
//     *                 只不过取出项目时没有显示
//     * @return 结果的json字符串
//     */
//    @RequestMapping(path = {"/admin/file/zip/upload"}, method = {RequestMethod.GET, RequestMethod.POST})
//    @ResponseBody
//    public String uploadZipFile(@RequestParam("file-zip") MultipartFile file,@RequestParam("file-name")String fileName) {
//        FileHandleResponse fileHandleResponse = new FileHandleResponse();
//        try {
//            if(file.isEmpty()){
//                fileHandleResponse.setSuccess(0);
//                fileHandleResponse.setMessage("上传压缩文件为空");
//                return JSON.toJSONString(fileHandleResponse);
//            }
//            fileHandleResponse = fileService.uploadFileZip(file,fileName);
//            return JSON.toJSONString(fileHandleResponse);
//        }catch (Exception e) {
//            fileHandleResponse.setSuccess(0);
//            fileHandleResponse.setMessage("服务器异常！");
//            fileHandleResponse.setUrl(null);
//            return JSON.toJSONString(fileHandleResponse);
//        }
//    }
//
//    /**
//     * 展示上传的zip项目解压缩后的文件结构
//     * @param filePath 项目的路径，比如，C:\home\myblog\project\2d76c7aa844b4585a53d982d205099e2\123\其中123为项目名，
//     * @param model
//     * @return
//     */
//    @RequestMapping(path = {"/admin/file/zip/show"}, method = {RequestMethod.GET, RequestMethod.POST})
//    public String showZipFile(@RequestParam("file-path")String filePath, Model model) {
//        model.addAttribute("filePath",filePath);
//        //filePath地址大概样子，C:\home\myblog\project\2d76c7aa844b4585a53d982d205099e2\123\,windows和linux不同，
//        // 包含文件名，我们提取出来，作为fileName，分隔符可能为/或\或\\，其中\要转意为\\
//        String fileName = filePath.split("\\|\\\\|/")[filePath.split("\\|\\\\|/").length-1];
//        model.addAttribute("fileName",fileName);
//        return "show_zip";
//    }
//
//    /**
//     * 项目展示页面
//     * @param filePath 项目路径
//     * @param relativePath 节点相比项目路径的相对路径，比如项目路径：
//     *                     C:/home/myblog/project/dccb182a7ded477483362ce46be1eb5c/123/
//     *                     那么节点路径src/main/java/表示
//     *                     C:/home/myblog/project/dccb182a7ded477483362ce46be1eb5c/123/src/main/java/
//     * @return 对于文件，返回字符内容的json字符串，对于文件夹，返回文件夹的下一级所有子文件和子文件夹，其实若文件是图片，我们在下面的getImage()方法中处理
//     */
//    @RequestMapping(path = {"/admin/file/zip/show.action"}, method = {RequestMethod.GET, RequestMethod.POST})
//    @ResponseBody
//    public String showZipFileDetail(@RequestParam("file-path") String filePath, @RequestParam("id") String relativePath, Model model) {
//        FileHandleResponse fileHandleResponse = new FileHandleResponse();
//        try {
//            if (relativePath.equals("#")) {    //表示第一次打开页面的请求,relativePath为#，没什么意义，设为空字符串
//                relativePath = "";
//            }
//            File file = new File(filePath+relativePath);
//
//            //如果请求路径存在，即文件或者目录存在
//            if (file.exists()) {
//                //分为文件或者文件夹两种情况
//                if (file.isFile()) {
//                    BufferedReader bufferedReader;
//                    try {
//                        StringBuilder stringBuilder = new StringBuilder();
//                        //将字节流向字符流的转换,并创建字符流缓冲区
//                        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
//                        // 每次读入一行
//                        String read;
//                        //每读入一行，要加一个换行符
//                        String lineText="\n";
//                        while ((read = bufferedReader.readLine()) != null) {
//                            stringBuilder.append(read+lineText);
//                        }
//                        bufferedReader.close();
//                        fileHandleResponse.setSuccess(1);
//                        fileHandleResponse.setMessage("请求成功！");
//                        model.addAttribute("result", fileHandleResponse);
//                        model.addAttribute("fileContent", stringBuilder.toString());
//                        return JSON.toJSONString(model);
//                    } catch (Exception e1) {
//                        e1.printStackTrace();
//                    }
//                } else {
//                    List<JstreeNode> list = fileService.getAllChildrenNode(filePath,relativePath);
//                    JSONArray jsonArray = new JSONArray();
//                    for(JstreeNode jstreeNode : list){
//                        JSONObject jsonObject = new JSONObject();
//                        jsonObject.put("id", jstreeNode.getId());
//                        jsonObject.put("text", jstreeNode.getText());
//                        jsonObject.put("children", jstreeNode.isHasChildren());
//                        jsonObject.put("type",jstreeNode.getType());
//                        jsonArray.add(jsonObject);
//                    }
//                    fileHandleResponse.setSuccess(1);
//                    fileHandleResponse.setMessage("请求成功！");
//                    model.addAttribute("result", fileHandleResponse);
//                    //最好不要直接传递list，前端不可以很好的解析
//                    model.addAttribute("array", jsonArray);
//                    return JSON.toJSONString(model);
//                }
//            } else {            //如果请求路径不存在
//                fileHandleResponse.setSuccess(0);
//                fileHandleResponse.setMessage("请求路径不存在！");
//                model.addAttribute("result",fileHandleResponse);
//                return JSON.toJSONString(model);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    /**
//     * 将项目压缩后以字节流的方式发送
//     * @param filePath 项目路径
//     * @param response
//     */
//    @RequestMapping(path = {"/admin/file/zip/download"}, method = {RequestMethod.GET})
//    public void downloadZipFile(@RequestParam("file-path")String filePath, HttpServletResponse response) {
//        FileHandleResponse fileHandleResponse;
//        try {
//            fileHandleResponse = fileService.downloadFileZip(filePath);
//            //地址大概样子，C:\home\myblog\project\2d76c7aa844b4585a53d982d205099e2\123.zip,windows和linux不同，
//            // 包含文件名，我们提取出来，作为fileName，分隔符可能为/或\或\\，其中\要转意为\\
//            String fileName = fileHandleResponse.getUrl().split("\\|/|\\\\")[fileHandleResponse.getUrl().split("\\|/|\\\\").length-1];
//            response.setContentType("application/zip");
//            response.setCharacterEncoding("UTF-8");
//
//            response.setHeader("Content-Disposition","attachment;filename="+fileName);
//            OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
//            byte[] data = fileService.toByteArray(fileHandleResponse.getUrl());
//            outputStream.write(data);
//            outputStream.flush();
//            outputStream.close();
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 按照图片路径查找图片
//     * @param filePath 项目路径
//     * @param relativePath 节点相比项目路径的相对路径，比如项目路径：
//     *                     C:/home/myblog/project/dccb182a7ded477483362ce46be1eb5c/123/
//     *                     那么节点路径src/main/java/表示
//     *                     C:/home/myblog/project/dccb182a7ded477483362ce46be1eb5c/123/src/main/java/
//     * @param response
//     */
//    @RequestMapping(path = "/admin/file/zip/image.action")
//    public void getImage(@RequestParam("file-path") String filePath,
//                         @RequestParam("id") String relativePath,
//                         HttpServletResponse response) {
//        try {
//            byte[] data = fileService.toByteArray(filePath+relativePath);
//            response.setCharacterEncoding("UTF-8");
//            OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
//            outputStream.write(data);
//            outputStream.flush();
//            outputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}