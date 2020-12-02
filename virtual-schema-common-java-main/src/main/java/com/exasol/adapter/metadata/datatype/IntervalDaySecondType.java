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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = (prime * result) + this.fraction;
        return result;
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
        final IntervalDaySecondType other = (IntervalDaySecondType) obj;
        if (this.fraction != other.fraction) {
            return false;
        }
        return true;
    }

}
