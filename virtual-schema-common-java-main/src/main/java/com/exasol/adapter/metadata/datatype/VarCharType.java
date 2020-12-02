package com.exasol.adapter.metadata.datatype;

public class VarCharType extends DataType {
    private final int size;
    private final ExaCharset charset;

    public VarCharType(final int size, final ExaCharset charset) {
        this.exaDataType = ExaDataType.VARCHAR;
        this.size = size;
        this.charset = charset;
    }

    public VarCharType(final ExaCharset charset) {
        this(MAX_EXASOL_VARCHAR_SIZE, charset);
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public ExaCharset getCharset() {
        return this.charset;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("VARCHAR");
        builder.append(String.format("(%d)", this.size));
        builder.append(this.charset.toString());
        return builder.toString();
    }
}
