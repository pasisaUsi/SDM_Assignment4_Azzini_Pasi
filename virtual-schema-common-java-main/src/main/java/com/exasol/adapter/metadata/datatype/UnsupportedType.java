package com.exasol.adapter.metadata.datatype;

public class UnsupportedType extends DataType {

    public UnsupportedType() {
        this.exaDataType = ExaDataType.UNSUPPORTED;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("UNSUPPORTED");
        return builder.toString();
    }

}
