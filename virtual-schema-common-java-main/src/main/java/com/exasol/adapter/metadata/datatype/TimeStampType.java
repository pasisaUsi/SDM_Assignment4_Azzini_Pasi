package com.exasol.adapter.metadata.datatype;

public class TimeStampType extends DataType {
    private final boolean withLocalTimezone;

    public TimeStampType(final boolean withLocalTimezone) {
        this.exaDataType = ExaDataType.TIMESTAMP;
        this.withLocalTimezone = withLocalTimezone;
    }

    @Override
    public boolean isWithLocalTimezone() {
        return this.withLocalTimezone;
    }

    // Dimenticato il toString
}
