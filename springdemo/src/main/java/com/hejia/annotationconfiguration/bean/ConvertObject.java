package com.hejia.annotationconfiguration.bean;

import com.hejia.annotationconfiguration.enums.Format;
import org.springframework.beans.factory.annotation.Value;

public class ConvertObject {
    @Value("${car.num}")
    private Format format;

    public ConvertObject() {
    }

    public ConvertObject(Format format) {
        this.format = format;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "ConvertObject{" +
                "format=" + format +
                '}';
    }
}
