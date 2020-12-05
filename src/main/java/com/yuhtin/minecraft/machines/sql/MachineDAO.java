package com.yuhtin.minecraft.machines.sql;

import com.google.inject.Singleton;
import com.yuhtin.minecraft.machines.api.machine.LocalMachine;
import com.yuhtin.minecraft.machines.sql.provider.DatabaseProvider;
import com.yuhtin.minecraft.machines.sql.provider.document.parser.impl.LocalMachineDocumentParser;
import com.yuhtin.minecraft.machines.utils.SimpleLocation;
import com.yuhtin.minecraft.machines.utils.SimpleLocationSerializer;

@Singleton
public class MachineDAO extends DatabaseProvider {

    public void createTable() {
        update("create table if not exists `machines` ("
                + "`owner` char(16) not null,"
                + "`location` text not null, "
                + "`machine` text not null"
                + ");");

        update("create table if not exists `player_drops` ("
                + "`name` char(16) not null, "
                + "`drop` text not null"
                + ");");
    }

    public LocalMachine findAll() {
        return query("select * from `machines`")
                .parse(LocalMachineDocumentParser.getInstance());
    }

    public void insertMachine(String name, LocalMachine localMachine) {

        update("insert into `machines` values (?, ?, ?);",
                name,
                SimpleLocationSerializer.serialize(new SimpleLocation(localMachine.getLocation())),
                localMachine.getMachine().getName());
    }
    
}
