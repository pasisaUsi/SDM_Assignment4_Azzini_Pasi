package com.exasol.adapter.metadata.datatype;

public class HashType extends DataType {
    private final int byteSize;

    public HashType(final int byteSize) {
        this.exaDataType = ExaDataType.HASHTYPE;
        this.byteSize = byteSize;

    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("HASHTYPE");
        builder.append(String.format("(%d byte)", this.byteSize));
        return builder.toString();
    }

    public int getByteSize() {
        return this.byteSize;
    }

}
