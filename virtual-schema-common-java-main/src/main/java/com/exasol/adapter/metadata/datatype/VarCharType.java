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

    public int getSize() {
        return this.size;
    }

    public ExaCharset getCharset() {
        return this.charset;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(String.format("VARCHAR(%d)", this.size));
        builder.append(this.charset.toString());
        return builder.toString();
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
        final VarCharType other = (VarCharType) obj;
        if (this.charset != other.charset) {
            return false;
        }
        if (this.size != other.size) {
            return false;
        }
        return true;
    }

}
