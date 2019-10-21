package io.github.vampirestudios.dungeon_mod;

import net.fabricmc.api.ModInitializer;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorConfig;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

public class DungeonMod implements ModInitializer {

    public static final StructureFeature<DefaultFeatureConfig> EXAMPLE_FEATURE = Registry.register(
            Registry.FEATURE,
            new Identifier("tutorial", "example_feature"),
            new ExampleFeature(DefaultFeatureConfig::deserialize)
    );

    public static final StructureFeature<DefaultFeatureConfig> EXAMPLE_STRUCTURE_FEATURE = Registry.register(
            Registry.STRUCTURE_FEATURE,
            new Identifier("tutorial", "example_structure_feature"),
            new ExampleFeature(DefaultFeatureConfig::deserialize)
    );

    public static final StructurePieceType EXAMPLE_PIECE = Registry.register(
            Registry.STRUCTURE_PIECE,
            new Identifier("tutorial", "example_piece"),
            ExamplePiece::new
    );

    public static final String MOD_ID = "dungeon_mod";
    public static final String MOD_VERSION = "0.1.0";
    public static final String MOD_NAME = "Unnamed Dungeon Mod";

    @Override
    public void onInitialize() {
        System.out.println(String.format("You're running %s v%s", MOD_NAME, MOD_VERSION));
        Feature.STRUCTURES.put("test_dungeon", EXAMPLE_FEATURE);


        Registry.BIOME.forEach(biome -> {
            biome.addFeature(GenerationStep.Feature.RAW_GENERATION, EXAMPLE_FEATURE.method_23397(new DefaultFeatureConfig())
                    .method_23388(Decorator.NOPE.method_23475(DecoratorConfig.DEFAULT)));
            biome.addStructureFeature(EXAMPLE_FEATURE.method_23397(FeatureConfig.DEFAULT)/*.method_23388(Decorator.NOPE.method_23475(DecoratorConfig.DEFAULT))*/);
        });
    }

}