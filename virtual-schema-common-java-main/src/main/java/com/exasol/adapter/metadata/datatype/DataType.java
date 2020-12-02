package com.exasol.adapter.metadata.datatype;

/**
 * Represents an EXASOL data type.
 */
public abstract class DataType {
    public static final int MAX_EXASOL_CHAR_SIZE = 2000;
    public static final int MAX_EXASOL_VARCHAR_SIZE = 2000000;
    public static final int MAX_EXASOL_DECIMAL_PRECISION = 36;

    protected ExaDataType exaDataType;

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((this.exaDataType == null) ? 0 : this.exaDataType.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DataType other = (DataType) obj;
        if (this.exaDataType != other.exaDataType) {
            return false;
        }
        return true;
    }

}