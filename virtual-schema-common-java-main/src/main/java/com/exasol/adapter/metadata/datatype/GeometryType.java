package com.exasol.adapter.metadata.datatype;

public class GeometryType extends DataType {
    private final int geometrySrid;

    public GeometryType(final int geometrySrid) {
        this.exaDataType = ExaDataType.GEOMETRY;
        this.geometrySrid = geometrySrid;
    }

    @Override
    public int getGeometrySrid() {
        return this.geometrySrid;
    }

}
