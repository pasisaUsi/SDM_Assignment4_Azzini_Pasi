package com.exasol.adapter.metadata.datatype;

public class DoubleType extends DataType {

    public DoubleType() {
        this.exaDataType = ExaDataType.DOUBLE;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("DOUBLE");
        return builder.toString();
    }
}
