package com.ytq.data.config.valid;

import java.util.List;

/**
 * @author yuantongqin
 * description:
 * 2020/3/12
 */
public class ISBFieldError {
    public ISBFieldError() {
    }
    public ISBFieldError(String fieldName, String errorMessage, Object errorValue) {
        this.fieldName = fieldName;
        this.errorMessage = errorMessage;
        this.errorValue = errorValue;
    }

    public ISBFieldError (String fieldName, String errorMessage, Object errorValue,Integer index) {
        this.fieldName = fieldName;
        this.errorMessage = errorMessage;
        this.errorValue = errorValue;
        this.index = index;
    }

//    @ApiModelProperty(value = "验证不通过的位置,可以是字段,也可以是标记", name = "出错的位置,可以是字段,也可以是标记", example = "name")
    private String fieldName = null;

//    @ApiModelProperty(value = "验证不通过的原因", name = "解释出错的原因", example = "Can't be null")
    private String errorMessage = null;

//    @ApiModelProperty(value = "数组返回列表异常坐标", name = "数组返回列表异常坐标", example = "1")
    private Integer index;

//    @ApiModelProperty(value = "验证不通过的原始值", name = "验证不通过的原始值", example = "0")
    private Object errorValue = null;

    private List<ISBFieldError> isbFieldErrors;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Object getErrorValue() {
        return errorValue;
    }

    public void setErrorValue(Object errorValue) {
        this.errorValue = errorValue;
    }

    public List<ISBFieldError> getIsbFieldErrors() {
        return isbFieldErrors;
    }

    public void setIsbFieldErrors(List<ISBFieldError> isbFieldErrors) {
        this.isbFieldErrors = isbFieldErrors;
    }

    public Integer getIndex(){
        return index;
    }

    public void setIndex(Integer index){
        this.index=index;

    }
}
