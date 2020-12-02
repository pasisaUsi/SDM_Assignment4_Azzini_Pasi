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
        if (this.geometrySrid != other.geometrySrid) {
            return false;
        }
        return true;
    }

}
