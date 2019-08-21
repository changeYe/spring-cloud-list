package com.ytq.m.validate;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yuantongqin
 * 2019/7/31
 */
public class VdataUtil<T> {

    Logger logger = LoggerFactory.getLogger(VdataUtil.class);

    private final static int MaxIndex=10;
    public T verification(T t){
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        if(t instanceof List){
            int j=0;
            for(int i=0;i<((List) t).size();i++){
                if(j > MaxIndex){
                    break;
                }
                Set<ConstraintViolation<Object>> constraintViolations = validator.validate(((List) t).get(i));
                for(ConstraintViolation constraintViolation:constraintViolations) {
                    logger.info("name:"+constraintViolation.getPropertyPath().toString());
                    logger.info("message:"+constraintViolation.getMessage());
                    logger.info("index:"+i);
                    j++;
                }
            }
        }else{
            Set<ConstraintViolation<T>> constraintViolations = validator.validate(t);
            for(ConstraintViolation constraintViolation:constraintViolations) {
                logger.info("nameg:"+constraintViolation.getPropertyPath().toString());
                logger.info("msggg:"+constraintViolation.getMessage());
            }
        }

        return t;
    }

}
