package com.exasol.adapter.metadata.datatype;

public class IntervalDaySecondType extends IntervalDataType {
    private final int fraction;

    public IntervalDaySecondType(final int precision, final int fraction) {
        super(precision);
        this.intervalType = IntervalType.DAY_TO_SECOND;
        this.fraction = fraction;
    }

    public int getIntervalFraction() {
        return this.fraction;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("DAY (%d) TO SECOND (%d)", this.precision, this.fraction);
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
        return this.fraction == other.fraction;
    }

}
