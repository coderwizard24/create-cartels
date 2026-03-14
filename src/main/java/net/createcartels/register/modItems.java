package net.createcartels.register;

import net.createcartels.CreateCartels;
import net.createcartels.itemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class modItems {

    public static final Item PURE_COKE = registerItem("pure_coke", new Item(new FabricItemSettings()));
    public static final Item COCA_PLANT = registerItem("coca_plant", new Item(new FabricItemSettings()));


    private static void addToGroup(FabricItemGroupEntries entries){
        entries.add(PURE_COKE);
        entries.add(COCA_PLANT);
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(CreateCartels.MOD_ID, name), item);
    }

    public static void declareItemReg(){
        CreateCartels.LOGGER.info("Beginning item registration");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(modItems::addToGroup);
    }
}
