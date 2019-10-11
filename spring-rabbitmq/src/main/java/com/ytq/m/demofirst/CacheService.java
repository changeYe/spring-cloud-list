package com.ytq.m.demofirst;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author yuantongqin
 * 2019/9/22
 */
public class CacheService implements ImportSelector {

    /**
     * 这是两种 不同的动态注入放过,AnnotationMetadata 这是注入的元数据
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
//        annotationMetadata.getAnnotationAttributes(CacheDemo.class.getName());

        return new String[]{CacheDemo.class.getName()};
    }
}
