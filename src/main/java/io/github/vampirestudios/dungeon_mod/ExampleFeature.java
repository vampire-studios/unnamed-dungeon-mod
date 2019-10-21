package io.github.vampirestudios.dungeon_mod;

import com.mojang.datafixers.Dynamic;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.AbstractTempleFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
 
import java.util.Random;
import java.util.function.Function;
 
public class ExampleFeature extends AbstractTempleFeature<DefaultFeatureConfig> {
 
    public ExampleFeature(Function<Dynamic<?>, ? extends DefaultFeatureConfig> config) {
        super(config);
    }

    @Override
    protected int getSeedModifier() {
        return 437583903;
    }

    @Override
    public StructureFeature.StructureStartFactory getStructureStartFactory() {
        return ExampleStructureStart::new;
    }
 
    @Override
    public String getName() {
        return "Test Dungeon";
    }
 
    @Override
    public int getRadius() {
        return 2;
    }
}