package com.exasol.adapter.metadata.datatype;

public class IntervalYearMonthType extends DataType {
    private final int precision;
    private final IntervalType intervalType;

    public IntervalYearMonthType(final int precision) {
        this.exaDataType = ExaDataType.INTERVAL;
        this.precision = precision;
        this.intervalType = IntervalType.YEAR_TO_MONTH;
    }

    @Override
    public int getPrecision() {
        return this.precision;
    }

    @Override
    public IntervalType getIntervalType() {
        return this.intervalType;
    }

}
