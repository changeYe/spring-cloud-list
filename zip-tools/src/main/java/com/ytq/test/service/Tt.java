package com.ytq.test.service;

import org.apache.commons.io.FileUtils;

/**
 * @author yuantongqin
 * 2019/4/12
 */
public class Tt {

    public static void main(String[] args) {
        String tempDirectoryPath = FileUtils.getTempDirectoryPath();
        System.out.println(tempDirectoryPath);

        String userDirectoryPath = FileUtils.getUserDirectoryPath();
        System.out.println(userDirectoryPath);
    }

}
