package mrthomas20121.thermal_extra.inventory.device;

import cofh.core.common.inventory.BlockEntityCoFHMenu;
import cofh.lib.common.inventory.SlotCoFH;
import cofh.lib.common.inventory.wrapper.InvWrapperCoFH;
import mrthomas20121.thermal_extra.block.entity.DeviceHarvesterBlockEntity;
import mrthomas20121.thermal_extra.init.ThermalExtraContainers;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class DeviceHarvesterMenu extends BlockEntityCoFHMenu {

    public final DeviceHarvesterBlockEntity tile;

    public DeviceHarvesterMenu(int windowId, Level world, BlockPos pos, Inventory inventory, Player player) {

        super(ThermalExtraContainers.HARVESTER_CONTAINER.get(), windowId, world, pos, inventory, player);
        this.tile = (DeviceHarvesterBlockEntity) world.getBlockEntity(pos);
        InvWrapperCoFH tileInv = new InvWrapperCoFH(this.tile.getItemInv());

        addSlot(new SlotCoFH(tileInv, 0, 8, 53));

        bindAugmentSlots(tileInv, 1, this.tile.augSize());
        bindPlayerInventory(inventory);
    }

}

