package com.ytq.data.config.valid;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import java.util.List;
import java.util.Set;

/**
 * @author yuantongqin
 * description:
 * 2020/3/12
 */
public class ValidUtil {

    private final static int MaxIndex=10;
    public static  <T> ISBResult<T> verification(ISBResult<T> isbResult){

        T t = isbResult.getBody();
        List<ISBFieldError> ifrList = isbResult.getValidationErrors();
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        if(t instanceof List){
            int j=0;
            for(int i=0;i<((List) t).size();i++){
                if(j > MaxIndex){
                    break;
                }
                Set<ConstraintViolation<Object>> constraintViolations = validator.validate(((List) t).get(i));
                for(ConstraintViolation constraintViolation:constraintViolations) {
                    ISBFieldError isbFieldEr=new ISBFieldError();
                    isbFieldEr.setFieldName(constraintViolation.getPropertyPath().toString());
                    isbFieldEr.setErrorMessage(constraintViolation.getMessage());
                    isbFieldEr.setIndex(i);
                    ifrList.add(isbFieldEr);
                    j++;
                }
            }
        }else{
            Set<ConstraintViolation<T>> constraintViolations = validator.validate(t);
            for(ConstraintViolation constraintViolation:constraintViolations) {
                ISBFieldError isbFieldError=new ISBFieldError(constraintViolation.getPropertyPath().toString(),constraintViolation.getMessage(),null);
                ifrList.add(isbFieldError);
            }
        }
//        if(ifrList.size()!=0){
//            isbResult.markRefused();
//        }
        return isbResult;
    }
}
