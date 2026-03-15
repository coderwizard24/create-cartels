package net.createcartels;

import net.createcartels.register.modBlock;
import net.createcartels.register.modItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class itemGroup {
    // In your ModItemGroups class
    public static final ItemGroup CARTEL_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(CreateCartels.MOD_ID, "cartel_group"), FabricItemGroup.builder()
            .displayName(Text.translatable("itemgroup.create-cartels.cartels_group"))
            .icon(() -> new ItemStack(modItems.PURE_COKE)) // Change to your item
            .entries((displayContext, entries) -> {

                entries.add(modItems.PURE_COKE);
                entries.add(modItems.COCA_PLANT);
                entries.add(modBlock.COKE_BLOCK);
                entries.add(modItems.DERP_TOTEM);
                entries.add(modBlock.DISTRIBUTION_BLOCK);

            })
            .build());


    public static void initialize(){

    }

}
