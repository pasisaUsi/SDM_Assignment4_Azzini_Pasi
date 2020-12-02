package com.exasol.adapter.metadata.datatype;

public class TimeStampType extends DataType {
    private final boolean withLocalTimezone;

    public TimeStampType(final boolean withLocalTimezone) {
        this.exaDataType = ExaDataType.TIMESTAMP;
        this.withLocalTimezone = withLocalTimezone;
    }

    public boolean isWithLocalTimezone() {
        return this.withLocalTimezone;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("TIMESTAMP");
        if (this.withLocalTimezone) {
            builder.append(" WITH LOCAL TIME ZONE");
        }
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = (prime * result) + (this.withLocalTimezone ? 1231 : 1237);
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
        final TimeStampType other = (TimeStampType) obj;
        return this.withLocalTimezone == other.withLocalTimezone;
    }

}
