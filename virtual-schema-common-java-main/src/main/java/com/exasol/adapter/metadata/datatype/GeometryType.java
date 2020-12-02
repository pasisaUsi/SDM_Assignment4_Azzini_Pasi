package com.exasol.adapter.metadata.datatype;

public class GeometryType extends DataType {
    private final int geometrySrid;

    public GeometryType(final int geometrySrid) {
        this.exaDataType = ExaDataType.GEOMETRY;
        this.geometrySrid = geometrySrid;
    }

    public int getGeometrySrid() {
        return this.geometrySrid;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(String.format("GEOMETRY(%d)", this.geometrySrid));
        return builder.toString();
    }

}
