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

}
