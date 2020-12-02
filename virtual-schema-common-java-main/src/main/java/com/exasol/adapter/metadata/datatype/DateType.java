package com.exasol.adapter.metadata.datatype;

public class DateType extends DataType {

    public DateType() {
        this.exaDataType = ExaDataType.DATE;
    }

    @Override
    public String toString() {
        return "DATE";
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
