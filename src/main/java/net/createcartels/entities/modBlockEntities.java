package net.createcartels.entities;

import net.createcartels.CreateCartels;
import net.createcartels.register.modBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class modBlockEntities {
    public static final BlockEntityType<distroBlockEntity> DISTRO_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(CreateCartels.MOD_ID, "distroblock_blockentity"),
                    FabricBlockEntityTypeBuilder.create(distroBlockEntity::new, modBlock.DISTRIBUTION_BLOCK).build());
}
