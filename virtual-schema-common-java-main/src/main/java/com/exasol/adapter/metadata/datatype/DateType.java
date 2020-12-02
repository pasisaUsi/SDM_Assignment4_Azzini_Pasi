package com.exasol.adapter.metadata.datatype;

public class DateType extends DataType {

    public DateType() {
        this.exaDataType = ExaDataType.DATE;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("DATE");
        return builder.toString();
    }

}
