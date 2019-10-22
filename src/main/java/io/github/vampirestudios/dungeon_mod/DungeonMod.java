package io.github.vampirestudios.dungeon_mod;

import net.fabricmc.api.ModInitializer;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorConfig;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

public class DungeonMod implements ModInitializer {

    public static final StructureFeature<DefaultFeatureConfig> RANDOM_DUNGEON_FEATURE = Registry.register(
            Registry.FEATURE,
            new Identifier(Reference.MOD_ID, "random_dungeon_feature"),
            new RandomDungeonFeature(DefaultFeatureConfig::deserialize)
    );

    public static final StructureFeature<DefaultFeatureConfig> RANDOM_DUNGEON_STRUCTURE_FEATURE = Registry.register(
            Registry.STRUCTURE_FEATURE,
            new Identifier(Reference.MOD_ID, "random_dungeon_structure_feature"),
            new RandomDungeonFeature(DefaultFeatureConfig::deserialize)
    );

    public static final StructurePieceType RANDOM_DUNGEON_PIECE = Registry.register(
            Registry.STRUCTURE_PIECE,
            new Identifier(Reference.MOD_ID, "random_dungeon_piece"),
            RandomDungeonPiece::new
    );

    @Override
    public void onInitialize() {
        System.out.println(String.format("You're running %s v%s", Reference.MOD_NAME, Reference.MOD_VERSION));
        Feature.STRUCTURES.put("random_dungeon", RANDOM_DUNGEON_FEATURE);


        Registry.BIOME.forEach(biome -> {
            biome.addFeature(GenerationStep.Feature.RAW_GENERATION, RANDOM_DUNGEON_FEATURE.method_23397(new DefaultFeatureConfig())
                    .method_23388(Decorator.NOPE.method_23475(DecoratorConfig.DEFAULT)));
            biome.addStructureFeature(RANDOM_DUNGEON_FEATURE.method_23397(FeatureConfig.DEFAULT)/*.method_23388(Decorator.NOPE.method_23475(DecoratorConfig.DEFAULT))*/);
        });
    }

}