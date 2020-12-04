package com.yuhtin.minecraft.machines.sql.provider.document.parser.impl;

import com.google.inject.Inject;
import com.yuhtin.minecraft.machines.api.machine.LocalMachine;
import com.yuhtin.minecraft.machines.manager.MachineManager;
import com.yuhtin.minecraft.machines.sql.provider.document.Document;
import com.yuhtin.minecraft.machines.sql.provider.document.parser.DocumentParser;
import com.yuhtin.minecraft.machines.utils.SimpleLocation;
import com.yuhtin.minecraft.machines.utils.SimpleLocationSerializer;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LocalMachineDocumentParser implements DocumentParser<LocalMachine> {

    @Inject private MachineManager machineManager;

    @Getter private static final LocalMachineDocumentParser instance = new LocalMachineDocumentParser();

    @Override
    public LocalMachine parse(Document document) {

        if (document.isEmpty()) return null;

        return LocalMachine.builder()
                .location(SimpleLocationSerializer.deserialize(document.getString("location")).toBukkit())
                .machine(this.machineManager.get(document.getString("machine")))
                .build();
    }

}
