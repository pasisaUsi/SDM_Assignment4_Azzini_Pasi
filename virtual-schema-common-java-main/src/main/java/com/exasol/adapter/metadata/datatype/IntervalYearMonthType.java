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

}
