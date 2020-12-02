package com.exasol.adapter.metadata.datatype;

public class IntervalYearMonthType extends IntervalDataType {

    public IntervalYearMonthType(final int precision) {
        super(precision);
    }

    @Override
    public String toString() {
        return super.toString() + String.format("YEAR (%d) TO MONTH", this.precision);
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
