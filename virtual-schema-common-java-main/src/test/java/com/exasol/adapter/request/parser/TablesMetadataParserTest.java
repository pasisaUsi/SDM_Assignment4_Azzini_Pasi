package com.exasol.adapter.request.parser;

import static com.exasol.adapter.metadata.datatype.ExaCharset.ASCII;
import static com.exasol.adapter.metadata.datatype.ExaCharset.UTF8;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.json.*;

import org.junit.jupiter.api.Test;

import com.exasol.adapter.metadata.ColumnMetadata;
import com.exasol.adapter.metadata.TableMetadata;
import com.exasol.adapter.metadata.datatype.*;

class TablesMetadataParserTest {
    @Test
    void testParseMetadata() throws IOException {
        final List<ColumnMetadata> tableColumns = new ArrayList<>();
        tableColumns.add(ColumnMetadata.builder().name("ID").adapterNotes("").type(new DecimalType(22, 0))
                .nullable(true).identity(true).defaultValue("").comment("").build());
        tableColumns.add(ColumnMetadata.builder().name("USER_ID").adapterNotes("").type(new DecimalType(18, 0))
                .nullable(true).identity(true).defaultValue("").comment("").build());
        tableColumns.add(ColumnMetadata.builder().name("URL").adapterNotes("").type(new VarCharType(1000, UTF8))
                .nullable(true).identity(true).defaultValue("").comment("").build());
        tableColumns.add(ColumnMetadata.builder().name("REQUEST_TIME").adapterNotes("").type(new TimeStampType(false))
                .nullable(true).identity(true).defaultValue("").comment("").build());
        final List<TableMetadata> expectedInvolvedTablesMetadata = new ArrayList<>();
        expectedInvolvedTablesMetadata.add(new TableMetadata("CLICKS", "", tableColumns, ""));
        final JsonArray tablesAsJson = readInvolvedTablesFromJsonFile("target/test-classes/pushdown_request.json");
        final TablesMetadataParser tablesMetadataParser = new TablesMetadataParser();
        final List<TableMetadata> tables = tablesMetadataParser.parse(tablesAsJson);
        assertThat(tables, equalTo(expectedInvolvedTablesMetadata));
    }

    private JsonArray readInvolvedTablesFromJsonFile(final String file) throws IOException {
        final String rawRequest = readFile(new File(file), Charset.defaultCharset());
        final JsonArray tablesAsJson;
        try (final JsonReader reader = Json.createReader(new StringReader(rawRequest))) {
            tablesAsJson = reader.readObject().getJsonArray(RequestParserConstants.INVOLVED_TABLES_KEY);
        }
        return tablesAsJson;
    }

    private String readFile(final File file, final Charset charset) throws IOException {
        return new String(Files.readAllBytes(file.toPath()), charset);
    }

    @Test
    void testParseTablesMetadataAllColumnsTypes() throws IOException {
        final List<TableMetadata> expectedInvolvedTablesMetadata = createExpectedTableMetadata();
        final JsonArray tablesAsJson = readInvolvedTablesFromJsonFile(
                "target/test-classes/pushdown_request_alltypes.json");
        final TablesMetadataParser tablesMetadataParser = new TablesMetadataParser();
        final List<TableMetadata> tables = tablesMetadataParser.parse(tablesAsJson);
        assertThat(tables, equalTo(expectedInvolvedTablesMetadata));
    }

    private List<TableMetadata> createExpectedTableMetadata() {
        final List<ColumnMetadata> tableColumns = new ArrayList<>();
        tableColumns.add(ColumnMetadata.builder().name("C_DECIMAL").adapterNotes("").type(new DecimalType(18, 2))
                .nullable(true).identity(true).defaultValue("").comment("").build());
        tableColumns.add(ColumnMetadata.builder().name("C_DOUBLE").adapterNotes("").type(new DoubleType())
                .nullable(true).identity(true).defaultValue("").comment("").build());
        tableColumns.add(ColumnMetadata.builder().name("C_VARCHAR_UTF8_1").adapterNotes("")
                .type(new VarCharType(10000, UTF8)).nullable(true).identity(true).defaultValue("").comment("").build());
        tableColumns.add(ColumnMetadata.builder().name("C_VARCHAR_UTF8_2").adapterNotes("")
                .type(new VarCharType(10000, UTF8)).nullable(true).identity(true).defaultValue("").comment("").build());
        tableColumns.add(
                ColumnMetadata.builder().name("C_VARCHAR_ASCII").adapterNotes("").type(new VarCharType(10000, ASCII))
                        .nullable(true).identity(true).defaultValue("").comment("").build());
        tableColumns.add(ColumnMetadata.builder().name("C_CHAR_UTF8_1").adapterNotes("").type(new CharType(3, UTF8))
                .nullable(true).identity(true).defaultValue("").comment("").build());
        tableColumns.add(ColumnMetadata.builder().name("C_CHAR_UTF8_2").adapterNotes("").type(new CharType(3, UTF8))
                .nullable(true).identity(true).defaultValue("").comment("").build());
        tableColumns.add(ColumnMetadata.builder().name("C_CHAR_ASCII").adapterNotes("").type(new CharType(3, ASCII))
                .nullable(true).identity(true).defaultValue("").comment("").build());
        tableColumns.add(ColumnMetadata.builder().name("C_DATE").adapterNotes("").type(new DateType()).nullable(true)
                .identity(true).defaultValue("").comment("").build());
        tableColumns.add(ColumnMetadata.builder().name("C_TIMESTAMP_1").adapterNotes("").type(new TimeStampType(false))
                .nullable(true).identity(true).defaultValue("").comment("").build());
        tableColumns.add(ColumnMetadata.builder().name("C_TIMESTAMP_2").adapterNotes("").type(new TimeStampType(false))
                .nullable(true).identity(true).defaultValue("").comment("").build());
        tableColumns.add(ColumnMetadata.builder().name("C_TIMESTAMP_3").adapterNotes("").type(new TimeStampType(true))
                .nullable(true).identity(true).defaultValue("").comment("").build());
        tableColumns.add(ColumnMetadata.builder().name("C_BOOLEAN").adapterNotes("").type(new BoolType()).nullable(true)
                .identity(true).defaultValue("").comment("").build());
        tableColumns.add(ColumnMetadata.builder().name("C_GEOMETRY").adapterNotes("").type(new GeometryType(1))
                .nullable(true).identity(true).defaultValue("").comment("").build());
        tableColumns.add(ColumnMetadata.builder().name("C_HASHTYPE").adapterNotes("").type(new HashType(16))
                .nullable(true).identity(true).defaultValue("").comment("").build());
        tableColumns.add(
                ColumnMetadata.builder().name("C_INTERVAL_DS_1").adapterNotes("").type(new IntervalDaySecondType(2, 3))
                        .nullable(true).identity(true).defaultValue("").comment("").build());
        tableColumns.add(
                ColumnMetadata.builder().name("C_INTERVAL_DS_2").adapterNotes("").type(new IntervalDaySecondType(3, 4))
                        .nullable(true).identity(true).defaultValue("").comment("").build());
        tableColumns.add(ColumnMetadata.builder().name("C_INTERVAL_YM_1").adapterNotes("")
                .type(new IntervalYearMonthType(2)).nullable(true).identity(true).defaultValue("").comment("").build());
        tableColumns.add(ColumnMetadata.builder().name("C_INTERVAL_YM_2").adapterNotes("")
                .type(new IntervalYearMonthType(3)).nullable(true).identity(true).defaultValue("").comment("").build());
        final List<TableMetadata> expectedInvolvedTablesMetadata = new ArrayList<>();
        expectedInvolvedTablesMetadata.add(new TableMetadata("T1", "", tableColumns, ""));
        return expectedInvolvedTablesMetadata;
    }
}