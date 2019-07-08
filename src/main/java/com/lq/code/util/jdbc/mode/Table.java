package com.lq.code.util.jdbc.mode;

import java.util.List;

/**
 * 数据库表
 * Created by qi_liang on 2018/6/2.
 */
public class Table {

    /**
     * TABLE_CAT
     TABLE_SCHEM
     TABLE_NAME
     TABLE_TYPE
     REMARKS
     TYPE_CAT
     TYPE_SCHEM
     TYPE_NAME
     SELF_REFERENCING_COL_NAME
     REF_GENERATION
     */
    //类别
    private String tableCat;
    //模式
    private String tableSchem;
    //表名
    private String tableName;
    //表类型
    private String tableType;
    //备注
    private String remarks;
    //类型的类别
    private String typeCat;
    //类型模式
    private String typeSchem;
    //类型名称
    private String typeName;
    // 有类型表的指定 "identifier" 的列的名称
    private String  selfReferencingColName;
    //
 //   private String refGeneration;

    private List<Column> columns;

    public String getTableCat() {
        return tableCat;
    }

    public void setTableCat(String tableCat) {
        this.tableCat = tableCat;
    }


    public String getTableSchem() {
        return tableSchem;
    }

    public void setTableSchem(String tableSchem) {
        this.tableSchem = tableSchem;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableType() {
        return tableType;
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTypeCat() {
        return typeCat;
    }

    public void setTypeCat(String typeCat) {
        this.typeCat = typeCat;
    }

    public String getTypeSchem() {
        return typeSchem;
    }

    public void setTypeSchem(String typeSchem) {
        this.typeSchem = typeSchem;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getSelfReferencingColName() {
        return selfReferencingColName;
    }

    public void setSelfReferencingColName(String selfReferencingColName) {
        this.selfReferencingColName = selfReferencingColName;
    }

//    public String getRefGeneration() {
//        return refGeneration;
//    }
//
//    public void setRefGeneration(String refGeneration) {
//        this.refGeneration = refGeneration;
//    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }
}
