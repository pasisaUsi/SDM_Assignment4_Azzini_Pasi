package com.exasol.adapter.metadata.datatype;

public class Geometry extends DataType {
    public int geometrySrid;

    public Geometry(final int geometrySrid) {
        this.exaDataType = ExaDataType.GEOMETRY;
        this.geometrySrid = geometrySrid;
    }

    @Override
    public int getGeometrySrid() {
        return this.geometrySrid;
    }

}
