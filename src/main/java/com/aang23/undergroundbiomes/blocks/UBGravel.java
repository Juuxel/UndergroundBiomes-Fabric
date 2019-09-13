package com.aang23.undergroundbiomes.blocks;

import com.aang23.undergroundbiomes.api.enums.UBBlock;
import com.aang23.undergroundbiomes.api.enums.UBStoneStyle;
import com.aang23.undergroundbiomes.api.enums.UBStoneType;
import com.aang23.undergroundbiomes.api.enums.Variant;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.Blocks;
import net.minecraft.block.GravelBlock;
import net.minecraft.sound.BlockSoundGroup;

public class UBGravel extends GravelBlock implements UBBlock {
    private final Variant<?> variant;

    public UBGravel(Variant<?> variant) {
        super(FabricBlockSettings.copy(Blocks.GRAVEL)
                .sounds(BlockSoundGroup.GRAVEL)
                .breakByTool(FabricToolTags.SHOVELS)
                .build());
        this.variant = variant;
    }

    @Override
    public UBStoneStyle getStoneStyle() {
        return UBStoneStyle.GRAVEL;
    }

    @Override
    public Variant<?> getVariant() {
        return variant;
    }

    @Override
    public UBStoneType getStoneType() {
        return variant.getStoneType();
    }

    // TODO
    /*@Override
    public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing,
            IPlantable plantable) {
        return Blocks.GRAVEL.canSustainPlant(state, world, pos, facing, plantable);
    }*/
}
