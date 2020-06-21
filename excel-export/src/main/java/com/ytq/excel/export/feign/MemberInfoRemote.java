//package com.ytq.excel.export.feign;
//
//import com.kunchi.ic.m4c.obc.dto.SaleOutQryVO;
//import com.ytq.excel.export.feign.hystrix.MemberInfoHystrix;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
///**
// * @author yuantongqin
// * desc: 获取会员信息
// * 2020-05-24
// */
////@FeignClient(value = "nc-spi",fallback = MemberInfoHystrix.class)
//@FeignClient(value = "kshop-member-server",fallback = MemberInfoHystrix.class)
//public interface MemberInfoRemote {
//
//
//
//    @GetMapping(value = "/nc-spi/spi/saleOut_executeQuery", produces="application/json;charset=UTF-8")
////    @GetMapping(value = "/nc-spi/spi/saleOut_executeQuery")
//    Object getNameA(@RequestBody SaleOutQryVO saleOutQryVO);
//
//    @GetMapping(value = "/get/memberInfo/byPhone/", produces="application/json;charset=UTF-8")
////    @GetMapping(value = "/nc-spi/spi/saleOut_executeQuery")
//    Object getName(@RequestBody Aa saleOutQryVO);
//
//}
