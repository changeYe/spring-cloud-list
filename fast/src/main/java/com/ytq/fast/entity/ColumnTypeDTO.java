package com.ytq.fast.entity;

/**
 * @author yuantongqin
 * 2019/9/26
 */
public class ColumnTypeDTO {


    public  class Param{
        private Integer id;

        private Integer parentId;

        private String columnType;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getParentId() {
            return parentId;
        }

        public void setParentId(Integer parentId) {
            this.parentId = parentId;
        }

        public String getColumnType() {
            return columnType;
        }

        public void setColumnType(String columnType) {
            this.columnType = columnType;
        }
    }




}
