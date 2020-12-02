package com.exasol.adapter.metadata.datatype;

public class TimeStamp extends DataType {
    public boolean withLocalTimezone;

    public TimeStamp(final boolean withLocalTimezone) {
        this.exaDataType = ExaDataType.TIMESTAMP;
        this.withLocalTimezone = withLocalTimezone;
    }

    @Override
    public boolean isWithLocalTimezone() {
        return this.withLocalTimezone;
    }

    // Dimenticato il toString
}
