package com.aang23.undergroundbiomes.mixin;

import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(targets = {"net.fabricmc.fabric.impl.tools.ToolManager$EntryImpl"}, remap = false)
public interface ToolManagerEntryImplAccessor {
    @Accessor
    Tag<Item>[] getTags();

    @Accessor
    int[] getTagLevels();
}
