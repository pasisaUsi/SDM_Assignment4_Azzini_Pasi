package com.exasol.adapter.metadata.datatype;

public class UnsupportedType extends DataType {

    public UnsupportedType() {
        this.exaDataType = ExaDataType.UNSUPPORTED;
    }

    @Override
    public String toString() {
        return "UNSUPPORTED";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        return getClass() == obj.getClass();
    }

}
