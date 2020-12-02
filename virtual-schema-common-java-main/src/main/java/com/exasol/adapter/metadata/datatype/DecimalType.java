package com.exasol.adapter.metadata.datatype;

public class DecimalType extends DataType {
    private final int precision;
    private final int scale;

    public DecimalType(final int precision, final int scale) {
        this.exaDataType = ExaDataType.DECIMAL;
        this.precision = precision;
        this.scale = scale;
    }

    public int getPrecision() {
        return this.precision;
    }

    public int getScale() {
        return this.scale;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(String.format("DECIMAL(%d, %d)", this.precision, this.scale));
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = (prime * result) + this.precision;
        result = (prime * result) + this.scale;
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
        final DecimalType other = (DecimalType) obj;
        if (this.precision != other.precision) {
            return false;
        }
        if (this.scale != other.scale) {
            return false;
        }
        return true;
    }

}
