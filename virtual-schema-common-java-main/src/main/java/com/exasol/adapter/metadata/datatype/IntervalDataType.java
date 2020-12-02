package com.exasol.adapter.metadata.datatype;

public abstract class IntervalDataType extends DataType {

    protected int precision;
    protected IntervalType intervalType;

    public IntervalDataType(final int precision) {
        this.exaDataType = ExaDataType.INTERVAL;
        this.precision = precision;
        this.intervalType = IntervalType.YEAR_TO_MONTH;
    }

    public int getPrecision() {
        return this.precision;
    }

    public IntervalType getIntervalType() {
        return this.intervalType;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("INTERVAL ");
        return builder.toString();
    }

}
