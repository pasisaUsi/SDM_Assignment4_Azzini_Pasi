package com.exasol.adapter.metadata.datatype;

import java.util.Objects;

/**
 * Represents an EXASOL data type.
 */
public abstract class DataType {
    public static final int MAX_EXASOL_CHAR_SIZE = 2000;
    public static final int MAX_EXASOL_VARCHAR_SIZE = 2000000;
    public static final int MAX_EXASOL_DECIMAL_PRECISION = 36;

    protected ExaDataType exaDataType;
    private int precision;
    private int scale;
    private int size;
    private ExaCharset charset;
    private boolean withLocalTimezone;
    private int geometrySrid;
    private IntervalType intervalType;
    private int intervalFraction;
    private int byteSize;

    protected DataType() {
        // prevent instantiation
    }

    /**
     * Get the Exasol data type without parameters
     *
     * @return Exasol data type
     */
    public ExaDataType getExaDataType() {
        return this.exaDataType;
    }

    /**
     * Check if the data type is supported.
     *
     * @return {@code true} if the data type is supported by the Virtual Schema.
     */
    public boolean isSupported() {
        return this.exaDataType != ExaDataType.UNSUPPORTED;
    }

    @Override
    abstract public String toString();

    private void appendGeometry(final StringBuilder builder) {
        builder.append("GEOMETRY");
        builder.append("(");
        builder.append(this.geometrySrid);
        builder.append(")");
    }

    private void appendTimestamp(final StringBuilder builder) {
        builder.append("TIMESTAMP");
        if (this.withLocalTimezone) {
            builder.append(" WITH LOCAL TIME ZONE");
        }
    }

    private void appendLiteralValue(final StringBuilder builder, final String toAppend) {
        builder.append(toAppend);
        builder.append("(");
        builder.append(this.size);
        builder.append(") ");
        builder.append(this.charset.toString());
    }

    private void appendDecimal(final StringBuilder builder) {
        builder.append("DECIMAL(");
        builder.append(this.precision);
        builder.append(", ");
        builder.append(this.scale);
        builder.append(")");
    }

    private void appendOneString(final StringBuilder builder, final String toAppend) {
        builder.append(toAppend);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if ((o == null) || (getClass() != o.getClass())) {
            return false;
        }
        final DataType dataType = (DataType) o;
        return (this.precision == dataType.precision) && (this.scale == dataType.scale) && (this.size == dataType.size)
                && (this.withLocalTimezone == dataType.withLocalTimezone)
                && (this.geometrySrid == dataType.geometrySrid) && (this.intervalFraction == dataType.intervalFraction)
                && (this.exaDataType == dataType.exaDataType) && (this.charset == dataType.charset)
                && (this.intervalType == dataType.intervalType) && (this.byteSize == dataType.byteSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.exaDataType, this.precision, this.scale, this.size, this.charset,
                this.withLocalTimezone, this.geometrySrid, this.intervalType, this.intervalFraction, this.byteSize);
    }
}