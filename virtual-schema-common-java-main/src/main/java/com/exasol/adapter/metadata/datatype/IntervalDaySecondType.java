package com.exasol.adapter.metadata.datatype;

public class IntervalDaySecondType extends DataType {
    private final int precision;
    private final int fraction;
    private final IntervalType intervalType;

    public IntervalDaySecondType(final int precision, final int fraction) {
        this.exaDataType = ExaDataType.INTERVAL;
        this.precision = precision;
        this.fraction = fraction;
        this.intervalType = IntervalType.DAY_TO_SECOND;
    }

    @Override
    public int getPrecision() {
        return this.precision;
    }

    public int getFraction() {
        return this.fraction;
    }

    @Override
    public IntervalType getIntervalType() {
        return this.intervalType;
    }

}
