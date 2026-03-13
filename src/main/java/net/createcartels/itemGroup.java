package net.createcartels;

import net.createcartels.register.modBlock;
import net.createcartels.register.modItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class itemGroup {
    public static final ItemGroup CARTELS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(CreateCartels.MOD_ID, "create_cartels"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.cartels_group"))
                    .icon(() -> new ItemStack(modItems.PURE_COKE)).entries((displayContext, entries) -> {
                        entries.add(modItems.PURE_COKE);
                        entries.add(modBlock.COKE_BLOCK);
                        entries.add(modItems.COCA_PLANT);


                    }).build());
}
