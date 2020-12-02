package com.exasol.adapter.metadata.datatype;

public class DecimalType extends DataType {
    private final int precision;
    private final int scale;

    public DecimalType(final int precision, final int scale) {
        this.exaDataType = ExaDataType.DECIMAL;
        this.precision = precision;
        this.scale = scale;
    }

    // Dimenticato il toString

    @Override
    public int getPrecision() {
        return this.precision;
    }

    @Override
    public int getScale() {
        return this.scale;
    }

}
