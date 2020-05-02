package com.lq.code.util.jdbc.mode;

/**
 * 列
 * @author qi
 */
public class Column {

    /**
     * TABLE_CAT
     TABLE_SCHEM
     TABLE_NAME
     COLUMN_NAME
     DATA_TYPE
     TYPE_NAME
     COLUMN_SIZE
     BUFFER_LENGTH
     DECIMAL_DIGITS
     NUM_PREC_RADIX
     NULLABLE
     REMARKS
     COLUMN_DEF
     SQL_DATA_TYPE
     SQL_DATETIME_SUB
     CHAR_OCTET_LENGTH
     ORDINAL_POSITION
     IS_NULLABLE
     SCOPE_CATALOG
     SCOPE_SCHEMA
     SCOPE_TABLE
     SOURCE_DATA_TYPE
     IS_AUTOINCREMENT
     IS_GENERATEDCOLUMN
     */

    /**
     *  列名
     */
    private String columnName;
    /**
     *  列大小
     */
    private Integer columnSize;
    /**
     * 默认值
     */
    private String columnDef;
    /**
     * 备注
     */
    private String remarks;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Integer getColumnSize() {
        return columnSize;
    }

    public void setColumnSize(Integer columnSize) {
        this.columnSize = columnSize;
    }

    public String getColumnDef() {
        return columnDef;
    }

    public void setColumnDef(String columnDef) {
        this.columnDef = columnDef;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
