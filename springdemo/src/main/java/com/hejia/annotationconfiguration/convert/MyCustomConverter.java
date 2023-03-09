package com.hejia.annotationconfiguration.convert;

import com.hejia.annotationconfiguration.enums.Format;
import org.springframework.core.convert.converter.Converter;

public class MyCustomConverter implements Converter<String, Format> {

    @Override
    public Format convert(String source) {
        return Format.DVD;
    }
}
