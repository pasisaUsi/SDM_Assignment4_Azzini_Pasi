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

}
