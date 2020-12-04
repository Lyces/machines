package com.yuhtin.minecraft.machines.sql.provider.document.parser;

import com.yuhtin.minecraft.machines.sql.provider.document.Document;

public interface DocumentParser<T> {

    T parse(Document document);

}
