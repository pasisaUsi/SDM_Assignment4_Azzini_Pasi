package com.exasol.adapter.metadata.datatype;

public class IntervalDaySecondType extends IntervalDataType {
    private final int fraction;

    public IntervalDaySecondType(final int precision, final int fraction) {
        super(precision);
        this.fraction = fraction;
    }

    public int getIntervalFraction() {
        return this.fraction;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append(String.format("DAY (%d) TO SECOND (%d)", this.precision, this.fraction));
        return builder.toString();
    }

}
