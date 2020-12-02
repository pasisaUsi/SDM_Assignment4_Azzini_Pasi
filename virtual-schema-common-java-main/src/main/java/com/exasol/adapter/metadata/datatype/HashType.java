package com.exasol.adapter.metadata.datatype;

public class HashType extends DataType {
    private final int byteSize;

    public HashType(final int byteSize) {
        this.exaDataType = ExaDataType.HASHTYPE;
        this.byteSize = byteSize;

    }

    @Override
    public int getByteSize() {
        return this.byteSize;
    }

}
