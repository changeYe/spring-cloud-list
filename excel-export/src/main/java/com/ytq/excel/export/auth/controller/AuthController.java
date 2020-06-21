package com.ytq.excel.export.auth.controller;

import com.kunchi.ic.m4c.ffc.api.SaleOutExecuteForFFCApi;
import com.kunchi.ic.m4c.obc.dto.SaleOutExecuteVO;
import com.kunchi.ic.m4c.obc.dto.SaleOutQryVO;
import com.kunchi.nc.base.entity.response.NCResult;
import com.ytq.excel.export.auth.entity.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yuantongqin
 * description:
 * 2020/3/28
 */
@RestController
@Slf4j
public class AuthController {


//
    @Autowired
    private SaleOutExecuteForFFCApi saleOutExecuteForFFCApi;
@Autowired
private RestTemplate restTemplate;
//
//    @Autowired
//    private MemberInfoRemote memberInfoRemote;
//
//    @Autowired
//    private NCInfoRemote ncInfoRemote;
//
//
//
//    @GetMapping(value = "/hello",produces="application/json;charset=UTF-8")
//    public String getHello(){// produces="application/json;charset=UTF-8"
//        List<String> orderList = new ArrayList<>();
//        orderList.add("82063997200470547");
//        SaleOutQryVO saleOutQryVO = new SaleOutQryVO();
//        saleOutQryVO.setPo(orderList);
//        Object namea = ncInfoRemote.getNameA(saleOutQryVO);
//        System.out.println("哈哈哈="+namea);
//
//
//        Aa a = new Aa();
//        a.setPhone("12222222");
//        Object name = memberInfoRemote.getName(a);
//        System.out.println(name);
//        return "你好";
//    }

    @GetMapping("/user")
    public UserDTO getUser( UserDTO name) throws NoSuchMethodException {

        List<String> orderList = new ArrayList<>();
        orderList.add("82063997200470547");
        SaleOutQryVO saleOutQryVO = new SaleOutQryVO();
        saleOutQryVO.setPo(orderList);


//        http://nc-spi/nc-spi/spi/saleOut_executeQuery
//        nc-dev-1-tech.ikunchi.com:80
//        http://nc-dev-1-tech.ikunchi.com:80/nc-spi/spi/saleOut_executeQuery
//
//        http://sg-dev-tech.ikunchi.com:80/nc-spi/nc-spi/spi/
//
//        NCResult<List<SaleOutExecuteVO>> process = saleOutExecuteForFFCApi.process(saleOutQryVO);
//        System.out.println("结果："+process);
//        try {
//            SaleOutExecuteForFFCApi  saleOutExecuteForFFCApi = new SaleOutExecuteForFFCApi();
//            getServiceName = saleOutExecuteForFFCApi.getClass().getSuperclass().getSuperclass().getDeclaredMethod("getServiceName", null);
//            getServiceName.setAccessible(true);
//            String invoke = (String) getServiceName.invoke(saleOutExecuteForFFCApi, null);
//            System.out.println(invoke);
//
//            String s = uri.replaceFirst(invoke, invoke+"/"+invoke);
            String s = "http://nc-spi/nc-spi/spi/saleOut_executeQuery";
        String uri = saleOutExecuteForFFCApi.getURI();
        System.out.println(uri);
//            ResponseEntity<String> responseEntity = this.restTemplate.postForEntity(s, saleOutQryVO, String.class, new Object[0]);
//            System.out.println("结果："+responseEntity);
        NCResult<List<SaleOutExecuteVO>> process = saleOutExecuteForFFCApi.process(saleOutQryVO);
        System.out.println(process);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }


////
//        NCResult<List<SaleOutExecuteVO>> process = saleOutExecuteForFFCApi.process(saleOutQryVO);
//        System.out.println(process.toString());

        System.out.println(name.toString());
        UserDTO userDTO = new UserDTO();
        userDTO.setTime(LocalDateTime.now());
        return userDTO;
    }


    protected boolean isHttps() {
        return Boolean.FALSE;
    }


//    public String getURI() {
//        StringBuffer url = new StringBuffer();
//        if (this.isHttps()) {
//            url.append("https");
//        } else {
//            url.append("http");
//        }
//
//        url.append("://");
//        url.append(this.getServiceName());
//        url.append("/");
//        url.append(this.getServiceName());
//        url.append("/");
//        url.append("spi");
//        url.append("/");
//        url.append(this.getBasePath());
//        return url.toString();
//    }

//
//    public static void main(String[] args) {
//
//        Method getServiceName = null;
//        try {
//            SaleOutExecuteForFFCApi  saleOutExecuteForFFCApi = new SaleOutExecuteForFFCApi();
//            getServiceName = saleOutExecuteForFFCApi.getClass().getSuperclass().getSuperclass().getDeclaredMethod("getServiceName", null);
//            getServiceName.setAccessible(true);
//            String invoke = (String) getServiceName.invoke(saleOutExecuteForFFCApi, null);
//            System.out.println(invoke);
//
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//
//
//        String a = "http://nc-dev-1-tech.ikunchi.com:80/nc-spi/spi/saleOut_executeQuery";
//        String s = a.replaceFirst("nc-spi", "nc-spi/nc-spi");
//        System.out.println(s);
//
//    }

}
