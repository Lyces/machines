package com.yuhtin.minecraft.machines.sql;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.yuhtin.minecraft.steelbosses.api.player.BossPlayer;
import com.yuhtin.minecraft.steelbosses.sql.provider.DatabaseProvider;
import com.yuhtin.minecraft.steelbosses.sql.provider.document.parser.impl.BossPlayerDocumentParser;
import com.yuhtin.minecraft.steelbosses.utils.BossPlayerSerializer;
import com.yuhtin.minecraft.steelbosses.utils.ItemStackUtil;

@Singleton
public class BossPlayerDAO extends DatabaseProvider {

    @Inject private BossPlayerSerializer bossPlayerSerializer;

    public void createTable() {
        update("create table if not exists `steel_bosses` ("
                + "`name` char(16) not null, "
                + "`data` text not null,"
                + "`sword` text not null"
                + ");");
    }

    public BossPlayer findByName(String name) {
        return query("select * from `steel_bosses` where `name` = ?", name)
                .parse(BossPlayerDocumentParser.getInstance());
    }

    public void insertPlayer(String name, BossPlayer bossPlayer) {
        String sword = bossPlayer.getSword() == null ? "" : ItemStackUtil.serialize(bossPlayer.getSword().clone());
        bossPlayer.setSword(null);

        String serializedPlayer = bossPlayerSerializer.serialize(bossPlayer);

        update("insert into `steel_bosses` values (?, ?, ?);",
                name,
                serializedPlayer,
                sword);
    }

    public void updatePlayer(String name, BossPlayer bossPlayer) {

        String sword = bossPlayer.getSword() == null ? "" : ItemStackUtil.serialize(bossPlayer.getSword().clone());
        bossPlayer.setSword(null);

        String serializedPlayer = bossPlayerSerializer.serialize(bossPlayer);

        update("update `steel_bosses` set `data` = ?, `sword` = ? where `name` = ?",
                serializedPlayer,
                sword,
                name
        );

    }

}
