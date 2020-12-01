package com.exasol.adapter.metadata;

import java.util.List;

/**
 * Represents the metadata of an EXASOL Virtual Schema, including tables and columns. These metadata are are returned by
 * the Adapter when creating a virtual schema or when the adapter updates the metadata (during refresh or set property).
 */
public class SchemaMetadata {
    private final String adapterNotes;
    private final List<TableMetadata> tables;

    public SchemaMetadata(final String adapterNotes, final List<TableMetadata> tables) {
        this.adapterNotes = adapterNotes;
        this.tables = tables;
    }

    public String getAdapterNotes() {
        return adapterNotes;
    }

    public List<TableMetadata> getTables() {
        return tables;
    }
}
