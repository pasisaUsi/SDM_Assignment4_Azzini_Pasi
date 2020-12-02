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

    public int getSize() {
        return this.size;
    }

    public ExaCharset getCharset() {
        return this.charset;
    }

    @Override
    public String toString() {
        return String.format("CHAR(%d) ", this.size) + this.charset.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = (prime * result) + ((this.charset == null) ? 0 : this.charset.hashCode());
        result = (prime * result) + this.size;
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CharType other = (CharType) obj;
        if (this.charset != other.charset) {
            return false;
        }
        return this.size == other.size;
    }

}
