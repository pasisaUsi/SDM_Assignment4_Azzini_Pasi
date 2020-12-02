package com.exasol.adapter.metadata.datatype;

public class HashType extends DataType {
    private final int byteSize;

    public HashType(final int byteSize) {
        this.exaDataType = ExaDataType.HASHTYPE;
        this.byteSize = byteSize;

    }

    public int getByteSize() {
        return this.byteSize;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("HASHTYPE");
        builder.append(String.format("(%d byte)", this.byteSize));
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = (prime * result) + this.byteSize;
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
        final HashType other = (HashType) obj;
        if (this.byteSize != other.byteSize) {
            return false;
        }
        return true;
    }

}
