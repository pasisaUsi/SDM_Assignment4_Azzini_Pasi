package com.exasol.adapter.metadata.datatype;

public class IntervalYearMonthType extends IntervalDataType {

    public IntervalYearMonthType(final int precision) {
        super(precision);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append(String.format("YEAR (%d) TO MONTH", this.precision));
        return builder.toString();
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
        if (getClass() != obj.getClass()) {
            return false;
        }
        return true;
    }

}
