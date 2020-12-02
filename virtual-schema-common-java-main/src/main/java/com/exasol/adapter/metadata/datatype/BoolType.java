package com.exasol.adapter.metadata.datatype;

public class BoolType extends DataType {

    public BoolType() {
        this.exaDataType = ExaDataType.BOOLEAN;
    }

    @Override
    public String toString() {
        return "BOOLEAN";
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
