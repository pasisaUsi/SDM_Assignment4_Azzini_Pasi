package com.exasol.adapter.metadata.datatype;

public class CharType extends DataType {
    private final int size;
    private final ExaCharset charset;

    public CharType(final int size, final ExaCharset charset) {
        this.exaDataType = ExaDataType.CHAR;
        this.size = size;
        this.charset = charset;
    }

    public CharType(final ExaCharset charset) {
        this(MAX_EXASOL_CHAR_SIZE, charset);
    }
    // Dimenticato il toString

    public int getSize() {
        return this.size;
    }

    public ExaCharset getCharset() {
        return this.charset;
    }
}
