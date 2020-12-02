package com.exasol.adapter.metadata;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.exasol.adapter.metadata.datatype.*;

class TableMetadataTest {
    private TableMetadata tableMetadata;

    @BeforeEach
    void setUp() {
        final List<ColumnMetadata> columns = new ArrayList<>();
        columns.add(ColumnMetadata.builder().name("C1").type(new Bool()).build());
        columns.add(ColumnMetadata.builder().name("C2").type(new VarChar(70, ExaCharset.ASCII)).build());
        final String name = "FooBar";
        this.tableMetadata = new TableMetadata(name, "", columns, "");
    }

    @Test
    void testDescribe() {
        assertThat(this.tableMetadata.describe(), equalTo("FooBar (C1 BOOLEAN, C2 VARCHAR(70) ASCII)"));
    }

    @Test
    void testToString() {
        assertThat(this.tableMetadata.toString(),
                equalTo("TableMetadata{name=FooBar, adapterNotes=, "
                        + "columns=[ColumnMetadata{name=\"C1\", adapterNotes=\"\", type=BOOLEAN, "
                        + "isNullable=true, isIdentity=false}, ColumnMetadata{name=\"C2\", adapterNotes=\"\", "
                        + "type=VARCHAR(70) ASCII, isNullable=true, isIdentity=false}], comment=}\n"));
    }
}