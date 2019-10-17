package io.github.vampirestudios.dungeon_mod;

import net.fabricmc.api.ModInitializer;

public class DungeonMod implements ModInitializer {

    public static final String MOD_ID = "dungeon_mod";
    public static final String MOD_VERSION = "0.1.0";
    public static final String MOD_NAME = "Unnamed Dungeon Mod";

    @Override
    public void onInitialize() {
        System.out.println(String.format("You're running %s v%s", MOD_NAME, MOD_VERSION));
    }

}
