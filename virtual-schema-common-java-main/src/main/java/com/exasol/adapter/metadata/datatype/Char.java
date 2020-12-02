package com.exasol.adapter.metadata.datatype;

public class Char extends DataType {
    private final int size;
    private final ExaCharset charset;

    public Char(final int size, final ExaCharset charset) {
        this.exaDataType = ExaDataType.CHAR;
        this.size = size;
        this.charset = charset;
    }

    public Char(final ExaCharset charset) {
        this(MAX_EXASOL_CHAR_SIZE, charset);
    }
    // Dimenticato il toString

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public ExaCharset getCharset() {
        return this.charset;
    }
}
