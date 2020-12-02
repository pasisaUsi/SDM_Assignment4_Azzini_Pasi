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
        return String.format("GEOMETRY(%d)", this.geometrySrid);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = (prime * result) + this.geometrySrid;
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
        final GeometryType other = (GeometryType) obj;
        return this.geometrySrid == other.geometrySrid;
    }

}
