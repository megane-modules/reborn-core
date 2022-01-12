package lol.bai.megane.module.reborncore.provider;

import lol.bai.megane.api.provider.FluidProvider;
import org.jetbrains.annotations.Nullable;
import reborncore.common.blockentity.MachineBaseBlockEntity;
import reborncore.common.util.Tank;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MachineBaseFluidProvider extends FluidProvider<MachineBaseBlockEntity> {

    private Tank tank;

    @Override
    public void setContext(World world, BlockPos pos, PlayerEntity player, MachineBaseBlockEntity machineBaseBlockEntity) {
        super.setContext(world, pos, player, machineBaseBlockEntity);

        this.tank = machineBaseBlockEntity.getTank();
    }

    @Override
    public boolean hasFluids() {
        return tank != null;
    }

    @Override
    public int getSlotCount() {
        return 1;
    }

    @Override
    public @Nullable Fluid getFluid(int slot) {
        return tank.getFluid();
    }

    @Override
    public double getStored(int slot) {
        return droplets(tank.getAmount());
    }

    @Override
    public double getMax(int slot) {
        return droplets(tank.getCapacity());
    }

}
