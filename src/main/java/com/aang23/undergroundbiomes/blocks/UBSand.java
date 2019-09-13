package com.aang23.undergroundbiomes.blocks;

import com.aang23.undergroundbiomes.api.enums.UBBlock;
import com.aang23.undergroundbiomes.api.enums.UBStoneStyle;
import com.aang23.undergroundbiomes.api.enums.UBStoneType;
import com.aang23.undergroundbiomes.api.enums.Variant;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.Blocks;
import net.minecraft.block.SandBlock;
import net.minecraft.sound.BlockSoundGroup;

public class UBSand extends SandBlock implements UBBlock {
    private final Variant<?> variant;

    public UBSand(Variant<?> variant) {
        super(0, FabricBlockSettings.copy(Blocks.SAND)
                .sounds(BlockSoundGroup.SAND)
                .breakByTool(FabricToolTags.SHOVELS)
                .build());
        this.variant = variant;
    }

    @Override
    public UBStoneStyle getStoneStyle() {
        return UBStoneStyle.SAND;
    }

    @Override
    public UBStoneType getStoneType() {
        return variant.getStoneType();
    }

    @Override
    public Variant<?> getVariant() {
        return variant;
    }

    // TODO: Mixin-to-dead-bush-and-cactus time
    /*@Override
    public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing,
            IPlantable plantable) {
        return Blocks.SAND.canSustainPlant(state, world, pos, facing, plantable);
    }*/
}
