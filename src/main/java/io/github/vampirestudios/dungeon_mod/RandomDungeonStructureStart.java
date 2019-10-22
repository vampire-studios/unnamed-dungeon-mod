package io.github.vampirestudios.dungeon_mod;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.StructureStart;
import net.minecraft.structure.pool.SinglePoolElement;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolBasedGenerator;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.StructureFeature;

public class RandomDungeonStructureStart extends StructureStart {

    private static final Identifier BASE_DUNGEONS = new Identifier("dungeon_mod:base_dungeons");
    private static final Identifier NORTH_DUNGEONS = new Identifier("dungeon_mod:dungeons_north");
    private static final Identifier SOUTH_DUNGEONS = new Identifier("dungeon_mod:dungeons_south");
    private static final Identifier EAST_DUNGEONS = new Identifier("dungeon_mod:dungeons_east");
    private static final Identifier WEST_DUNGEONS = new Identifier("dungeon_mod:dungeons_west");
    private static final Identifier NORTH_DUNGEON_DOOR = new Identifier("dungeon_mod:dungeon_door_north");
    private static final Identifier SOUTH_DUNGEON_DOOR = new Identifier("dungeon_mod:dungeon_door_south");
    private static final Identifier EAST_DUNGEON_DOOR = new Identifier("dungeon_mod:dungeon_door_east");
    private static final Identifier WEST_DUNGEON_DOOR = new Identifier("dungeon_mod:dungeon_door_west");
 
    RandomDungeonStructureStart(StructureFeature<?> feature, int x, int z, BlockBox box, int int_3, long seed) {
        super(feature, x, z, box, int_3, seed);
    }
 
    @Override
    public void initialize(ChunkGenerator<?> chunkGenerator, StructureManager structureManager, int x, int z, Biome biome) {
        StructurePoolBasedGenerator.addPieces(BASE_DUNGEONS, 7, RandomDungeonPiece::new, chunkGenerator, structureManager, new BlockPos(x * 16, 150, z * 16), children, random);
        setBoundingBoxFromChildren();
    }

    static {
        StructurePoolBasedGenerator.REGISTRY.add(
                new StructurePool(
                        BASE_DUNGEONS,
                        new Identifier("empty"),
                        ImmutableList.of(
                                Pair.of(new SinglePoolElement("dungeon_mod:base_1"), 1),
                                Pair.of(new SinglePoolElement("dungeon_mod:base_2"), 1)
                        ),
                        StructurePool.Projection.RIGID
                )
        );

        StructurePoolBasedGenerator.REGISTRY.add(
                new StructurePool(
                        NORTH_DUNGEONS,
                        new Identifier("empty"),
                        ImmutableList.of(
                                Pair.of(new SinglePoolElement("dungeon_mod:test_2"), 1),
                                Pair.of(new SinglePoolElement("dungeon_mod:test_3"), 1),
                                Pair.of(new SinglePoolElement("dungeon_mod:passage_way_nsw"), 1),
                                Pair.of(new SinglePoolElement("dungeon_mod:passage_way_ns"), 1),
                                Pair.of(new SinglePoolElement("dungeon_mod:passage_way_nse"), 1)
                        ),
                        StructurePool.Projection.RIGID
                )
        );

        StructurePoolBasedGenerator.REGISTRY.add(
                new StructurePool(
                        SOUTH_DUNGEONS,
                        new Identifier("empty"),
                        ImmutableList.of(
                                Pair.of(new SinglePoolElement("dungeon_mod:test_2"), 1),
                                Pair.of(new SinglePoolElement("dungeon_mod:test_3"), 1),
                                Pair.of(new SinglePoolElement("dungeon_mod:passage_way_nsw"), 1),
                                Pair.of(new SinglePoolElement("dungeon_mod:passage_way_ns"), 1),
                                Pair.of(new SinglePoolElement("dungeon_mod:passage_way_nse"), 1),
                                Pair.of(new SinglePoolElement("dungeon_mod:passage_way_ews"), 1)
                        ),
                        StructurePool.Projection.RIGID
                )
        );

        StructurePoolBasedGenerator.REGISTRY.add(
                new StructurePool(
                        EAST_DUNGEONS,
                        new Identifier("empty"),
                        ImmutableList.of(
                                Pair.of(new SinglePoolElement("dungeon_mod:test_2"), 1),
                                Pair.of(new SinglePoolElement("dungeon_mod:test_3"), 1),
                                Pair.of(new SinglePoolElement("dungeon_mod:passage_way_ew"), 1),
                                Pair.of(new SinglePoolElement("dungeon_mod:passage_way_nse"), 1),
                                Pair.of(new SinglePoolElement("dungeon_mod:passage_way_ews"), 1)
                        ),
                        StructurePool.Projection.RIGID
                )
        );

        StructurePoolBasedGenerator.REGISTRY.add(
                new StructurePool(
                        WEST_DUNGEONS,
                        new Identifier("empty"),
                        ImmutableList.of(
                                Pair.of(new SinglePoolElement("dungeon_mod:test_2"), 1),
                                Pair.of(new SinglePoolElement("dungeon_mod:test_3"), 1),
                                Pair.of(new SinglePoolElement("dungeon_mod:passage_way_ew"), 1),
                                Pair.of(new SinglePoolElement("dungeon_mod:passage_way_nsw"), 1),
                                Pair.of(new SinglePoolElement("dungeon_mod:passage_way_ews"), 1)
                        ),
                        StructurePool.Projection.RIGID
                )
        );
    }

}