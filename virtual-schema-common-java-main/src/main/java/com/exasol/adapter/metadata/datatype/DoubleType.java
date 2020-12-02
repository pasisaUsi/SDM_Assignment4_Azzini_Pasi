package com.exasol.adapter.metadata.datatype;

public class DoubleType extends DataType {

    public DoubleType() {
        this.exaDataType = ExaDataType.DOUBLE;
    }

    @Override
    public String toString() {
        return "DOUBLE";
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
