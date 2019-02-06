package com.file.parser.processor;

import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.cellprocessor.ift.StringCellProcessor;
import org.supercsv.util.CsvContext;

public class TrimProcessor extends CellProcessorAdaptor implements StringCellProcessor {

    private boolean isNullable;

    public TrimProcessor() {
    }

    public TrimProcessor(StringCellProcessor next, boolean isNullable) {
        super(next);
        this.isNullable = isNullable;
    }

    public Object execute(Object value, CsvContext context) {

        if (isNullable == false) {
            this.validateInputNotNull(value, context);
        }
        String result = "";
        if (value != null) {
            result = value.toString().trim();
        }
        return this.next.execute(result, context);
    }
}