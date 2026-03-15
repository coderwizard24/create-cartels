package net.createcartels.entities;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class distroBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory{

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2, ItemStack.EMPTY);

    private static final int input = 0;
    private static final int output = 1;
    protected final PropertyDelegate propertyDelegate;

    private int progress = 0;
    private int maxProgress = 72;

    public distroBlockEntity(BlockPos pos, BlockState state) {
        super(modBlockEntities.DISTRO_BLOCK_ENTITY, pos, state);
        this.propertyDelegate = new PropertyDelegate(){
            @Override
            public int get(int index){
                return switch(index){
                    case(0) -> distroBlockEntity.this.progress;
                    case (1) -> distroBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value){
                switch (index){
                    case 0 -> distroBlockEntity.this.progress = value;
                    case 1 -> distroBlockEntity.this.maxProgress = value;

                }
            };

            public int size(){
                return 2;
            }
        };
    }

    public distroBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state, PropertyDelegate propertyDelegate) {
        super(type, pos, state);
        this.propertyDelegate = propertyDelegate;
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity serverPlayerEntity, PacketByteBuf packetByteBuf) {
        packetByteBuf.writeBlockPos(this.pos);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.create-cartels.distribution_block");
    }

    @Override
    protected void writeNbt(NbtCompound nbt){
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("distroblock.progress", progress);
    }

    @Override
    public void readNbt(NbtCompound nbt){
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
        progress = nbt.getInt("distroblock.progress");
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return null;
    }
}
