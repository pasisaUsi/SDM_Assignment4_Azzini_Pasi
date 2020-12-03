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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = (prime * result) + ((this.intervalType == null) ? 0 : this.intervalType.hashCode());
        result = (prime * result) + this.precision;
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
        final IntervalDataType other = (IntervalDataType) obj;
        if (this.intervalType != other.intervalType) {
            return false;
        }
        return this.precision == other.precision;

    }

}
